import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumof2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int colws = size[1];
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;

        }
        int max = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int current = matrix[i][j];
                int right = matrix[i][j + 1];
                int below = matrix[i + 1][j];
                int diagonal = matrix[i + 1][j + 1];
                int sum = current + right + below + diagonal;
                if (sum > max) {
                    max = sum;
                    maxMatrix[0][0] = current;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = below;
                    maxMatrix[1][1] = diagonal;

                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max);

    }
}
