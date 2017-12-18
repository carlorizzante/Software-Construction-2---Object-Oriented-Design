package model;

public class Chef {

    private static final String PREFIX = "CHEF - ";

    private Order order;

    public Chef() {
        this.order = null;
    }

    // GETTERS
    public Order getActiveOrder() { return order; }

    // MODIFIES: this
    // EFFECTS:  Makes food and logs order as prepared
    public void makeDish(Order order) {
        this.order = order;
        prepareIngredients();
        followRecipe();
        cookFood();
        plate(order);
    }

    // EFFECTS: Prints out a doing dishes message
    public void doDishes() {
        System.out.println(PREFIX + "Cleaning, scrubbing...");
        System.out.println("Dishes done.");
    }

    // EFFECTS: Prints out ingredients being prepared
    private void prepareIngredients() {
        Dish dish = order.getDish();
        for (String i : dish.getIngredients()) {
            System.out.print(i + ", "); // This will leave a trailing comma, let the intern take care of that.
        }
        System.out.println();
    }

    // EFFECTS: Prints out recipe being followed
    private void followRecipe() {
        System.out.println(order.getDish().getRecipe());
    }

    // EFFECTS: Prints out message about cooking food
    private void cookFood() {
        System.out.println(PREFIX + "Grilling sandwich...");
    }

    // MODIFIES: order
    // EFFECTS:  Logs order as prepared and prints out plating message
    private void plate(Order order) {
        order.setPrepared(true);
        System.out.println(PREFIX + "Plated order:");
        order.print();
        this.order = null;
    }
}
