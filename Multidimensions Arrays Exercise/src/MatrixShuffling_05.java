import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] sizeData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeData[0];
        int col = sizeData[1];

        String[][] matrix = new String[rows][col];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("swap") && tokens.length == 5) {
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);


                if (isInRange(matrix, firstRow, firstCol)
                        && isInRange(matrix, secondRow, secondCol)) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");

                }

            } else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static boolean isInRange(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
