package net.impactdev.reforged.mixins.extensions;

import com.pixelmonmod.pixelmon.api.pokemon.item.pokeball.PokeBall;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.species.Stats;
import com.pixelmonmod.pixelmon.api.pokemon.species.gender.Gender;
import com.pixelmonmod.pixelmon.api.pokemon.species.gender.GenderProperties;
import com.pixelmonmod.pixelmon.api.pokemon.species.palette.PaletteProperties;

public interface PokemonBaseExpansion {

    int contentVersion();

    void species(Species species);
    void form(Stats form);
    Stats form();
    void palette(PaletteProperties palette);
    void gender(Gender gender);
    void pokeball(PokeBall ball);
    void eggCycles(int cycles);

    // Effectively shadowed methods
    Species getSpecies();
    GenderProperties getGenderProperties();

}
