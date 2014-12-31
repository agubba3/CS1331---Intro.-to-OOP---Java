import java.util.Set;
import java.util.LinkedList;
/**
 * The comparator for the pizza shack class
 * @author Anirudh Gubba
 * @version 1.1
 */
public class CascadePizza extends AbstractPizzeria {
    /**
     * This instantiates a new CascadePizza object which
     * passes the set to the super class and then
     * sets the queue declared in the abstract class to a
     * linked list.
     *
     * @param Set<Order> set of orders
     */
    public CascadePizza(Set<Order> a) {
        super(a);
        orderQ  = new LinkedList<Customer>();
    }
    /**
     * This method simply outputs the name of each
     * pizza place.
     *
     * @return The name of the pizza place
     */
    public String getName() {
        return "Cascade Pizza";
    }
}
