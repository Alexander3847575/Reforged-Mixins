package net.impactdev.reforged.mixins;

import com.pixelmonmod.api.registry.RegistryValue;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.species.Stats;
import com.pixelmonmod.pixelmon.api.pokemon.species.gender.Gender;
import net.impactdev.reforged.mixins.api.translations.forms.Destination;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslation;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyKey;
import net.impactdev.reforged.mixins.api.translations.forms.types.PaletteTranslation;
import net.impactdev.reforged.mixins.api.registry.Registries;
import net.impactdev.reforged.mixins.registries.LegacyFormTranslationRegistry;
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
import java.util.Optional;

@Mod("reforgedmixins")
public class ReforgedMixins {

	public static final Logger logger = LogManager.getLogger("Reforged Mixins");

	public ReforgedMixins() {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
		Mixins.addConfiguration("mixins.impactdev.reforged.json");
		MinecraftForge.EVENT_BUS.register(this);
		logger.info("Booting Reforged Mixins, ready to apply patches to Reforged's shortcomings");
	}

	@SubscribeEvent
	public void onServerLaunch(FMLServerStartedEvent event) {

		// Moved later in lifecycle to prevent classloading which broke the mixin targets
		Registries.LEGACY_FORMS.set(new LegacyFormTranslationRegistry());
		Registries.LEGACY_FORMS.get().init();
		Map<LegacyKey, LegacyFormTranslation> translations = Registries.LEGACY_FORMS.get().translations();
		long forms = translations.values().stream().filter(x -> x.destination() == Destination.FORM).count();
		long palettes = translations.values().stream().filter(x -> x.destination() == Destination.PALETTE).count();

		logger.info("Registered form translations: " + forms);
		logger.info("Registered palette translations: " + palettes);

		long fValid = translations.entrySet().stream()
				.filter(entry -> entry.getValue().destination() == Destination.FORM)
				.filter(entry -> {
					RegistryValue<Species> species = entry.getKey().species();
					if(species != null) {
						return species.getValue().map(s -> s.hasForm(entry.getValue().name())).isPresent();
					}

					return true;
				})
				.count();
		long pValid = translations.entrySet().stream()
				.filter(entry -> entry.getValue().destination() == Destination.PALETTE)
				.filter(entry -> {
					RegistryValue<Species> species = entry.getKey().species();
					PaletteTranslation translation = (PaletteTranslation) entry.getValue();
					if(species != null) {
						for(Gender gender : Gender.values()) {
							Optional<Stats> stats = species.getValue()
									.flatMap(s -> translation.form().map(s::getForm));
							if(!stats.isPresent()) {
								stats = species.getValue().map(Species::getDefaultForm);
							}

							if(stats.map(s -> s.getGenderProperties(gender)).map(g -> g.getPalette(entry.getValue().name())).isPresent()) {
								return false;
							}
						}

						return true;
					}

					return false;
				})
				.peek(entry -> logger.info("Invalid Palette translation: " + entry.getKey()))
				.count();

		logger.debug("Valid form translations: {}/{}", fValid, forms);
		logger.debug("Valid palette translations: {}/{}", palettes - pValid, palettes);
	}

}
