package net.olervi.modularprocessing.events;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnvilHandler {
    static class CombineRecipe{
        public final Item left;
        public final Item right;
        public final Item out;
        protected CombineRecipe(Item left, Item right, Item out){
            this.left = left;
            this.right = right;
            this.out = out;
        }

    }
    private static ArrayList<CombineRecipe> combineRecipes = new ArrayList<>();
    public static void initAnvilRecipes(){
        combineRecipes.add(new CombineRecipe(Items.IRON_INGOT, Items.EMERALD, Items.DIAMOND));
    }

    @SubscribeEvent
    public static void handleRepair(AnvilUpdateEvent event){
        combineRecipes.forEach((data) -> {
            if (event.getLeft().getItem() == data.left && event.getRight().getItem() == data.right){
                event.setOutput(new ItemStack(data.out, event.getLeft().getCount()));
                event.setCost(event.getLeft().getCount());
                event.setMaterialCost(event.getLeft().getCount());
            }
        });
    }
}
