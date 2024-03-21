package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.stats.EVStore;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EVStore.class)
public class EVStoreMixin_ImpactDev {

    @Redirect(
            method = "readFromNBT",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/nbt/CompoundNBT;getShort(Ljava/lang/String;)S",
                    ordinal = 2
            )
    )
    public short translateDefense(final CompoundNBT nbt, final String provided) {
        if(nbt.contains("EVDefence")) {
            return nbt.getShort("EVDefence");
        } else {
            short providedValue = nbt.getShort(provided);
            return (providedValue < 1) ? (0) : providedValue;
        }
    }

    @Redirect(
            method = "readFromNBT",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/nbt/CompoundNBT;getShort(Ljava/lang/String;)S",
                    ordinal = 4
            )
    )
    public short translateSpDef(final CompoundNBT nbt, final String provided) {
        if(nbt.contains("EVSpecialDefence")) {
            return nbt.getShort("EVSpecialDefence");
        } else {
            short providedValue = nbt.getShort(provided);
            return (providedValue < 1) ? (0) : providedValue;
        }
    }

}
