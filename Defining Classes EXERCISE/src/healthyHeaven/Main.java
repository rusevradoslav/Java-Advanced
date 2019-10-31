package healthyHeaven;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Casa Domingo");
        // Initialize the entities
        Vegetable tomato = new Vegetable("Tomato", 20);
        Vegetable cucumber = new Vegetable("Cucumber", 15);

        Salad salad = new Salad("Tomatoes with cucumbers");

        salad.add(tomato);
        salad.add(cucumber);

        System.out.println(salad.getTotalCalories());
        System.out.println(salad.getProductCount());  // 2

        System.out.println(salad.toString());

        restaurant.add(salad);

        System.out.println(restaurant.buy("Invalid salad")); // false

// Initialize the second entities
        Vegetable corn = new Vegetable("Corn", 90);
        Salad casaDomingo = new Salad("Casa Domingo");

        casaDomingo.add(tomato);
        casaDomingo.add(cucumber);
        casaDomingo.add(corn);

        restaurant.add(casaDomingo);

        System.out.println(restaurant.getHealthiestSalad()); // Tomatoes with cucumbers


        System.out.println(restaurant.generateMenu());

    }
}
