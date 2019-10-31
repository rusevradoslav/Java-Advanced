package CompanyRoster_02;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
            String departmentName = tokens[3];

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(tokens[4]));
                } else {
                    employee.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
                departments.get(departmentName).addEmployees(employee);
            } else {
                departments.get(departmentName).addEmployees(employee);
            }
        }

        departments.entrySet().stream().sorted((f, s) ->
                Double.compare(s.getValue().averageSalary(), f.getValue().averageSalary()))
                .limit(1)
                .forEach(entnry -> {
                    System.out.println(String.format("Highest Average Salary: %s", entnry.getKey()));

                    entnry.getValue().getEmployees()
                            .stream()
                            .sorted((f, s) -> Double.compare(s.getSlary(), f.getSlary()))
                            .forEach(e -> {
                                System.out.println(String.format("%s %.2f %s %d", e.getName(), e.getSlary(), e.getEmail(), e.getAge()));

                            });

                });
    }
}

