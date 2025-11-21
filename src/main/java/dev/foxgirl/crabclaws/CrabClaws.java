package dev.foxgirl.crabclaws;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import java.util.function.Consumer;

//? fabric {
/*import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
*///?}

//? neoforge {
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
//? >=1.21 {
import net.minecraft.world.item.Items;
//?}
//?} else forge {
/*import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
*///?}

//? forge-like {
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
//?}

//? fabric
/*@Entrypoint*/
//? forge-like
@Mod(CrabClaws.MOD_ID)
public final class CrabClaws
    //? fabric
    /*implements ClientModInitializer*/
{
    public static final String MOD_ID = "@MODID@";
    public static CrabClawItem CRAB_CLAW_ITEM = null;

    public static ResourceLocation id(String path) {
        //? >=1.21 {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
        //?} else {
        /*return new ResourceLocation(MOD_ID, path);
        *///?}
    }

    //? forge-like {
    public CrabClaws(IEventBus modEventBus) {
        modEventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                //? >=1.21 {
                event.insertBefore(new ItemStack(Items.WOODEN_SHOVEL), new ItemStack(CRAB_CLAW_ITEM), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                //?} else {
                /*event.accept(new ItemStack(CRAB_CLAW_ITEM), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                *///?}
            }
        });
    }
    //?} else fabric {
    /*@Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.prepend(CRAB_CLAW_ITEM));
    }
    *///?}

    private void onModifyLootTable(
        ResourceKey<LootTable> key,
        Consumer<LootPool.Builder> addPoolConsumer,
        boolean isBuiltin
    ) {
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
        if (CrabClawsConfig.getConfig().shouldSpawnClawsInRuins && (key.location().equals(underWaterRuinSmall) || key.location().equals(underWaterRuinBig))) {
            addPoolConsumer.accept(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(EmptyLootItem.emptyItem().setWeight(CrabClawsConfig.getConfig().probabilityOfClawsInRuins))
                    .add(LootItem.lootTableItem(CRAB_CLAW_ITEM).setWeight(1)));
        }
    }
}
