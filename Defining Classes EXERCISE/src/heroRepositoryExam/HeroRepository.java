package heroRepositoryExam;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;


    public HeroRepository() {
        this.data = new ArrayList<>();
    }


    public void add(Hero hero) {
        if (!data.contains(hero)) {
            data.add(hero);
        }
    }

    public void remove(String name) {
        data.removeIf(entry -> entry.getName().equals(name));
    }

    public Hero getHeroWithHighestStrength() {
        return data.stream().max((f, s) -> Integer.compare(f.getItem().getStrength(), s.getItem().getStrength())).get();
    }

    public Hero getHeroWithHighestAgility() {
        return data.stream().max((f, s) -> Integer.compare(f.getItem().getAgility(), s.getItem().getAgility())).get();
    }

    public Hero getHeroWithHighestIntelligence() {
        return data.stream().max((f, s) -> Integer.compare(f.getItem().getIntelligence(), s.getItem().getIntelligence())).get();
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : data) {
            sb.append(hero + "\n");
        }

        return sb.toString();
    }
}
