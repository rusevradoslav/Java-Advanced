import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int firstMatrixRows = tokens[0];
        int firstMatrixCols = tokens[1];
        int firstMatrix[][] = new int[firstMatrixRows][firstMatrixCols];

        matrixFilling(scanner, firstMatrixRows, firstMatrix);
        tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int secondMatrixRow = tokens[0];
        int secondMatrixCols = tokens[1];
        int secondMatrix[][] = new int[secondMatrixRow][secondMatrixCols];

        matrixFilling(scanner, secondMatrixRow, secondMatrix);

        if (isEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                return false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }


        return true;
    }


    private static void matrixFilling(Scanner scanner, int firstMatrixRows, int[][] firstMatrix) {
        for (int i = 0; i < firstMatrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }
    }
}

