package Ordenamiento;

import java.util.Scanner;

import static Ordenamiento.GenerarDatos.*;
import static Ordenamiento.MetodosDeOrdenamiento.*;

/**
 * Created by Javier Sánchez on 20/11/2016.
 **/
public class SortTest {
    public static void main(String[] args) {
        //Declaración de variables.
        boolean pruebaAutomatica = false;
        int longitudDeLosDatos;
        int porcentajeDeOrdenamiento;
        int metodoActualEnLaPruebaAutomatica = 1;
        int metodoDeOrdenamiento = 0;
        String mensajeBubbleSort;
        String mensajeShellSort;
        String mensajeBubbleSortWithSignal;
        String mensajeSelectionSort;
        String mensajeShakerSort;
        //Variables donde se almacenará el conjunto de valores que será
        //probado con los diversos métodos de ordenamiento.
        int[] datosBestCase, datosWorstCase, datosMixedCase, datosRandomCase;
        //Creación de objetos.
        Scanner entrada = new Scanner(System.in);
        System.out.println("SortTest.");
        //Mostrando información sobre la dinámica de resolución.
        System.out.println("Los métodos de ordenamiento serán probados en los siguientes casos: ");
        System.out.println("1. El mejor caso de ordenamiento.");
        System.out.println("2. El peor caso de ordenamiento.");
        System.out.println("3. Un caso aleatorio de ordenamiento.");
        System.out.println("4. Un caso mixto de ordenamiento.");
        //Pidiendo la cantidad de datos que se desea ordenar.
        System.out.print("¿Qué longitud desea que tengan los datos?");
        longitudDeLosDatos = entrada.nextInt();
        //Pidiendo datos necesarios para probar los métodos.
        System.out.println("Para el caso mixto necesitaré el porcentaje de ordenamiento.");
        System.out.print("Inserta dicho porcentaje: ");
        porcentajeDeOrdenamiento = entrada.nextInt();
        //Generando los datos.
        System.out.println("Generando los datos...");
        long startGenerate = System.currentTimeMillis();
        datosBestCase = new int[longitudDeLosDatos];
        bestCase(datosBestCase);
        datosWorstCase = new int[longitudDeLosDatos];
        worstCase(datosWorstCase);
        datosMixedCase = new int[longitudDeLosDatos];
        do {
            try {
                mixedCase(datosMixedCase, porcentajeDeOrdenamiento);
            } catch (Exception e) {
                porcentajeDeOrdenamiento = (int) (Math.random() * 98 + 1);
            }
        } while (porcentajeDeOrdenamiento < 0 || porcentajeDeOrdenamiento > 100);
        datosRandomCase = new int[longitudDeLosDatos];
        randomCase(datosRandomCase);
        long endGenerate = System.currentTimeMillis();
        System.out.println("Completado en " + (endGenerate - startGenerate) + " milisegundos.");
        do {
            //Probar los métodos de ordenamiento.
            if (!pruebaAutomatica) {
                if (metodoDeOrdenamiento == 6) {
                    pruebaAutomatica = true;
                } else {
                    metodoDeOrdenamiento = seleccionarMetodoDeOrdenamiento(entrada);
                }
            } else {
                if (metodoActualEnLaPruebaAutomatica == 6) {
                    break;
                } else {
                    metodoDeOrdenamiento = metodoActualEnLaPruebaAutomatica++;
                }
            }
            //Ejecutando la prueba del método seleccionado.
            switch (metodoDeOrdenamiento) {
                //Método de ordenamiento burbuja.
                case 1:
                    //Creando el mensaje que contiene los tiempos para el método burbuja.
                    mensajeBubbleSort = "Método de ordenamiento burbuja: \n";
                    //Probando el mejor caso.
                    mensajeBubbleSort += "El mejor caso tardó " + bubbleSortTest(datosBestCase.clone()) + "ms en ser completado.\n";
                    //Probando el peor caso.
                    mensajeBubbleSort += "El peor caso tardó " + bubbleSortTest(datosWorstCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso mixto.
                    mensajeBubbleSort += "El caso mixto tardó " + bubbleSortTest(datosMixedCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso aleatorio.
                    mensajeBubbleSort += "El caso aleatorio tardó " + bubbleSortTest(datosRandomCase.clone()) + "ms en ser completado.\n";
                    System.out.println(mensajeBubbleSort);
                    break;
                case 2:
                    //Creando el mensaje que contiene los tiempos para el método burbuja con señal.
                    mensajeBubbleSortWithSignal = "Método de ordenamiento burbuja con señal: \n";
                    //Probando el mejor caso.
                    mensajeBubbleSortWithSignal += "El mejor caso tardó " + bubbleSortWithSignalTest(datosBestCase.clone()) + "ms en ser completado.\n";
                    //Probando el peor caso.
                    mensajeBubbleSortWithSignal += "El peor caso tardó " + bubbleSortWithSignalTest(datosWorstCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso mixto.
                    mensajeBubbleSortWithSignal += "El caso mixto tardó " + bubbleSortWithSignalTest(datosMixedCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso aleatorio.
                    mensajeBubbleSortWithSignal += "El caso aleatorio tardó " + bubbleSortWithSignalTest(datosRandomCase.clone()) + "ms en ser completado.\n";
                    System.out.println(mensajeBubbleSortWithSignal);
                    break;
                case 3:
                    //Creando el mensaje que contiene los tiempos para el método de ordenamiento Shell.
                    mensajeShellSort = "Método de ordenamiento Shell: \n";
                    //Probando el mejor caso.
                    mensajeShellSort += "El mejor caso tardó " + shellSortTest(datosBestCase.clone()) + "ms en ser completado.\n";
                    //Probando el peor caso.
                    mensajeShellSort += "El peor caso tardó " + shellSortTest(datosWorstCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso mixto.
                    mensajeShellSort += "El caso mixto tardó " + shellSortTest(datosMixedCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso aleatorio.
                    mensajeShellSort += "El caso aleatorio tardó " + shellSortTest(datosRandomCase.clone()) + "ms en ser completado.\n";
                    System.out.println(mensajeShellSort);
                    break;
                case 4:
                    //Creando el mensaje que contiene los tiempos para el método de seleccion directa.
                    mensajeSelectionSort = "Método de ordenamiento por selección directa \n";
                    //Probando el mejor caso.
                    mensajeSelectionSort += "El mejor caso tardó " + selectionSortTest(datosBestCase.clone()) + "ms en ser completado.\n";
                    //Probando el peor caso.
                    mensajeSelectionSort += "El peor caso tardó " + selectionSortTest(datosWorstCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso mixto.
                    mensajeSelectionSort += "El caso mixto tardó " + selectionSortTest(datosMixedCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso aleatorio.
                    mensajeSelectionSort += "El caso aleatorio tardó " + selectionSortTest(datosRandomCase.clone()) + "ms en ser completado.\n";
                    System.out.println(mensajeSelectionSort);
                    break;
                case 5:
                    //Creando el mensaje que contiene los tiempos para el método ShakerSort.
                    mensajeShakerSort = "Método de ordenamiento ShakerSort: \n";
                    //Probando el mejor caso.
                    mensajeShakerSort += "El mejor caso tardó " + shakerSortTest(datosBestCase.clone()) + "ms en ser completado.\n";
                    //Probando el peor caso.
                    mensajeShakerSort += "El peor caso tardó " + shakerSortTest(datosWorstCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso mixto.
                    mensajeShakerSort += "El caso mixto tardó " + shakerSortTest(datosMixedCase.clone()) + "ms en ser completado.\n";
                    //Probando el caso aleatorio.
                    mensajeShakerSort += "El caso aleatorio tardó " + shakerSortTest(datosRandomCase.clone()) + "ms en ser completado.\n";
                    System.out.print(mensajeShakerSort);
                    break;
            }
        } while (metodoDeOrdenamiento != 7);
        System.out.println();
        System.out.println("Finalizado. :)");
    }

    /**
     * Método para seleccionar el método de ordenamiento a usar.
     *
     * @param entrada que es el lector de datos de tipo Scanner.
     * @return metodoDeOrdenamiento que es el método seleccionado.
     **/
    private static int seleccionarMetodoDeOrdenamiento(Scanner entrada) {
        int metodoDeOrdenamiento;
        do {
            System.out.println("¿Qué método de ordenamiento desea probar?");
            System.out.println("1. Burbuja.");
            System.out.println("2. Burbuja con señal.");
            System.out.println("3. Shell. ");
            System.out.println("4. Selección directa.");
            System.out.println("5. Shaker.");
            System.out.println("6. Probar todos automáticamente.");
            System.out.println("7. Salir");
            metodoDeOrdenamiento = entrada.nextInt();
        } while (metodoDeOrdenamiento > 7 || metodoDeOrdenamiento < 1);
        return metodoDeOrdenamiento;
    }

    private static long bubbleSortTest(int[] datos) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio = System.currentTimeMillis();
        //Llamada al método de ordenamiento burbuja.
        bubbleSort(datos);
        //Almacenando el momento en que finaliza el método.
        long tiempoDeFinalizacion = System.currentTimeMillis();
        //Se regresa el tiempo total de ejecución.
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    private static long bubbleSortWithSignalTest(int[] datos) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio = System.currentTimeMillis();
        //Llamada al método de ordenamiento burbuja con señal.
        bubbleSortWithSignal(datos);
        //Almacenando el momento en que finaliza el método.
        long tiempoDeFinalizacion = System.currentTimeMillis();
        //Se regresa el tiempo total de ejecución.
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    private static long shellSortTest(int[] datos) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio = System.currentTimeMillis();
        //Llamada al método de ordenamiento shell.
        shellSort(datos);
        //Almacenando el momento en que finaliza el método.
        long tiempoDeFinalizacion = System.currentTimeMillis();
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    private static long selectionSortTest(int[] datos) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio = System.currentTimeMillis();
        //Llamada al método de ordenamiento selection.
        selectionSort(datos);
        //Almacenando el momento en que finaliza el método.
        long tiempoDeFinalizacion = System.currentTimeMillis();
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    private static long shakerSortTest(int[] datos) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio = System.currentTimeMillis();
        //Llamada al método de ordenamiento shaker.
        shakerSort(datos);
        //Almacenando el momento en que finaliza el método.
        long tiempoDeFinalizacion = System.currentTimeMillis();
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    /**
     * Método que prueba los distintos métodos de ordenamiento
     * y regresa la duración en milisegundos de dicho método.
     *
     * @param datos  que es el conjunto de datos a ordenar.
     * @param method que es el método a usar en la ordenación.
     * @return tiempoDeFinalizacion - tiempoDeInicio que es el
     * tiempo total de ejecución que utilizó el método probado.
     **/
    private static long probarMetodosDeOrdenamiento(int[] datos, int method) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de ordenamiento es llamado.
        long tiempoDeInicio, tiempoDeFinalizacion;
        //Se inicializa el tiempo de inicio, el valor será afinado más adelante.
        tiempoDeInicio = System.currentTimeMillis();
        switch (method) {
            case 1:
                tiempoDeInicio = System.currentTimeMillis();
                bubbleSort(datos);
                break;
            case 2:
                tiempoDeInicio = System.currentTimeMillis();
                bubbleSortWithSignal(datos);
                break;
            case 3:
                tiempoDeInicio = System.currentTimeMillis();
                shellSort(datos);
                break;
            case 4:
                tiempoDeInicio = System.currentTimeMillis();
                selectionSort(datos);
                break;
            case 5:
                tiempoDeInicio = System.currentTimeMillis();
                shakerSort(datos);
                break;
        }
        //Almacenando el momento en que finaliza el método.
        tiempoDeFinalizacion = System.currentTimeMillis();
        //Regresando el tiempo de ejecución al restar el tiempo de inicio
        //del tiempo final. El tiempo se regresa en milisegundos.
        return tiempoDeFinalizacion - tiempoDeInicio;
    }
}
