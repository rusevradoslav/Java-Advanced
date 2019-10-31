import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrossFire_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dataSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dataSize[0];
        int cols = dataSize[1];
        ArrayList<ArrayList<Integer>> matrix = fillMatrix(rows, cols);


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {

            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int range = tokens[2];


            for (int r = row - range; r <= row + range; r++) {
                if (isInBound(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }

            }
            for (int c = col-range; c <=col+range; c++) {
                if (isInBound(matrix,c,row)){
                    matrix.get(c).set(row,0);
                }
            }



            for (int c = col - range; c <= col + range; c++) {
                if (isInBound(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }

            }


            for (int r = 0; r < matrix.size(); r++) {
                matrix.set(r, matrix.get(r).stream()
                        .filter(element -> element != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(r).size() == 0) {
                    matrix.remove(r);
                    r--;
                }
            }


            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static boolean isInBound(ArrayList<ArrayList<Integer>> matrix, int row, int col) {

        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> fillMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;
        for (int r = 0; r < rows; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add(value);
                value++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}
