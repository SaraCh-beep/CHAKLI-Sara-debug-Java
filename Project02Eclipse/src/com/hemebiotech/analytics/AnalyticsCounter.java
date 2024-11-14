package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String[] args) {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.processSymptoms();
    }

    /**
     * Process the symptoms from "symptoms.txt" and counts each occurrence.
     */
    public void processSymptoms() {
        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
             FileWriter writer = new FileWriter("result.out")) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Symptom from file: " + line);

                if (line.equals("headache")) {
                    headacheCount++;
                } else if (line.equals("rash")) {
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilCount++;
                }
            }

            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilCount + "\n");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}