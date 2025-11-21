package dev.foxgirl.crabclaws;

import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

//? >=1.20.5 {
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
//?} else {
/*import net.minecraft.world.level.storage.loot.LootDataManager;
*///?}

//? fabric {
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//?}

//? neoforge {
/*import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
*///?}

//? fabric
@Entrypoint
//? neoforge
/*@Mod(CrabClaws.MOD_ID)*/
public final class CrabClaws
    //? fabric
    implements ClientModInitializer
{
    public static final String MOD_ID = "@MODID@";

    public static ResourceLocation id(String path) {
        //? >=1.21 {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
         //?} else {
        /*return new ResourceLocation(MOD_ID, path);
        *///?}
    }

    private void initialize(
        //? neoforge
        /*IEventBus modEventBus*/
    ) {
        LootEvent.MODIFY_LOOT_TABLE.register(this::onModifyLootTable);
        //? fabric {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.prepend(CrabClawItem.INSTANCE));
        //?} else {
        /*modEventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                //? >=1.21.2 {
                /^event.insertBefore(new ItemStack(Items.WOODEN_SHOVEL), new ItemStack(CrabClawItem.INSTANCE), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                ^///?} else {
                event.accept(new ItemStack(CrabClawItem.INSTANCE), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                //?}
            }
        });
        *///?}
    }

    //? neoforge {
    /*public CrabClaws(IEventBus modEventBus) {
        initialize(modEventBus);
    }
    *///?} else fabric {
    @Override
    public void onInitializeClient() {
        initialize();
    }
    //?}

    private void onModifyLootTable(
        //? >=1.20.5 {
        ResourceKey<LootTable> key,
         //?} else {
        /*LootDataManager lootDataManager, ResourceLocation resourceLocation,
        *///?}
        LootEvent.LootTableModificationContext context,
        boolean builtIn
    ) {
        final ResourceLocation lootLocation =
            //? >=1.20.5 {
            key.location();
             //?} else {
            /*resourceLocation;
            *///?}
        final ResourceLocation underWaterRuinSmall =
            //? >=1.20.5 {
            BuiltInLootTables.UNDERWATER_RUIN_SMALL.location();
            //?} else {
            /*BuiltInLootTables.UNDERWATER_RUIN_SMALL;
            *///?}
        final ResourceLocation underWaterRuinBig =
            //? >=1.20.5 {
            BuiltInLootTables.UNDERWATER_RUIN_BIG.location();
            //?} else {
            /*BuiltInLootTables.UNDERWATER_RUIN_BIG;
            *///?}
        if (CrabClawsConfig.getConfig().shouldSpawnClawsInRuins && (lootLocation.equals(underWaterRuinSmall) || lootLocation.equals(underWaterRuinBig))) {
            context.addPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(EmptyLootItem.emptyItem().setWeight(CrabClawsConfig.getConfig().probabilityOfClawsInRuins))
                    .add(LootItem.lootTableItem(CrabClawItem.INSTANCE).setWeight(1)));
        }
    }
}
