package harmonised.pmmo.events;

import harmonised.pmmo.sound.PlayerJingle;
import harmonised.pmmo.sound.PlayerJingleProvider;
import harmonised.pmmo.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CapEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e){
        e.player.getCapability(PlayerJingleProvider.PLAYER_JINGLE).ifPresent(playerJingle -> {
            if (playerJingle.isAJinglePlaying()){
                if (playerJingle.getTickCooldown() > 100){
                    playerJingle.setTickCooldown(0);
                    playerJingle.setJinglePlaying(false);
                }else{
                    playerJingle.incrementTickCooldown();
                }
            }
        });
    }

    @SubscribeEvent
    public static void onAttachCapsPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player){
            if (!event.getObject().getCapability(PlayerJingleProvider.PLAYER_JINGLE).isPresent()){
                event.addCapability(new ResourceLocation(Reference.MOD_ID,"properties"), new PlayerJingleProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onRegisterCaps(RegisterCapabilitiesEvent event){
        event.register(PlayerJingle.class);
    }
}
