package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.stats.EVStore;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EVStore.class)
public class EVStoreMixin_ImpactDev {

    // hecking mixin classload order shenanigans....
    private void log(String out) {
        System.out.print(out);
    }

    @Redirect(
            method = "readFromNBT",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/nbt/CompoundNBT;getShort(Ljava/lang/String;)S",
                    ordinal = 2
            )
    )
    public short translateDefense(final CompoundNBT nbt, final String provided) {
        log("EVDef translation triggered for ndex " + nbt.getInt("ndex"));
        if(nbt.contains("EVDefence")) {
            log(" -> Fetch LEGACY for " + nbt.getShort("EVDefence") + "\n");
            return nbt.getShort("EVDefence");
        } else {
            log(" -> Fetch modern for " + nbt.getShort(provided) + "\n");
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
        log("EVSpDef translation triggered for ndex " + nbt.getInt("ndex"));
        if(nbt.contains("EVSpecialDefence")) {
            log("-> Fetch LEGACY for " + nbt.getShort("EVSpecialDefence") + "\n");
            return nbt.getShort("EVSpecialDefence");
        } else {
            log("-> Fetch modern for " + nbt.getShort(provided) + "\n");
            short providedValue = nbt.getShort(provided);
            return (providedValue < 1) ? (0) : providedValue;
        }
    }

}
