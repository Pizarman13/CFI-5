package org.example.GestionInformacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusquedaLineal {

    public List<String> palabras;

    public BusquedaLineal(String ruta) {

        try {
            String texto = new String(Files.readAllBytes(Paths.get(ruta)));
            palabras = Arrays.asList(texto.split("\\s+"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean busquedaLineal(String palabra) {

        for (String p : palabras) {
            if (p.equals(palabra)) {
                return true;
            }
        }

        return false;
    }
}
