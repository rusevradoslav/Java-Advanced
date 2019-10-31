package arena_EXAM;

import java.util.ArrayList;
import java.util.List;

public class FightingArena {
    private String name;
    private List<Gladiator> gladiators;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator entity) {
        if (!gladiators.contains(entity)) {
            gladiators.add(entity);
        }
    }

    public void remove(String name) {
        gladiators.removeIf(gladiator -> gladiator.getName().equals(name));
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return gladiators.stream().max((f, s) -> Integer.compare(f.getStatPower(), s.getStatPower())).get();

    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return gladiators.stream().max((f, s) -> Integer.compare(f.getWeaponPower(), s.getWeaponPower())).get();

    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return gladiators.stream().max((f, s) -> Integer.compare(f.getTotalPower(), s.getTotalPower())).get();

    }

    public int getCount() {
        return gladiators.size();
    }

    @Override
    public String toString() {


        return String.format("%s – %d gladiators are participating.", this.name, getCount());
    }
}

