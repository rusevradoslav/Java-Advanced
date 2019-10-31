import java.util.ArrayList;
import java.util.Scanner;

public class TheGaden_DEMO_EXAM {

    public static int carrotsCount = 0;
    public static int potatoesCount = 0;
    public static int lettuceCount = 0;
    public static int harmedVgetables = 0;

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

        String line = scanner.nextLine();

        while (!line.equals("End of Harvest")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Harvest":
                    if (!isInRange(matrix, row, col)) {
                        break;
                    } else {
                        if (matrix[row][col] != ' ') {  //check if already harvested or harmed
                            harvestVegetables(matrix, row, col);
                        }

                    }
                    break;

                case "Mole":
                    if (!isInRange(matrix, row, col)) {
                        break;
                    } else {
                        String direction = tokens[3];
                        moleVegetables(matrix, row, col, direction);

                    }
                    break;
            }


            line = scanner.nextLine();
        }
        printMatrix(matrix);
        System.out.println("Carrots: " + carrotsCount);
        System.out.println("Potatoes: " + potatoesCount);
        System.out.println("Lettuce: " + lettuceCount);
        System.out.println("Harmed vegetables: " + harmedVgetables);


    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moleVegetables(char[][] matrix, int row, int col, String direction) {

        if (direction.equalsIgnoreCase("up")) {
            if (matrix[row][col] == 'L' || matrix[row][col] == 'C' || matrix[row][col] == 'P') {
                while (row >= 0) {
                    if (matrix[row][col] != ' ') {
                        matrix[row][col] = ' ';
                        harmedVgetables++;
                    }
                    row -= 2;
                }
            }
        } else if (direction.equalsIgnoreCase("down")) {
            if (matrix[row][col] == 'L' || matrix[row][col] == 'C' || matrix[row][col] == 'P') {
                while (row < matrix.length) {
                    if (matrix[row][col] != ' ') {
                        matrix[row][col] = ' ';
                        harmedVgetables++;
                    }
                    row += 2;
                }
            }

        } else if (direction.equalsIgnoreCase("left")) {
            if (matrix[row][col] == 'L' || matrix[row][col] == 'C' || matrix[row][col] == 'P') {
                while (col >= 0) {
                    if (matrix[row][col] != ' ') {
                        matrix[row][col] = ' ';
                        harmedVgetables++;
                    }
                    col -= 2;
                }
            }

        } else if (direction.equalsIgnoreCase("right")) {
            if (matrix[row][col] == 'L' || matrix[row][col] == 'C' || matrix[row][col] == 'P') {
                while (col < matrix[row].length) {
                    if (matrix[row][col] != ' ') {
                        matrix[row][col] = ' ';
                        harmedVgetables++;
                    }
                    col += 2;
                }
            }

        }
    }

    private static void harvestVegetables(char[][] matrix, int row, int col) {
        if (matrix[row][col] == 'L') {
            matrix[row][col] = ' ';
            lettuceCount++;
        } else if (matrix[row][col] == 'C') {
            matrix[row][col] = ' ';
            carrotsCount++;
        } else if (matrix[row][col] == 'P') {
            matrix[row][col] = ' ';
            potatoesCount++;
        }
    }

    private static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
