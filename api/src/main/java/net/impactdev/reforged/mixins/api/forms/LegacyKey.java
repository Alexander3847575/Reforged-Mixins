package net.impactdev.reforged.mixins.api.forms;

import com.pixelmonmod.api.registry.RegistryValue;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;

import javax.annotation.Nullable;

public class LegacyKey {

    private final RegistryValue<Species> species;
    private final int id;

    public static LegacyKey of(final int id) {
        return of(id, null);
    }

    public static LegacyKey of(final int id, @Nullable final RegistryValue<Species> species) {
        return new LegacyKey(id, species);
    }

    private LegacyKey(final int id, @Nullable final RegistryValue<Species> species) {
        this.id = id;
        this.species = species;
    }

    public final RegistryValue<Species> species() {
        return this.species;
    }

    public final int id() {
        return this.id;
    }

}
