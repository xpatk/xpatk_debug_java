package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The main class that reads symptoms from a given file and counts the occurrence of the symptoms
 */

public class AnalyticsCounter {

	public static void main(String[] args) {

		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = symptomReader.GetSymptoms();

		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
		symptomWriter.writeSymptoms(symptomCounts);

	}
}
