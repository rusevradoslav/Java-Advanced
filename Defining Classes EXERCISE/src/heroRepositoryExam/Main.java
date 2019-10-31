package heroRepositoryExam;

public class Main {

    public static void main(String[] args) {

        HeroRepository repository = new HeroRepository();
        Item item = new Item(23, 35, 48);
        Hero hero = new Hero("Hero Name", 24, item);

        repository.add(hero);
        repository.remove("Hero Name");


        Item secondItem = new Item(100, 20, 13);
        Hero secondHero = new Hero("Second Hero Name", 125, secondItem);
        repository.add(hero);
        repository.add(secondHero);

        Hero heroStrength = repository.getHeroWithHighestStrength();
        Hero heroAbility = repository.getHeroWithHighestAgility();
        Hero heroIntelligence = repository.getHeroWithHighestIntelligence();


        System.out.println(repository);

    }
}
