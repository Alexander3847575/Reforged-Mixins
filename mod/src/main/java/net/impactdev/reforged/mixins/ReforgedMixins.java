package net.impactdev.reforged.mixins;

import com.google.common.collect.Maps;
import net.impactdev.reforged.mixins.api.forms.Destination;
import net.impactdev.reforged.mixins.api.forms.FormTarget;
import net.impactdev.reforged.mixins.api.forms.LegacyKey;
import net.impactdev.reforged.mixins.registries.Registries;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@Mod("reforgedmixins")
public class ReforgedMixins {

	public static final Logger logger = LogManager.getLogger("Pixelmon Mixins");

	public ReforgedMixins() {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
		Mixins.addConfiguration("mixins.impactdev.reforged.json");
		MinecraftForge.EVENT_BUS.register(this);
		logger.info("Booting Pixelmon Mixins");

		Registries.LEGACY_FORMS.init();
	}

	@SubscribeEvent
	public void onServerLaunch(FMLServerStartedEvent event) {
		Map<LegacyKey, FormTarget> translations = Registries.LEGACY_FORMS.translations();
		long forms = translations.values().stream().filter(x -> x.destination() == Destination.FORM).count();
		long palettes = translations.values().stream().filter(x -> x.destination() == Destination.PALETTE).count();

		logger.info("Registered form translations: " + forms);
		logger.info("Registered palette translations: " + palettes);
	}

}
