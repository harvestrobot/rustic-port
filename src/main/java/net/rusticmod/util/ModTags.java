package net.rusticmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.rusticmod.RusticMod;

public class ModTags {

    public static class Blocks{

        private static TagKey<Block> tag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, name));
        }

        public static final TagKey<Block> TEMPORAL_BEACONS =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "temporal_beacons"));
    }

    public static class Items {
        private static TagKey<Item> tag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, name));
        }
        public static final TagKey<Item> MUSHROOMS =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "mushrooms"));
        public static final TagKey<Item> SYRINGES =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "syringes"));
    }
}
