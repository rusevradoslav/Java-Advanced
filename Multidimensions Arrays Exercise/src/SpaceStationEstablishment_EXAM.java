import java.util.Scanner;

public class SpaceStationEstablishment_EXAM {
    public static int stefanRow = 0;
    public static int stefanCol = 0;
    public static int firstBlackRow = 0;
    public static int firstBlackCol = 0;
    public static int secondBlackRow = 0;
    public static int secondBlackCol = 0;
    public static int stars = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        int blackHolesCount = 2;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                stefanRow = i;
                stefanCol = line.indexOf('S');
            }
            if (line.contains("O")) {
                if (blackHolesCount == 2) {
                    firstBlackRow = i;
                    firstBlackCol = line.indexOf("O");
                    blackHolesCount--;

                } else {
                    secondBlackRow = i;
                    secondBlackCol = line.indexOf("O");

                }
            }
        }

        boolean outOfField = false;

        while (!outOfField && stars < 50) {

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (stefanRow - 1 < 0) {
                        outOfField = true;
                        matrix[stefanRow][stefanCol] = '-';
                    } else if (matrix[stefanRow - 1][stefanCol] == 'O') {
                        if (stefanRow - 1 == firstBlackRow && stefanCol == firstBlackCol) {
                            moveFirstTosecond(matrix, firstBlackRow, firstBlackCol, secondBlackRow, secondBlackCol);
                        } else if ((stefanRow - 1 == secondBlackRow && stefanCol == secondBlackCol))
                            moveSecondTofirst(matrix, secondBlackRow, secondBlackCol, firstBlackRow, firstBlackCol);

                    } else if (isDigit(stefanRow - 1, stefanCol, matrix)) {
                        stars += Integer.parseInt(String.valueOf(matrix[stefanRow - 1][stefanCol]));
                        matrix[stefanRow][stefanCol] = '-';
                        stefanRow--;
                        matrix[stefanRow][stefanCol] = 'S';
                    } else if (stefanRow - 1 < 0) {
                        outOfField = true;
                        matrix[stefanRow][stefanCol] = '-';
                    } else {
                        matrix[stefanRow][stefanCol] = '-';
                        stefanRow--;
                        matrix[stefanRow][stefanCol] = 'S';
                    }

                    break;
                case "down":
                    if (stefanRow + 1 > matrix.length - 1) {
                        outOfField = true;
                        matrix[stefanRow][stefanCol] = '-';

                    } else if (matrix[stefanRow + 1][stefanCol] == 'O') {
                        if (stefanRow + 1 == firstBlackRow && stefanCol == firstBlackCol) {
                            moveFirstTosecond(matrix, firstBlackRow, firstBlackCol, secondBlackRow, secondBlackCol);
                        } else if ((stefanRow + 1 == secondBlackRow && stefanCol == secondBlackCol))
                            moveSecondTofirst(matrix, secondBlackRow, secondBlackCol, firstBlackRow, firstBlackCol);

                    } else if (isDigit(stefanRow + 1, stefanCol, matrix)) {
                        stars += Integer.parseInt(String.valueOf(matrix[stefanRow + 1][stefanCol]));
                        matrix[stefanRow][stefanCol] = '-';
                        stefanRow++;
                        matrix[stefanRow][stefanCol] = 'S';
                    } else {
                        matrix[stefanRow][stefanCol] = '-';
                        stefanRow++;
                        matrix[stefanRow][stefanCol] = 'S';
                    }

                    break;
                case "left":
                    if (stefanCol - 1 < 0) {
                        outOfField = true;
                        matrix[stefanRow][stefanCol] = '-';

                    } else if (matrix[stefanRow][stefanCol - 1] == 'O') {
                        if (stefanRow == firstBlackRow && stefanCol - 1 == firstBlackCol) {
                            moveFirstTosecond(matrix, firstBlackRow, firstBlackCol, secondBlackRow, secondBlackCol);
                        } else if ((stefanRow == secondBlackRow && stefanCol - 1 == secondBlackCol))
                            moveSecondTofirst(matrix, secondBlackRow, secondBlackCol, firstBlackRow, firstBlackCol);

                    } else if (isDigit(stefanRow, stefanCol - 1, matrix)) {
                        stars += Integer.parseInt(String.valueOf(matrix[stefanRow][stefanCol-1]));
                        matrix[stefanRow][stefanCol] = '-';
                        stefanCol--;
                        matrix[stefanRow][stefanCol] = 'S';
                    } else {
                        matrix[stefanRow][stefanCol] = '-';
                        stefanCol--;
                        matrix[stefanRow][stefanCol] = 'S';
                    }

                    break;
                case "right":
                    if (stefanCol + 1 > matrix.length - 1) {
                        outOfField = true;
                        matrix[stefanRow][stefanCol] = '-';

                    } else if (matrix[stefanRow][stefanCol + 1] == 'O') {
                        if (stefanRow == firstBlackRow && stefanCol + 1 == firstBlackCol) {
                            moveFirstTosecond(matrix, firstBlackRow, firstBlackCol, secondBlackRow, secondBlackCol);
                        } else if ((stefanRow == secondBlackRow && stefanCol + 1 == secondBlackCol))
                            moveSecondTofirst(matrix, secondBlackRow, secondBlackCol, firstBlackRow, firstBlackCol);

                    } else if (isDigit(stefanRow, stefanCol + 1, matrix)) {
                        stars += Integer.parseInt(String.valueOf(matrix[stefanRow ][stefanCol+1]));
                        matrix[stefanRow][stefanCol] = '-';
                        stefanCol++;
                        matrix[stefanRow][stefanCol] = 'S';
                    } else {
                        matrix[stefanRow][stefanCol] = '-';
                        stefanCol++;
                        matrix[stefanRow][stefanCol] = 'S';
                    }
                    break;
            }


        }
        if (outOfField) {

            System.out.println("Bad news, the spaceship went to the void.");
            System.out.printf("Star power collected: %d\n", stars);

        } else if (stars >= 50) {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
            System.out.printf("Star power collected: %d\n", stars);

        }

        printMatrix(matrix);
    }

    private static void moveSecondTofirst(char[][] matrix, int secondBlackRow, int secondBlackCol, int firstBlackRow, int firstBlackCol) {
        matrix[stefanRow][stefanCol] = '-';
        matrix[secondBlackRow][secondBlackCol] = '-';
        matrix[firstBlackRow][firstBlackCol] = 'S';
        stefanRow = firstBlackRow;
        stefanCol = firstBlackCol;
    }

    private static void moveFirstTosecond(char[][] matrix, int firstBlackRow, int firstBlackCol, int secondBlackRow, int secondBlackCol) {
        matrix[stefanRow][stefanCol] = '-';
        matrix[firstBlackRow][firstBlackCol] = '-';
        matrix[secondBlackRow][secondBlackCol] = 'S';
        stefanRow = secondBlackRow;
        stefanCol = secondBlackCol;
    }

    private static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isDigit(int stefanRow, int stefanCol, char[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Character.isDigit(matrix[stefanRow][stefanCol])) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
