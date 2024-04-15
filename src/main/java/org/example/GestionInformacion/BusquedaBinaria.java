package org.example.GestionInformacion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BusquedaBinaria {

    private List<String> palabras;

    public BusquedaBinaria(String ruta) {

        try {
            String texto = new String(Files.readAllBytes(Paths.get(ruta)));
            palabras = Arrays.asList(texto.split("\\s+"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean busquedaBinaria(String palabra) {

        int inicio = 0;
        int fin = palabras.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = palabra.compareTo(palabras.get(medio));

            if (comparacion == 0) {
                return true;
            } else if (comparacion < 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return false;
    }
}
