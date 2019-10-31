import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> map = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            map.putIfAbsent(type, new TreeMap<>());
            map.get(type).put(name, new int[]{damage, health, armor});
        }

        map.entrySet().forEach(entry -> {
                    double averageDamage = entry.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(e -> e.getValue()[0]).average().orElse(0.0);
                    double averageHealth = entry.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(e -> e.getValue()[1]).average().orElse(0.0);
                    double averageArmor = entry.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(e -> e.getValue()[2]).average().orElse(0.0);

                    System.out.printf("%s::(%.2f/%.2f/%.2f)\n",entry.getKey(), averageDamage, averageHealth, averageArmor);

                    entry.getValue().entrySet().forEach(entry1 -> {
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", entry1.getKey(), entry1.getValue()[0], entry1.getValue()[1], entry1.getValue()[2]);
                    });
                }


        );
    }
}
