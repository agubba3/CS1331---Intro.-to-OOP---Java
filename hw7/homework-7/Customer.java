/**
 * The Customer class which represents a single customer
 * @author Anirudh Gubba
 * @version 1.1
 */
public class Customer {

    private double money;
    private Order order;

    /**
     * A constructor which instantiates
     * the money to a random value between 5 and 34.
     */
    public Customer(Order o) {
        order = o;
        int low = 5;
        int high = 34;
        money = Driver.RANDOM.nextInt(30) + 5;
    }
    /**
     * A method which retrives an order from the field
     *
     * @return an Order of a customer
     */
    public Order getOrder() {
        return order;
    }
    /**
     * A method which retrives the money from the field
     *
     * @return the amount of money a customer has
     */
    public double getMoney() {
        return money;
    }
    /**
     * A method which determines a customer can pay for an order
     *
     * @return a boolean stating if a customer can pay or not
     */
    public boolean canPay() {
        if (this.getMoney() >= order.getTotalPrice()) {
            return true;
        }
        return false;
    }
}