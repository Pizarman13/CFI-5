package org.example;


import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Contar genes en un ADN
        String ADN = "ATGATGATGATG";
        int numGenes = contarGenes(ADN);
        System.out.println("El número de genes en el ADN es: " + numGenes);


        //Combinaciones Geneticas
        char[] bases = {'A', 'T', 'C', 'G'};
        int n = 3;
        combinacionesGen(bases, n);

    }

    public static int contarGenes (String ADN) {

        int c = 0;
        int index = ADN.indexOf("ATG");

        if (index == -1) {
            return 0;
        } else {
            c++;
            c += contarGenes(ADN.substring(index + 3));
        }

        return c;
    }

    public static void combinacionesGen(char[] bases, int longitud) {
        List<Character> combinacion = new ArrayList<>();
        calcularCombinaciones(bases, longitud, combinacion);
    }

    public static void calcularCombinaciones(char[] bases, int longitud, List<Character> combinacion) {

        if (combinacion.size() == longitud) {
            for (char gen : combinacion) {
                System.out.print(gen);
            }
            System.out.println();
            return;
        }

        for (char base : bases) {
            combinacion.add(base);
            calcularCombinaciones(bases, longitud, combinacion);
            combinacion.remove(combinacion.size() - 1);
        }
    }

}