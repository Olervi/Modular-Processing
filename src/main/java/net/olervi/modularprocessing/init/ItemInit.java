package net.olervi.modularprocessing.init;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.olervi.modularprocessing.ModularProcessing;
import net.olervi.modularprocessing.items.MachineBlock;

import static net.minecraft.item.Items.DIAMOND_SWORD;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModularProcessing.MOD_ID);

    public static final RegistryObject<Item> MACHINE_BLOCK = ITEMS.register("machine_block",
            () -> new MachineBlock(new Item.Properties().tab(ModCreativeTab.instance)));
    public static class ModCreativeTab extends ItemGroup {
        public static final ModCreativeTab instance = new ModCreativeTab(ItemGroup.TABS.length, "modular_processing");

        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MACHINE_BLOCK.get());
        }
    }
}