package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	}