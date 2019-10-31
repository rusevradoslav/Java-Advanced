import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] line = scanner.nextLine().toCharArray();

        Map<Character, Integer> map = new TreeMap<>();

        for (Character character : line) {
            map.putIfAbsent(character, 0);
            map.put(character, map.get(character) + 1);
        }


        for (Character character : map.keySet()) {
            System.out.printf("%c: %d time/s\n", character, map.get(character));
        }

    }
}
