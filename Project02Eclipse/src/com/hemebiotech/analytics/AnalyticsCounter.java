package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The main class that reads symptoms from a given file and counts the occurrence of the symptoms
 */

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	/**
	 * Constructor for AnalyticsCounter
	 *
	 * @param reader The symptom reader implementation
	 * @param writer The symptom writer implementation
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Gets the list of symptoms from the input source
	 *
	 * @return List of symptoms
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Counts symptoms
	 *
	 * @param symptoms List of symptoms to count
	 * @return Map of symptoms and their occurrence
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}


	/**
	 * Sorts the symptoms alphabetically
	 *
	 * @param symptoms Map of symptoms and their counts to sort
	 * @return Sorted map of symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>();
		sortedSymptoms.putAll(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Writes the symptoms and their counts to the output destination
	 *
	 * @param symptoms Map of symptoms and their counts to write
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	public static void main(String[] args) {
		try {
			ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");

			AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);

			List<String> symptoms = counter.getSymptoms();
			Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);
			Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);
			counter.writeSymptoms(sortedSymptoms);

		} catch (Exception e) {
			System.err.println("An error occurred while processing files: " + e.getMessage());
			e.printStackTrace();
		}
	}
}