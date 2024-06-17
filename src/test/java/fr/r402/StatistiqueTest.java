package fr.r402;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StatistiqueTest {

    @Test
    public void testPrixSansRemise() {
        StatistiqueVoiture statistiques = new StatistiqueVoiture();
        statistiques.ajouter(new Voiture("Toyota", 10000));
        statistiques.ajouter(new Voiture("Honda", 20000));
        statistiques.ajouter(new Voiture("BMW", 30000));

        int prixAttendu = 10000 + 20000 + 30000;
        assertEquals(prixAttendu, statistiques.prix(), "Le prix sans remise doit être égal à la somme des prix des voitures.");
    }

    @Test
    public void testPrixAvecRemise() {
        StatistiqueVoiture statistiques = new StatistiqueVoiture();
        for (int i = 0; i < 10; i++) {
            statistiques.ajouter(new Voiture("Toyota", 10000));
        }

        // 10 voitures -> 2 groupes de 5 voitures -> 2*5% = 10% remise
        int prixTotal = 10 * 10000;
        int remiseAttendue = prixTotal * 10 / 100;
        int prixAttendu = prixTotal - remiseAttendue;

        assertEquals(prixAttendu, statistiques.prix(), "Le prix avec remise doit être calculé correctement.");
    }
}