import java.util.Scanner;

public class SpaceStationEstablishment_Exam_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

        }

        playerRow = getFirstRowSymbol('S', field);
        playerCol = getFirstColSymbol('S', playerRow, field);
        int starsCollection = 0;
        boolean isInField = true;
        while (starsCollection < 50) {
            String command = scanner.nextLine();
            field[playerRow][playerCol] = '-';
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        isInField = false;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow > field.length - 1) {
                        isInField = false;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        isInField = false;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol > field.length - 1) {
                        isInField = false;
                    }
                    break;
            }
            if (!isInField) {
                System.out.println("Bad news, the spaceship went to the void.");
                System.out.println("Star power collected: " + starsCollection);
                printMatrix(field);
                return;
            }
            if (Character.isDigit(field[playerRow][playerCol])) {
                starsCollection += Integer.parseInt(String.valueOf(field[playerRow][playerCol]));
            }
            if (field[playerRow][playerCol] == 'O') {
                field[playerRow][playerCol] = '-';
                int blackHallRow = getFirstRowSymbol('O', field);
                int blackHallCol = getFirstColSymbol('O', blackHallRow, field);
                playerRow = blackHallRow;
                playerCol = blackHallCol;
            }
            field[playerRow][playerCol] = 'S';

        }

        System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        System.out.println("Star power collected: " + starsCollection);
        printMatrix(field);


    }

    private static void printMatrix(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static int getFirstColSymbol(char symbol, int playerRow, char[][] field) {

        int index = -1;
        for (int i = 0; i < field.length; i++) {
            if (field[playerRow][i] == symbol) {
                index = i;
                break;
            }
        }

        return index;
    }


    private static int getFirstRowSymbol(char symbol, char[][] field) {
        int index = -1;
        int lenght = field.length;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                if (symbol == field[i][j]) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}

