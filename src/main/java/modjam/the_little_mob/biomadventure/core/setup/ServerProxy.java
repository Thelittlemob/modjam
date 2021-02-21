package modjam.the_little_mob.biomadventure.core.setup;

import modjam.the_little_mob.biomadventure.Biomadventure;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Biomadventure.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerProxy implements IProxy{

	@Override
	public void init() {
	}

	@Override
	public World getClientWorld() {
		throw new IllegalStateException("Cannot run on server!");
	}
}
