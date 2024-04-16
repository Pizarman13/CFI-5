package org.example;


import java.text.SimpleDateFormat;
import java.util.*;

import org.example.GestionInformacion.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Date> fechas = new ArrayList<>();


        //Menu del menu
        while (true) {
            System.out.println("\n1. Contar genes en un ADN");
            System.out.println("2. Combinaciones Geneticas");
            System.out.println("3. Sumatoria y Listado de Números");
            System.out.println("4. Calculo de Potencias y Maximos");
            System.out.println("5. Organizacion de Documentos");
            System.out.println("6. Busqueda Lineal");
            System.out.println("7. Busqueda Binaria");
            System.out.println("8. Gestion de Fechas");
            System.out.println("9. QuickSort");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String opc = sc.nextLine();

            switch (opc) {
                case "1":
                    String ADN = "ATGATGATGATG";
                    System.out.print("En la secuencia de ADN: " + ADN);
                    int genes = contarGenes(ADN);
                    System.out.println();
                    System.out.println("El número de genes en el ADN es: " + genes);
                    break;
                case "2":
                    char[] bases = {'A', 'T', 'C', 'G'};
                    int longitud = 3;
                    combinacionesGen(bases, longitud);
                    break;
                case "3":
                    int num = 5;
                    int sum = suma(num);
                    System.out.println("La suma de los números de 1 a " + num + " es: " + sum);

                    int inicio = 1;
                    int fin = 5;
                    listadoNumeros(inicio, fin);
                    break;
                case "4":
                    System.out.println("La potencia de 2 elevado a 3 es: " + potencia(2, 3));

                    int[] numeros = {7, 2, 9, 4, 5};
                    System.out.println("Array original:");
                    for (int i : numeros) {
                        System.out.print(i + " ");
                    }
                    System.out.println();

                    int maximo = calcularMaximo(numeros, numeros.length);
                    System.out.println("El número máximo del array es: " + maximo);
                    break;
                case "5":
                    OrganizacionDocumentos organizacionDocumentos = new OrganizacionDocumentos();
                    organizacionDocumentos.ordenarDocumentos("Texto.txt");
                    break;
                case "6":
                    BusquedaLineal busquedaLineal = new BusquedaLineal("Texto.txt");
                    boolean encontrado = busquedaLineal.busquedaLineal("Gormiti");
                    System.out.println("La palabra fue encontrada con el metodo Lineal: " + encontrado);
                    break;
                case "7":
                    BusquedaBinaria busquedaBinaria = new BusquedaBinaria("Texto.txt");
                    boolean encontradoBinario = busquedaBinaria.busquedaBinaria("Mandarina");
                    System.out.println("La palabra fue encontrada con el metodo Binaro: " + encontradoBinario);
                    break;
                case "8":

                    boolean n = true;

                    while (n) {
                        System.out.println("\n1. Ingresar fecha");
                        System.out.println("2. Listar fechas");
                        System.out.println("3. Salir");
                        System.out.print("Seleccione una opción: ");
                        String opcion = sc.nextLine();

                        switch (opcion) {
                            case "1":
                                System.out.print("Ingrese una fecha en formato dd/MM/yyyy: ");
                                String fechaStr = sc.nextLine();
                                try {
                                    Date fecha = dateFormat.parse(fechaStr);
                                    fechas.add(fecha);
                                    Collections.sort(fechas);
                                } catch (Exception e) {
                                    System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato dd/MM/yyyy.");
                                }
                                break;
                            case "2":
                                System.out.println("\nFechas ingresadas:");
                                for (Date fecha : fechas) {
                                    System.out.println(dateFormat.format(fecha));
                                }
                                break;
                            case "3":
                                n = false;
                                System.out.println("Ha salido de Gestion de Fechas.");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                    }
                case "9":
                    int[] array = {10, 5, 2, 3, 9, 1, 8, 7, 6, 4};
                    System.out.println("Array original:");
                    for (int i : array) {
                        System.out.print(i + " ");
                    }
                    System.out.println();

                    quickSort(array, 0, array.length - 1);

                    System.out.println("Array ordenado por QuickSort:");
                    for (int i : array) {
                        System.out.print(i + " ");
                    }
                    break;
                case "0":
                    System.out.println("Ha salido del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }
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

    public static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = partition(array, inicio, fin);

            quickSort(array, inicio, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, fin);
        }
    }

    private static int partition(int[] array, int inicio, int fin) {
        int pivot = array[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;

        return i + 1;
    }

}