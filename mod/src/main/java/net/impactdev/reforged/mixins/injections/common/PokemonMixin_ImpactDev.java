package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Pokemon.class)
public abstract class PokemonMixin_ImpactDev extends PokemonBase {

    @Redirect(method = "readFromNBT",
            at = @At(value = "INVOKE",
                    target = "Lcom/pixelmonmod/pixelmon/api/pokemon/Pokemon;setPalette(Ljava/lang/String;)Z",
                    ordinal = 1,
                    remap = false)
            , remap = false)
    public boolean dontRereadForm(Pokemon instance, String palette) {
        PokemonBase.SYNC_POKEMON_BASE.set(instance, new PokemonBase(this.species, this.form, this.form.getGenderProperties(this.gender).getPalette(palette), this.gender, this.eggCycles, this.ball));
        instance.markDirty();
        return false;
    }

}
