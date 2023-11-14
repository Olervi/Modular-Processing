package net.olervi.modularprocessing;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.olervi.modularprocessing.events.AnvilHandler;
import net.olervi.modularprocessing.init.BlockInit;
import net.olervi.modularprocessing.init.ItemInit;
import net.olervi.modularprocessing.init.TileEntityInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModularProcessing {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "modular_processing";

    public ModularProcessing() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private  void setup(final FMLCommonSetupEvent event){
        AnvilHandler.initAnvilRecipes();
    }
}