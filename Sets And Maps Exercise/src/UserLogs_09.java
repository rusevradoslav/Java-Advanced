import java.util.*;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            String IP = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String name = tokens[2].split("=")[1];
            if (!map.containsKey(name)) {
                map.put(name, new LinkedHashMap<>());
                map.get(name).put(IP, 1);
            } else {
                if (!map.get(name).containsKey(IP)) {
                    map.get(name).put(IP, 1);
                } else {
                    map.get(name).put(IP, map.get(name).get(IP) + 1);
                }
            }

            line = scanner.nextLine();
        }
        for (String name : map.keySet()) {
            System.out.printf("%s:\n", name);
            int size = map.get(name).keySet().size() - 1;

            for (String ip : map.get(name).keySet()) {
                int count = map.get(name).get(ip);
                if (size != 0) {
                    System.out.printf("%s => %d, ", ip, count);
                } else {
                    System.out.printf("%s => %d.\n", ip, count);

                }
                size--;

            }
        }
    }
}
