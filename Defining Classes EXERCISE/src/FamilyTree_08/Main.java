package FamilyTree_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static Person person = new Person();
    public static ArrayList<Person> people = new ArrayList<Person>();
    public static LinkedHashMap<String, Person> mapNames = new LinkedHashMap<>();
    public static LinkedHashMap<String, Person> mapBirthdays = new LinkedHashMap<>();
    public static ArrayList<Person> parents = new ArrayList<>();
    public static ArrayList<Person> children = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.contains("/")) {
            person.setBirthday(input);
        } else {
            person.setName(input);
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            String toAppend = br.readLine();
            sb.append(toAppend).append("\n");
            if (toAppend.equals("End")) {
                break;
            }
        }
        findPerson(sb.toString().split("\\n"));
        findPeople(sb.toString().split("\\n"));
        doLogic(sb.toString().split("\\n"));

        System.out.println(person);
        System.out.println("Parents:");
        for (Person p : parents){
            System.out.println(p);
        }
        System.out.println("Children:");
        for (Person p : children){
            System.out.println(p);
        }

    }




    public static void findPeople (String[]array){
        for (String line : array) {
            if (!line.contains("-") && !line.equals("End")) {
                String[] p = line.split(" ");
                Person personNew = new Person();
                personNew.setName(p[0] + " " + p[1]);
                personNew.setBirthday(p[2]);
                people.add(personNew);
                mapNames.put(personNew.getName(), personNew);
                mapBirthdays.put(personNew.birthday, personNew);
            }
        }
    }


    public static void findPerson (String[]array){
        for (String line : array) {
            if (line.contains(person.getName()) && !line.contains("-") || line.contains(person.getBirthday()) && !line.contains("-")) {
                String[] p = line.split(" ");
                person.setName(p[0] + " " + p[1]);
                person.setBirthday(p[2]);
                return;
            }
        }
    }


    public static int getForm (String input){
        if (!input.contains("-")) {
            return 5;
        }
        String[] split = input.split(" - ");
        if (split[0].contains("/") && split[1].contains("/")) {
            return 4;
        } else if (split[0].contains("/") && !split[1].contains("/")) {
            return 3;
        } else if (!split[0].contains("/") && split[1].contains("/")) {
            return 2;
        }
        return 1;


    }
    public static void doLogic(String[] array) {
        for(String input: array) {
            if (!input.contains("-")) {
                continue;
            }
            String[] split = input.split(" - ");
            if (split[0].contains("/") && split[1].contains("/")) {
                Person parent = mapBirthdays.get(split[0]);
                Person child = mapBirthdays.get(split[1]);
                if(child.name.equals(person.name)) {
                    parents.add(parent);
                }
                if(parent.name.equals(person.name)) {
                    children.add(child);
                }
            } else if (split[0].contains("/") && !split[1].contains("/")) {
                Person parent = mapBirthdays.get(split[0]);
                Person child = mapNames.get(split[1]);
                if(child.name.equals(person.name)) {
                    parents.add(parent);
                }
                if(parent.name.equals(person.name)) {
                    children.add(child);
                }
            } else if (!split[0].contains("/") && split[1].contains("/")) {
                Person parent = mapNames.get(split[0]);
                Person child = mapBirthdays.get(split[1]);
                if(child.name.equals(person.name)) {
                    parents.add(parent);
                }
                if(parent.name.equals(person.name)) {
                    children.add(child);
                }
            }
            else{
                Person parent = mapNames.get(split[0]);
                Person child = mapNames.get(split[1]);
                if(child.name.equals(person.name)) {
                    parents.add(parent);
                }
                if(parent.name.equals(person.name)) {
                    children.add(child);
                }
            }

        }
    }
}

