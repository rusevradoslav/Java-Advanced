import java.util.*;

public class PopulationCountry_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> resultCounting = new LinkedHashMap<>();
        Map<String, Long> populationResult = new LinkedHashMap<>();


        String line = scanner.nextLine();
        while (!line.equals("report")) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            resultCounting.putIfAbsent(country, new LinkedHashMap<>());
            resultCounting.get(country).putIfAbsent(city, 0L);
            resultCounting.get(country).put(city, resultCounting.get(country).get(city) + population);

            populationResult.putIfAbsent(country, 0L);
            populationResult.put(country, populationResult.get(country) + resultCounting.get(country).get(city));

            line = scanner.nextLine();
        }

        populationResult.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(entry -> {
            System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
            String current = entry.getKey();

            resultCounting.get(current).entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(entry1 ->
                    System.out.printf("=>%s: %d\n", entry1.getKey(), entry1.getValue()));
        });
    }

}

