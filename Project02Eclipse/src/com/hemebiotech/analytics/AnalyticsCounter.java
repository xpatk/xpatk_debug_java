package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A program that reads symptoms from a given file and counts the occurrence of the symptoms
 */

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		try (BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"))) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
			System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}
		}} catch (IOException e) {
			System.err.println("Error reading the file");
		}

		try (FileWriter writer = new FileWriter ("result.out")) {
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
		} catch (IOException e) {
			System.err.println("Cannot write in the file.");
		}
	}
}
