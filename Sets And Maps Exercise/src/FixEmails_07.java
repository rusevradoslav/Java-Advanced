import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();


        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = scanner.nextLine();
            String[] tokens = email.split("\\.");

           if (tokens[1].equals("bg")){
                map.put(name, email);
            }
        }
        for (String name : map.keySet()) {
            System.out.printf("%s -> %s\n", name, map.get(name));
        }
    }
}
