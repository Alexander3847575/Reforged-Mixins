package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonBase;
import com.pixelmonmod.pixelmon.api.pokemon.species.Stats;
import com.pixelmonmod.pixelmon.api.pokemon.species.palette.PaletteProperties;
import com.pixelmonmod.pixelmon.api.storage.StoragePosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.stream.Collectors;

@Mixin(Pokemon.class)
public abstract class PokemonMixin_ImpactDev extends PokemonBase {

    //@Shadow protected transient StoragePosition position;

    @Redirect(method = "readFromNBT", at = @At(
            value = "INVOKE",
            target = "Lcom/pixelmonmod/pixelmon/api/pokemon/Pokemon;setPalette(Lcom/pixelmonmod/pixelmon/api/pokemon/species/palette/PaletteProperties;)Z"
    ), remap = false)
    public boolean impactdev$dontUpdatePalette(Pokemon instance, PaletteProperties paletteProperties) {
        return true;
    }

    @Inject(method = "setPalette(Ljava/lang/String;Z)Z", at = @At("HEAD"), remap = false)
    public void checkForm(String palette, boolean sync, CallbackInfoReturnable<Boolean> cir) {
        if(this.getForm() == null) {
            throw new IllegalStateException("Form is null for species: " + this.getSpecies().getName() + ". This is likely due to an unregistered or corrupt form value." + "\nValid forms are: " + this.getSpecies().getForms().stream().map(Stats::getName).collect(Collectors.toList()).toString());
        }
        // Morpeko: 39... 58-6
    }
    
}
