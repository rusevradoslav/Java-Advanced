import java.util.*;
import java.util.Map.Entry;

public class SpaceshiftCrafting_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(l -> liquids.offer(l));

        ArrayDeque<Integer> physicalItems = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(p -> physicalItems.push(p));

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("Glass", 0);
        materials.put("Aluminium", 0);
        materials.put("Lithium", 0);
        materials.put("Carbon fiber", 0);

        while (!liquids.isEmpty() && !physicalItems.isEmpty()) {
            int liquid = liquids.poll();
            int item = physicalItems.pop();

            int sum = liquid + item;

            if (sum == 25) {
                materials.put("Glass", materials.get("Glass") + 1);

            } else if (sum == 50) {
                materials.put("Aluminium", materials.get("Aluminium") + 1);
            } else if (sum == 75) {
                materials.put("Lithium", materials.get("Lithium") + 1);
            } else if (sum == 100) {
                materials.put("Carbon fiber", materials.get("Carbon fiber") + 1);
            } else {

                physicalItems.push(item + 3);
            }
        }

        if (materials.get("Glass") != 0 && materials.get("Aluminium") != 0 && materials.get("Lithium") != 0 && materials.get("Carbon fiber") != 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
            if (!liquids.isEmpty()) {
                System.out.print("Liquids left: ");
                int count = 0;
                for (Integer liquid : liquids) {
                    System.out.print(liquid);
                    if (count != liquids.size() - 1) {
                        System.out.print(", ");
                        count++;
                    }
                }
                System.out.println();
            } else {
                System.out.println("Liquids left: none");
            }
            if (!physicalItems.isEmpty()) {
                System.out.print("Physical items left: ");
                int count = 0;
                for (Integer physicalItem : physicalItems) {
                    System.out.print(physicalItem);
                    if (count != physicalItems.size() - 1) {
                        System.out.print(", ");
                        count++;
                    }
                }
                System.out.println();
            } else {
                System.out.println("Physical items left: none");
            }
            for (var material : materials.entrySet()) {
                System.out.printf("%s: %d\n", material.getKey(), material.getValue());
            }
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
            if (!liquids.isEmpty()) {
                System.out.print("Liquids left: ");
                int count = 0;
                for (Integer liquid : liquids) {
                    System.out.print(liquid);
                    if (count != liquids.size() - 1) {
                        System.out.print(", ");
                        count++;
                    }
                }
                System.out.println();
            } else {
                System.out.println("Liquids left: none");
            }
            if (!physicalItems.isEmpty()) {
                System.out.print("Physical items left: ");
                int count = 0;
                for (Integer physicalItem : physicalItems) {
                    System.out.print(physicalItem);
                    if (count != physicalItems.size() - 1) {
                        System.out.print(", ");
                        count++;
                    }
                }
                System.out.println();
            } else {
                System.out.println("Physical items left: none");
            }
            for (var material : materials.entrySet()) {
                System.out.printf("%s: %d\n", material.getKey(), material.getValue());
            }
        }


    }
}
