package modjam.the_little_mob.biomadventure.core.setup;

import net.minecraft.world.World;

public interface IProxy {
	void init();

	World getClientWorld();
}
