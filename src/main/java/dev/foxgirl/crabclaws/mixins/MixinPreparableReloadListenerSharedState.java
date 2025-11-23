package dev.foxgirl.crabclaws.mixins;
// TODO/NOTE: Temporary fix to get 1.21.10 neoforge to load and not crash immediately

import org.spongepowered.asm.mixin.Mixin;

//? >=1.21.10 && neoforge {
/*import net.minecraft.server.packs.resources.PreparableReloadListener;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.injection.At;
*///?}

//? >=1.21.10 && neoforge {
/*@Mixin(PreparableReloadListener.SharedState.class)
*///?} else {
@Mixin(net.minecraft.client.Minecraft.class)
//?}
public abstract class MixinPreparableReloadListenerSharedState {
    //? >=1.21.10 && neoforge {
    /*@WrapOperation(method = "get", at = @At(value = "INVOKE", target = "Ljava/util/Objects;requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;"))
    private <T> T crabclaws$fixArchitectury(T object, Operation<T> original) {
        return object;
    }
    *///?}
}
