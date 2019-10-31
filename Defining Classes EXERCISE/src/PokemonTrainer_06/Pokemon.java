package PokemonTrainer_06;

public class Pokemon {
    private String name;
    private String Element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        Element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return Element;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
