package PokemonTrainer_06;

import java.util.*;

public class Trainer {
    private String trainerName;
    private Map<String, List<Pokemon>> pokemons;
    private int badges;

    public int getBadges() {
        return badges;
    }

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.setPokemons();
        this.badges = 0;

    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }


    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }


    public boolean hasElementType(String element) {
        return !this.pokemons.get(element).isEmpty();
    }

    public void incrementBadges(int badge) {
        this.badges += badge;
    }

    public void damagePokemones(int damage) {
        for (List<Pokemon> value : pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.takeDamage(damage);
            }
        }
        this.clearDeadPokemons();
    }

    private void clearDeadPokemons() {
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int getPokemosCount() {
        int size = 0;
        for (List<Pokemon> value : pokemons.values()) {
            size += value.size();

        }
        return size;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.trainerName, this.badges, this.getPokemosCount());
    }
}
