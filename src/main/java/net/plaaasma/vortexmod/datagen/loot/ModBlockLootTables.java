package net.plaaasma.vortexmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.plaaasma.vortexmod.block.ModBlocks;
import net.plaaasma.vortexmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.THROTTLE_BLOCK.get());
        this.dropSelf(ModBlocks.INTERFACE_BLOCK.get());
        this.dropSelf(ModBlocks.COORDINATE_BLOCK.get());
        this.dropSelf(ModBlocks.KEYPAD_BLOCK.get());
        this.dropSelf(ModBlocks.SIZE_MANIPULATOR_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}