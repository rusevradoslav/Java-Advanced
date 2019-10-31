import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = line[0];
        int cols = line[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = Integer.MIN_VALUE;

        int rowIndex = -1;
        int colIndex = -1;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = getMatrixSum(matrix, row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = row;
                    colIndex = col;
                }

            }

        }
        System.out.println("Sum = " + maxSum);
        printMatrix(matrix, rowIndex, colIndex);

    }

    private static void printMatrix(int[][] matrix, int rowIndex, int colIndex) {
        if (rowIndex != -1 && colIndex != -1) {
            int beginRow = rowIndex - 1;
            int beginCol = colIndex - 1;

            for (int r = beginRow; r < beginRow + 3; r++) {
                for (int c = beginCol; c < beginCol + 3; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }

        }
    }

    private static int getMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row - 1][col + 1];


        return sum;

    }
}
