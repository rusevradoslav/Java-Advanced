import java.util.Scanner;

public class TronRacer_EXAM_2 {
    private static int firstPlayerRow = 0;
    private static int firstPlayerCol = 0;
    private static int secondPlayerRow = 0;
    private static int secondPlayerCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][rows];
        fillMatrix(field, scanner);

        boolean isFirstAlived = true;
        boolean isSecondAlived = true;
        while (isFirstAlived && isSecondAlived) {
            String[] tokens = scanner.nextLine().split(" ");
            String firstCommand = tokens[0];
            String secondCommand = tokens[1];


            isFirstAlived = moveFirst(field, firstCommand);
            if (!isFirstAlived) {
                break;
            }

            isSecondAlived = moveSecond(field, secondCommand);

        }
        printMatrix(field);
    }

    private static boolean moveSecond(char[][] field, String command) {
        int newPositionRow = secondPlayerRow;
        int newPositionCol = secondPlayerCol;
        boolean isAlived = true;
        switch (command) {
            case "up":

                if (newPositionRow == 0) {
                    newPositionRow = field.length - 1;
                } else {
                    newPositionRow = newPositionRow - 1;
                }

                break;
            case "down":
                if (newPositionRow == field.length - 1) {
                    newPositionRow = 0;
                } else {
                    newPositionRow = newPositionRow + 1;
                }
                break;
            case "left":

                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol = newPositionCol - 1;
                }

                break;
            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol = newPositionCol + 1;
                }
                break;
        }

        secondPlayerRow = newPositionRow;
        secondPlayerCol = newPositionCol;
        if (field[secondPlayerRow][secondPlayerCol] == 'f') {
            field[secondPlayerRow][secondPlayerCol] = 'x';
            isAlived = false;
        } else {
            field[secondPlayerRow][secondPlayerCol] = 's';
        }

        return isAlived;
    }

    private static boolean moveFirst(char[][] field, String command) {
        int newPositionRow = firstPlayerRow;
        int newPositionCol = firstPlayerCol;
        boolean isAlived = true;
        switch (command) {
            case "up":

                if (newPositionRow == 0) {
                    newPositionRow = field.length - 1;
                } else {
                    newPositionRow = newPositionRow - 1;
                }

                break;
            case "down":
                if (newPositionRow == field.length - 1) {
                    newPositionRow = 0;
                } else {
                    newPositionRow = newPositionRow + 1;
                }
                break;
            case "left":

                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol = newPositionCol - 1;
                }

                break;
            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol = newPositionCol + 1;
                }
                break;
        }

        firstPlayerRow = newPositionRow;
        firstPlayerCol = newPositionCol;
        if (field[firstPlayerRow][firstPlayerCol] == 's') {
            field[firstPlayerRow][firstPlayerCol] = 'x';
            isAlived = false;
        } else {
            field[firstPlayerRow][firstPlayerCol] = 'f';
        }

        return isAlived;
    }

    private static void fillMatrix(char[][] field, Scanner scanner) {
        for (int i = 0; i < field.length; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            for (int j = 0; j < field[i].length; j++) {
                char element = field[i][j];
                if (element == 'f') {
                    firstPlayerRow = i;
                    firstPlayerCol = line.indexOf('f');
                }
                if (element == 's') {
                    secondPlayerRow = i;
                    secondPlayerCol = line.indexOf('s');
                }
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
}
