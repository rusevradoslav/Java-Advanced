package heroRepositoryExam;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s – %d\n",this.getName(),this.getLevel()));
        sb.append(String.format("  *  Strength: %d\n",item.getStrength()));
        sb.append(String.format("  *  Agility: %d\n",item.getAgility()));
        sb.append(String.format("  *  Intelligence: %d",item.getIntelligence()));


        return sb.toString();
    }
}
