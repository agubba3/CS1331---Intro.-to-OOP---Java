import java.util.HashSet;
/**
 * The Order class which is a hashset
 * @author Anirudh Gubba
 * @version 1.1
 */
public class Order extends HashSet<Ingredient> implements Comparable<Order> {
    /**
     * Adds the prices of all ingredients stored in the hashset
     *
     * @return the total price of all ingredients
     */
    public int getTotalPrice() {
        int price = 0;
        for (Ingredient a: this) {
            price += a.getPrice();
        }
        return price;
    }
    /**
     * Compares an object passed in and returns an int value
     *
     * @return the int value which compares the price of an order
     * with one which is passed in
     */
    public int compareTo(Order cus) {
        return this.getTotalPrice() - cus.getTotalPrice();
    }
}