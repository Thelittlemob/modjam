package modjam.the_little_mob.biomadventure.core.setup;

import modjam.the_little_mob.biomadventure.Biomadventure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Biomadventure.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy {

	@Override
	public void init() {
	}

	@SuppressWarnings("resource")
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

}
