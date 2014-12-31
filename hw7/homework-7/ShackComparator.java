import java.util.Comparator;
/**
 * The comparator for the pizza shack class
 * @author Anirudh Gubba
 * @version 1.1
 */
public class ShackComparator implements Comparator<Customer> {
    /**
     * Returns the cheapest menu item based on price
     *
     * @return an int detailing the ordering of two people
     * in accordance to the price of their order and also whether
     * they can pay for their order
     */
    public int compare(Customer person, Customer persona) {
        if (person.canPay() && persona.canPay()) {
            return persona.getOrder().getTotalPrice()
                - person.getOrder().getTotalPrice();
        }
        if (person.canPay() && !persona.canPay()) {
            return -1;
        }
        if (persona.canPay() && !person.canPay()) {
            return 1;
        }
        if (!person.canPay() && !persona.canPay()) {
            return persona.getOrder().getTotalPrice()
                - person.getOrder().getTotalPrice();
        }
        return 0;
    }
}