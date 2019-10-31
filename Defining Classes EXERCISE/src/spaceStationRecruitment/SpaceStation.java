package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.LinkedList;
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
        if (this.capacity != 0) {
            this.data.add(astronaut);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(astronaut -> astronaut.getName().equals(name));
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
      //  Astronaut givenName =this.data.stream().filter(astronaut -> astronaut.getName().equals(name)).findFirst().orElse(null);
        return givenName;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:%n", this.name));
        for (Astronaut astronaut : data) {
            sb.append(astronaut.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
