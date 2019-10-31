import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int row = rows - 1;
        int col = cols - 1;
        while (row >= 0) {
            int c = col;
            int r = row;
            while (r >= 0 && c < cols) {
                System.out.print(matrix[r--][c++] + " ");
            }
            col--;
            System.out.println();
            if (col == -1) {
                col = 0;
                row--;
            }

        }
    }
}
