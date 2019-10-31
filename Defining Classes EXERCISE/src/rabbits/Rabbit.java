package rabbits;

import java.util.List;

public class Rabbit {
    private String name;
    private String species;
    private boolean available = true;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }


    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Rabbit (%s): %s", this.species, this.name));
        return sb.toString().trim();
    }


}
