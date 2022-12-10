package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonBase;
import com.pixelmonmod.pixelmon.api.pokemon.species.palette.PaletteProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Pokemon.class)
public abstract class PokemonMixin_ImpactDev extends PokemonBase {

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
            throw new IllegalStateException("Form is null for species: " + this.getSpecies().getName());
        }
    }
    
}
