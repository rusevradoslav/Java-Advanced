import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> map = new HashMap<>();

        String line = scanner.nextLine();


        while (!line.equals("search")) {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            map.put(name, phoneNumber);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("stop")) {
            if (map.containsKey(line)) {
                System.out.printf("%s -> %s\n", line, map.get(line));
            } else {
                System.out.printf("Contact %s does not exist.\n", line);
            }

            line = scanner.nextLine();
        }

    }
}
