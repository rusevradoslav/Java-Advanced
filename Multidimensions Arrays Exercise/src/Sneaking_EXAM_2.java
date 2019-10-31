import java.util.Scanner;

public class Sneaking_EXAM_2 {
    public static int samRow = 0;
    public static int samCol = 0;
    public static int nikoCol = 0;
    public static int nikoRow = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][];

        fillMatrix(field, scanner);

        String line = scanner.nextLine();


        for (int i = 0; i < line.length(); i++) {
            char command = line.charAt(i);

            moveEnemies(n, field);

            if (isDead(samRow, samCol, field)) {
                field[samRow][samCol] = 'X';
                System.out.printf("Sam died at %d, %d\n", samRow, samCol);
                printMatrix(field);
                return;

            } else {

                switch (command) {
                    case 'U':
                        field[samRow][samCol] = '.';
                        samRow--;
                        break;
                    case 'D':
                        field[samRow][samCol] = '.';
                        samRow++;
                        break;
                    case 'L':
                        field[samRow][samCol] = '.';
                        samCol--;
                        break;
                    case 'R':
                        field[samRow][samCol] = '.';
                        samCol++;
                        break;
                    case 'W':
                        break;
                }
                field[samRow][samCol] = 'S';

            }
            if (samRow == nikoRow) {
                field[nikoRow][nikoCol] = 'X';
                field[samRow][samCol] = 'S';
                System.out.println("Nikoladze killed!");
                printMatrix(field);
                return;
            }


        }
    }

    private static void printMatrix(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isDead(int samRow, int samCol, char[][] field) {
        boolean dead = false;
        for (int i = 0; i < samCol; i++) {
            if (field[samRow][i] == 'b') {
                dead = true;
            }
        }
        for (int i = samCol + 1; i <=field[samRow].length-1; i++) {
            if (field[samRow][i] == 'd') {
                dead = true;
            }
        }

        return dead;

    }

    private static void moveEnemies(int n, char[][] field) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'b') {
                    if (j == field[i].length - 1) {
                        field[i][j] = 'd';

                    } else {
                        field[i][j++] = '.';
                        field[i][j] = 'b';
                    }
                    break;
                }
                if (field[i][j] == 'd') {
                    if (j == 0) {
                        field[i][j] = 'b';

                    } else {
                        field[i][j--] = '.';
                        field[i][j] = 'd';
                    }
                    break;
                }
            }
        }

    }


    private static void fillMatrix(char[][] field, Scanner scanner) {
        for (int i = 0; i < field.length; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'S') {
                    samRow = i;
                    samCol = j;
                    break;
                }
                if (field[i][j] == 'N') {
                    nikoRow = i;
                    nikoCol = j;
                    break;
                }
            }

        }
    }
}
