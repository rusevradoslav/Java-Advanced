import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SpaceshipCrafting_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> chemicalLiquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> physicalItems = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Map<String, Integer> materials = new TreeMap<>();

        int counterG = 1;
        int counterA = 1;
        int counterL = 1;
        int counterC = 1;
        materials.put("Glass", 0);
        materials.put("Aluminium", 0);
        materials.put("Lithium", 0);
        materials.put("Carbon fiber", 0);

        while (!chemicalLiquids.isEmpty() && !physicalItems.isEmpty()) {
            int firstLiquid = chemicalLiquids.get(0);
            int lastPhysical = physicalItems.get(physicalItems.size() - 1);
            int sum = firstLiquid + lastPhysical;
            if (sum == 25) {
                materials.put("Glass", counterG);
                counterG++;
                chemicalLiquids.remove(chemicalLiquids.get(0));
                physicalItems.remove(physicalItems.get(physicalItems.size() - 1));
            } else if (sum == 50) {
                materials.put("Aluminium", counterA);
                counterA++;
                chemicalLiquids.remove(chemicalLiquids.get(0));
                physicalItems.remove(physicalItems.get(physicalItems.size() - 1));
            } else if (sum == 75) {
                materials.put("Lithium", counterL);
                counterL++;
                chemicalLiquids.remove(chemicalLiquids.get(0));
                physicalItems.remove(physicalItems.get(physicalItems.size() - 1));
            } else if (sum == 100) {
                materials.put("Carbon fiber", counterC);
                counterC++;
                chemicalLiquids.remove(chemicalLiquids.get(0));
                physicalItems.remove(physicalItems.get(physicalItems.size() - 1));
            } else {
                chemicalLiquids.remove(chemicalLiquids.get(0));
                int lastIndex = physicalItems.indexOf(lastPhysical);
                physicalItems.set(lastIndex, physicalItems.get(physicalItems.size() - 1) + 3);
            }
        }

        if (materials.get("Glass") >= 1 && materials.get("Aluminium") >= 1 && materials.get("Lithium") >= 1 && materials.get("Carbon fiber") >= 1) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (chemicalLiquids.isEmpty()) {
            System.out.print("Liquids left: none");
        } else {
            int size = 0;
            System.out.print("Liquids left: ");
            for (int i = 0; i < chemicalLiquids.size() - 1; i++) {
                System.out.print(chemicalLiquids.get(i));
                if (size != chemicalLiquids.size() - 1) {
                    System.out.print(", ");
                    size++;
                }
            }

        }
        System.out.println();
        if (physicalItems.isEmpty()) {
            System.out.print("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            int size = 0;
            for (int i = physicalItems.size() - 1; i >= 0; i--) {
                System.out.print(physicalItems.get(i));
                if (size != physicalItems.size() - 1) {
                    System.out.print(", ");
                    size++;
                }

            }
        }
        System.out.println();
        materials.entrySet().stream().forEach(entry -> {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        });


    }

}
