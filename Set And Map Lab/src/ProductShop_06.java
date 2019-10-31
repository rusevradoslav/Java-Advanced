import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);
            if (!map.containsKey(shop)) {
                map.put(shop, new LinkedHashMap<>());
                map.get(shop).put(product, price);
            } else {
                map.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }
        for (String shop : map.keySet()) {
            System.out.printf("%s->\n", shop);
            for (String product : map.get(shop).keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", product, map.get(shop).get(product));


            }
        }
    }
}
