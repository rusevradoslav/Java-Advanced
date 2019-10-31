import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParkingSystem_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = line[0];
        int cols = line[1];

        List<List<String>> parkingCeils = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            parkingCeils.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    parkingCeils.get(i).add("n");
                } else {
                    parkingCeils.get(i).add("free");
                }
            }

        }

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = tokens[0];
            int desiredRow = tokens[1];
            int desiredCol = tokens[2];
            int counterSteps = 0;
            int nearPlace = Integer.MAX_VALUE;


            if (!parkingCeils.get(desiredRow).contains("free")) {
                System.out.printf("Row %d full\n", desiredRow);
                input = scanner.nextLine();
                continue;
            }
            if (isFree(parkingCeils, desiredRow, desiredCol)) {
                parkingCeils.get(desiredRow).set(desiredCol, "car");
                counterSteps = desiredCol + 1 + Math.abs(desiredRow - entryRow);
            } else {
                for (int i = desiredCol - 1; i > 0; i--) {
                    if (isFree(parkingCeils, desiredRow, i)) {
                        counterSteps = i + 1;
                        nearPlace = desiredCol - i;
                        break;
                    }
                }
                for (int i = desiredCol + 1; i < cols; i++) {
                    if (isFree(parkingCeils, desiredRow, i)) {
                        if (nearPlace > i - desiredCol) {
                            nearPlace = i - desiredCol;
                            counterSteps = i + 1;
                            break;
                        }
                    }
                }
                parkingCeils.get(desiredRow).set(counterSteps - 1, "car");
                counterSteps += Math.abs(entryRow - desiredRow);
            }
            System.out.println(counterSteps);
            input = scanner.nextLine();
        }

    }


    private static boolean isFree(List<List<String>> parkingCeils, int desiredRow, int desiredCol) {
        return parkingCeils.get(desiredRow).get(desiredCol).equals("free");
    }
}
