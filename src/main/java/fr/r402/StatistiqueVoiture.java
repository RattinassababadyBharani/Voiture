package fr.r402;

import java.util.ArrayList;
import java.util.List;

public class StatistiqueVoiture implements Statistique {

    private List<Voiture> voitures;

    public StatistiqueVoiture() {
        this.voitures = new ArrayList<>();
    }

    @Override
    public void ajouter(Voiture voiture) {
        if (voiture != null) {
            voitures.add(voiture);
        }
    }

    @Override
    public int prix() throws ArithmeticException {
        if (voitures.isEmpty()) {
            throw new ArithmeticException("Il n'y a pas de voiture.");
        }

        int prixTotal = 0;
        int nombreVoitures = voitures.size();

        for (Voiture voiture : voitures) {
            prixTotal += voiture.getPrix();
        }

        // Calcul des remises
        int remises = (nombreVoitures / 5) * 5; // 5% de remise supplémentaire pour chaque groupe de 5 voitures
        int remiseMax = 20000; // Remise maximale de 20000 euros

        int montantRemise = (prixTotal * remises) / 100;
        if (montantRemise > remiseMax) {
            montantRemise = remiseMax;
        }

        return prixTotal - montantRemise;
    }
}