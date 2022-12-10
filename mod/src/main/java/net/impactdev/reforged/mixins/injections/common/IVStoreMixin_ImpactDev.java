package net.impactdev.reforged.mixins.injections.common;

import com.pixelmonmod.pixelmon.api.pokemon.stats.IVStore;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IVStore.class)
public class IVStoreMixin_ImpactDev {

    @Redirect(
            method = "readFromNBT",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/nbt/CompoundNBT;getByte(Ljava/lang/String;)B",
                    ordinal = 2
            )
    )
    public byte translate(final CompoundNBT nbt, final String provided) {
        if(nbt.contains("IVDefence")) {
            return nbt.getByte("IVDefence");
        } else {
            return nbt.getByte(provided);
        }
    }
}
