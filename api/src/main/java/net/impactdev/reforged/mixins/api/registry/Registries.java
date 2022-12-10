package net.impactdev.reforged.mixins.api.registry;

import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslator;

public class Registries {

    public static final Delegator<LegacyFormTranslator> LEGACY_FORMS = new Delegator<>(LegacyFormTranslator.class);

}
