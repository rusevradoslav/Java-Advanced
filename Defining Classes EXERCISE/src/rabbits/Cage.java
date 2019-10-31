package rabbits;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return capacity;
    }


    public void add(Rabbit rabbit) {
        this.data.add(rabbit);
        if (this.data.size() > capacity) {
            this.data.remove(data.size() - 1);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getSpecies().equals(name));

    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(species1 -> species1.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit givenName = null;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                if (rabbit.isAvailable()) {
                    rabbit.setAvailable(false);
                    givenName = rabbit;
                }
            }
        }
        return givenName;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitsAsList = new ArrayList<>();

        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbitsAsList.add(rabbit);
            }
        }
        return rabbitsAsList;
    }



    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", this.name));
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable() == true) {
                sb.append(rabbit.toString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public int count() {
        return data.size();
    }
}
