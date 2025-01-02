package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Interface to implement to help write down the symptoms in a file.
 *
 */

public interface ISymptomWriter {
    /**
     *
     *
     * @param symptoms
     */

    void writeSymptoms(Map<String, Integer> symptoms);
}
