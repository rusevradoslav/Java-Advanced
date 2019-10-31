import java.util.Scanner;

public class SpaceStationEstablishment_EXAM_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;
        int firstBlackRow = 0;
        int firstBlackCol = 0;
        int secondBlackRow = 0;
        int secondBlackCol = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();


            if (line.contains("S")) {
                playerRow = i;
                playerCol = line.indexOf("S");
            }
            if (line.contains("O")) {
                if (count == 0) {
                    firstBlackRow = i;
                    firstBlackCol = line.indexOf("O");
                    count++;
                } else {
                    secondBlackRow = i;
                    secondBlackCol = line.indexOf("O");
                }
            }

        }

        int starsCollection = 0;
        boolean outOfField = false;
        while (starsCollection < 50) {
            field[playerRow][playerCol] = '-';
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        outOfField = true;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow > field.length - 1) {
                        outOfField = true;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        outOfField = true;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol > field.length - 1) {
                        outOfField = true;
                    }
                    break;
            }

            if (outOfField) {
                System.out.println("Bad news, the spaceship went to the void.");
                System.out.printf("Star power collected: %s\n", starsCollection);
                printMatrix(field);
                return;
            }


            if (Character.isDigit(field[playerRow][playerCol])) {
                starsCollection += Integer.parseInt(String.valueOf(field[playerRow][playerCol]));
            } else if (field[playerRow][playerCol] == 'O') {
                if (playerRow == firstBlackRow && playerCol == firstBlackCol) {

                    field[firstBlackRow][firstBlackCol] = '-';
                    playerRow = secondBlackRow;
                    playerCol = secondBlackCol;
                } else {

                    field[firstBlackRow][firstBlackCol] = '-';
                    playerRow = firstBlackRow;
                    playerCol = firstBlackCol;
                }

            }
            field[playerRow][playerCol] = 'S';
        }

        System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        System.out.printf("Star power collected: %s\n", starsCollection);
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
}
