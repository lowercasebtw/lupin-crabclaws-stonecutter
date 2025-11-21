package dev.foxgirl.crabclaws.mixins;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

//? <1.20.5 {
/*import dev.foxgirl.crabclaws.CrabClawItem;
import dev.foxgirl.crabclaws.CrabClawsConfig;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
*///?}

@Mixin(Player.class)
public abstract class MixinPlayer {
    //? <1.20.5 {
    /*@Inject(method = "getPickRange", at = @At(value = "RETURN"), cancellable = true)
    private static void crabclaws$modifyPickRange(boolean creative, CallbackInfoReturnable<Float> cir) {
        float original = cir.getReturnValueF();

        final Player player = Minecraft.getInstance().player;
        if (player != null && (player.getMainHandItem().is(CrabClawItem.INSTANCE) || player.getOffhandItem().is(CrabClawItem.INSTANCE))) {
            original += CrabClawsConfig.getConfig().clawExtraReachAmount;
        }

        cir.setReturnValue(original);
    }
    *///?}
}
