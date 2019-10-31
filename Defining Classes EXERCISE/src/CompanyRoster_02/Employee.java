package CompanyRoster_02;

public class Employee {
    private String name;
    private double slary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double slary, String position) {
        this.name = name;
        this.slary = slary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSlary() {
        return this.slary;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }
}
