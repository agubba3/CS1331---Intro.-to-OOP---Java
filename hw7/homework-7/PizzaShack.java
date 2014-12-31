import java.util.Set;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * The comparator for the pizza shack class
 * @author Anirudh Gubba
 * @version 1.1
 */
public class PizzaShack extends AbstractPizzeria {
    /**
     * This instantiates a new PizzaShack object which
     * passes the set to the super class and then
     * sets the queue declared in the abstract class to a
     * priority queue. A new comparator object relating to the
     * PizzaShack class is also instantiated.
     *
     * @param Set<Order> set of orders
     */
    public PizzaShack(Set<Order> a) {
        super(a);
        Comparator<Customer> comp = new ShackComparator();
        orderQ  = new PriorityQueue<Customer>(comp);
    }
    /**
     * This method simply outputs the name of each
     * pizza place.
     *
     * @return The name of the pizza place
     */
    public String getName() {
        return "Pizza Shack";
    }
}