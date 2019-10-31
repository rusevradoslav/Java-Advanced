import java.util.Arrays;
        import java.util.Scanner;

public class PrintyDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int row = 0;
        int col = 0;

        while (row < size && col < size) {

            int element = matrix[row][col];
            System.out.print(element + " ");
            row++;
            col++;
        }
        System.out.println();

        int col1 = 0;
        int row1 = size - 1;
        while (row1 >= 0 && col1 < size) {
            int element1 = matrix[row1][col1];
            System.out.print(element1 + " ");
            col1++;
            row1--;
        }


    }
}