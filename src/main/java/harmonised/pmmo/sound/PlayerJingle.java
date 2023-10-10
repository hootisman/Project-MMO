package harmonised.pmmo.sound;

import net.minecraft.nbt.CompoundTag;

public class PlayerJingle {
    private boolean jinglePlaying;
    private int tickCooldown;

    public boolean isAJinglePlaying(){
        return jinglePlaying;
    }
    public int getTickCooldown(){
        return tickCooldown;
    }
    public void setJinglePlaying(boolean set){
        jinglePlaying = set;
    }
    public void setTickCooldown(int set){
        tickCooldown = set;
    }

    public void incrementTickCooldown() {
        tickCooldown += 1;
    }
}
