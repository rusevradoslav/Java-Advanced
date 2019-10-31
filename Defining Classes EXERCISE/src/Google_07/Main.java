package Google_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Person> map = new LinkedHashMap<>();

        while(true){
            String[] input = br.readLine().split("\\s+");
            if(input[0].equals("End")){
                break;
            }
            Person person;
            if(!map.containsKey(input[0])){
                person = new Person(input[0]);
                map.put(input[0], person);
            } else{
                person = map.get(input[0]);
            }

            switch(input[1]){
                case "pokemon":
                    Pokemon pokemon = new Pokemon(input[2], input[3]);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(input[2], input[3]);
                    person.addParent(parent);
                    break;
                case "car":
                    Car car = new Car(input[2], input[3]);
                    person.setCar(car);
                    break;
                case "company":
                    Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                    person.setCompany(company);
                    break;
                case "children":
                    Child child = new Child(input[2], input[3]);
                    person.addChild(child);
                    break;
            }

        }

        String input = br.readLine();
        Person person = map.get(input);
        System.out.println(person);
    }
}

