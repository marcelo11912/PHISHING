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
        System.out.println(phishingTerms);

    }
}
