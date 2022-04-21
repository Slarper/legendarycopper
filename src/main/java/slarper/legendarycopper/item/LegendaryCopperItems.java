package slarper.legendarycopper.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
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
            return 200;
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
    public static final ArmorMaterial ARMOR_MATERIAL_COPPER = new ArmorMaterial() {
        private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
        private final int[] protectionAmounts = new int[]{2, 5, 6, 2};
        private final SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_IRON;

        @Override
        public int getDurability(EquipmentSlot slot) {
            int durabilityMultiplier = 11;
            return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMultiplier;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return this.protectionAmounts[slot.getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return 9;
        }

        @Override
        public SoundEvent getEquipSound() {
            return this.equipSound;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.COPPER_INGOT);
        }

        @Override
        public String getName() {
            return "copper";
        }

        @Override
        public float getToughness() {
            return 0.0F;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0F;
        }
    };


    public static final Item COPPER_SWORD;
    public static final Item COPPER_SHOVEL;
    public static final Item COPPER_PICKAXE;
    public static final Item COPPER_AXE;
    public static final Item COPPER_HOE;
    public static final Item COPPER_NUGGET;
    public static final Item COPPER_HORSE_ARMOR;

    public static final Item COPPER_HELMET;
    public static final Item COPPER_CHESTPLATE;
    public static final Item COPPER_LEGGINGS;
    public static final Item COPPER_BOOTS;


    static {
        COPPER_SWORD = register("copper_sword", new SwordItem(TOOL_MATERIAL_COPPER, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT)));
        COPPER_SHOVEL = register("copper_shovel", new ShovelItem(TOOL_MATERIAL_COPPER, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_PICKAXE = register("copper_pickaxe", new LegendaryCopperPickaxeItem(TOOL_MATERIAL_COPPER, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_AXE = register("copper_axe", new LegendaryCopperAxeItem(TOOL_MATERIAL_COPPER, 6.0F, -3.1F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_HOE = register("copper_hoe", new LegendaryCopperHoeItem(TOOL_MATERIAL_COPPER, -2, -1.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
        COPPER_NUGGET = register("copper_nugget", new Item((new FabricItemSettings()).group(ItemGroup.MATERIALS)));
        COPPER_HORSE_ARMOR = register("copper_horse_armor", new HorseArmorItem(5, "copper", (new FabricItemSettings()).maxCount(1).group(ItemGroup.MISC)));

        COPPER_HELMET = register("copper_helmet", new ArmorItem(ARMOR_MATERIAL_COPPER, EquipmentSlot.HEAD, (new FabricItemSettings()).group(ItemGroup.COMBAT)));
        COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(ARMOR_MATERIAL_COPPER, EquipmentSlot.CHEST, (new FabricItemSettings()).group(ItemGroup.COMBAT)));
        COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(ARMOR_MATERIAL_COPPER, EquipmentSlot.LEGS, (new FabricItemSettings()).group(ItemGroup.COMBAT)));
        COPPER_BOOTS = register("copper_boots", new ArmorItem(ARMOR_MATERIAL_COPPER, EquipmentSlot.FEET, (new FabricItemSettings()).group(ItemGroup.COMBAT)));


    }
}
