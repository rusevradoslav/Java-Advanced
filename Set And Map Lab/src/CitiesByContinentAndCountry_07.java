import java.lang.reflect.Array;
import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new LinkedList<>());
                map.get(continent).get(country).add(city);

            } else {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);

                }
            }


        }
        for (String continent : map.keySet()) {
            System.out.println(continent + ":");
            Map<String, List<String>> newMap = map.get(continent);
            for (String s : newMap.keySet()) {
                System.out.printf("%s -> %s\n", s, String.join(", ", newMap.get(s)));

            }

        }

    }


}


