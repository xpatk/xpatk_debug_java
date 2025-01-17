package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main application class for symptom analysis
 */

public class Main {

    /**
     * Main method that runs the symptom analysis
     */

    public static void main(String[] args) {
        try {
            // Create instances of the reader and writer
            ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
            ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");

            // Create the analytics counter
            AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);

            // Executes the analysis
            List<String> symptoms = counter.getSymptoms();
            Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);
            Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);
            counter.writeSymptoms(sortedSymptoms);

            System.out.println("Symptom analysis completed successfully.");

        } catch (Exception e) {
            System.err.println("An error occurred while processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
