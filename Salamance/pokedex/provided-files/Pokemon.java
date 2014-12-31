/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Joe Rossi
 * @version 1.0
 */
public class Pokemon implements Comparable<Pokemon> {

    private String pokeName;
    private int pokeNum;
    private PokemonType pokeType1;
    private PokemonType pokeType2;

    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        pokeName = name;
        pokeNum = num;
        pokeType1 = p;
        pokeType2 = s;
    }
    /**
     * This is the default compare to method which compares
     * two pokemon by number and identifies the difference
     * between two pokemon.
     *
     * @param o This is a Pokemon which is passed in
     * @return an int which simply gives the differnce between
     * two numbers of pokemon
     */
    @Override
    public int compareTo(Pokemon o) {
        return this.getNumber() - o.getNumber();
    }
    /**
     * This method determines if two objects are equal
     * and compares two pokemon by each of its fields.
     *
     * @param o This is a general object passed in
     * @return a boolean value which decides (True or False)
     * if two pokemon are equal or not based on their fields.
     */
    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon that = (Pokemon) o;
        return ((this.getName().equals(((Pokemon) that).getName()))
            && (this.getNumber() == (((Pokemon) that).getNumber()))
            && (this.getPrimaryType().equals(((Pokemon) that).getPrimaryType()))
            && (this.getSecondaryType().equals(((Pokemon) that)
                .getSecondaryType())));
    }
    /**
     * This method gives the hashcode of pokemon
     * which is used to sort them into buckets
     * based on each pokemon's fields
     *
     * @return an int which gives difference between two pokemon
     * based on their hashcode and sorts them into the
     * respective buckets.
     */
    @Override
    public int hashCode() {
        int cod = 17;
        cod = 31 + pokeName.hashCode();
        cod = 31 + pokeNum;
        cod = 31 + pokeType1.hashCode();
        cod = 31 + pokeType2.hashCode();
        return cod;
    }
    /**
     * This method overrides the default toString method
     * in Object to output a Pokemon with its differnt fields
     * with proper indentations.
     *
     * @return a String representation of a Pokemon as
     * displayed by each of its fields.
     */
    @Override
    public String toString() {
        String formattedOuput = String.format("#%4s: %-14sPrimary Type: "
            + "%-12sSecondary Type: %s",
            pokeNum, pokeName, pokeType1, pokeType2);
        return formattedOuput;
    }

    /**
     * This method outputs the name of the pokemon by its field name
     *
     * @return  the name of this Pokemon
     */
    public String getName() {
        return pokeName;
    }

    /**
     * This method outputs the pokemon's number
     *
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        return pokeNum;
    }

    /**
     * This method outputs a Pokemon's primary type
     * as determined by the field and its enum
     *
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        return pokeType1;
    }

    /**
     * This method outputs a Pokemon's secondary type
     * as determined by the field and its enum
     *
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        return pokeType2;
    }
}
