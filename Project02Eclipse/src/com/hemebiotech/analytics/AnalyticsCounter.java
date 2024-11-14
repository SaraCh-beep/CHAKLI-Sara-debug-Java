import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    public static void main(String[] args) {
        Map<String, Integer> symptomCounts = new TreeMap<>();

        // Lecture du fichier
        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
            String line = reader.readLine();
            
            while (line != null) {
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1); // ajout de comm pour le compte
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier symptoms.txt: " + e.getMessage());
        }

        // Écriture des résultats dans le fichier de sortie
        try (FileWriter writer = new FileWriter("result.out")) {
            for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) { // ??? List ?? entry set ? , comment ça marche
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n"); 
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier result.out: " + e.getMessage());
        }
    }
}
