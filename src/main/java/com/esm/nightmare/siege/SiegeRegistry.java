package com.esm.nightmare.siege;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SiegeRegistry {

	public static final String MOD_ID = "nightmareesm";

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

	public static final RegistryObject<Block> PROTECTION_LANTERN = BLOCKS.register("protection_lantern",
			ProtectionLanternBlock::new);

	public static final RegistryObject<Item> PROTECTION_LANTERN_ITEM = ITEMS.register("protection_lantern",
			() -> new BlockItem(PROTECTION_LANTERN.get(), new Item.Properties()));

	private SiegeRegistry() {
	}

	public static void register(IEventBus modEventBus) {
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		modEventBus.addListener(SiegeRegistry::addToCreativeTab);
	}

	private static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			event.accept(PROTECTION_LANTERN_ITEM.get());
		}
	}
}
