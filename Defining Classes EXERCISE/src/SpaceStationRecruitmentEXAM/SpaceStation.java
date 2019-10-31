package SpaceStationRecruitmentEXAM;


import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> data;


    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public void add(Astronaut astronaut) {
        data.add(astronaut);
        if (data.size() > capacity) {
            data.remove(data.size() - 1);
        }
    }

    public boolean remove(String name) {

        Astronaut astronaut = null;
        for (Astronaut person : this.data) {
            if (person.getName().equals(name)){
                astronaut = person;
                break;
            }
        }
        if (astronaut != null) {
            this.data.remove(astronaut);
            return true;
        } else {
            return false;
        }

    }

    public Astronaut getOldestAstronaut() {
        return data.stream().max((f, s) -> Integer.compare(f.getAge(), s.getAge())).get();
    }

    public Astronaut getAstronaut(String name) {
        Astronaut givenName = null;
        for (Astronaut astronaut : this.data) {
            if (astronaut.getName().equals(name)) {
                givenName = astronaut;
            }
        }
        return givenName;
    }


 // public String report() {
 //     StringBuilder sb = new StringBuilder();
 //     sb.append(String.format("Astronauts working at Space Station %s:\n", this.name));
 //     int counter = 0;
 //     for (Astronaut astronaut : data) {
 //         if (counter == data.size() - 1) {
 //             sb.append(String.format("Astronaut: %s, %d (%s)", astronaut.getName(), astronaut.getAge(), astronaut.getCountry()));
 //         } else {
 //             sb.append(String.format("Astronaut: %s, %d (%s)\n", astronaut.getName(), astronaut.getAge(), astronaut.getCountry()));
 //         }
 //     }
 //     return sb.toString().trim();
 // }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Astronauts working at Space Station ").append(name).append(":");
        for(Astronaut a: data){
            sb.append(System.lineSeparator()).append(a.toString());
        }
        return sb.toString().trim();
    }
}

