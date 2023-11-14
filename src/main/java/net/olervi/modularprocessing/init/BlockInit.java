package net.olervi.modularprocessing.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.olervi.modularprocessing.ModularProcessing;
import net.olervi.modularprocessing.blocks.PoweredSmelterBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModularProcessing.MOD_ID);

    public static final RegistryObject<Block> POWERED_SMELTER = BLOCKS.register("powered_smelter",
            () -> new PoweredSmelterBlock(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // for each block we registered above...
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
            // make an item properties object that puts it in your creative tab
            final Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);

            // make a block item that places the block
            // note, if you have a special block that needs a custom implementation for the BlockItem, just add an if statement here
            final BlockItem blockItem = new BlockItem(block, properties);

            // register the block item with the same name as the block
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
}
