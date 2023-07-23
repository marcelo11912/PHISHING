package phishing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Phishing {

    private static final String RUTA = "src/phishing.txt";

    public static void main(String[] args) {
        ProcesarTexto pt = new ProcesarTexto();
        Map<String, Integer> phishingTerms = pt.cargarArchivo(RUTA);

        if (phishingTerms.isEmpty()) {
            System.out.println("No se pudieron cargar los términos de phishing del archivo.");
            return;
        }
        String[] frasesAnalizar = {
            "Necesita un cambio de clave en Amazon",
            "Contraseña: Hemos detectado actividad sospechosa en tu cuenta. Cambia tu contraseña ahora.",
            "Banco: Verifica tu información para evitar el bloqueo de tu cuenta.",
            "Cuenta bloqueada. Cambia tu contraseña ahora.",
            "Alerta de seguridad : Banco Pichincha le informa que necesita cambiar su clave",};

        Map<String, Integer> termOccurrences = new HashMap<>();

        for (String frase : frasesAnalizar) {
            // Convertir la frase a minúsculas para realizar una búsqueda insensible a mayúsculas y minúsculas
            frase = frase.toLowerCase();

            for (String term : phishingTerms.keySet()) {
                if (frase.contains(term)) {
                    int occurrences = termOccurrences.getOrDefault(term, 1);
                    int value = phishingTerms.get(term); // Obtenemos el valor del término desde el archivo de frases
                    termOccurrences.put(term, occurrences * value);

                }
            }
        }

        // Resultados de las apariciones de términos
        System.out.println("Resultados de las apariciones de términos ");
        for (String term : termOccurrences.keySet()) {
            int occurrences = termOccurrences.get(term);
            System.out.println(term + ": " + occurrences);
        }
    }
}
