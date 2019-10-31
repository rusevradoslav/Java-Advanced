
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;


public class AcademyGraduations_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Double[]> map = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String student = scanner.nextLine();
            String[] tokens = scanner.nextLine().split(" ");
            Double[] scores = new Double[tokens.length];

            for (int i = 0; i < scores.length; i++) {
                scores[i] = Double.parseDouble(tokens[i]);
            }
            map.put(student, scores);
        }
        for (String studenName : map.keySet()) {
            double avg = Arrays.stream(map.get(studenName)).mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.println(studenName + "is graduated with " + avg);
        }
    }
}
