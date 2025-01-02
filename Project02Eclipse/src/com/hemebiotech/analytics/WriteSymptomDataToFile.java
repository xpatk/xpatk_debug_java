package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de ISymptomWriter pour écrire les symptômes dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String outputFilePath;

    /**
     * Constructeur qui prend le chemin du fichier de sortie.
     *
     * @param outputFilePath Chemin du fichier où les données seront écrites.
     */
    public WriteSymptomDataToFile(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + outputFilePath);
            e.printStackTrace();
        }
    }
}
