package model;

import java.util.ArrayList;
import java.util.List;

public class Server extends FOHEmployee {

    private static final double DISH_PRICE = 10.0;
    private static final String PREFIX = "SERVER - ";

    private List<Order> orders;
    private double cash;
    private int currentOrderNumber;

    public Server(Dish dish) {
        super(dish);
        this.orders = new ArrayList<>();
        currentOrderNumber = 100;
    }

    // GETTERS
    public List<Order> getActiveOrders() { return orders; }
    public double getCash() { return cash; }

    @Override
    public String getPrefix() { return null; }

    // MODIFIES: this
    // EFFECTS:  Creates new order with the dish on the menu
    public Order takeOrder() {
        System.out.println(PREFIX + "Taking order...");
        Order o = new Order(dish, currentOrderNumber++);
        orders.add(o);
        System.out.println("Order taken: ");
        o.print();
        return o;
    }

    // MODIFIES: this
    // EFFECTS:  Takes payment from guest, removes order from orders
    public void takePayment(Order order) {
        System.out.println(PREFIX + "Taking payment...");
        orders.remove(order);
        cash += DISH_PRICE;
        System.out.println("Thanks for visiting Busy's Diner!");
    }
}
