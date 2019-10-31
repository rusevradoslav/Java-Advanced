import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        ArrayList<String> inputString = new ArrayList<>();

        int maxLenght = 0;
        for (int i = 0; i < rows; i++) {
            String characters = "";
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                characters += line[j];
            }
            for (int j = 0; j < line.length; j++) {
                inputString.add(characters);
                break;
            }
            if (maxLenght < line.length) {
                maxLenght = line.length;
            }

        }
        char[][] matrix = new char[rows][maxLenght];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < maxLenght; j++) {
                if (j > inputString.get(i).length() - 1) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = inputString.get(i).charAt(j);
                }

            }
        }
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Carrots", 0);
        map.put("Potatoes", 0);
        map.put("Lettuce", 0);
        int harmedVegetables = 0;
        String input = scanner.nextLine();
        while (!input.equals("End of Harvest")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);


            switch (command) {
                case "Harvest":
                    if (!isInRange(matrix, row, col) || matrix[row][col] == ' ') {
                        break;
                    } else {
                        char symbol = matrix[row][col];
                        harvestVegetable(symbol, map);
                        matrix[row][col] = ' ';

                    }
                    break;
                case "Mole":
                    String direction = tokens[3];
                    if (!isInRange(matrix, row, col) || matrix[row][col] == ' ')
                        break;
                    else {
                        harmedVegetables += moleVegetables(matrix, row, col, direction);
                    }
            }


            input = scanner.nextLine();
        }
        printMatrix(matrix);
        for (var entry : map.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
        System.out.println("Harmed vegetables: " + harmedVegetables);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static int moleVegetables(char[][] matrix, int row, int col, String direction) {

        int harmed = 1;
        if (direction.equalsIgnoreCase("Up")) {
            matrix[row][col] = ' ';
            while (row - 2 >= 0 && matrix[row - 2][col] != ' ') {
                row -= 2;
                harmed++;
                matrix[row][col] = ' ';
            }

        } else if (direction.equalsIgnoreCase("Down")) {
            matrix[row][col] = ' ';
            while (row + 2 <= matrix.length - 1 && matrix[row + 2][col] != ' ') {
                row += 2;
                harmed++;
                matrix[row][col] = ' ';

            }

        } else if (direction.equalsIgnoreCase("Left")) {
            matrix[row][col] = ' ';
            while (col - 2 <= 0 && matrix[row][col - 2] != ' ') {
                col -= 2;
                harmed++;
                matrix[row][col] = ' ';

            }

        } else if (direction.equalsIgnoreCase("Right")) {
            matrix[row][col] = ' ';
            while (col + 2 <= matrix[row].length - 1 && matrix[row][col + 2] != ' ') {
                col += 2;
                harmed++;
                matrix[row][col] = ' ';

            }

        }
        return harmed;
    }

    private static void harvestVegetable(char symbol, Map<String, Integer> map) {
        switch (symbol) {
            case 'L':
                map.put("Lettuce", map.get("Lettuce") + 1);
                break;
            case 'P':
                map.put("Potatoes", map.get("Potatoes") + 1);
                break;
            case 'C':
                map.put("Carrots", map.get("Carrots") + 1);
                break;
        }
    }


    private static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
