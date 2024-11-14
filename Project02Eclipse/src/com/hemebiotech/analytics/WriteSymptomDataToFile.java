package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de ISymptomWriter pour écrire les symptômes et leurs occurrences dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String outputFilePath;

    /**
     * Constructeur qui prend le chemin du fichier de sortie.
     * 
     * @param outputFilePath le chemin du fichier où les symptômes seront écrits
     */
    public WriteSymptomDataToFile(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    /**
     * Écrit les symptômes et leurs occurrences dans le fichier de sortie.
     * 
     * @param symptoms une map contenant les noms des symptômes et leur nombre d'occurrences
     * @throws IOException si une erreur se produit lors de l'écriture
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}