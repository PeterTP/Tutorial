package com.petertp.tutorial.item

import com.petertp.tutorial.Tutorial
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import java.util.function.Supplier

enum class ModArmorMaterials(
    private val armorName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>
) : ArmorMaterial {
    RUBY("ruby", 25, intArrayOf(3, 8, 6, 3), 19,
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2f, 0.1f, Supplier<Ingredient> {
            Ingredient.ofItems(
                ModItems.RUBY
            )
        });

    override fun getDurability(type: ArmorItem.Type): Int {
        return BASE_DURABILITY[type.ordinal] * durabilityMultiplier
    }

    override fun getProtection(type: ArmorItem.Type): Int {
        return protectionAmounts[type.ordinal]
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return "${Tutorial.MOD_ID}:$armorName"
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }

    companion object {
        private val BASE_DURABILITY = intArrayOf(11, 16, 15, 13)
    }
}
