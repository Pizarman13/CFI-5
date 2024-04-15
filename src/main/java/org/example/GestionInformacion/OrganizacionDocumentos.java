package org.example.GestionInformacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OrganizacionDocumentos {

    public void ordenarDocumentos(String ruta) {

        ArrayList<String> documentos = new ArrayList<>();

        try {

            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                documentos.add(linea);
            }
            br.close();

            Collections.sort(documentos);

            System.out.println("Contenido Ordenado:");
            for (String documento : documentos) {
                System.out.println(documento);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
