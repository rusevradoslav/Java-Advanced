import java.util.Scanner;

public class Sneaking_Exam {
    public static int samRow = 0;
    public static int samCol = 0;
    public static int nikoRow = 0;
    public static int nikoCol = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];


        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                samRow = i;
                samCol = line.indexOf("S");
            }
            if (line.contains("N")) {
                nikoRow = i;
                nikoCol = line.indexOf("N");
            }
        }


        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char command = line.charAt(i);

            moveEnemies(rows, matrix);

            if (isDead(samRow, samCol, matrix)) {
                matrix[samRow][samCol] = 'X';
                System.out.printf("Sam died at %d, %d\n", samRow, samCol);
                printMatrix(matrix);
                return;
            } else {

                switch (command) {
                    case 'U':
                        matrix[samRow][samCol] = '.';
                        matrix[samRow - 1][samCol] = 'S';
                        samRow--;
                        break;
                    case 'D':
                        matrix[samRow][samCol] = '.';
                        matrix[samRow + 1][samCol] = 'S';
                        samRow++;
                        break;
                    case 'L':
                        matrix[samRow][samCol] = '.';
                        matrix[samRow][samCol - 1] = 'S';
                        samCol--;
                        break;
                    case 'R':
                        matrix[samRow][samCol] = '.';
                        matrix[samRow][samCol + 1] = 'S';
                        samCol++;
                        break;
                    case 'W':
                        break;
                }
            }
            if (samRow == nikoRow) {
                matrix[nikoRow][nikoCol] = 'X';

                System.out.println("Nikoladze killed!");
                printMatrix(matrix);
                return;
            }
        }
    }


    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isDead(int samRow, int samCol, char[][] matrix) {
        boolean dead = false;

        for (int j = 0; j < samCol; j++) {
            if (matrix[samRow][j] == 'b') {
                dead = true;
            }
        }
        for (int i = samCol + 1; i < matrix[samRow].length; i++) {
            if (matrix[samRow][i] == 'd') {
                dead = true;
            }
        }


        return dead;
    }


    private static void moveEnemies(int rows, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'b') {
                    if (j < matrix[i].length - 1) {
                        matrix[i][j] = '.';
                        matrix[i][j + 1] = 'b';

                    } else {
                        matrix[i][j] = 'd';
                    }
                    break;
                }
                if (matrix[i][j] == 'd') {
                    if (j > 0) {
                        matrix[i][j] = '.';
                        matrix[i][j - 1] = 'd';
                    } else {
                        matrix[i][j] = 'b';
                    }
                    break;
                }
            }
        }
    }
}
