package model;

public abstract class FOHEmployee {

    protected Dish dish;

    public FOHEmployee(Dish dish) {
        this.dish = dish;
    }

    public abstract String getPrefix();

    // EFFECTS: Prints description of current available dish
    public void describeDish() {
        System.out.println(getPrefix() + dish.getDescription());
    }

    // EFFECTS: Prints greeting
    public void greet() {
        System.out.println(getPrefix() + "Hello and welcome to Busy's, the home of the trendy turkey club sandwich.");
    }

    // MODIFIES: this, order
    // EFFECTS:  Logs order as served, brings it to the table
    public void deliverFood(Order order) {
        order.setServed(true);
        System.out.print(getPrefix() + "delivered food: ");
        order.print();
    }
}
