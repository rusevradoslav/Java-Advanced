import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> nameWithAge = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split(", ");
            int age = Integer.parseInt(line[1]);
            String name = line[0];
            nameWithAge.put(name, age);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();

        Predicate<Integer> filter = predicateMethode(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = getPrinted(type);

        nameWithAge.entrySet().stream().filter(e -> filter.test(e.getValue())).forEach(entry -> printer.accept(entry));


    }

    private static Consumer<Entry<String, Integer>> getPrinted(String type) {
        Consumer<Map.Entry<String, Integer>> printer;
        if (type.equals("name")) {
            printer = n -> System.out.printf("%s\n", n.getKey());
        } else if (type.equals("age")) {
            printer = n -> System.out.printf("%s\n", n.getValue());
        } else {
            printer = n -> System.out.printf("%s - %d\n", n.getKey(), n.getValue());
        }
        return printer;
    }

    private static Predicate<Integer> predicateMethode(String condition, int age) {
        Predicate<Integer> result;
        if (condition.equals("younger")) {
            result = n -> n <= age;
        } else {
            result = n -> n >= age;
        }
        return result;
    }
}
