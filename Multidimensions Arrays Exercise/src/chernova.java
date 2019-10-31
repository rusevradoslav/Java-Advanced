import java.util.Scanner;

public class chernova {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] tokens = scanner.nextLine().split(" ");
        String command = tokens[0];
        String hiddenColumn = tokens[1];


        switch (command) {
            case "hide":
                hideAndPrint(matrix, hiddenColumn);
                break;
            case "sort":
                sortAndPrint(matrix, hiddenColumn);
                break;
            case "filter":
                filterAndPrint(matrix, hiddenColumn, tokens[2]);
                break;

        }
    }

    private static void filterAndPrint(String[][] matrix, String hiddenColumn, String value) {
        int columnIndex = hiddenColumnIndex(matrix, hiddenColumn);
        System.out.println(String.join(" | ", matrix[0]));

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][columnIndex].equals(value)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }


    private static void sortAndPrint(String[][] matrix, String hiddenColumn) {
        int columnIndex = hiddenColumnIndex(matrix, hiddenColumn);
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][columnIndex].compareTo(matrix[i + 1][columnIndex]) > 0) {
                    String[] temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void hideAndPrint(String[][] matrix, String hiddenColumn) {
        int columnIndex = hiddenColumnIndex(matrix, hiddenColumn);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == columnIndex) {
                    continue;
                }
                System.out.print(matrix[i][j]);

                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static int hiddenColumnIndex(String[][] matrix, String hiddenColumn) {
        int hiddenColumnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(hiddenColumn)) {
                    hiddenColumnIndex = j;
                }
            }
        }
        return hiddenColumnIndex;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }
}

