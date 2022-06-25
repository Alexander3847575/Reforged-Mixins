package net.impactdev.reforged.mixins.api.translations.forms.types;

import net.impactdev.reforged.mixins.api.translations.forms.Destination;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslation;

public class FormTranslation implements LegacyFormTranslation {

    private final String name;

    public static FormTranslation of(final String name) {
        return new FormTranslation(name);
    }

    private FormTranslation(String name) {
        this.name = name;
    }

    public final String name() {
        return this.name;
    }

    public final Destination destination() {
        return Destination.FORM;
    }

}
