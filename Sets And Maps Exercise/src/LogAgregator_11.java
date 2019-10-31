import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogAgregator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeSet<String>> countingMap = new TreeMap<>();
        TreeMap<String, Integer> resultMap = new TreeMap<>();


        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String IP = line[0];
            String usrname = line[1];
            int duration = Integer.parseInt(line[2]);

            countingMap.putIfAbsent(usrname, new TreeSet<>());
            countingMap.get(usrname).add(IP);

            resultMap.putIfAbsent(usrname, 0);
            resultMap.put(usrname, resultMap.get(usrname) + duration);

        }
        resultMap.keySet().stream().forEach(entry -> {
            System.out.printf("%s: %d %s\n",entry,resultMap.get(entry),countingMap.get(entry));



        });

    }

}
