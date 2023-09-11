package net.olervi.modularprocessing.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MACHINES_GROUP = new ItemGroup("machineModTab")
    {
        @Override
        public ItemStack makeIcon() {

            return  new ItemStack(ModItems.BASE_MODULE.get());
        }
    };

    public static final ItemGroup ITEMS_GROUP = new ItemGroup("machineModTabItems") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BERYLLIUM_BLOCK.get());
        }
    };

    static void register() {}
}
