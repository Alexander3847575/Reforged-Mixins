package net.impactdev.reforged.mixins.api.translations.forms.types;

import net.impactdev.reforged.mixins.api.translations.forms.Destination;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslation;

import javax.annotation.Nullable;
import java.util.Optional;

public class PaletteTranslation implements LegacyFormTranslation {

    private final String name;
    private final String form;

    public static PaletteTranslation of(final String name) {
        return new PaletteTranslation(name, null);
    }

    public static PaletteTranslation of(final String name, @Nullable final String form) {
        return new PaletteTranslation(name, form);
    }

    private PaletteTranslation(String name, @Nullable String form) {
        this.name = name;
        this.form = form;
    }

    public final String name() {
        return this.name;
    }

    public Optional<String> form() {
        return Optional.ofNullable(this.form);
    }

    @Override
    public Destination destination() {
        return Destination.PALETTE;
    }

}
