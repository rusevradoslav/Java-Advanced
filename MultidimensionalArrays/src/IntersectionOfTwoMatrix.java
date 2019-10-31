import java.util.Scanner;

public class IntersectionOfTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[n][m];
        char[][] secondMatrix = new char[n][m];


        fillMatrixChar(scanner, n, m, firstMatrix);
        fillMatrixChar(scanner, n, m, secondMatrix);

        isEqual(n, m, firstMatrix, secondMatrix);


    }

    private static void fillMatrixChar(Scanner scanner, int n, int m, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < m; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
    }


    private static void isEqual(int n, int m, char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}

