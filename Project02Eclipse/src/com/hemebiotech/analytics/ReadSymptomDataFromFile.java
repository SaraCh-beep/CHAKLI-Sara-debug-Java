package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de ISymptomReader pour lire les symptômes depuis un fichier.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
    private String inputFilePath;

    /**
     * Constructeur prenant le chemin du fichier d'entrée.
     * 
     * @param inputFilePath le chemin du fichier contenant les symptômes
     */
    public ReadSymptomDataFromFile(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    /**
     * Lit les symptômes depuis le fichier et les renvoie sous forme de liste.
     * 
     * @return une liste de symptômes lus depuis le fichier
     * @throws IOException si une erreur se produit lors de la lecture du fichier
     */
    @Override
    public List<String> getSymptoms() throws IOException {
        List<String> symptoms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.add(line);
            }
        }
        return symptoms;
    }
}