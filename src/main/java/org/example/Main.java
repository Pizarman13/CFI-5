package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.GestionInformacion.*;

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

        //Sumatoria Y Listado de Números
        int num = 5;
        int sum = suma(num);
        System.out.println("La suma de los números de 1 a " + num + " es: " + sum);

        int inicio = 1;
        int fin = 5;
        listadoNumeros(inicio, fin);

        //Calculo de Potencias y Maximos
        System.out.println("La potencia de 2 elevado a 3 es: " + potencia(2, 3));

        int[] numeros = {7, 2, 9, 4, 5};
        int maximo = calcularMaximo(numeros, numeros.length);
        System.out.println("El número máximo en el arreglo es: " + maximo);

        //Organizacion de Documentos
        OrganizacionDocumentos organizacionDocumentos = new OrganizacionDocumentos();
        organizacionDocumentos.ordenarDocumentos("Texto.txt");
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

    public static int suma(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + suma(n - 1);
        }
    }

    public static void listadoNumeros(int inicio, int fin) {
        if (inicio == fin) {
            System.out.println(inicio);
        } else {
            System.out.print(inicio + " ");
            listadoNumeros(inicio + 1, fin);
        }

    }

    public static double potencia(double base, int exponente) {
        double res = 1;
        for (int i = 0; i < exponente; i++) {
            res *= base;
        }
        return res;
    }

    public static int calcularMaximo(int[] numeros, int longitiud) {
        if (longitiud == 1) {
            return numeros[0];
        } else {
            int max = calcularMaximo(numeros, longitiud - 1);
            return numeros[longitiud - 1] > max ? numeros[longitiud - 1] : max;
        }
    }

}