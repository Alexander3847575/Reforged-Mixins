package net.impactdev.reforged.mixins.api.translations.forms;

import com.pixelmonmod.api.registry.RegistryValue;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

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
        this.id = Math.max(0, id);
        this.species = species;
    }

    public final RegistryValue<Species> species() {
        return this.species;
    }

    public final int id() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegacyKey legacyKey = (LegacyKey) o;
        return id == legacyKey.id && Objects.equals(species, legacyKey.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, id);
    }

    @Override
    public String toString() {
        return "LegacyKey{" +
                "species=" + Optional.ofNullable(this.species).map(RegistryValue::getKey).orElse(null) +
                ", id=" + id +
                '}';
    }
}
