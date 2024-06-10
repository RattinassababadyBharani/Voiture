import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatistiqueImplTest {

    @Test
    public void testPrixSansRemise() {
        StatistiqueImpl statistiques = new StatistiqueImpl();
        statistiques.ajouter(new Voiture("Toyota", 10000));
        statistiques.ajouter(new Voiture("Honda", 20000));
        statistiques.ajouter(new Voiture("BMW", 30000));

        int prixAttendu = 10000 + 20000 + 30000;
        assertEquals(prixAttendu, statistiques.prix(), "Le prix sans remise doit être égal à la somme des prix des voitures.");
    }

    @Test
    public void testPrixAvecRemise() {
        StatistiqueImpl statistiques = new StatistiqueImpl();
        for (int i = 0; i < 10; i++) {
            statistiques.ajouter(new Voiture("Toyota", 10000));
        }

        // 10 voitures -> 2 groupes de 5 voitures -> 2*5% = 10% remise
        int prixTotal = 10 * 10000;
        int remiseAttendue = prixTotal * 10 / 100;
        int prixAttendu = prixTotal - remiseAttendue;

        assertEquals(prixAttendu, statistiques.prix(), "Le prix avec remise doit être calculé correctement.");
    }

    @Test
    public void testPrixListeVide() {
        StatistiqueImpl statistiques = new StatistiqueImpl();

        ArithmeticException thrown = assertThrows(
                ArithmeticException.class,
                statistiques::prix,
                "Une ArithmeticException doit être lancée si la liste des voitures est vide."
        );

        assertEquals("Il n'y a pas de voiture.", thrown.getMessage());
    }

    @Test
    public void testPrixAvecRemiseMaximale() {
        StatistiqueImpl statistiques = new StatistiqueImpl();
        for (int i = 0; i < 100; i++) {
            statistiques.ajouter(new Voiture("Toyota", 10000));
        }

        // 100 voitures -> 20 groupes de 5 voitures -> 20*5% = 100% remise mais limitée à 20000 euros
        int prixTotal = 100 * 10000;
        int remiseMaximale = 20000;
        int prixAttendu = prixTotal - remiseMaximale;

        assertEquals(prixAttendu, statistiques.prix(), "Le prix avec la remise maximale doit être calculé correctement.");
    }

    @Test
    public void testPrixUneSeuleVoiture() {
        StatistiqueImpl statistiques = new StatistiqueImpl();
        statistiques.ajouter(new Voiture("Toyota", 15000));

        int prixAttendu = 15000;
        assertEquals(prixAttendu, statistiques.prix(), "Le prix pour une seule voiture doit être égal au prix de cette voiture.");
    }
    @Test
    public void testAjouterVoitureNull() {
        StatistiqueImpl statistiques = new StatistiqueImpl();

        // Initialement, la liste de voitures doit être vide
        assertEquals(0, statistiques.getVoitureCount(), "La liste de voitures doit être vide au départ.");

        // Essayer d'ajouter une voiture null
        statistiques.ajouter(null);

        // La liste de voitures doit toujours être vide
        assertEquals(0, statistiques.getVoitureCount(), "La liste de voitures doit rester vide après avoir tenté d'ajouter une voiture null.");
    }

}
