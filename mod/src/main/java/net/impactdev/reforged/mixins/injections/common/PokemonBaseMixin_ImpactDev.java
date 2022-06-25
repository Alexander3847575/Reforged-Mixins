package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonBase;
import com.pixelmonmod.pixelmon.api.pokemon.item.pokeball.PokeBall;
import com.pixelmonmod.pixelmon.api.pokemon.item.pokeball.PokeBallRegistry;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.species.Stats;
import com.pixelmonmod.pixelmon.api.pokemon.species.gender.Gender;
import com.pixelmonmod.pixelmon.api.pokemon.species.palette.PaletteProperties;
import com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies;
import net.impactdev.reforged.mixins.ReforgedMixins;
import net.impactdev.reforged.mixins.api.translations.forms.Destination;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslation;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyKey;
import net.impactdev.reforged.mixins.api.translations.forms.types.PaletteTranslation;
import net.impactdev.reforged.mixins.extensions.PokemonBaseExpansion;
import net.impactdev.reforged.mixins.registries.Registries;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(PokemonBase.class)
public abstract class PokemonBaseMixin_ImpactDev implements PokemonBaseExpansion {

    @Shadow(remap = false) protected Species species;
    @Shadow(remap = false) protected Stats form;
    @Shadow(remap = false) protected Gender gender;
    @Shadow(remap = false) protected PaletteProperties palette;
    @Shadow(remap = false) protected PokeBall ball;
    @Shadow(remap = false) protected int eggCycles;

    /**
     * If a pokemon is found to meet a 1.12.2 data format, this injection will attempt
     * to translate that pokemon correctly to 1.16.5. At present, 1.16.5 translations in
     * reforged lack form definitions from legacy data, and this information is lost upon
     * load. This injection will effectively override the base version of this method,
     * and ensure 1.12.2 data is transitioned appropriately.
     *
     * @author NickImpact
     * @reason Reforged features a set of tremendously lazy and self-righteous "developers"
     * each composed of god complexes. Per the 1.16.5 mantra, why fix a feature when you can
     * just remove it instead. If you're reading this, ask them why megas outside of battle
     * were really removed... (Hint: Raid battles)
     */
    @Inject(method = "fromNBT", at = @At("HEAD"), remap = false, cancellable = true)
    private static void impactdev$translate(CompoundNBT nbt, CallbackInfoReturnable<PokemonBase> cir) {
        ReforgedMixins.logger.info("NBT Version: " + nbt.getInt("NBT_VERSION"));
        if(nbt.getInt("NBT_VERSION") != 2) {
            if(nbt.contains("Variant") && nbt.getTagType("Variant") == 1) {
                // 1.12.2 data found, translate this now
                PokemonBaseExpansion base = (PokemonBaseExpansion) new PokemonBase();
                Map<LegacyKey, LegacyFormTranslation> translations = Registries.LEGACY_FORMS.translations();

                if(nbt.contains("ndex")) {
                    base.species(PixelmonSpecies.fromNationalDex(nbt.getInt("ndex")));
                }

                if(nbt.contains("Gender")) {
                    base.gender(Gender.getGender(nbt.getByte("Gender")));
                }

                final byte form = nbt.getByte("Variant");
                final LegacyKey species = LegacyKey.of(form, base.getSpecies().getRegistryValue());
                if(translations.containsKey(species)) {
                    translate(nbt, base, translations, species);
                } else {
                    final LegacyKey id = LegacyKey.of(form);
                    if(translations.containsKey(id)) {
                        translate(nbt, base, translations, id);
                    } else {
                        base.form(base.getSpecies().getDefaultForm());
                    }
                }

                if (nbt.contains("CaughtBall")) {
                    String ball = nbt.getString("CaughtBall");
                    if (ball.isEmpty()) {
                        if (nbt.getInt("CaughtBall") > -1) {
                            base.pokeball(PokeBallRegistry.STRANGE_BALL.get());
                        } else {
                            base.pokeball(null);
                        }
                    } else {
                        base.pokeball(PokeBallRegistry.getPokeBall(ball).orElse(PokeBallRegistry.POKE_BALL.get()));
                    }
                } else {
                    base.pokeball(null);
                }

                if (nbt.contains("eggCycles")) {
                    base.eggCycles(nbt.getInt("eggCycles"));
                } else {
                    base.eggCycles(-1);
                }

                cir.setReturnValue((PokemonBase) base);
            }
        }

    }

    private static void translate(CompoundNBT nbt, PokemonBaseExpansion base, Map<LegacyKey, LegacyFormTranslation> translations, LegacyKey species) {
        LegacyFormTranslation target = translations.get(species);
        if(target.destination() == Destination.FORM) {
            base.form(base.getSpecies().getForm(target.name()));
        } else {
            PaletteProperties properties = base.getGenderProperties().getPalette(target.name());
            base.form(((PaletteTranslation) target).form().map(f -> base.getSpecies().getForm(f)).orElse(base.getSpecies().getDefaultForm()));
            base.palette(properties);
            nbt.putString("palette", properties.getName());
            nbt.remove("IsShiny");
        }
    }

    @Override
    public void species(Species species) {
        this.species = species;
    }

    @Override
    public void form(Stats form) {
        this.form = form;
    }

    @Override
    public void palette(PaletteProperties palette) {
        this.palette = palette;
    }

    @Override
    public void gender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void pokeball(PokeBall ball) {
        this.ball = ball;
    }

    @Override
    public void eggCycles(int cycles) {
        this.eggCycles = cycles;
    }
}
