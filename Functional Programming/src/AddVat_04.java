import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class AddVat_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> vat = x -> x * 1.2;
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).map(d -> vat.apply(d)).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        numbers.stream().forEach(number ->
                System.out.printf("%.2f\n", number));

    }
}
