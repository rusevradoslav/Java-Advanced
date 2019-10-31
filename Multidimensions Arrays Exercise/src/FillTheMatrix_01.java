import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[size][size];

        switch (pattern) {
            case "A":
                fillMatrixA(matrix, size);
                printMethode(matrix);
                break;
            case "B":
                fillMatrixB(matrix, size);
                printMethode(matrix);
                break;
        }

    }

    private static void fillMatrixB(int[][] matrix, int size) {
        int value = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = value;
                    value++;
                }


            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }

        }
    }

    private static void printMethode(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrixA(int[][] matrix, int size) {
        int value = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = value;
                value++;
            }

        }
    }
}
