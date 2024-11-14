package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe qui gère le comptage des symptômes.
 */
public class AnalyticsCounter {
    private ISymptomReader symptomReader;
    private ISymptomWriter symptomWriter;

    /**
     * Constructeur pour initialiser le lecteur et l'écrivain de symptômes.
     * 
     * @param symptomReader l'objet pour lire les symptômes
     * @param symptomWriter l'objet pour écrire les résultats des symptômes
     */
    public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
        this.symptomReader = symptomReader;
        this.symptomWriter = symptomWriter;
    }

    /**
     * Récupère les symptômes depuis la source de données.
     * 
     * @return une liste de symptômes
     * @throws IOException si une erreur se produit lors de la lecture
     */
    public List<String> getSymptoms() throws IOException {
        return symptomReader.getSymptoms();
    }

    /**
     * Compte les occurrences de chaque symptôme.
     * 
     * @param symptoms la liste des symptômes à traiter
     * @return une map des symptômes et de leurs occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     * 
     * @param symptomCounts la map des symptômes à trier
     * @return une map triée des symptômes
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts) {
        return new TreeMap<>(symptomCounts);
    }

    /**
     * Écrit les symptômes comptabilisés dans un fichier de sortie.
     * 
     * @param symptomCounts la map des symptômes et leurs occurrences
     * @throws IOException si une erreur se produit lors de l'écriture dans le fichier
     */
    public void writeSymptoms(Map<String, Integer> symptomCounts) throws IOException {
        symptomWriter.writeSymptoms(symptomCounts);
    }
}