import java.util.Scanner;
        import java.util.function.IntPredicate;
        import java.util.stream.IntStream;

public class FindEvenOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens =scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(tokens[0]);
        int upperBound = Integer.parseInt(tokens[1]);

        String filter = scanner.nextLine();

        IntPredicate condition;
        if (filter.equals("odd")) {
            condition = n -> n % 2 != 0;
        } else {
            condition = n -> n % 2 == 0;
        }
        IntStream.range(lowerBound, upperBound + 1).filter(condition).forEach(n -> System.out.printf(n + " "));

    }
}
