package harmonised.pmmo.features.fireworks;

import java.util.Iterator;
import java.util.List;
import harmonised.pmmo.api.APIUtils;
import harmonised.pmmo.api.perks.Perk;
import harmonised.pmmo.core.CoreUtils;
import harmonised.pmmo.registry.SoundRegistry;
import harmonised.pmmo.setup.datagen.LangProvider;
import harmonised.pmmo.sound.PlayerJingle;
import harmonised.pmmo.sound.PlayerJingleProvider;
import harmonised.pmmo.util.MsLoggy;
import harmonised.pmmo.util.TagBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.registries.RegistryObject;

public class FireworkHandler {
	/**A sorely misplaced key used by the SKILL_UP event to mark what skill leveled up.*/
	public static final String FIREWORK_SKILL = "firework_skill";
	
	public static final Perk FIREWORK = Perk.begin()
			.addDefaults(TagBuilder.start().withString(APIUtils.SKILLNAME, "none").build())
			.setStart((player, nbt) -> {
				BlockPos pos = player.blockPosition();
				spawnRocket(player.level(), new Vec3(pos.getX(), pos.getY(), pos.getZ()), nbt.getString(FIREWORK_SKILL));
				return new CompoundTag();
			})
			.setStop((player, nbt) ->{
				player.getCapability(PlayerJingleProvider.PLAYER_JINGLE).ifPresent(jingle -> {
					if (!jingle.isAJinglePlaying()){
						levelUpSound(player, nbt.getString(FIREWORK_SKILL), nbt.getInt(APIUtils.SKILL_LEVEL));
						jingle.setJinglePlaying(true);
					}
				});
				return new CompoundTag();
			})
			.setDescription(LangProvider.PERK_FIREWORK_DESC.asComponent())
			.setStatus((p, nbt) -> List.of(LangProvider.PERK_FIREWORK_STATUS_1
					.asComponent(Component.translatable("pmmo."+nbt.getString(APIUtils.SKILLNAME))
							.withStyle(CoreUtils.getSkillStyle(nbt.getString(APIUtils.SKILLNAME)))))).build();
	public static void levelUpSound(Player player, String skillName, int skillLevel){
		int choice = ((skillLevel) % 5 == 0 ? 2 : 1);
		String eventName = skillName + "_" + choice;

		SoundRegistry.SOUND_EVENTS.getEntries().forEach(sound ->{
			if (sound.getId().getPath().equals(eventName)){
				player.level().playSound(null,player.blockPosition(),sound.get(), SoundSource.MASTER,1.0f,1.0f);
			}
		});
	}
	public static void spawnRocket(Level world, Vec3 pos, String skill/*, @Nullable WorldText explosionText*/)
	{
		CompoundTag nbt = new CompoundTag();
		CompoundTag fw = new CompoundTag();
		ListTag explosion = new ListTag();
		CompoundTag l = new CompoundTag();

		int[] colors = new int[] {CoreUtils.getSkillColor(skill)};

		l.putInt("Flicker", 1);
		l.putInt("Trail", 0);
		l.putInt("Type", 1);
		l.put("Colors", new IntArrayTag(colors));
		explosion.add(l);

		fw.put("Explosions", explosion);
		fw.putInt("Flight", 0);
		nbt.put("Fireworks", fw);

		ItemStack itemStack = new ItemStack(Items.FIREWORK_ROCKET);
		itemStack.setTag(nbt);

		PMMOFireworkEntity fireworkRocketEntity = new PMMOFireworkEntity(world, pos.x() + 0.5D, pos.y() + 0.5D, pos.z() + 0.5D, itemStack);
		//if(explosionText != null)
		//	fireworkRocketEntity.setExplosionText(explosionText);
		world.addFreshEntity(fireworkRocketEntity);
	}
}
