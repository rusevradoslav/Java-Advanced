package CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employees;


    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double averageSalary() {
        return this.employees.stream().mapToDouble(e -> e.getSlary()).average().getAsDouble();
    }
}
