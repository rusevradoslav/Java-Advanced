package arena_EXAM;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower() {
        return this.stat.getStrength() + this.stat.getFlexibility() + this.stat.getAgility() + this.stat.getSkills() + this.stat.getIntelligence();
    }

    public int getWeaponPower() {
        return this.weapon.getSharpness() + this.weapon.getSize() + this.weapon.getSolidity();
    }

    public int getTotalPower() {
        return this.stat.getStrength()
                + this.stat.getFlexibility()
                + this.stat.getAgility()
                + this.stat.getSkills()
                + this.stat.getIntelligence()
                + this.weapon.getSharpness()
                + this.weapon.getSize()
                + this.weapon.getSolidity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s – %d\n",getName(),getTotalPower()));
        sb.append(String.format("  Weapon Power: %d\n",getWeaponPower()));
        sb.append(String.format("  Stat Power: %d",getStatPower()));



        return sb.toString();
    }
}
