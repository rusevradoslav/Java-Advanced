package OpinionPool_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> persons = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            persons.add(person);

        }


        persons.stream().sorted((f, s) -> f.getName().compareTo(s.getName())).filter(person -> person.getAge() > 30).forEach(entry -> {
            System.out.println(String.format("%s - %d", entry.getName(), entry.getAge()));
        });

    }
}
