package harmonised.pmmo.registry;

import harmonised.pmmo.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class SoundRegistry {
    public static final String[] SOUND_NAMES = {
        "agility_1",
        "agility_2",
        "alchemy_1",
        "alchemy_2",
        "attack_1",
        "attack_2",
        "building_1",
        "building_2",
        "charisma_1",
        "charisma_2",
        "cooking_1",
        "cooking_2",
        "crafting_1",
        "crafting_2",
        "defence_1",
        "defence_2",
        "engineering_1",
        "engineering_2",
        "farming_1",
        "farming_2",
        "fishing_1",
        "fishing_2",
        "flying_1",
        "flying_2",
        "hunter_1",
        "hunter_2",
        "magic_1",
        "magic_2",
        "mining_1",
        "mining_2",
        "mysticcrafting_1",
        "mysticcrafting_2",
        "navigation_1",
        "navigation_2",
        "ranged_1",
        "ranged_2",
        "slayer_1",
        "slayer_2",
        "smithing_1",
        "smithing_2",
        "stealth_1",
        "stealth_2",
        "taming_1",
        "taming_2",
        "woodcutting_1",
        "woodcutting_2"
    };
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);
    public static final RegistryObject<SoundEvent> AGILITY_1 = SOUND_EVENTS.register("agility_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"agility_1")));
    public static final RegistryObject<SoundEvent> AGILITY_2 = SOUND_EVENTS.register("agility_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"agility_2")));
    public static final RegistryObject<SoundEvent> ALCHEMY_1 = SOUND_EVENTS.register("alchemy_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"alchemy_1")));
    public static final RegistryObject<SoundEvent> ALCHEMY_2 = SOUND_EVENTS.register("alchemy_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"alchemy_2")));
    public static final RegistryObject<SoundEvent> ATTACK_1 = SOUND_EVENTS.register("attack_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"attack_1")));
    public static final RegistryObject<SoundEvent> ATTACK_2 = SOUND_EVENTS.register("attack_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"attack_2")));
    public static final RegistryObject<SoundEvent> BUILDING_1 = SOUND_EVENTS.register("building_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"building_1")));
    public static final RegistryObject<SoundEvent> BUILDING_2 = SOUND_EVENTS.register("building_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"building_2")));
    public static final RegistryObject<SoundEvent> CHARISMA_1 = SOUND_EVENTS.register("charisma_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"charisma_1")));
    public static final RegistryObject<SoundEvent> CHARISMA_2 = SOUND_EVENTS.register("charisma_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"charisma_2")));
    public static final RegistryObject<SoundEvent> COOKING_1 = SOUND_EVENTS.register("cooking_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"cooking_1")));
    public static final RegistryObject<SoundEvent> COOKING_2 = SOUND_EVENTS.register("cooking_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"cooking_2")));
    public static final RegistryObject<SoundEvent> CRAFTING_1 = SOUND_EVENTS.register("crafting_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"crafting_1")));
    public static final RegistryObject<SoundEvent> CRAFTING_2 = SOUND_EVENTS.register("crafting_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"crafting_2")));
    public static final RegistryObject<SoundEvent> DEFENCE_1 = SOUND_EVENTS.register("defence_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"defence_1")));
    public static final RegistryObject<SoundEvent> DEFENCE_2 = SOUND_EVENTS.register("defence_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"defence_2")));
    public static final RegistryObject<SoundEvent> ENGINEERING_1 = SOUND_EVENTS.register("engineering_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"engineering_1")));
    public static final RegistryObject<SoundEvent> ENGINEERING_2 = SOUND_EVENTS.register("engineering_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"engineering_2")));
    public static final RegistryObject<SoundEvent> FARMING_1 = SOUND_EVENTS.register("farming_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"farming_1")));
    public static final RegistryObject<SoundEvent> FARMING_2 = SOUND_EVENTS.register("farming_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"farming_2")));
    public static final RegistryObject<SoundEvent> FISHING_1 = SOUND_EVENTS.register("fishing_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"fishing_1")));
    public static final RegistryObject<SoundEvent> FISHING_2 = SOUND_EVENTS.register("fishing_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"fishing_2")));
    public static final RegistryObject<SoundEvent> FLYING_1 = SOUND_EVENTS.register("flying_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"flying_1")));
    public static final RegistryObject<SoundEvent> FLYING_2 = SOUND_EVENTS.register("flying_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"flying_2")));
    public static final RegistryObject<SoundEvent> HUNTER_1 = SOUND_EVENTS.register("hunter_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"hunter_1")));
    public static final RegistryObject<SoundEvent> HUNTER_2 = SOUND_EVENTS.register("hunter_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"hunter_2")));
    public static final RegistryObject<SoundEvent> MAGIC_1 = SOUND_EVENTS.register("magic_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"magic_1")));
    public static final RegistryObject<SoundEvent> MAGIC_2 = SOUND_EVENTS.register("magic_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"magic_2")));
    public static final RegistryObject<SoundEvent> MINING_1 = SOUND_EVENTS.register("mining_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"mining_1")));
    public static final RegistryObject<SoundEvent> MINING_2 = SOUND_EVENTS.register("mining_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"mining_2")));
    public static final RegistryObject<SoundEvent> MYSTICCRAFTING_1 = SOUND_EVENTS.register("mysticcrafting_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"mysticcrafting_1")));
    public static final RegistryObject<SoundEvent> MYSTICCRAFTING_2 = SOUND_EVENTS.register("mysticcrafting_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"mysticcrafting_2")));
    public static final RegistryObject<SoundEvent> NAVIGATION_1 = SOUND_EVENTS.register("navigation_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"navigation_1")));
    public static final RegistryObject<SoundEvent> NAVIGATION_2 = SOUND_EVENTS.register("navigation_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"navigation_2")));
    public static final RegistryObject<SoundEvent> RANGED_1 = SOUND_EVENTS.register("ranged_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"ranged_1")));
    public static final RegistryObject<SoundEvent> RANGED_2 = SOUND_EVENTS.register("ranged_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"ranged_2")));
    public static final RegistryObject<SoundEvent> SLAYER_1 = SOUND_EVENTS.register("slayer_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"slayer_1")));
    public static final RegistryObject<SoundEvent> SLAYER_2 = SOUND_EVENTS.register("slayer_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"slayer_2")));
    public static final RegistryObject<SoundEvent> SMITHING_1 = SOUND_EVENTS.register("smithing_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"smithing_1")));
    public static final RegistryObject<SoundEvent> SMITHING_2 = SOUND_EVENTS.register("smithing_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"smithing_2")));
    public static final RegistryObject<SoundEvent> STEALTH_1 = SOUND_EVENTS.register("stealth_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"stealth_1")));
    public static final RegistryObject<SoundEvent> STEALTH_2 = SOUND_EVENTS.register("stealth_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"stealth_2")));
    public static final RegistryObject<SoundEvent> TAMING_1 = SOUND_EVENTS.register("taming_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"taming_1")));
    public static final RegistryObject<SoundEvent> TAMING_2 = SOUND_EVENTS.register("taming_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"taming_2")));
    public static final RegistryObject<SoundEvent> WOODCUTTING_1 = SOUND_EVENTS.register("woodcutting_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"woodcutting_1")));
    public static final RegistryObject<SoundEvent> WOODCUTTING_2 = SOUND_EVENTS.register("woodcutting_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"woodcutting_2")));
    public void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
