package dev.foxgirl.crabclaws.mixins;

import net.minecraft.core.registries.Registries;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Registries.class)
public abstract class MixinReloadableServerRegistries {
}
