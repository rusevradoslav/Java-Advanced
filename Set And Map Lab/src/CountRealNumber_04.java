import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumber_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();

        for (double value : values) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }
        for (Double number : map.keySet()) {
            System.out.printf("%.1f -> %d\n", number, map.get(number));
        }
    }
}
