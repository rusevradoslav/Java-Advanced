import java.util.Scanner;

public class ExelFunction_EXAM_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] tokens = scanner.nextLine().split("\\s+");

        switch (tokens[0]) {
            case "hide":
                hideAndPrint(matrix, tokens[1]);

                break;
            case "sort":
                sortAndPrint(matrix, tokens[1]);
                break;
            case "filter":
                filterAndPrint(matrix, tokens[1], tokens[2]);
                break;
        }
    }

    private static void filterAndPrint(String[][] matrix, String token, String token1) {
        int filterColumnIndex = getColumnByIndex(matrix[0], token);
        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][filterColumnIndex].equals(token1)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }


    private static void sortAndPrint(String[][] matrix, String token) {
        int sortColumnIndex = getColumnByIndex(matrix[0], token);
        System.out.println(String.join(" | ", matrix[0]));
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 1; row < matrix.length - 1; row++) {
                if (matrix[row][sortColumnIndex].compareTo(matrix[row + 1][sortColumnIndex]) > 0) {
                    String[] temp = matrix[row];
                    matrix[row] = matrix[row + 1];
                    matrix[row + 1] = temp;

                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }


    }

    private static void hideAndPrint(String[][] matrix, String token) {
        int hiddenColumn = getColumnByIndex(matrix[0], token);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == hiddenColumn) {
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


    private static int getColumnByIndex(String[] matrix, String token) {
        int columnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(token)) {
                columnIndex = i;
                break;
            }
        }
        return columnIndex;
    }
}
