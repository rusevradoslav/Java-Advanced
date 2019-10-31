package DEMO_PokeonTrainer_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String trainerName;
    private Map<String, List<Pokemon>> pokemons;
    private int badges;

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
        pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public String getTrainerName() {
        return trainerName;
    }


    public boolean hasElement(String element) {
        return !this.pokemons.get(element).isEmpty();
    }

    public void incrementBdges(int badge) {
        this.badges += badge;
    }

    public void damagePokemon(int damage) {
        for (List<Pokemon> value : pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.damageTake(damage);
            }
        }
        this.clearDeadPokemons();
    }

    private void clearDeadPokemons() {
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(pokemon -> pokemon.getHealth() <= 0);
        }
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getTrainerName(), getBadges(), countPokemons());

    }


    public int countPokemons() {
        int size = 0;
        for (List<Pokemon> pokemonList : pokemons.values()) {
            size += pokemonList.size();
        }
        return size;
    }
}
