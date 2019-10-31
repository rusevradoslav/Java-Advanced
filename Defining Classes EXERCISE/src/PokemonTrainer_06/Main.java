package PokemonTrainer_06;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String name = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);


            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(name, element, health);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);
            line = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String element = input;

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)) {
                    trainer.incrementBadges(1);
                } else {
                    trainer.damagePokemones(10);

                }
            }
            input = scanner.nextLine();
        }

        trainers.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue().getBadges(), f.getValue().getBadges())).forEach(entry -> {
            System.out.println(entry.getValue().toString());
            // System.out.println(String.format("%s %d %d", entry.getValue().getTrainerName(), entry.getValue().getBadges(), entry.getValue().countPokemons()));
        });


    }


}

