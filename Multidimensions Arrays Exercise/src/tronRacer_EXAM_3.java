import java.util.Scanner;

public class tronRacer_EXAM_3 {
    public static int firstPlayerRow = 0;
    public static int firstPlayerCol = 0;
    public static int secondPlayerRow = 0;
    public static int secondPlayerCol = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];

        fillMatrix(field, scanner, n);
        boolean isFirstAlived = true;
        boolean isSeconAlived = true;

        while (isFirstAlived && isSeconAlived) {
            String[] tokens = scanner.nextLine().split(" ");
            String firstCommand = tokens[0];
            String secondCommand = tokens[1];

            isFirstAlived = moveFirstPlayer(field, firstCommand);
            if (!isFirstAlived) {
                break;
            }
            isSeconAlived = moveSecondPlayer(field, secondCommand);


        }
        printMatrix(field);

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean moveSecondPlayer(char[][] field, String command) {

        int newPositionRow = secondPlayerRow;
        int newPositionCol = secondPlayerCol;

        switch (command) {
            case "up":
                if (newPositionRow == 0) {
                    newPositionRow = field.length - 1;
                } else {
                    newPositionRow--;
                }
                break;
            case "down":
                if (newPositionRow == field.length - 1) {
                    newPositionRow = 0;
                } else {
                    newPositionRow++;
                }
                break;
            case "left":
                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol--;
                }
                break;
            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol++;
                }
                break;
        }

        secondPlayerRow = newPositionRow;
        secondPlayerCol = newPositionCol;

        boolean isAlived = true;
        if (field[secondPlayerRow][secondPlayerCol] == 'f') {
            field[secondPlayerRow][secondPlayerCol] = 'x';
            isAlived = false;
        } else {
            field[secondPlayerRow][secondPlayerCol] = 's';
        }


        return isAlived;
    }

    private static boolean moveFirstPlayer(char[][] field, String command) {

        int newPositionRow = firstPlayerRow;
        int newPositionCol = firstPlayerCol;

        switch (command) {
            case "up":
                if (newPositionRow == 0) {
                    newPositionRow = field.length - 1;
                } else {
                    newPositionRow--;
                }
                break;
            case "down":
                if (newPositionRow == field.length - 1) {
                    newPositionRow = 0;
                } else {
                    newPositionRow++;
                }
                break;
            case "left":
                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol--;
                }
                break;
            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol++;
                }
                break;
        }

        firstPlayerRow = newPositionRow;
        firstPlayerCol = newPositionCol;

        boolean isAlived = true;
        if (field[firstPlayerRow][firstPlayerCol] == 's') {
            field[firstPlayerRow][firstPlayerCol] = 'x';
            isAlived = false;
        } else {
            field[firstPlayerRow][firstPlayerCol] = 'f';
        }
        return isAlived;
    }

    private static void fillMatrix(char[][] field, Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'f') {
                    firstPlayerRow = i;
                    firstPlayerCol = j;
                    break;
                }
                if (field[i][j] == 's') {
                    secondPlayerRow = i;
                    secondPlayerCol = j;
                    break;
                }
            }
        }
    }
}

