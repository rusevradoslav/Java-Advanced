import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();


        while (true) {
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            map.putIfAbsent(resource, 0);
            map.put(resource, map.get(resource) + quantity);
        }
        for (String element : map.keySet()) {
            System.out.printf("%s -> %s\n", element, map.get(element));
        }

    }
}