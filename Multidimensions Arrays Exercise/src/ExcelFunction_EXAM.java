    import java.util.*;

    public class ExcelFunction_EXAM {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int row = Integer.parseInt(scanner.nextLine());


            String[][] matrix = new String[row][];

            for (int i = 0; i < row; i++) {
                matrix[i] = scanner.nextLine().split(", ");
            }

            String[] tokens = scanner.nextLine().split(" ");


            if (tokens[0].equals("hide")) {

                hiddenColumnAndPrint(matrix, tokens[1]);

            } else if (tokens[0].equals("sort")) {
                sortByColumn(matrix, tokens[1]);

            } else if (tokens[0].equals("filter")) {
                filterByColumnAndPrint(matrix, tokens[1], tokens[2]);
            }

        }

        private static void filterByColumnAndPrint(String[][] matrix, String token, String value) {
            int filterColumnIndex = getColumnIndexByName(matrix[0], token);
            System.out.println(String.join(" | ", matrix[0]));
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][filterColumnIndex].equals(value)) {
                    System.out.println(String.join(" | ", matrix[i]));
                }
            }
        }

        private static void sortByColumn(String[][] matrix, String token) {
            int sortColumnIndex = getColumnIndexByName(matrix[0], token);
            for (int j = 0; j < matrix.length; j++) {
                for (int i = 1; i < matrix.length - 1; i++) {
                    if (matrix[i][sortColumnIndex].compareTo(matrix[i + 1][sortColumnIndex]) > 0) {
                        String[] tmp = matrix[i];
                        matrix[i] = matrix[i + 1];
                        matrix[i + 1] = tmp;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                    if (j != matrix[i].length - 1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();

            }

        }

        private static void hiddenColumnAndPrint(String[][] matrix, String token) {

            int hiddenCoulmnIndex = getColumnIndexByName(matrix[0], token);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == hiddenCoulmnIndex) {
                        continue;
                    }
                    System.out.print(matrix[i][j]);
                    if (j != matrix[i].length - 1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }
        }

        private static int getColumnIndexByName(String[] matrix, String hiddenColumn) {
            int hiddenCoulmnIndex = -1;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].equals(hiddenColumn)) {
                    hiddenCoulmnIndex = i;
                    break;
                }
            }
            return hiddenCoulmnIndex;
        }

    }
