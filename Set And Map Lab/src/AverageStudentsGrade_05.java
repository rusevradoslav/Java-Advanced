import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrade_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> record = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if (!record.containsKey(name)) {
                record.put(name, new LinkedList<>());
                record.get(name).add(grade);
            } else {
                record.get(name).add(grade);
            }

        }
        DecimalFormat df = new DecimalFormat("#.00");
        for (String student : record.keySet()) {
            double sum = 0;

            System.out.printf("%s -> ", student);
            for (Double s : record.get(student)) {
                sum += s;
                System.out.printf(df.format(s) + " ");
            }
            System.out.printf("(avg: %.2f)\n", sum / record.get(student).size());
        }
    }
}
