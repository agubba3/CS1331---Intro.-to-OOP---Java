import java.util.Queue;
import java.util.Set;
import java.util.Collections;
import java.util.LinkedList;
/**
 * The comparator for the pizza shack class
 * @author Anirudh Gubba
 * @version 1.1
 */
public abstract class AbstractPizzeria implements Pizzeria {

    protected Set<Order> menu;
    protected int totalRev;
    protected Queue<Customer> orderQ = new LinkedList<Customer>();
    protected int ordersReceived;
    protected int ordersAttempted;
    protected int ordersDelivered;

    /**
     * This instantiates a new pizzeria object with a
     * compile type of AbstractPizzeria
     *
     * @param Set<Order> set of orders
     */
    public AbstractPizzeria(Set<Order> o) {
        menu = o;
    }
    /**
     * Tells the pizzeria to place an order with a Customer
     *
     * @param customer Customer who wants a pizza
     */
    public void placeOrder(Customer m) {
        this.orderQ.add(m);
        ordersReceived++;
    }
    /**
     * Status message of a Pizzeria's performance
     * Should say what percentage of orders have been delivered
     * and what percentage of attempted orders have been delivered
     * along with total revenues
     *
     * @return Message string
     */
    public String status() {
        return "We delivered "
            + Math.round(((double) ordersDelivered
                / (double) ordersReceived) * 100)
            + "% of our orders! We delivered "
            + Math.round(((double) ordersDelivered
                / (double) ordersAttempted) * 100)
            + "% of our attempted orders and made $"
            + Math.round(totalRev) + ".00";
    }
    /**
     * Attempts to deliver an order to a customer.
     * If the customer placed an order that's not on the menu,
     * we don't deliver. If the customer placed an order that is
     * on the menu but he doesn't have enough money to pay,
     * we don't deliver. Otherwise, we deliver to customer
     * and collect our money.
     */
    public void processOrder() {
        Customer c = orderQ.remove();
        if (!(menu.contains(c.getOrder()))) {
            ordersAttempted++;
        }
        if (menu.contains(c.getOrder()) && (!c.canPay())) {
            ordersAttempted++;
        }
        if (menu.contains(c.getOrder()) && c.canPay()) {
            ordersDelivered++;
            ordersAttempted++;
            totalRev += c.getOrder().getTotalPrice();
        }
    }
    /**
     * Returns the cheapest menu item based on price
     *
     * @return cheapest menu item
     */
    public Order getCheapestMenuItem() {
        return Collections.min(menu);
    }
    /**
     * Returns the most expensive menu item based on price
     *
     * @return most expensive menu item
     */
    public Order getMostExpensiveMenuItem() {
        return Collections.max(menu);
    }
    /**
     * Pizzeria name
     *
     * @return name
     */
    public abstract String getName();
}

