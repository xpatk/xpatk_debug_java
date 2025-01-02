package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The main class that reads symptoms from a given file and counts the occurrence of the symptoms
 */

public class AnalyticsCounter {
	
	public static void main(String[] args) {

		}} catch (IOException e) {
			System.err.println("Error reading the file");
		}

		try (FileWriter writer = new FileWriter ("result.out")) {

		} catch (IOException e) {
			System.err.println("Cannot write in the file.");
		}
	}
}
