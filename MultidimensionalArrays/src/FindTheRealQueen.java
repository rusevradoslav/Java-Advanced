import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] queenMatrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                queenMatrix[i][j] = tokens[j].charAt(0);
            }
        }

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (queenMatrix[r][c] == 'q') {
                    boolean isOnlyQueenCol = chekQueenCol(queenMatrix, c);
                    boolean isOnlyQueenRow = checkQueenRow(queenMatrix, r);
                    boolean isValidLeftDiagonal = checkLeftDiagonalUpLeft(r, c, queenMatrix);
                    boolean isValidLeftDiagonal1 = checkLeftDiagonalDownRight(r, c, queenMatrix);
                    boolean isValidRightDiagonal = checkRightDiagonalupRightUpRight(r, c, queenMatrix);
                    boolean isValidRightDiagonal1 = checkRightDiagonalDownLeft(r, c, queenMatrix);

                    if (isOnlyQueenCol && isOnlyQueenRow && isValidLeftDiagonal && isValidLeftDiagonal1 && isValidRightDiagonal && isValidRightDiagonal1) {
                        System.out.println(r + " " + c);
                        return;
                    }
                }

            }
        }
    }

    private static boolean checkRightDiagonalDownLeft(int row, int col, char[][] queenMatrix) {
        row++;
        col--;
        while (row < 8 && col >= 0)
            if (queenMatrix[row++][col--] == 'q') {
                return false;
            }
        return true;
    }

    private static boolean checkRightDiagonalupRightUpRight(int row, int col, char[][] queenMatrix) {
        row--;
        col++;
        while (row >= 0 && col < 8)
            if (queenMatrix[row--][col++] == 'q') {
                return false;
            }
        return true;
    }

    private static boolean checkLeftDiagonalDownRight(int row, int col, char[][] queenMatrix) {
        row++;
        col++;
        while (row < 8 && col < 8) {
            if (queenMatrix[row++][col++] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checkLeftDiagonalUpLeft(int row, int col, char[][] queenMatrix) {
        row--;
        col--;
        while (row >= 0 && col >= 0) {
            if (queenMatrix[row--][col--] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checkQueenRow(char[][] queenMatrix, int row) {
        int queen = 0;
        for (int i = 0; i < queenMatrix.length; i++) {
            char symbol = queenMatrix[row][i];
            if (symbol == 'q') {
                queen++;
            }
        }
        return queen == 1;
    }

    private static boolean chekQueenCol(char[][] queenMatrix, int col) {
        int queen = 0;
        for (int i = 0; i < queenMatrix.length; i++) {
            char symbol = queenMatrix[i][col];
            if (symbol == 'q') {
                queen++;
            }
        }
        return queen == 1;

    }

}
