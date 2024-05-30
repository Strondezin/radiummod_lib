package radium.lib.procedure;

import radium.lib.ElementsRadiumLib;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

@ElementsRadiumLib.ModElement.Tag
public class ProcedureWarning extends ElementsRadiumLib.ModElement {
	public ProcedureWarning(ElementsRadiumLib instance) {
		super(instance, 1);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("\u00A7cWARNING!!"));
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString(
						"\u00A76EN: \u00A7eAny distribution of this mod is not allowed, if you would like to reply to a distribution source for it, send a DM to cristianmakes on Discord, please."));
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("-----------------------------------------------------"));
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("\u00A7cAVISO!!"));
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString(
						"\u00A76PT: \u00A7eQualquer distribui\u00E7\u00E3o deste mod n\u00E3o \u00E9 permitida, se voc\u00EA quiser ajudar reportando uma fonte de distribui\u00E7\u00E3o, envie uma DM para cristianmakes no Discord, por favor."));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.player;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", (int) entity.posX);
		dependencies.put("y", (int) entity.posY);
		dependencies.put("z", (int) entity.posZ);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
