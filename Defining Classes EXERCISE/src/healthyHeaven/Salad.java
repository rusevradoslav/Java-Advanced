package healthyHeaven;

import java.util.ArrayList;

public class Salad {
    private String name;
    private ArrayList<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable product : products) {
            sum += product.getCalories();
        }
        return sum;
    }

    public int getProductCount() {
        return products.size();
    }

    public void add(Vegetable product) {
        products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:%n",this.name,getTotalCalories(),getProductCount()));
        for (Vegetable product : products) {
            sb.append(product);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
