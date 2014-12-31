import java.util.Comparator;
/**
 * The comparator for the pizza shack class
 * @author Anirudh Gubba
 * @version 1.1
 */
public class CustComparator implements Comparator<Customer> {
    /**
     * Compares two customers to determine the disparity
     * in prices of their orders
     *
     * @return an int detailing the ordering of two people
     * in accordance to the price of their order
     */
    @Override
    public int compare(Customer person, Customer persona) {
        return persona.getOrder().getTotalPrice()
            - person.getOrder().getTotalPrice();
    }
}
