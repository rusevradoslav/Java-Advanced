package FamilyTree_08;

public class Person {
    String name = "n/a";
    String birthday = "n/a";

    public Person(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString(){
        return this.name + " " + this.birthday;
    }
}