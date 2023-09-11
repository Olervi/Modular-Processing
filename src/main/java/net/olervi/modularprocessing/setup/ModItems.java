package net.olervi.modularprocessing.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public  static final RegistryObject<Item> BASE_MODULE = Registration.ITEMS.register("base_module", () ->
            new Item(new Item.Properties().tab(ModItemGroup.ITEMS_GROUP)));
    public  static final RegistryObject<Item> BANANA = Registration.ITEMS.register("banana", () ->
            new Item(new Item.Properties().tab(ModItemGroup.ITEMS_GROUP)));
    
    //Adding different metals to tier progress
    public static final  RegistryObject<Item> DARK_MATTER = Registration.ITEMS.register("dark_matter", () ->
            new Item(new Item.Properties().tab(ModItemGroup.ITEMS_GROUP)));



    static void register() {}
}
