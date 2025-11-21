package dev.foxgirl.crabclaws.mixins;

import dev.foxgirl.crabclaws.CrabClawItem;
import dev.foxgirl.crabclaws.CrabClaws;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltInRegistries.class)
public abstract class MixinBuiltInRegistries {
    @Inject(method = "createContents", at = @At("TAIL"))
    private static void createBetterTrimsContents(CallbackInfo ci) {
        CrabClaws.CRAB_CLAW_ITEM = Registry.register(BuiltInRegistries.ITEM, CrabClawItem.ID, CrabClawItem.of(new Item.Properties()));
    }
}
