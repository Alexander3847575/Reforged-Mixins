package net.impactdev.reforged.mixins.api.translations.forms.types;

import net.impactdev.reforged.mixins.api.translations.forms.Destination;
import net.impactdev.reforged.mixins.api.translations.forms.LegacyFormTranslation;

import javax.annotation.Nullable;
import java.util.Optional;

public class PaletteTranslation implements LegacyFormTranslation {

    private final String name;
    private final String form;
    private final String shinySuffix; // The ONLY reason why this exists is that for some reason the Florges line has <form>shiny whereas others have <form>_shiny

    public static PaletteTranslation of(final String name) {
        return PaletteTranslation.of(name, null);
    }

    public static PaletteTranslation of(final String name, @Nullable final String form) {
        return PaletteTranslation.of(name, form, "_shiny");
    }

    public static PaletteTranslation of(final String name, @Nullable final String form, String shinySuffix) {
        return new PaletteTranslation(name, form, shinySuffix);
    }

    private PaletteTranslation(String name, @Nullable String form, String shinySuffix) {
        this.name = name;
        this.form = form;
        this.shinySuffix = shinySuffix;
    }

    public final String name() {
        return this.name;
    }

    public Optional<String> form() {
        return Optional.ofNullable(this.form);
    }

    public final String shinySuffix() { return this.shinySuffix; }

    @Override
    public Destination destination() {
        return Destination.PALETTE;
    }

}
