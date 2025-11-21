package dev.foxgirl.crabclaws;

//? >=1.20.5 {
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
//? <1.21 {
/*import java.util.UUID;
*///?}
//?}

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CrabClawItem extends Item {
    public static CrabClawItem INSTANCE = null;
    //? >=1.20.5 {
    public static final AttributeModifier REACH_ATTRIBUTE_MODIFIER = new AttributeModifier(
        //? >=1.21 {
        CrabClaws.id("extra_reach"),
        //?} else {
        /*UUID.fromString("3219060d-8efc-4e48-b81b-ffa418f62c7f"),
        CrabClaws.MOD_ID + "_extra_reach",
        *///?}
        CrabClawsConfig.getConfig().clawExtraReachAmount,
        AttributeModifier.Operation.ADD_VALUE
    );
    //?}
    public static ResourceKey<Item> ID = ResourceKey.create(Registries.ITEM, CrabClaws.id("crab_claw"));

    public CrabClawItem(Item.Properties properties) {
        super(properties);
    }

    public static CrabClawItem of(Item.Properties properties) {
        //? >=1.21.2
        properties.setId(ID);
        properties.stacksTo(1);
        properties.rarity(Rarity.COMMON);
        //? >=1.20.5 {
        properties.attributes(ItemAttributeModifiers.builder()
            .add(Attributes.BLOCK_INTERACTION_RANGE, REACH_ATTRIBUTE_MODIFIER, EquipmentSlotGroup.HAND)
            .build());
        //?}
        return new CrabClawItem(properties);
    }
}
