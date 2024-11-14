package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Classe principale pour orchestrer l'exécution des étapes de l'application.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Créer les objets nécessaires
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("results.out");
            AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

            // Récupérer les symptômes depuis le fichier
            Map<String, Integer> symptomCounts = counter.countSymptoms(counter.getSymptoms());

            // Trier les symptômes par ordre alphabétique
            Map<String, Integer> sortedSymptomCounts = counter.sortSymptoms(symptomCounts);

            // Écrire les résultats dans un fichier
            counter.writeSymptoms(sortedSymptomCounts);

            System.out.println("Traitement terminé avec succès. Les résultats ont été écrits dans 'results.out'.");

        } catch (IOException e) {
            System.err.println("Une erreur s'est produite pendant l'exécution : " + e.getMessage());
        }
    }
}