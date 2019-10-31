import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        int rows = tokens[0];
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int n = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == n) {
                    System.out.printf("%d %d\n", row, col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }

    }
}
