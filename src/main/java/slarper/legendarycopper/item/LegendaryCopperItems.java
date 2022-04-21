package slarper.legendarycopper.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import slarper.legendarycopper.LegendaryCopper;

public class LegendaryCopperItems {
    public static void load(){}
    private static Item register(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier(LegendaryCopper.MOD_ID, id), item);
    }
    public static final ToolMaterial TOOL_MATERIAL_COPPER = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 181;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6.0F;
        }

        @Override
        public float getAttackDamage() {
            return 2.0F;
        }

        @Override
        public int getMiningLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 14;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.COPPER_INGOT);
        }
    };


    public static final Item COPPER_SWORD;
    public static final Item COPPER_SHOVEL;
    public static final Item COPPER_PICKAXE;
    public static final Item COPPER_AXE;
    public static final Item COPPER_HOE;
    public static final Item COPPER_NUGGET;

    static {
        COPPER_SWORD = register("copper_sword", new SwordItem(TOOL_MATERIAL_COPPER, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT)));
        COPPER_SHOVEL = register("copper_shovel", new ShovelItem(TOOL_MATERIAL_COPPER, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_PICKAXE = register("copper_pickaxe", new LegendaryCopperPickaxeItem(TOOL_MATERIAL_COPPER, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_AXE = register("copper_axe", new LegendaryCopperAxeItem(TOOL_MATERIAL_COPPER, 6.0F, -3.1F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_HOE = register("copper_hoe", new LegendaryCopperHoeItem(TOOL_MATERIAL_COPPER, -2, -1.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_NUGGET = register("copper_nugget", new Item((new FabricItemSettings()).group(ItemGroup.MATERIALS)));

    }
}
