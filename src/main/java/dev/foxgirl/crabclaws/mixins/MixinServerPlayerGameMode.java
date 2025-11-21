package dev.foxgirl.crabclaws.mixins;

import net.minecraft.server.level.ServerPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;

//? <1.20.5 {
/*import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
*///?}

@Mixin(ServerPlayerGameMode.class)
public abstract class MixinServerPlayerGameMode {
    //? <1.20.5 {
    /*@Shadow
    @Final
    protected ServerPlayer player;

    @Definition(id = "player", field = "Lnet/minecraft/server/level/ServerPlayerGameMode;player:Lnet/minecraft/server/level/ServerPlayer;")
    @Definition(id = "getEyePosition", method = "Lnet/minecraft/server/level/ServerPlayer;getEyePosition()Lnet/minecraft/world/phys/Vec3;")
    @Definition(id = "distanceToSqr", method = "Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D")
    @Definition(id = "MAX_INTERACTION_DISTANCE", field = "Lnet/minecraft/server/network/ServerGamePacketListenerImpl;MAX_INTERACTION_DISTANCE:D")
    @Expression("this.player.getEyePosition().distanceToSqr(?) > MAX_INTERACTION_DISTANCE")
    @ModifyExpressionValue(method = "handleBlockBreakAction", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private boolean crabclaws$modifyServerRange(boolean original, @Local(argsOnly = true) BlockPos blockPos) {
        return !crabclaws$canInteract(blockPos, 1.0);
    }

    @Unique
    private boolean crabclaws$canInteract(BlockPos blockPos, double extraDist) {
        final double dist = Player.getPickRange(this.player.isCreative()) + extraDist;
        return new AABB(blockPos).distanceToSqr(this.player.getEyePosition()) < dist * dist;
    }
    *///?}
}
