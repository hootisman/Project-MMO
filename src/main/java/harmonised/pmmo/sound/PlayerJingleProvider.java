package harmonised.pmmo.sound;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerJingleProvider implements ICapabilityProvider {
    public static Capability<PlayerJingle> PLAYER_JINGLE = CapabilityManager.get(new CapabilityToken<PlayerJingle>() {});

    private PlayerJingle jingle = null;
    private final LazyOptional<PlayerJingle> opt = LazyOptional.of(this::getJingle);

    private PlayerJingle getJingle(){
        if (jingle == null){
            jingle = new PlayerJingle();
            jingle.setJinglePlaying(false);
            jingle.setTickCooldown(0);
        }
        return jingle;
    }
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_JINGLE){
            return opt.cast();
        }

        return LazyOptional.empty();
    }
}
