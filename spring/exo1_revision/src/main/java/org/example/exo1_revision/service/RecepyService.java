package org.example.exo1_revision.service;

import org.example.exo1_revision.model.Recepy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecepyService implements RecepyInterface<Recepy> {

    private final Map<UUID, Recepy> recepies;

    public RecepyService() {
        this.recepies = new HashMap<>();
        Recepy recepy = Recepy.builder()
                .id(UUID.randomUUID())
                .name("Spaghetti Bolognese")
                .ingredients(List.of("spaghetti", "ground beef", "tomato sauce", "onion", "garlic", "olive oil"))
                .difficulty("Medium")
                .prepTime(20)
                .build();

        Recepy recepy2 = Recepy.builder()
                .id(UUID.randomUUID())
                .name("Salade César")
                .ingredients(List.of("laitue romaine", "poulet grillé", "croûtons", "parmesan", "sauce César"))
                .difficulty("Facile")
                .prepTime(15)
                .build();

        Recepy recepy3 = Recepy.builder()
                .id(UUID.randomUUID())
                .name("Pizza Margherita")
                .ingredients(List.of("pâte à pizza", "sauce tomate", "mozzarella", "basilic frais", "huile d'olive"))
                .difficulty("Moyenne")
                .prepTime(30)
                .build();

        this.recepies.put(recepy.getId(),recepy);
        this.recepies.put(recepy2.getId(),recepy2);
        this.recepies.put(recepy3.getId(),recepy3);



    }

    public List<Recepy> getAll() {
        return recepies.values().stream().toList();
    }

    @Override
    public Recepy getById(UUID id) {
        return recepies.values().stream().filter(recepy -> recepy.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public boolean add(Recepy recepy, String[] ingredientsArray) {

        recepy.setId(UUID.randomUUID());
        recepy.setIngredients(Arrays.asList(ingredientsArray));
        recepies.put(recepy.getId(), recepy);
        return true;
    }


    @Override
    public List<Recepy> searchByTitle(String title) {
        return recepies.values().stream()
                .filter(recepy -> recepy.getName().toLowerCase().contains(title.toLowerCase()) || recepy.getIngredients().stream().anyMatch(ingredient -> ingredient.contains(title)))
                .toList();


    }


}
