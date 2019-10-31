import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDiference_03 {

    private static int[][] matrix;
    private static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        int sumFirst = 0;
        int sumSecond = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int row1 = 0;
        int col1 = 0;
        while (row1 < matrix.length)
            sumFirst += matrix[row1++][col1++];


        int row = size - 1;
        int col = 0;
        while (row >= 0) {
            sumSecond += matrix[row--][col++];
        }

        System.out.println(Math.abs(sumFirst - sumSecond));
    }

}