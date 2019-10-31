package heroRepositoryExam;

public class Item {
   private int strength;
   private int agility;
   private int intelligence;


    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item:\n");
        sb.append(String.format("  *  Strength: %d\n",this.getStrength()));
        sb.append(String.format("  *  Agility: %d\n",this.getAgility()));
        sb.append(String.format("  *  Intelligence: %d",this.getIntelligence()));


        return sb.toString();
    }
}
