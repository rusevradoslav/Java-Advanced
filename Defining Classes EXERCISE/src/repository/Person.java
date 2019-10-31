package repository;

public class Person {

    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s\n", this.name));
        sb.append(String.format("Age: %d\n", this.age));
        sb.append(String.format("Birthday: %s", this.birthDate));
        return sb.toString();
    }
}
