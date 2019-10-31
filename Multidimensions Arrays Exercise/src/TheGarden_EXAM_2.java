import java.util.Scanner;

public class TheGarden_EXAM_2 {

        public static int lettuceCount = 0;
        public static int potatoesCount = 0;
        public static int carrotsCount = 0;
        public static int harmedVegetables = 0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int rows = Integer.parseInt(scanner.nextLine());

            String[][] matrix = new String[rows][];

            for (int i = 0; i < rows; i++) {
                String[] line = scanner.nextLine().split("\\s+");
                matrix[i] = line;

            }

            String input = scanner.nextLine();
            while (!input.equals("End of Harvest")) {

                String[] tokens = input.split("\\s+");
                String command = tokens[0];
                int row = Integer.parseInt(tokens[1]);
                int col = Integer.parseInt(tokens[2]);

                switch (command) {
                    case "Harvest":
                        if (!isInRange(matrix, row, col)) {
                            break;
                        } else {
                            harvestVegetables(matrix, row, col);
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

                input = scanner.nextLine();
            }
            printMatrix(matrix);
            System.out.println("Carrots: " + carrotsCount);
            System.out.println("Potatoes: " + potatoesCount);
            System.out.println("Lettuce: " + lettuceCount);
            System.out.println("Harmed vegetables: " + harmedVegetables);

        }

        private static void printMatrix(String[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        private static void moleVegetables(String[][] matrix, int row, int col, String direction) {
            if (direction.equalsIgnoreCase("Up")) {
                while (row >= 0) {
                    if (matrix[row][col].equalsIgnoreCase("L") ||
                            matrix[row][col].equalsIgnoreCase("P") ||
                            matrix[row][col].equalsIgnoreCase("c")) {
                        harmedVegetables++;
                    }

                    matrix[row][col] = " ";
                    row -= 2;
                }
            } else if (direction.equalsIgnoreCase("Down")) {
                while (row < matrix.length) {
                    if (matrix[row][col].equalsIgnoreCase("L") ||
                            matrix[row][col].equalsIgnoreCase("P") ||
                            matrix[row][col].equalsIgnoreCase("c")) {
                        harmedVegetables++;
                    }
                    matrix[row][col] = " ";
                    row += 2;
                }
            } else if (direction.equalsIgnoreCase("Left")) {
                while (col >= 0) {
                    if (matrix[row][col].equalsIgnoreCase("L") ||
                            matrix[row][col].equalsIgnoreCase("P") ||
                            matrix[row][col].equalsIgnoreCase("c")) {
                        harmedVegetables++;
                    }
                    matrix[row][col] = " ";
                    col -= 2;

                }

            } else if (direction.equalsIgnoreCase("Right")) {
                while (col < matrix[row].length) {
                    if (matrix[row][col].equalsIgnoreCase("L") ||
                            matrix[row][col].equalsIgnoreCase("P") ||
                            matrix[row][col].equalsIgnoreCase("c")) {
                        harmedVegetables++;
                    }
                    matrix[row][col] = " ";
                    col += 2;
                }

            }
        }

        private static void harvestVegetables(String[][] matrix, int row, int col) {

            if (matrix[row][col].equalsIgnoreCase("L")) {
                matrix[row][col] = " ";
                lettuceCount++;
            } else if (matrix[row][col].equalsIgnoreCase("P")) {
                matrix[row][col] = " ";
                potatoesCount++;
            } else if (matrix[row][col].equalsIgnoreCase("C")) {
                matrix[row][col] = " ";
                carrotsCount++;
            }
        }


        private static boolean isInRange(String[][] matrix, int row, int col) {
            return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
        }
    }


