package net.olervi.modularprocessing.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.olervi.modularprocessing.ModularProcessing;
import net.olervi.modularprocessing.tiles.PoweredSmelterTile;

public class TileEntityInit {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModularProcessing.MOD_ID);

    public static final RegistryObject<TileEntityType<PoweredSmelterTile>> POWERED_SMELTER
            = TILE_ENTITY_TYPES.register("powered_smelter",
            () -> TileEntityType.Builder.of(PoweredSmelterTile::new, BlockInit.POWERED_SMELTER.get()).build(null));
}