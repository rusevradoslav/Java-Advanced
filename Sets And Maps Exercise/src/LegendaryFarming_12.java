import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> junk = new TreeMap<>();
        TreeMap<String, Integer> legendaryMaterials = new TreeMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);
        String obtain = "";
        boolean toContiniue = true;

        while (toContiniue) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length - 1; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String item = line[i + 1].toLowerCase();

                if (item.equals("fragmenst") || item.equals("shards") || item.equals("motes")) {
                    legendaryMaterials.put(item, legendaryMaterials.get(item) + quantity);

                    if (legendaryMaterials.get(item) >= 250) {
                        legendaryMaterials.put(item, legendaryMaterials.get(item) - 250);
                        obtain = item;
                        toContiniue = false;
                        break;
                    }
                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + quantity);
                }


            }
        }
        printMethod(obtain, legendaryMaterials, junk);


    }

    private static void printMethod(String item, TreeMap<String, Integer> legendary, TreeMap<String, Integer> material) {
        String toPrint = "";
        if (item.equals("shards")) {
            toPrint = "Shadowmourne";
        } else if (item.equals("fragments")) {
            toPrint = "Valanyr";
        } else if (item.equals("motes")) {
            toPrint = "Dragonwarth";
        }
        System.out.printf("%s obtained!\n",toPrint);

        legendary
                .entrySet()
                .stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s: %d\n",entry.getKey(),entry.getValue());

                });
        material.entrySet().stream().forEach(entry1 ->
            System.out.printf("%s: %d\n", entry1.getKey(), entry1.getValue()));
    }
}
