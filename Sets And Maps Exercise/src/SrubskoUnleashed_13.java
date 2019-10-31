import java.util.*;

public class SrubskoUnleashed_13 {
    private static String name = "";
    private static String vanue = "";
    private static int ticketsCount = 0;
    private static int ticketsPrice = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Map<String, Integer>> map = new LinkedHashMap<>();


        String line = scanner.nextLine();
        while (!line.equals("End")) {

            if (isValid(line)) {

                map.putIfAbsent(vanue, new LinkedHashMap<>());
                map.get(vanue).putIfAbsent(name, 0);
                map.get(vanue).put(name, map.get(vanue).get(name) + (ticketsPrice * ticketsCount));

            }

            line = scanner.nextLine();
        }
        map.entrySet().stream().forEach(entry -> {
            System.out.printf("%s\n", entry.getKey());
            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry1 -> {

                System.out.printf("#  %s -> %d\n", entry1.getKey(), entry1.getValue());
            });
        });


    }


    private static boolean isValid(String line) {
        boolean isValid = true;
        int nameIndex = line.indexOf(" @");


        if (nameIndex != -1) {


            name = line.substring(0, nameIndex);

        } else {
            return false;
        }

        int ticketsCountIndex = line.lastIndexOf(" ");

        if (ticketsCountIndex != -1) {
            try {
                ticketsCount = Integer.parseInt(line.substring(ticketsCountIndex + 1, line.length()));
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }

        if (nameIndex != -1) {
            String middle = line.substring(nameIndex + 2, ticketsCountIndex);
            int middleLastIndex = middle.lastIndexOf(" ");

            if (middleLastIndex != -1) {
                try {
                    ticketsPrice = Integer.parseInt(middle.substring(middleLastIndex + 1, middle.length()));
                } catch (Exception e) {
                    return false;
                }
                vanue = middle.substring(0, middleLastIndex);
            } else {
                return false;
            }
        } else {

            return false;
        }


        return isValid;
    }
}
