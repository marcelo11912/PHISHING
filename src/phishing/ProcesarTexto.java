/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phishing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AMAG
 */
public class ProcesarTexto {

    public Map<String, Integer> cargarArchivo(String ruta ) {
        Map<String, Integer> phishingTerms = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String term = parts[0].trim();
                    int probability = Integer.parseInt(parts[1].trim());
                    phishingTerms.put(term.toLowerCase(), probability);
                }
            }

            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar los términos de phishing: " + e.getMessage());
        }

        return phishingTerms;
    }
}
