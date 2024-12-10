package deus.examplemod.block;

import deus.examplemod.guis.supercraftingtable.ExampleBlock;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static deus.guilib.GuiLib.config;
import static deus.guilib.util.blockanditems.BlockMaker.genericBlockBuilder;
import static deus.guilib.util.blockanditems.BlockMaker.make;

public class ExamplemodBlocks {

	public static ExampleBlock exampleBlock;

	public void initialize() {

		BlockBuilder stoneBlockBuilder = genericBlockBuilder
			.setBlockSound(BlockSounds.STONE)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			;

		BlockBuilder logBlockBuilder = genericBlockBuilder
			.setBlockSound(BlockSounds.WOOD)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setTags(BlockTags.MINEABLE_BY_AXE)
			;

		exampleBlock = make(
			logBlockBuilder
				.setTextures("examplemod:block/block_log_pile_side")
				.setTopBottomTextures("examplemod:block/block_log_pile"),
			new ExampleBlock("block.log.pile",config.newBlockID(), Material.wood)
		);
		System.out.println(exampleBlock.id);


	}


	public void blockAddDetails() {
		//ItemToolPickaxe.miningLevels.put(runeBlock, 1);
		//CreativeHelper.setParent(runeBlock, Block.netherrack);
		//CreativeHelper.setParent(netherRuneBlock, Block.stone);
		//Registries.ITEM_GROUPS.register("rune:rune_ores", Registries.stackListOf(runeBlock));
		//Registries.ITEM_GROUPS.register("rune:rune_ores", Registries.stackListOf(netherRuneBlock));
	}
}
