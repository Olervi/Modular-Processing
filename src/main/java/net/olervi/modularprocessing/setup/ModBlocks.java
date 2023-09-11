package net.olervi.modularprocessing.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> BERYLLIUM_ORE = register("beryllium_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BERYLLIUM_BLOCK = register("beryllium_block", () ->
            new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL).harvestLevel(3).sound(SoundType.METAL)));

    public static final RegistryObject<Block> GUERYLLIUM_ORE = register("gueryllium_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> POWERED_SMELTER = register("powered_smelter", () ->
            new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL).harvestLevel(3).sound(SoundType.NETHERITE_BLOCK)));



    private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModItemGroup.MACHINES_GROUP)));
        return ret;
    }

    static void register() {}
}

