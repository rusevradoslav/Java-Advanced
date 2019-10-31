import java.util.Scanner;

public class HelensAduction_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];
        int parisRow = 0;
        int parisCol = 0;
        int helenaRow = 0;
        int helenaCol = 0;


        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("H")) {
                helenaRow = i;
                helenaCol = line.indexOf('H');
            }
            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf('P');
            }

        }


        while (true) {
            boolean isAbducted = false;
            energy--;
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int rowS = Integer.parseInt(tokens[1]);
            int colS = Integer.parseInt(tokens[2]);
            matrix[rowS][colS] = 'S';

            if (command.equals("up") && inBound(matrix, parisRow - 1, parisCol)) {
                matrix[parisRow][parisCol] = '-';
                parisRow--;
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (matrix[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }
                matrix[parisRow][parisCol] = 'P';
            } else if (command.equals("down") && inBound(matrix, parisRow + 1, parisCol)) {

                matrix[parisRow][parisCol] = '-';
                parisRow++;
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (matrix[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }
                matrix[parisRow][parisCol] = 'P';

            } else if (command.equals("left") && inBound(matrix, parisRow, parisCol - 1)) {

                matrix[parisRow][parisCol] = '-';
                parisCol--;
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (matrix[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }
                matrix[parisRow][parisCol] = 'P';

            } else if (command.equals("right") && inBound(matrix, parisRow, parisCol + 1)) {

                matrix[parisRow][parisCol] = '-';
                parisCol++;
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (matrix[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }
                matrix[parisRow][parisCol] = 'P';

            }


            if (isAbducted) {
                matrix[parisRow][parisCol] = '-';
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                break;
            } else if (energy <= 0) {
                matrix[parisRow][parisCol] = 'X';
                System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
                break;

            }
        }

        printMatrix(matrix);
    }


    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean inBound(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}








