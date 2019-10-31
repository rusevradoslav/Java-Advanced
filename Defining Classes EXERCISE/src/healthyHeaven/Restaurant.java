package healthyHeaven;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(product -> product.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
        return data.stream().min((f, s) -> Integer.compare(f.getTotalCalories(), s.getTotalCalories())).get();
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %d salads:%n", this.name, this.data.size()));
        for (Salad salad : data) {
            sb.append(salad);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
