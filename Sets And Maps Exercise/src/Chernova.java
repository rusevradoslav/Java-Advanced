import java.util.Scanner;
import java.util.TreeMap;

public class Chernova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, Integer> legendaryMaterials = new TreeMap<>();
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("motes", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();


        boolean Continue = true;
        String current = "";

        while (Continue) {

            String[] line = scanner.nextLine().split("\\s+");
            for (int i = 0; i < line.length - 1; i += 2) {

                int quantity = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();


                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    legendaryMaterials.put(material, legendaryMaterials.get(material) + quantity);

                    if (legendaryMaterials.get(material) >= 250) {
                        legendaryMaterials.put(material, legendaryMaterials.get(material) - 250);
                        current = material;
                        Continue = false;
                        break;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }

        }

        printMethod(current, legendaryMaterials, junk);


    }

    private static void printMethod(String current, TreeMap<String, Integer> legendary, TreeMap<String, Integer> junk) {
        if (current.equals("fragments")) {
            System.out.println("Valanyr");
        } else if (current.equals("shards")) {
            System.out.println("Shadowmoure");
        } else if (current.equals("motes")) {
            System.out.println("Dragonwrath");
        }

        legendary.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry ->
                        System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));


        junk.entrySet().stream().forEach(entry1 ->
                System.out.printf("%s: %d\n", entry1.getKey(), entry1.getValue()));

    }
}
