package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe AnalyticsCounter permet de lire des symptômes à partir d'un fichier, 
 * de compter leurs occurrences, de les trier, et d'écrire les résultats dans un fichier de sortie.
 */
public class AnalyticsCounter {

    private String inputFilePath;
    private String outputFilePath;

    /**
     * Constructeur pour initialiser les chemins des fichiers d'entrée et de sortie.
     *
     * @param inputFilePath le chemin vers le fichier contenant la liste des symptômes
     * @param outputFilePath le chemin vers le fichier de sortie où les résultats seront enregistrés
     */
    public AnalyticsCounter(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    /**
     * Méthode principale pour exécuter toutes les étapes de traitement des symptômes.
     *
     * @param args arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter("symptoms.txt", "result.out");
        
        // 1. Lire les symptômes
        Map<String, Integer> symptoms = analyticsCounter.getSymptoms();

        // 2. Compter les occurrences de chaque symptôme
        symptoms = analyticsCounter.countSymptoms(symptoms);

        // 3. Trier les symptômes (automatique avec TreeMap)
        symptoms = analyticsCounter.sortSymptoms(symptoms);

        // 4. Écrire les résultats dans un fichier
        analyticsCounter.writeSymptoms(symptoms);
    }

    /**
     * Lit les symptômes à partir du fichier d'entrée.
     *
     * @return une map initiale contenant les symptômes non comptés (chaque symptôme présent une fois)
     */
    public Map<String, Integer> getSymptoms() {
        Map<String, Integer> symptoms = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.put(line, 0);  // Initialise chaque symptôme avec une occurrence de 0
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier de symptômes : " + e.getMessage());
        }
        return symptoms;
    }

    /**
     * Compte les occurrences de chaque symptôme.
     *
     * @param symptoms la map des symptômes avec des occurrences initialisées
     * @return la map avec le comptage mis à jour pour chaque symptôme
     */
    public Map<String, Integer> countSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> symptomCounts = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du comptage des symptômes : " + e.getMessage());
        }
        return symptomCounts;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     * (TreeMap est automatiquement triée par clé donc pas besoin de modification)
     *
     * @param symptoms la map des symptômes avec leurs occurrences
     * @return une map triée contenant les symptômes et leurs occurrences
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms); // Retourne une TreeMap, qui est triée par défaut
    }

    /**
     * Écrit les symptômes et leurs occurrences dans le fichier de sortie.
     *
     * @param symptoms la map des symptômes et leurs occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        ISymptomWriter writer = new WriteSymptomDataToFile(outputFilePath);
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des symptômes dans le fichier : " + e.getMessage());
        }
    }
}