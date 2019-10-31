import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        int wormRow = 0;
        int wormCol = 0;
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][rows];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("P")) {
                wormRow = i;
                wormCol = line.indexOf("P");
            }

        }
        String outPutText = text;


        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[wormRow][wormCol] = '-';
            switch (command) {
                case "up":
                    wormRow--;
                    if (isInRange(matrix, wormRow, wormCol)) {
                        if (Character.isLetter(matrix[wormRow][wormCol])) {
                            outPutText += matrix[wormRow][wormCol];
                        }
                    } else {
                        wormRow = 0;
                        if (!outPutText.isEmpty()) {
                            outPutText = outPutText.substring(0, outPutText.length() - 1);
                        }

                    }

                    break;
                case "down":
                    wormRow++;
                    if (isInRange(matrix, wormRow, wormCol)) {
                        if (Character.isLetter(matrix[wormRow][wormCol])) {
                            outPutText += matrix[wormRow][wormCol];
                        }
                    } else {
                        wormRow = matrix.length - 1;
                        if (!outPutText.isEmpty()) {
                            outPutText = outPutText.substring(0, outPutText.length() - 1);
                        }

                    }
                    break;
                case "left":
                    wormCol--;
                    if (isInRange(matrix, wormRow, wormCol)) {
                        if (Character.isLetter(matrix[wormRow][wormCol])) {
                            outPutText += matrix[wormRow][wormCol];
                        }
                    } else {

                        wormCol = 0;
                        if (!outPutText.isEmpty()) {
                            outPutText = outPutText.substring(0, outPutText.length() - 1);
                        }

                    }
                    break;
                case "right":
                    wormCol++;
                    if (isInRange(matrix, wormRow, wormCol)) {
                        if (Character.isLetter(matrix[wormRow][wormCol])) {
                            outPutText += matrix[wormRow][wormCol];
                        }
                    } else {
                        wormCol = matrix.length - 1;
                        if (!outPutText.isEmpty()) {
                            outPutText = outPutText.substring(0, outPutText.length() - 1);
                        }

                    }
                    break;
            }


            matrix[wormRow][wormCol] = 'P';

            command = scanner.nextLine();
        }

        System.out.println(outPutText);
        printMatrix(matrix);

    }

    private static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
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
