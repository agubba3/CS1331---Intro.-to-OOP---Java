import java.util.Comparator;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents a Pokedex - basically a Pokemon encyclopedia that adds new entries
 * when you encounter a Pokemon for the first time.
 * It also provides methods for organizing its information in useful ways.
 *
 * @author Joe Rossi
 * @version 1.0
 */

public class Pokedex {

    private MySortedSet<Pokemon> pokeSet;
    private Comparator<Pokemon> pokeCompare;

    /**
     * Constructs a Pokedex object by setting up the sorted set of Pokemon
     */
    public Pokedex() {
        pokeCompare = (k1, k2) -> k1.compareTo(k2);
        pokeSet = new MySortedSet<Pokemon>(pokeCompare);
    }

    @Override
    public String toString() {
        String a = "";
        for (Pokemon p: pokeSet) {
            a += "\n" + p.toString();
        }
        return a;
    }

    /**
     * Adds a Pokemon to the sorted set
     *
     * @param p the Pokemon to be added
     * @return true if the pokemon was not already in the set, false otherwise
     */
    public boolean add(Pokemon p) {

        return pokeSet.add(p);
    }

    /**
     * Returns the number of Pokemon in the Pokedex
     *
     * @return  the number of Pokemon in the Pokedex
     */
    public int countPokemon() {
        return pokeSet.size();
    }

    /**
     * Clear the Pokedex and start over
     */
    public void clear() {
        pokeSet.clear();
    }

    /**
     * Returns a set of alphabetized Pokemon, using a lambda expression
     *
     * @return  the alphabetized set
     */
    public MySortedSet<Pokemon> listAlphabetically() {
        //Comparator<String> typeComparator = (Pokemon k1, Pokemon k2)
        //-> k1.getName().hashCode() - k2.getName().hashCode();
        //ArrayList<Pokemon> list = pokeSet.getList();
        return pokeSet.sort((Pokemon k1, Pokemon k2)
            -> k1.getName().compareTo(k2.getName()));
        //return list.stream().collect(Collectors.toCollection(()
        //-> new MySortedSet<Pokemon>()));
    }

    /**
     * Returns a set of Pokemon grouped by type, using a lambda expression
     *
     * @return  the grouped by primary type set
     */
    public MySortedSet<Pokemon> groupByPrimaryType() {
        return pokeSet.sort((Pokemon k1, Pokemon k2)
            -> k1.getPrimaryType().ordinal() - k2.getPrimaryType().ordinal());

    }

    /**
     * Returns a set of all Pokemon of type t
     *
     * @param t the type we want listed
     * @return  the set of all Pokemon in the Pokedex of type t
     */
    public MySortedSet<Pokemon> listByType(PokemonType t) {
        ArrayList<Pokemon> list = pokeSet.getList();
        return list.stream().filter((a) -> a.getPrimaryType().equals(t)
            || a.getSecondaryType().equals(t))
            .collect(Collectors.toCollection(() -> new MySortedSet<Pokemon>()));
    }

    /**
     * Returns a set of Pokemon with numbers in the range [start, end]
     *
     * @param start the first number in the new set
     * @param end   the last number in the new set
     * @return  the set containing all Pokemon in the Pokedex from [start, end]
     */
    public MySortedSet<Pokemon> listRange(int start, int end) {
        ArrayList<Pokemon> list = pokeSet.getList();
        return list.stream().filter((a) ->
        a.getNumber() >= start && a.getNumber() <= end)
        .collect(Collectors.toCollection(() -> new MySortedSet<Pokemon>()));
    }
}
