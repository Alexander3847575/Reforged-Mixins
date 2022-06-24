package net.impactdev.reforged.mixins.registries;

import com.google.common.collect.Maps;
import com.pixelmonmod.api.registry.RegistryValue;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.registries.PixelmonForms;
import com.pixelmonmod.pixelmon.api.registries.PixelmonPalettes;
import net.impactdev.reforged.mixins.api.forms.Destination;
import net.impactdev.reforged.mixins.api.forms.FormTarget;
import net.impactdev.reforged.mixins.api.forms.LegacyFormTranslator;
import net.impactdev.reforged.mixins.api.forms.LegacyKey;

import java.util.Map;

import static com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies.*;

public class LegacyFormTranslationRegistry implements Registry, LegacyFormTranslator {

    private final Map<LegacyKey, FormTarget> translations = Maps.newHashMap();

    @Override
    public Map<LegacyKey, FormTarget> translations() {
        return this.translations;
    }

    @Override
    public boolean register(LegacyKey key, FormTarget target) {
        if(this.translations.containsKey(key)) {
            return false;
        }

        this.translations.put(key, target);
        return true;
    }


    @Override
    public void init() {
        this.register(0, PixelmonForms.NONE, Destination.FORM);

        // Mega Pokemon
        this.mega(ABOMASNOW);
        this.mega(ABSOL);
        this.mega(AERODACTYL);
        this.mega(AGGRON);
        this.mega(ALAKAZAM);
        this.mega(ALTARIA);
        this.mega(AMPHAROS);
        this.mega(AUDINO);
        this.mega(BANETTE);
        this.mega(BLASTOISE);
        this.mega(BLAZIKEN);
        this.mega(CAMERUPT);
        this.register(CHARIZARD, 1, PixelmonForms.MEGA_X, Destination.FORM);
        this.register(CHARIZARD, 2, PixelmonForms.MEGA_Y, Destination.FORM);
        this.mega(DIANCIE);
        this.mega(GALLADE);
        this.mega(GARCHOMP);
        this.mega(GARDEVOIR);
        this.mega(GENGAR);
        this.mega(GLALIE);
        this.mega(GYARADOS);
        this.mega(HERACROSS);
        this.mega(HOUNDOOM);
        this.mega(KANGASKHAN);
        this.mega(LATIAS);
        this.mega(LATIOS);
        this.mega(LOPUNNY);
        this.mega(LUCARIO);
        this.mega(MANECTRIC);
        this.mega(MAWILE);
        this.mega(MEDICHAM);
        this.mega(METAGROSS);
        this.register(MEWTWO, 1, PixelmonForms.MEGA_X, Destination.FORM);
        this.register(MEWTWO, 2, PixelmonForms.MEGA_Y, Destination.FORM);
        this.mega(PIDGEOT);
        this.mega(PINSIR);
        this.mega(RAYQUAZA);
        this.mega(SABLEYE);
        this.mega(SALAMENCE);
        this.mega(SCEPTILE);
        this.mega(SCIZOR);
        this.mega(SHARPEDO);
        this.mega(SLOWBRO);
        this.mega(STEELIX);
        this.mega(SWAMPERT);
        this.mega(TYRANITAR);
        this.mega(VENUSAUR);

        // Common Forms
        this.register(AEGISLASH, 0, PixelmonForms.SHIELD, Destination.FORM);
        this.register(AEGISLASH, 1, PixelmonForms.BLADE, Destination.FORM);
        this.register(AEGISLASH, 2, PixelmonForms.ALTERED, Destination.FORM);

        this.register(AMOONGUSS, 1, PixelmonPalettes.BLACK, Destination.PALETTE);
        this.register(AMOONGUSS, 2, PixelmonPalettes.BROWN, Destination.PALETTE);
        this.register(AMOONGUSS, 3, PixelmonPalettes.CYAN, Destination.PALETTE);
        this.register(AMOONGUSS, 4, "dark_blue", Destination.PALETTE);
        this.register(AMOONGUSS, 5, "dark_green", Destination.PALETTE);
        this.register(AMOONGUSS, 6, "dark_pink", Destination.PALETTE);
        this.register(AMOONGUSS, 7, "dark_red", Destination.PALETTE);
        this.register(AMOONGUSS, 8, "forte_green", Destination.PALETTE);
        this.register(AMOONGUSS, 9, "grey", Destination.PALETTE);
        this.register(AMOONGUSS, 10, "light_brown", Destination.PALETTE);
        this.register(AMOONGUSS, 11, "light_pink", Destination.PALETTE);
        this.register(AMOONGUSS, 12, "light_yellow", Destination.PALETTE);
        this.register(AMOONGUSS, 13, "lime", Destination.PALETTE);
        this.register(AMOONGUSS, 14, "olive", Destination.PALETTE);
        this.register(AMOONGUSS, 15, "orange", Destination.PALETTE);
        this.register(AMOONGUSS, 16, "pink", Destination.PALETTE);
        this.register(AMOONGUSS, 17, "purple", Destination.PALETTE);
        this.register(AMOONGUSS, 18, "red", Destination.PALETTE);
        this.register(AMOONGUSS, 19, "white", Destination.PALETTE);
        this.register(AMOONGUSS, 20, "yellow", Destination.PALETTE);

        this.register(ARBOK, 1, PixelmonPalettes.PRIMARY_CIRCULAR, Destination.PALETTE);
        this.register(ARBOK, 2, PixelmonPalettes.SECONDARY_CIRCULAR, Destination.PALETTE);
        this.register(ARBOK, 3, PixelmonPalettes.DARK, Destination.PALETTE);

        this.register(ARCANINE, 3, PixelmonForms.HISUIAN, Destination.FORM);
        this.register(ARCANINE, 100, PixelmonPalettes.ZOMBIE, Destination.PALETTE);
        this.register(ARCANINE, 113, PixelmonPalettes.ASHEN, Destination.PALETTE);

        this.form(ARCEUS, 0, PixelmonForms.NORMAL);
        this.form(ARCEUS, 1, PixelmonForms.GRASS);
        this.form(ARCEUS, 2, PixelmonForms.FIRE);
        this.form(ARCEUS, 3, PixelmonForms.WATER);
        this.form(ARCEUS, 4, PixelmonForms.FLYING);
        this.form(ARCEUS, 5, PixelmonForms.BUG);
        this.form(ARCEUS, 6, PixelmonForms.POISON);
        this.form(ARCEUS, 7, PixelmonForms.ELECTRIC);
        this.form(ARCEUS, 8, PixelmonForms.PSYCHIC);
        this.form(ARCEUS, 9, PixelmonForms.ROCK);
        this.form(ARCEUS, 10, PixelmonForms.GROUND);
        this.form(ARCEUS, 11, PixelmonForms.DARK);
        this.form(ARCEUS, 12, PixelmonForms.GHOST);
        this.form(ARCEUS, 13, PixelmonForms.STEEL);
        this.form(ARCEUS, 14, PixelmonForms.FIGHTING);
        this.form(ARCEUS, 15, PixelmonForms.ICE);
        this.form(ARCEUS, 16, PixelmonForms.DRAGON);
        this.form(ARCEUS, 17, PixelmonForms.FAIRY);

        this.form(ARTICUNO, 2, PixelmonForms.GALARIAN);
        this.form(ZAPDOS, 2, PixelmonForms.GALARIAN);
        this.form(MOLTRES, 2, PixelmonForms.GALARIAN);

        this.palette(AZUMARILL, 107, PixelmonPalettes.ALTER);
        this.palette(BAGON, 107, PixelmonPalettes.ALTER);
        this.palette(BALTOY, 107, PixelmonPalettes.ALTER);

        this.form(BASCULIN, 0, "red");
        this.palette(BASCULIN, 1, "blue");
        this.palette(BASCULIN, 2, "white");

        this.palette(BEAUTIFLY, 104, PixelmonPalettes.RAINBOW);

        // They've forgotten to add the pink to the mega palettes, so just revert a mega to base pink
        this.palette(BEEDRILL, 91, PixelmonPalettes.PINK);
        this.palette(BEEDRILL, 108, PixelmonPalettes.PINK);

        this.palette(BELLOSSOM, 106, PixelmonPalettes.VALENCIAN);
        this.palette(BELLOSSOM, 108, PixelmonPalettes.PINK);

        this.palette(BELLSPROUT, 106, PixelmonPalettes.VALENCIAN);
        this.palette(BELLSPROUT, 108, PixelmonPalettes.PINK);

        this.form(BIDOOF, 1, PixelmonForms.SIRDOOFUSIII);

        this.palette(BLASTOISE, 100, PixelmonPalettes.ZOMBIE);
        this.palette(BLISSEY, 106, PixelmonPalettes.VALENCIAN);
        this.palette(BOLTUND, 112, PixelmonPalettes.VALENCIAN);
        this.form(BRAVIARY, 3, PixelmonForms.HISUIAN);
        this.palette(BRELOOM, 114, PixelmonPalettes.SPIRIT);
        this.form(BURMY, 0, PixelmonForms.PLANT_CLOAK);
        this.form(BURMY, 1, PixelmonForms.SANDY_CLOAK);
        this.form(BURMY, 2, PixelmonForms.TRASH_CLOAK);
        this.palette(BUTTERFREE, 108, PixelmonPalettes.PINK);
        this.palette(BUTTERFREE, 106, PixelmonPalettes.VALENCIAN);
        this.form(CALYREX, 1, PixelmonForms.ICE_RIDER);
        this.form(CALYREX, 2, PixelmonForms.SHADOW_RIDER);
        this.form(CASTFORM, 1, PixelmonForms.ICE);
        this.form(CASTFORM, 2, PixelmonForms.RAIN);
        this.form(CASTFORM, 3, PixelmonForms.SUN);
        this.palette(CATERPIE, 106, PixelmonPalettes.VALENCIAN);
        this.palette(CATERPIE, 108, PixelmonPalettes.PINK);
        this.palette(CELEBI, 105, PixelmonPalettes.ALIEN);
        this.palette(CENTISKORCH, 113, PixelmonPalettes.ASHEN);
        this.palette(CHANSEY, 106, PixelmonPalettes.VALENCIAN);
        this.palette(CHARIZARD, 100, PixelmonPalettes.ZOMBIE);
        this.form(CHERRIM, 0, PixelmonForms.OVERCAST);
        this.form(CHERRIM, 1, PixelmonForms.SUNSHINE);
        this.palette(CHESNAUGHT, 100, PixelmonPalettes.ZOMBIE);
        this.palette(CLAYDOL, 102, PixelmonPalettes.DROWNED);
        this.palette(CLAYDOL, 107, PixelmonPalettes.ALTER);
        this.palette(CLOBBOPUS, 1, PixelmonPalettes.IRISH);
        this.palette(CLOBBOPUS, 2, PixelmonPalettes.DIAMONDS);
        this.palette(CLOBBOPUS, 3, PixelmonPalettes.CLUBS);
        this.palette(CLOBBOPUS, 4, PixelmonPalettes.MARTIAN);
        this.palette(CLOBBOPUS, 5, PixelmonPalettes.STARRY);
        this.palette(CLOBBOPUS, 6, PixelmonPalettes.YELLOW_RINGED);
        this.palette(CLOBBOPUS, 7, PixelmonPalettes.RED_RINGED);
        this.palette(CLOBBOPUS, 8, PixelmonPalettes.ALIEN);
        this.form(CORSOLA, 2, PixelmonForms.GALARIAN);
        this.palette(CRAWDAUNT, 104, PixelmonPalettes.RAINBOW);
        this.palette(CRESSELIA, 104, PixelmonPalettes.RAINBOW);
        this.palette(CRESSELIA, 114, PixelmonPalettes.SPIRIT);
        this.palette(CROBAT, 112, PixelmonPalettes.STRIKE);
        this.form(DARMANITAN, 1, PixelmonForms.ZEN);
        this.form(DARMANITAN, 2, PixelmonForms.GALARIAN);
        this.form(DARMANITAN, 3, PixelmonForms.ZEN_GALARIAN);
        this.form(DARUMAKA, 2, PixelmonForms.GALARIAN);
        this.form(DECIDUEYE, 3, PixelmonForms.HISUIAN);
        this.form(DEERLING, 0, PixelmonForms.SPRING);
        this.form(DEERLING, 1, PixelmonForms.SUMMER);
        this.form(DEERLING, 2, PixelmonForms.AUTUMN);
        this.form(DEERLING, 3, PixelmonForms.WINTER);
        this.palette(DELPHOX, 100, PixelmonPalettes.ZOMBIE);
        this.form(DEOXYS, 1, PixelmonForms.ATTACK);
        this.form(DEOXYS, 2, PixelmonForms.DEFENSE);
        this.form(DEOXYS, 3, PixelmonForms.SPEED);
        this.form(DEOXYS, 4, "sus");
        this.form(DIGLETT, 1, PixelmonForms.ALOLAN);
        this.palette(DIGLETT, 108, PixelmonPalettes.PINK);
        this.palette(DITTO, 100, PixelmonPalettes.ZOMBIE);
        this.palette(DODRIO, 108, PixelmonPalettes.PINK);
        this.palette(DODUO, 108, PixelmonPalettes.PINK);
        this.palette(DOUBLADE, 107, PixelmonPalettes.ALTER);
        this.palette(DRAGAPULT, 114, PixelmonPalettes.SPIRIT);
        this.form(DRAGONITE, 111, PixelmonForms.CREATOR);
        this.palette(DRAGONITE, 113, PixelmonPalettes.ASHEN);
        this.palette(DRAKLOAK, 114, PixelmonPalettes.SPIRIT);
        this.palette(DREEPY, 114, PixelmonPalettes.SPIRIT);
        this.form(DUBWOOL, 1, PixelmonForms.SHORN);
        this.palette(DUBWOOL, 2, PixelmonPalettes.BLACK);
        this.palette(DUBWOOL, 3, PixelmonPalettes.BLUE);
        this.palette(DUBWOOL, 4, PixelmonPalettes.BROWN);
        this.palette(DUBWOOL, 5, PixelmonPalettes.CYAN);
        this.palette(DUBWOOL, 6, PixelmonPalettes.GRAY);
        this.palette(DUBWOOL, 7, PixelmonPalettes.GREEN);
        this.palette(DUBWOOL, 8, PixelmonPalettes.LIGHT_BLUE);
        this.palette(DUBWOOL, 9, PixelmonPalettes.LIGHT_GRAY);
        this.palette(DUBWOOL, 10, PixelmonPalettes.LIME);
        this.palette(DUBWOOL, 11, PixelmonPalettes.MAGENTA);
        this.palette(DUBWOOL, 12, PixelmonPalettes.ORANGE);
        this.palette(DUBWOOL, 13, PixelmonPalettes.PINK);
        this.palette(DUBWOOL, 14, PixelmonPalettes.PURPLE);
        this.palette(DUBWOOL, 15, PixelmonPalettes.RED);
        this.palette(DUBWOOL, 16, PixelmonPalettes.YELLOW);
        this.form(DUGTRIO, 1, PixelmonForms.ALOLAN);
        this.palette(DUGTRIO, 108, PixelmonPalettes.PINK);
        this.palette(DUSTOX, 104, PixelmonPalettes.RAINBOW);
        this.form(EEVEE, 111, PixelmonForms.CREATOR);
        this.palette(EEVEE, 112, PixelmonPalettes.STRIKE);
        this.palette(EEVEE, 112, PixelmonPalettes.SPIRIT);
        this.form(EISCUE, 0, PixelmonForms.ICE_FACE);
        this.form(EISCUE, 1, PixelmonForms.NOICE_FACE);
        this.palette(ELECTIVIRE, 112, PixelmonPalettes.STRIKE);
        this.form(ELECTRODE, 3, PixelmonForms.HISUIAN);
        this.palette(ELECTRODE, 109, PixelmonPalettes.SUMMER);
        this.palette(EMBOAR, 100, PixelmonPalettes.ZOMBIE);
        this.palette(EMPOLEON, 100, PixelmonPalettes.ZOMBIE);
        this.palette(ESPEON, 112, PixelmonPalettes.STRIKE);
        this.palette(ESPEON, 114, PixelmonPalettes.STRIKE);
        this.form(ETERNATUS, 1, "eternamax");
        this.form(ETERNATUS, 2, "cosmetic");
        this.palette(EXEGGCUTE, 108, PixelmonPalettes.PINK);
        this.form(EXEGGUTOR, 1, PixelmonForms.ALOLAN);
        this.palette(EXEGGUTOR, 108, PixelmonPalettes.PINK);
        this.form(FARFETCHD, 2, PixelmonForms.GALARIAN);
        this.palette(FEEBAS, 1, PixelmonPalettes.KARP);
        this.palette(FEEBAS, 104, PixelmonPalettes.RAINBOW);
        this.palette(FINNEON, 102, PixelmonPalettes.DROWNED);
        this.palette(FLYGON, 102, PixelmonPalettes.DROWNED);
        this.palette(FLABEBE, 0, PixelmonPalettes.RED);
        this.palette(FLABEBE, 1, PixelmonPalettes.YELLOW);
        this.palette(FLABEBE, 2, PixelmonPalettes.ORANGE);
        this.palette(FLABEBE, 3, PixelmonPalettes.BLUE);
        this.palette(FLABEBE, 4, PixelmonPalettes.WHITE);
        this.palette(FLAREON, 114, PixelmonPalettes.SPIRIT);
        this.palette(FLOETTE, 0, PixelmonPalettes.RED);
        this.palette(FLOETTE, 1, PixelmonPalettes.YELLOW);
        this.palette(FLOETTE, 2, PixelmonPalettes.ORANGE);
        this.palette(FLOETTE, 3, PixelmonPalettes.BLUE);
        this.palette(FLOETTE, 4, PixelmonPalettes.WHITE);
        this.form(FLOETTE, 5, "az");
        this.palette(FLORGES, 0, PixelmonPalettes.RED);
        this.palette(FLORGES, 1, PixelmonPalettes.YELLOW);
        this.palette(FLORGES, 2, PixelmonPalettes.ORANGE);
        this.palette(FLORGES, 3, PixelmonPalettes.BLUE);
        this.palette(FLORGES, 4, PixelmonPalettes.WHITE);
        this.palette(FROAKIE, 107, PixelmonPalettes.ALTER);
        this.palette(FROGADIER, 107, PixelmonPalettes.ALTER);
        this.palette(GALLADE, 112, PixelmonPalettes.STRIKE);
        this.palette(GARDEVOIR, 103, PixelmonPalettes.VALENTINE);
        this.palette(GARDEVOIR, 112, PixelmonPalettes.STRIKE);
        this.form(GASTRODON, 0, PixelmonForms.EAST);
        this.form(GASTRODON, 1, PixelmonForms.WEST);
        this.form(GENESECT, 1, PixelmonForms.BURN);
        this.form(GENESECT, 2, PixelmonForms.CHILL);
        this.form(GENESECT, 3, PixelmonForms.DOUSE);
        this.form(GENESECT, 4, PixelmonForms.SHOCK);
        this.palette(GENGAR, 113, PixelmonPalettes.ASHEN);
        this.form(GEODUDE, 1, PixelmonForms.ALOLAN);
        this.form(GIRATINA, 1, PixelmonForms.ORIGIN);
        this.palette(GLACEON, 114, PixelmonPalettes.SPIRIT);
        this.palette(GLOOM, 106, PixelmonPalettes.VALENCIAN);
        this.palette(GLOOM, 108, PixelmonPalettes.PINK);
        this.palette(GOLBAT, 112, PixelmonPalettes.STRIKE);
        this.form(GENGAR, 1, PixelmonForms.ALOLAN);
        this.form(GOODRA, 3, PixelmonForms.HISUIAN);
        this.form(GRAVELER, 1, PixelmonForms.ALOLAN);
        this.form(GRENINJA, 1, PixelmonForms.BATTLEBOND);
        this.form(GRENINJA, 2, PixelmonForms.ASH);
        this.palette(GRENINJA, 3, PixelmonPalettes.ZOMBIE);
        this.palette(GRENINJA, 7, PixelmonPalettes.ALTER);
        this.form(GRIMER, 1, PixelmonForms.ALOLAN);
        this.form(GROUDON, 1, PixelmonForms.PRIMAL);
        this.palette(GROUDON, 3, PixelmonPalettes.META);
        this.form(GROWLITHE, 3, PixelmonForms.HISUIAN);
        this.palette(GYARADOS, 100, PixelmonPalettes.ZOMBIE);
        this.palette(GYARADOS, 102, PixelmonPalettes.DROWNED);
        this.palette(HONEDGE, 107, PixelmonPalettes.ALTER);
        this.palette(HOOH, 104, PixelmonPalettes.RAINBOW);
        this.form(HOOPA, 0, PixelmonForms.CONFINED);
        this.form(HOOPA, 1, PixelmonForms.UNBOUND);
        this.palette(HOUNDOOM, 113, PixelmonPalettes.ASHEN);
        this.palette(HYDREIGON, 113, PixelmonPalettes.ASHEN);
        this.palette(INFERNAPE, 100, PixelmonPalettes.ZOMBIE);
        this.palette(INFERNAPE, 104, PixelmonPalettes.RAINBOW);
        this.palette(IVYSAUR, 115, "halloween");
        this.palette(JOLTEON, 112, PixelmonPalettes.STRIKE);
        this.palette(JOLTEON, 114, PixelmonPalettes.SPIRIT);
        this.palette(KAKUNA, 108, PixelmonPalettes.PINK);
        this.palette(KECLEON, 104, PixelmonPalettes.RAINBOW);
        this.palette(KECLEON, 107, PixelmonPalettes.ALTER);
        this.form(KELDEO, 0, PixelmonForms.ORDINARY);
        this.form(KELDEO, 1, PixelmonForms.RESOLUTE);
        this.palette(KINGDRA, 102, PixelmonPalettes.DROWNED);
        this.palette(KIRLIA, 112, PixelmonPalettes.STRIKE);
        this.palette(KOFFING, 103, PixelmonPalettes.VALENTINE);
        this.form(KYOGRE, 1, PixelmonForms.PRIMAL);
        this.form(KYUREM, 1, PixelmonForms.BLACK);
        this.form(KYUREM, 2, PixelmonForms.WHITE);
        this.form(LANDORUS, 0, PixelmonForms.INCARNATE);
        this.form(LANDORUS, 1, PixelmonForms.THERIAN);
        this.palette(LEAFEON, 112, PixelmonPalettes.STRIKE);
        this.palette(LEAFEON, 114, PixelmonPalettes.SPIRIT);
        this.form(LINOONE, 2, PixelmonForms.GALARIAN);
        this.palette(LOPUNNY, 109, PixelmonPalettes.SUMMER);
        this.palette(LUMINEON, 102, PixelmonPalettes.DROWNED);
        this.palette(LUGIA, 102, PixelmonPalettes.DROWNED);
        this.form(LUNATONE, 0, PixelmonForms.GIBBOUS);
        this.form(LUNATONE, 1, PixelmonForms.QUARTER);
        this.form(LUNATONE, 2, PixelmonForms.FULL);
        this.form(LUNATONE, 3, PixelmonForms.NEW_MOON);
        this.form(LUNATONE, 4, PixelmonForms.CRESCENT);
        this.form(LYCANROC, 0, PixelmonForms.MIDDAY);
        this.form(LYCANROC, 1, PixelmonForms.MIDNIGHT);
        this.form(LYCANROC, 2, PixelmonForms.DUSK);
        this.palette(MAGIKARP, 1, PixelmonPalettes.ROASTED);
        this.palette(MAGIKARP, 2, PixelmonPalettes.SKELLY);
        this.palette(MAGIKARP, 3, PixelmonPalettes.CALICO_ORANGE_WHITE);
        this.palette(MAGIKARP, 4, PixelmonPalettes.CALICO_ORANGE_WHITE_BLACK);
        this.palette(MAGIKARP, 5, PixelmonPalettes.CALICO_WHITE_ORANGE);
        this.palette(MAGIKARP, 6, PixelmonPalettes.CALICO_ORANGE_GOLD);
        this.palette(MAGIKARP, 7, PixelmonPalettes.ORANGE_TWO_TONE);
        this.palette(MAGIKARP, 8, PixelmonPalettes.ORANGE_ORCA);
        this.palette(MAGIKARP, 9, PixelmonPalettes.ORANGE_DAPPLES);
        this.palette(MAGIKARP, 10, PixelmonPalettes.PINK_TWO_TONE);
        this.palette(MAGIKARP, 11, PixelmonPalettes.PINK_ORCA);
        this.palette(MAGIKARP, 12, PixelmonPalettes.PINK_DAPPLES);
        this.palette(MAGIKARP, 13, PixelmonPalettes.GRAY_BUBBLES);
        this.palette(MAGIKARP, 14, PixelmonPalettes.GRAY_DIAMONDS);
        this.palette(MAGIKARP, 15, PixelmonPalettes.GRAY_PATCHES);
        this.palette(MAGIKARP, 16, PixelmonPalettes.PURPLE_BUBBLES);
        this.palette(MAGIKARP, 17, PixelmonPalettes.PURPLE_DIAMONDS);
        this.palette(MAGIKARP, 18, PixelmonPalettes.PURPLE_PATCHES);
        this.palette(MAGIKARP, 19, PixelmonPalettes.APRICOT_TIGER);
        this.palette(MAGIKARP, 20, PixelmonPalettes.APRICOT_ZEBRA);
        this.palette(MAGIKARP, 21, PixelmonPalettes.APRICOT_STRIPES);
        this.palette(MAGIKARP, 22, PixelmonPalettes.BROWN_TIGER);
        this.palette(MAGIKARP, 23, PixelmonPalettes.BROWN_ZEBRA);
        this.palette(MAGIKARP, 24, PixelmonPalettes.BROWN_STRIPES);
        this.palette(MAGIKARP, 25, PixelmonPalettes.WHITE_FOREHEAD);
        this.palette(MAGIKARP, 26, PixelmonPalettes.WHITE_MASK);
        this.palette(MAGIKARP, 27, PixelmonPalettes.BLACK_FOREHEAD);
        this.palette(MAGIKARP, 28, PixelmonPalettes.BLACK_MASK);
        this.palette(MAGIKARP, 29, PixelmonPalettes.BLUE_SAUCY);
        this.palette(MAGIKARP, 30, PixelmonPalettes.BLUE_RAINDROP);
        this.palette(MAGIKARP, 31, PixelmonPalettes.VIOLET_SAUCY);
        this.palette(MAGIKARP, 32, PixelmonPalettes.VIOLET_RAINDROP);
        this.palette(MAGIKARP, 106, PixelmonPalettes.VALENCIAN);
        this.palette(MAGMAR, 1, PixelmonPalettes.COPPER_SULFATE);
        this.palette(MAGMAR, 2, PixelmonPalettes.CUPRIC_CHLORIDE);
        this.palette(MAGMAR, 3, PixelmonPalettes.LITHIUM_CHLORIDE);
        this.palette(MAGMAR, 4, PixelmonPalettes.MAGNESIUM_SULFIDE);
        this.palette(MAGMAR, 5, PixelmonPalettes.MANGANESE_CHLORIDE);
        this.palette(MAGMAR, 6, PixelmonPalettes.POTASSIUM_CHLORIDE);
        this.palette(MAGMAR, 7, PixelmonPalettes.SODIUM_CARBONATE);
        this.palette(MAGMAR, 8, PixelmonPalettes.CALCIUM_CARBONATE);
        this.palette(MANKEY, 108, PixelmonPalettes.PINK);
        this.form(MAREEP, 1, PixelmonForms.SHORN);
        this.palette(MAREEP, 2, PixelmonPalettes.BLACK);
        this.palette(MAREEP, 3, PixelmonPalettes.BLUE);
        this.palette(MAREEP, 4, PixelmonPalettes.BROWN);
        this.palette(MAREEP, 5, PixelmonPalettes.CYAN);
        this.palette(MAREEP, 6, PixelmonPalettes.GRAY);
        this.palette(MAREEP, 7, PixelmonPalettes.GREEN);
        this.palette(MAREEP, 8, PixelmonPalettes.LIGHT_BLUE);
        this.palette(MAREEP, 9, PixelmonPalettes.LIGHT_GRAY);
        this.palette(MAREEP, 10, PixelmonPalettes.LIME);
        this.palette(MAREEP, 11, PixelmonPalettes.MAGENTA);
        this.palette(MAREEP, 12, PixelmonPalettes.ORANGE);
        this.palette(MAREEP, 13, PixelmonPalettes.PINK);
        this.palette(MAREEP, 14, PixelmonPalettes.PURPLE);
        this.palette(MAREEP, 15, PixelmonPalettes.RED);
        this.palette(MAREEP, 16, PixelmonPalettes.YELLOW);
        this.palette(MAREANIE, 114, PixelmonPalettes.SPIRIT);
        this.palette(MARILL, 107, PixelmonPalettes.ALTER);
        this.form(MAROWAK, 1, PixelmonForms.ALOLAN);
        this.palette(MEGANIUM, 100, PixelmonPalettes.ZOMBIE);
        this.form(MELOETTA, 0, PixelmonForms.ARIA);
        this.form(MELOETTA, 1, PixelmonForms.PIROUETTE);
        this.form(MEOWTH, 1, PixelmonForms.ALOLAN);
        this.form(MEOWTH, 2, PixelmonForms.GALARIAN);
        this.palette(METAPOD, 106, PixelmonPalettes.VALENCIAN);
        this.palette(METAPOD, 108, PixelmonPalettes.PINK);
        this.palette(MILOTIC, 104, PixelmonPalettes.RAINBOW);
        this.palette(MILOTIC, 114, PixelmonPalettes.SPIRIT);
        this.form(MIMIKYU, 0, "disguised");
        this.form(MIMIKYU, 1, "busted");
        this.palette(MIMIKYU, 2, PixelmonPalettes.SPIRIT);
        this.palette(MIMIKYU, 3, PixelmonPalettes.SPIRIT);
        this.form(MINIOR, 0, PixelmonForms.METEOR);
        this.palette(MINIOR, 1, PixelmonPalettes.RED);
        this.palette(MINIOR, 2, PixelmonPalettes.ORANGE);
        this.palette(MINIOR, 3, PixelmonPalettes.YELLOW);
        this.palette(MINIOR, 4, PixelmonPalettes.GREEN);
        this.palette(MINIOR, 5, PixelmonPalettes.BLUE);
        this.palette(MINIOR, 6, "indigo");
        this.palette(MINIOR, 7, "violet");
        this.palette(MISDREAVUS, 108, PixelmonPalettes.PINK);
        this.palette(MISMAGIUS, 108, PixelmonPalettes.PINK);
        this.form(MRMIME, 2, PixelmonForms.GALARIAN);
        this.form(MUK, 1, PixelmonForms.ALOLAN);
        this.form(NECROZMA, 1, PixelmonForms.DUSK);
        this.form(NECROZMA, 2, PixelmonForms.DAWN_WINGS);
        this.form(NECROZMA, 3, PixelmonForms.ULTRA);
        this.palette(NIDOKING, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDOKING, 108, PixelmonPalettes.PINK);
        this.palette(NIDOQUEEN, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDOQUEEN, 108, PixelmonPalettes.PINK);
        this.palette(NIDORINA, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDORINA, 108, PixelmonPalettes.PINK);
        this.palette(NIDORINO, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDORINO, 108, PixelmonPalettes.PINK);
        this.palette(NIDORANMALE, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDORANMALE, 108, PixelmonPalettes.PINK);
        this.palette(NIDORANFEMALE, 106, PixelmonPalettes.VALENCIAN);
        this.palette(NIDORANFEMALE, 108, PixelmonPalettes.PINK);
        this.form(NINETALES, 1, PixelmonForms.ALOLAN);
        this.palette(NINETALES, 112, PixelmonPalettes.STRIKE);
        this.palette(OCTILLERY, 102, PixelmonPalettes.DROWNED);
        this.palette(ODDISH, 106, PixelmonPalettes.VALENCIAN);
        this.palette(ODDISH, 108, PixelmonPalettes.PINK);
        this.palette(ONIX, 110, PixelmonPalettes.CRYSTAL);
        this.palette(OMASTAR, 102, PixelmonPalettes.DROWNED);
        this.form(ORICORIO, 0, PixelmonForms.BAILE);
        this.form(ORICORIO, 1, PixelmonForms.POM_POM);
        this.form(ORICORIO, 2, PixelmonForms.PA_U);
        this.form(ORICORIO, 3, PixelmonForms.SENSU);
        this.palette(PARAS, 106, PixelmonPalettes.VALENCIAN);
        this.palette(PARAS, 108, PixelmonPalettes.PINK);
        this.palette(PARASECT, 106, PixelmonPalettes.VALENCIAN);
        this.palette(PARASECT, 108, PixelmonPalettes.PINK);
        this.form(PERSIAN, 1, PixelmonForms.ALOLAN);
        this.form(PICHU, 1, PixelmonForms.SPIKY_EAR);
        this.palette(PIDGEOT, 108, PixelmonPalettes.PINK);
        this.palette(PIDGEOTTO, 108, PixelmonPalettes.PINK);
        this.palette(PIDGEY, 108, PixelmonPalettes.PINK);
        this.palette(PIKACHU, 102, PixelmonPalettes.DROWNED);
        this.palette(POLIWAG, 106, PixelmonPalettes.VALENCIAN);
        this.palette(POLIWRATH, 112, PixelmonPalettes.STRIKE);
        this.form(POLTEAGEIST, 0, PixelmonForms.PHONEY);
        this.form(POLTEAGEIST, 0, "antique");
        this.form(PONYTA, 2, PixelmonForms.GALARIAN);
        this.palette(PONYTA, 104, PixelmonPalettes.RAINBOW);
        this.palette(PORYGON, 107, PixelmonPalettes.ALTER);
        this.palette(PORYGONZ, 107, PixelmonPalettes.ALTER);
        this.palette(PORYGON2, 107, PixelmonPalettes.ALTER);
        this.palette(PORYGON2, 114, PixelmonPalettes.SPIRIT);
        this.palette(PRIMEAPE, 108, PixelmonPalettes.PINK);
        this.palette(PYUKUMUKU, 102, PixelmonPalettes.DROWNED);
        this.palette(PYUKUMUKU, 107, PixelmonPalettes.ALTER);
        this.form(QWILFISH, 3, PixelmonForms.HISUIAN);
        this.palette(QWILFISH, 102, PixelmonPalettes.DROWNED);
        this.form(RAICHU, 1, PixelmonForms.ALOLAN);
        this.palette(RAICHU, 109, PixelmonPalettes.SUMMER);
        this.palette(RALTS, 112, PixelmonPalettes.STRIKE);
        this.form(RAPIDASH, 2, PixelmonForms.GALARIAN);
        this.palette(RAPIDASH, 102, PixelmonPalettes.DROWNED);
        this.palette(RAPIDASH, 104, PixelmonPalettes.RAINBOW);
        this.form(RATICATE, 1, PixelmonForms.ALOLAN);
        this.palette(RATICATE, 106, PixelmonPalettes.VALENCIAN);
        this.palette(RATICATE, 108, PixelmonPalettes.PINK);
        this.form(RATTATA, 1, PixelmonForms.ALOLAN);
        this.palette(RATTATA, 106, PixelmonPalettes.VALENCIAN);
        this.palette(RATTATA, 108, PixelmonPalettes.PINK);
        this.palette(RAYQUAZA, 107, PixelmonPalettes.ALTER);
        this.palette(REGIELEKI, 114, PixelmonPalettes.SPIRIT);
        this.palette(RELICANTH, 102, PixelmonPalettes.DROWNED);
        this.palette(REMORAID, 102, PixelmonPalettes.DROWNED);
        this.palette(RHYDON, 108, PixelmonPalettes.PINK);
        this.palette(RHYPERIOR, 108, PixelmonPalettes.PINK);
        this.palette(ROSERADE, 113, PixelmonPalettes.ASHEN);
        this.form(ROTOM, 1, PixelmonForms.HEAT);
        this.form(ROTOM, 2, PixelmonForms.WASH);
        this.form(ROTOM, 3, PixelmonForms.FROST);
        this.form(ROTOM, 4, PixelmonForms.FAN);
        this.form(ROTOM, 5, PixelmonForms.MOW);
        this.palette(SABLEYE, 100, PixelmonPalettes.ZOMBIE);
        this.palette(SABLEYE, 102, PixelmonPalettes.DROWNED);
        this.palette(SALAMENCE, 107, PixelmonPalettes.ALTER);
        this.form(SAMUROTT, 3, PixelmonForms.HISUIAN);
        this.palette(SAMUROTT, 100, PixelmonPalettes.ZOMBIE);
        this.form(SANDILE, 1, PixelmonForms.BLOCKY);
        this.form(SANDSHREW, 1, PixelmonForms.ALOLAN);
        this.form(SANDSLASH, 1, PixelmonForms.ALOLAN);
        this.form(SAWSBUCK, 0, PixelmonForms.SPRING);
        this.form(SAWSBUCK, 1, PixelmonForms.SUMMER);
        this.form(SAWSBUCK, 2, PixelmonForms.AUTUMN);
        this.form(SAWSBUCK, 3, PixelmonForms.WINTER);
        this.palette(SCEPTILE, 100, PixelmonPalettes.ZOMBIE);
        this.palette(SERPERIOR, 100, PixelmonPalettes.ZOMBIE);
        this.form(SHAYMIN, 0, PixelmonForms.LAND);
        this.form(SHAYMIN, 1, PixelmonForms.SKY);
        this.palette(SHEDINJA, 107, PixelmonPalettes.ALTER);
        this.palette(SHELGON, 107, PixelmonPalettes.ALTER);
        this.palette(SHELLDER, 106, PixelmonPalettes.VALENCIAN);
        this.palette(SHELLOS, 0, PixelmonForms.EAST);
        this.palette(SHELLOS, 1, PixelmonForms.WEST);
        this.palette(SHELLOS, 2, PixelmonPalettes.GRAY_BUBBLES);
        this.palette(SHELLOS, 3, PixelmonPalettes.GRAY_DIAMONDS);
        this.palette(SHELLOS, 4, PixelmonPalettes.PURPLE_BUBBLES);
        this.palette(SHELLOS, 5, PixelmonPalettes.PURPLE_DIAMONDS);
        this.palette(SHELLOS, 6, PixelmonPalettes.VIOLET_SAUCY);
        this.palette(SHELLOS, 7, PixelmonPalettes.BROWN_STRIPES);
        this.palette(SHELLOS, 8, "apricot_saucy");
        this.palette(SHELLOS, 9, PixelmonPalettes.BLUE_STRIPE);
        this.palette(SHELLOS, 10, "moons");
        this.palette(SHELLOS, 11, "sun");
        this.palette(SHELLOS, 12, "golde");
        this.palette(SHELLOS, 13, "goldw");
        this.palette(SHROOMISH, 114, PixelmonPalettes.SPIRIT);
        this.form(SILVALLY, 0, PixelmonForms.NORMAL);
        this.form(SILVALLY, 1, PixelmonForms.GRASS);
        this.form(SILVALLY, 2, PixelmonForms.FIRE);
        this.form(SILVALLY, 3, PixelmonForms.WATER);
        this.form(SILVALLY, 4, PixelmonForms.FLYING);
        this.form(SILVALLY, 5, PixelmonForms.BUG);
        this.form(SILVALLY, 6, PixelmonForms.POISON);
        this.form(SILVALLY, 7, PixelmonForms.ELECTRIC);
        this.form(SILVALLY, 8, PixelmonForms.PSYCHIC);
        this.form(SILVALLY, 9, PixelmonForms.ROCK);
        this.form(SILVALLY, 10, PixelmonForms.GROUND);
        this.form(SILVALLY, 11, PixelmonForms.DARK);
        this.form(SILVALLY, 12, PixelmonForms.GHOST);
        this.form(SILVALLY, 13, PixelmonForms.STEEL);
        this.form(SILVALLY, 14, PixelmonForms.FIGHTING);
        this.form(SILVALLY, 15, PixelmonForms.ICE);
        this.form(SILVALLY, 16, PixelmonForms.DRAGON);
        this.form(SILVALLY, 17, PixelmonForms.FAIRY);
        this.form(SINISTEA, 0, PixelmonForms.PHONEY);
        this.form(SINISTEA, 1, "antique");
        this.palette(SKARMORY, 104, PixelmonPalettes.RAINBOW);
        this.form(SLIGGOO, 3, PixelmonForms.HISUIAN);
        this.form(SLOWBRO, 2, PixelmonForms.GALARIAN);
        this.form(SLOWPOKE, 1, PixelmonForms.GALARIAN);
        this.palette(SLUGMA, 1, PixelmonPalettes.COPPER_SULFATE);
        this.palette(SLUGMA, 1, PixelmonPalettes.CUPRIC_CHLORIDE);
        this.palette(SLUGMA, 1, PixelmonPalettes.LITHIUM_CHLORIDE);
        this.palette(SLUGMA, 1, PixelmonPalettes.MAGNESIUM_SULFIDE);
        this.palette(SLUGMA, 1, PixelmonPalettes.MANGANESE_CHLORIDE);
        this.palette(SLUGMA, 1, PixelmonPalettes.POTASSIUM_CHLORIDE);
        this.palette(SLUGMA, 1, PixelmonPalettes.SODIUM_CARBONATE);
        this.palette(SLUGMA, 1, PixelmonPalettes.CALCIUM_CARBONATE);
        this.palette(SNEASEL, 112, PixelmonPalettes.STRIKE);
        this.palette(SNORLAX, 1, PixelmonPalettes.SNOWY);
        this.palette(SNORLAX, 109, PixelmonPalettes.SUMMER);
        this.form(SOLGALEO, 1, "radiantsun");
        this.palette(SPINDA, 103, PixelmonPalettes.VALENTINE);
        this.palette(STEELIX, 110, PixelmonPalettes.CRYSTAL);
        this.palette(STARMIE, 102, PixelmonPalettes.DROWNED);
        this.form(STUNFISK, 2, PixelmonForms.GALARIAN);
        this.palette(SUICUNE, 114, PixelmonPalettes.SPIRIT);
        this.palette(SWAMPERT, 100, PixelmonPalettes.ZOMBIE);
        this.palette(SYLVEON, 114, PixelmonPalettes.SPIRIT);
        this.palette(TALONFLAME, 113, PixelmonPalettes.ASHEN);
        this.palette(TENTACRUEL, 102, PixelmonPalettes.DROWNED);
        this.form(THUNDURUS, 0, PixelmonForms.INCARNATE);
        this.form(THUNDURUS, 1, PixelmonForms.THERIAN);
        this.form(TORNADUS, 0, PixelmonForms.INCARNATE);
        this.form(TORNADUS, 1, PixelmonForms.THERIAN);
        this.palette(TORTERRA, 100, PixelmonPalettes.ZOMBIE);
        this.palette(TOXAPEX, 114, PixelmonPalettes.SPIRIT);
        this.form(TOXTRICITY, 0, PixelmonForms.AMPED);
        this.form(TOXTRICITY, 1, PixelmonForms.LOW_KEY);
        this.palette(TYPHLOSION, 100, PixelmonPalettes.ZOMBIE);
        this.palette(UMBREON, 112, PixelmonPalettes.STRIKE);
        this.palette(UMBREON, 113, PixelmonPalettes.ASHEN);
        this.palette(UMBREON, 114, PixelmonPalettes.SPIRIT);
        this.form(UNOWN, 0, PixelmonForms.UNOWN_A);
        this.form(UNOWN, 1, PixelmonForms.UNOWN_B);
        this.form(UNOWN, 2, PixelmonForms.UNOWN_C);
        this.form(UNOWN, 3, PixelmonForms.UNOWN_D);
        this.form(UNOWN, 4, PixelmonForms.UNOWN_E);
        this.form(UNOWN, 5, PixelmonForms.UNOWN_F);
        this.form(UNOWN, 6, PixelmonForms.UNOWN_G);
        this.form(UNOWN, 7, PixelmonForms.UNOWN_H);
        this.form(UNOWN, 8, PixelmonForms.UNOWN_I);
        this.form(UNOWN, 9, PixelmonForms.UNOWN_J);
        this.form(UNOWN, 10, PixelmonForms.UNOWN_K);
        this.form(UNOWN, 11, PixelmonForms.UNOWN_L);
        this.form(UNOWN, 12, PixelmonForms.UNOWN_M);
        this.form(UNOWN, 13, PixelmonForms.UNOWN_N);
        this.form(UNOWN, 14, PixelmonForms.UNOWN_O);
        this.form(UNOWN, 15, PixelmonForms.UNOWN_P);
        this.form(UNOWN, 16, PixelmonForms.UNOWN_Q);
        this.form(UNOWN, 17, PixelmonForms.UNOWN_R);
        this.form(UNOWN, 18, PixelmonForms.UNOWN_S);
        this.form(UNOWN, 19, PixelmonForms.UNOWN_T);
        this.form(UNOWN, 20, PixelmonForms.UNOWN_U);
        this.form(UNOWN, 21, PixelmonForms.UNOWN_V);
        this.form(UNOWN, 22, PixelmonForms.UNOWN_W);
        this.form(UNOWN, 23, PixelmonForms.UNOWN_X);
        this.form(UNOWN, 24, PixelmonForms.UNOWN_Y);
        this.form(UNOWN, 25, PixelmonForms.UNOWN_Z);
        this.form(UNOWN, 26, PixelmonForms.UNOWN_QUESTION);
        this.form(UNOWN, 27, PixelmonForms.UNOWN_EXCLAMATION);
        this.form(URSHIFU, 0, PixelmonForms.SINGLE_STRIKE);
        this.form(URSHIFU, 1, PixelmonForms.RAPID_STRIKE);
        this.palette(VAPOREON, 112, PixelmonPalettes.STRIKE);
        this.palette(VAPOREON, 114, PixelmonPalettes.SPIRIT);
        this.palette(VENOMOTH, 108, PixelmonPalettes.PINK);
        this.palette(VENONAT, 108, PixelmonPalettes.PINK);
        this.palette(VENUSAUR, 100, PixelmonPalettes.ZOMBIE);
        this.palette(VICTREEBEL, 106, PixelmonPalettes.VALENCIAN);
        this.palette(VICTREEBEL, 108, PixelmonPalettes.PINK);
        this.palette(VILEPLUME, 106, PixelmonPalettes.VALENCIAN);
        this.palette(VILEPLUME, 108, PixelmonPalettes.PINK);
        this.palette(VIVILLON, 0, PixelmonPalettes.ARCHIPELAGO);
        this.palette(VIVILLON, 1, PixelmonPalettes.CONTINENTAL);
        this.palette(VIVILLON, 2, PixelmonPalettes.ELEGANT);
        this.palette(VIVILLON, 3, PixelmonPalettes.GARDEN);
        this.palette(VIVILLON, 4, PixelmonPalettes.HIGH_PLAINS);
        this.palette(VIVILLON, 5, PixelmonPalettes.ICY_SNOW);
        this.palette(VIVILLON, 6, PixelmonPalettes.JUNGLE);
        this.palette(VIVILLON, 7, PixelmonPalettes.MARINE);
        this.palette(VIVILLON, 8, PixelmonPalettes.MEADOW);
        this.palette(VIVILLON, 9, PixelmonPalettes.MODERN);
        this.palette(VIVILLON, 10, PixelmonPalettes.MONSOON);
        this.palette(VIVILLON, 11, PixelmonPalettes.OCEAN);
        this.palette(VIVILLON, 12, PixelmonPalettes.POLAR);
        this.palette(VIVILLON, 13, PixelmonPalettes.RIVER);
        this.palette(VIVILLON, 14, PixelmonPalettes.SANDSTORM);
        this.palette(VIVILLON, 15, PixelmonPalettes.SAVANNA);
        this.palette(VIVILLON, 16, PixelmonPalettes.SUN);
        this.palette(VIVILLON, 17, PixelmonPalettes.TUNDRA);
        this.palette(VIVILLON, 18, PixelmonPalettes.FANCY);
        this.palette(VIVILLON, 19, PixelmonPalettes.POKE_BALL);
        this.palette(VIVILLON, 112, PixelmonPalettes.STRIKE);
        this.palette(VOLCARONA, 107, PixelmonPalettes.ALTER);
        this.form(VOLTORB, 3, PixelmonForms.HISUIAN);
        this.form(VULPIX, 1, PixelmonForms.ALOLAN);
        this.palette(VULPIX, 112, PixelmonPalettes.STRIKE);
        this.palette(WEAVILE, 104, PixelmonPalettes.RAINBOW);
        this.palette(WEAVILE, 112, PixelmonPalettes.STRIKE);
        this.palette(WEEDLE, 108, PixelmonPalettes.PINK);
        this.palette(WEEPINBELL, 106, PixelmonPalettes.VALENCIAN);
        this.palette(WEEPINBELL, 108, PixelmonPalettes.PINK);
        this.form(WEEZING, 2, PixelmonForms.GALARIAN);
        this.palette(WEEZING, 103, PixelmonPalettes.VALENTINE);
        this.form(WISHIWASHI, 0, PixelmonForms.SOLO);
        this.form(WISHIWASHI, 1, PixelmonForms.SCHOOL);
        this.form(WOOLOO, 1, PixelmonForms.SHORN);
        this.palette(WOOLOO, 2, PixelmonPalettes.BLACK);
        this.palette(WOOLOO, 3, PixelmonPalettes.BLUE);
        this.palette(WOOLOO, 4, PixelmonPalettes.BROWN);
        this.palette(WOOLOO, 5, PixelmonPalettes.CYAN);
        this.palette(WOOLOO, 6, PixelmonPalettes.GRAY);
        this.palette(WOOLOO, 7, PixelmonPalettes.GREEN);
        this.palette(WOOLOO, 8, PixelmonPalettes.LIGHT_BLUE);
        this.palette(WOOLOO, 9, PixelmonPalettes.LIGHT_GRAY);
        this.palette(WOOLOO, 10, PixelmonPalettes.LIME);
        this.palette(WOOLOO, 11, PixelmonPalettes.MAGENTA);
        this.palette(WOOLOO, 12, PixelmonPalettes.ORANGE);
        this.palette(WOOLOO, 13, PixelmonPalettes.PINK);
        this.palette(WOOLOO, 14, PixelmonPalettes.PURPLE);
        this.palette(WOOLOO, 15, PixelmonPalettes.RED);
        this.palette(WOOLOO, 16, PixelmonPalettes.YELLOW);
        this.form(WORMADAM, 0, PixelmonForms.PLANT_CLOAK);
        this.form(WORMADAM, 1, PixelmonForms.SANDY_CLOAK);
        this.form(WORMADAM, 2, PixelmonForms.TRASH_CLOAK);
        this.form(XERNEAS, 0, PixelmonForms.NEUTRAL);
        this.form(XERNEAS, 1, PixelmonForms.ACTIVE);
        this.form(XERNEAS, 3, PixelmonForms.CREATOR);
        this.form(YAMASK, 2, PixelmonForms.GALARIAN);
        this.palette(YAMPER, 112, PixelmonPalettes.STRIKE);
        this.form(ZIGZAGOON, 2, PixelmonForms.GALARIAN);
        this.form(ZACIAN, 0, PixelmonForms.HERO);
        this.form(ZACIAN, 1, PixelmonForms.CROWNED);
        this.form(ZAMAZENTA, 0, PixelmonForms.HERO);
        this.form(ZAMAZENTA, 1, PixelmonForms.CROWNED);
        this.form(ZOROARK, 3, PixelmonForms.HISUIAN);
        this.palette(ZOROARK, 107, PixelmonPalettes.ALTER);
        this.form(ZORUA, 3, PixelmonForms.HISUIAN);
        this.palette(ZORUA, 107, PixelmonPalettes.ALTER);
        this.palette(ZUBAT, 112, PixelmonPalettes.STRIKE);
    }

    private void mega(RegistryValue<Species> species) {
        this.register(species, 1, PixelmonForms.MEGA, Destination.FORM);
    }

    private void form(RegistryValue<Species> species, int legacy, String name) {
        this.register(species, legacy, name, Destination.FORM);
    }

    private void palette(RegistryValue<Species> species, int legacy, String name) {
        this.register(species, legacy, name, Destination.PALETTE);
    }
}