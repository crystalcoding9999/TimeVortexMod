package net.plaaasma.vortexmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.plaaasma.vortexmod.VortexMod;

public class TardisBlockEntity extends BlockEntity {
    public final ContainerData data;

    public int owner = 0;

    public TardisBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TARDIS_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> TardisBlockEntity.this.owner;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> TardisBlockEntity.this.owner = pValue;
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        CompoundTag vortexModData = pTag.getCompound(VortexMod.MODID);

        this.owner = vortexModData.getInt("owner");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        CompoundTag vortexModData = new CompoundTag();

        vortexModData.putInt("owner", this.owner);

        pTag.put(VortexMod.MODID, vortexModData);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide()) {
            return;
        }

        setChanged(pLevel, pPos, pState);
    }
}