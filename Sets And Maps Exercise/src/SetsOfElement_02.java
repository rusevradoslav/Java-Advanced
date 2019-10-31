import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (n-- > 0) {
            int number = scanner.nextInt();
            first.add(number);
        }
        while (m-- > 0) {
            int number = scanner.nextInt();
            second.add(number);
        }
        first.retainAll(second);
        //tazi funkciq vrusta vs ednakvi elementi koito podavame ot second


        for (Integer integer : first) {
            System.out.printf(integer + " ");
        }
    }
}
