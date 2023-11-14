package net.olervi.modularprocessing.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.olervi.modularprocessing.tiles.PoweredSmelterTile;

public class PoweredSmelterBlock extends Block {
    public PoweredSmelterBlock(AbstractBlock.Properties props){
        super(props);
    }
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit){
        if (!world.isClientSide() && hand == Hand.MAIN_HAND){
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof PoweredSmelterTile){
                ((PoweredSmelterTile) tile).toggle();
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                return ActionResultType.SUCCESS;
            }
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
