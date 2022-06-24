package net.impactdev.reforged.mixins.api.forms;

import com.pixelmonmod.api.registry.RegistryValue;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Provides a means for forms pre-Reforged 9.x to be translated to their new intended typing.
 * Some forms are no longer forms, but are rather palettes instead. As such, it is expected that
 * a registration also provides a mapping of its intended write location.
 *
 * Reforged is very lazy, and did not provide their own proper mapping with a 1.16.5 update. As
 * such, any pokemon with a form in 1.12.2 will lose this form upon conversion (assuming they
 * would even convert correctly). The implementation will provide a base mapping for the
 * translations, but this API is meant to serve as a means of providing this implementation
 * additional detail on custom forms.
 */
public interface LegacyFormTranslator {

    /**
     * Provides a mapping for registered translations between the 1.12.2 information to
     * its 1.16.5 translation representation.
     *
     * @return The translation mapping for 1.12.2 to 1.16.5 data
     */
    Map<LegacyKey, FormTarget> translations();

    /**
     * Registers a form translation between 1.12.2 and 1.16.5 data.
     *
     * <p>With 1.16.5, some forms became palettes due to these being cosmetic
     * changes rather than stat/model changes. As such, it's required a destination
     * for a translation be specified to detail the proper endpoint on 1.16.5.
     *
     * @param legacy The 1.12.2 form ID to translate from
     * @param target The target name of the form on 1.16.5
     * @param destination The target destination of the translation, that being a form or palette
     * @return <code>true</code> if the translation was registered, <code>false</code> if a
     * registration was already registered with the same key parameters.
     */
    default boolean register(int legacy, String target, Destination destination) {
        return this.register(null, legacy, target, destination);
    }

    /**
     * Registers a form translation between 1.12.2 and 1.16.5 data.
     *
     * <p>In some cases, a species might need to be provided to further help with
     * translation, due to no uniform ID system. For example, Arcanine with form
     * ID 3 means it is Hisuian, while for Arceus, form ID 3 equals Arceus-Water.
     * The species would help to differentiate the translations and ensure that
     * the correct form is applied at time of translation.
     *
     * @param species A nullable registry key indicating the target species of the translation
     * @param legacy The 1.12.2 form ID to translate from
     * @param target The target name of the form on 1.16.5
     * @param destination The target destination of the translation, that being a form or palette
     * @return <code>true</code> if the translation was registered, <code>false</code> if a
     * registration was already registered with the same key parameters.
     * @see #register(int, String, Destination) for further documentation on destination
     */
    default boolean register(@Nullable RegistryValue<Species> species, int legacy, String target, Destination destination) {
        return this.register(LegacyKey.of(legacy, species), FormTarget.of(target, destination));
    }

    /**
     * Registers a form translation between 1.12.2 and 1.16.5 data.
     *
     * <p>In some cases, a species might need to be provided to further help with
     * translation, due to no uniform ID system. For example, Arcanine with form
     * ID 3 means it is Hisuian, while for Arceus, form ID 3 equals Arceus-Water.
     * The species would help to differentiate the translations and ensure that
     * the correct form is applied at time of translation.
     *
     * @param key A bundle of the legacy 1.12.2 ID and an optional species key
     * @param target The name and destination for a translation on 1.16.5
     * @return <code>true</code> if the translation was registered, <code>false</code> if a
     * registration was already registered with the same key parameters.
     * @see #register(int, String, Destination) for further documentation on destination
     */
    boolean register(LegacyKey key, FormTarget target);

}
