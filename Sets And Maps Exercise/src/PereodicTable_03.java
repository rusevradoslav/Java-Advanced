import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PereodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> chemicals = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {

                chemicals.add(line[i]);
            }
        }
        for (String chemical : chemicals) {
            System.out.printf(chemical + " ");
        }
    }

}
