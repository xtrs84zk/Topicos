package Ordenamiento;

import util.Tabla;

import javax.swing.*;

import static Ordenamiento.GenerarDatos.*;
import static Ordenamiento.MetodosDeBusqueda.*;
import static Ordenamiento.MetodosDeOrdenamiento.*;

/**
 * Created by Javier Sánchez on 01/12/2016.
 **/
public class SortAndSearchTest {
    public static void main(String[] args) {
        int[] datosBestCase, datosWorstCase, datosMixedCase, datosRandomCase;
        int cantidadDeDatos = 0, opcion, porcentajeParaElCasoMixto;
        long tiempoDeEjecucion;
        boolean yaSeHanGeneradoDatos = false;
        final String opciones = "¿Qué desea hacer?\n" +
                "1. Comparar métodos de ordenamiento. \n" +
                "2. Comparar métodos de búsqueda. \n" +
                "3. Generar datos.\n" +
                "4. Ver los datos.\n" +
                "5. Salir.";
        //Se inicializan los conjuntos de datos
        datosBestCase = new int[0];
        datosWorstCase = new int[0];
        datosMixedCase = new int[0];
        datosRandomCase = new int[0];
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (opcion) {
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo.");
                    break;
                case 4:
                    if (yaSeHanGeneradoDatos) {
                        int datoAMostrar;
                        do {
                            datoAMostrar = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué datos desea mostrar?\n" +
                                    "1. Mejor caso." +
                                    "2. Peor caso. " +
                                    "3. Caso mixto." +
                                    "4. Caso aleatorio."));
                        } while (datoAMostrar < 1 || datoAMostrar > 4);
                        JOptionPane.showMessageDialog(null, muestra(datosBestCase));
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay datos para mostrar.");
                    }
                    break;
                case 2:
                    if (yaSeHanGeneradoDatos) {
                        JOptionPane.showMessageDialog(null, compararMetodosDeBusqueda(datosBestCase, (int) (Math.random() * cantidadDeDatos + 1)));
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero necesita generar datos.");
                    }
                    break;
                case 1:
                    if (yaSeHanGeneradoDatos) {
                        compararMetodosDeOrdenamiento(datosBestCase, datosWorstCase, datosMixedCase, datosRandomCase);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han generado datos, mostrando el menú para generarlos.");
                    }
                case 3:
                    if (!yaSeHanGeneradoDatos) {
                        cantidadDeDatos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos datos desea que contenga cada conjunto?"));
                        porcentajeParaElCasoMixto = Integer.parseInt(JOptionPane.showInputDialog(null, "Para generar los datos, necesito el porcentaje de ordenamiento para el caso mixto."));
                        datosBestCase = new int[cantidadDeDatos];
                        datosWorstCase = new int[cantidadDeDatos];
                        datosMixedCase = new int[cantidadDeDatos];
                        datosRandomCase = new int[cantidadDeDatos];
                        tiempoDeEjecucion = generarDatos(datosBestCase, datosWorstCase, datosMixedCase, porcentajeParaElCasoMixto, datosRandomCase);
                        JOptionPane.showMessageDialog(null, "Los datos se han generado en " + tiempoDeEjecucion + " milisegundos.");
                        yaSeHanGeneradoDatos = true;
                    } else {
                        int reemplazo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ya se han generado datos, presione 1 para eliminar los actuales."));
                        if (1 == reemplazo) {
                            datosBestCase = new int[0];
                            datosWorstCase = new int[0];
                            datosMixedCase = new int[0];
                            datosRandomCase = new int[0];
                            yaSeHanGeneradoDatos = false;
                            JOptionPane.showMessageDialog(null, "Los datos se han eliminado correctamente.");
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static long generarDatos(int[] datosBestCase, int[] datosWorstCase, int[] datosMixedCase, int porcentajeParaElCasoMixto, int[] datosRandomCase) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de generación de datos es llamado.
        long tiempoDeInicio, tiempoDeFinalizacion;
        //Se inicializa el tiempo de inicio, el valor será afinado más adelante.
        tiempoDeInicio = System.currentTimeMillis();
        bestCase(datosBestCase);
        worstCase(datosWorstCase);
        try {
            mixedCase(datosMixedCase, porcentajeParaElCasoMixto);
        } catch (Exception e) {
            try {
                do {
                    porcentajeParaElCasoMixto = (int) (Math.random() * 99 + 1);
                } while (porcentajeParaElCasoMixto < 1 || porcentajeParaElCasoMixto > 100);
                System.err.println("El usuario introdujo un porcentaje inválido, se usará " + porcentajeParaElCasoMixto + "%");
                mixedCase(datosMixedCase, porcentajeParaElCasoMixto);
            } catch (Exception ex) {
                System.err.println(e.getMessage());
            }
        }
        randomCase(datosRandomCase);
        //Almacenando el momento en que finaliza el método.
        tiempoDeFinalizacion = System.currentTimeMillis();
        //Regresando el tiempo de ejecución al restar el tiempo de inicio
        //del tiempo final. El tiempo se regresa en milisegundos.
        return tiempoDeFinalizacion - tiempoDeInicio;
    }

    private static void compararMetodosDeOrdenamiento(int[] datosBestCase, int[] datosWorstCase, int[] datosMixedCase, int[] datosRandomCase) {
        //Se definen los titulos que llevara cada fila.
        String[] metodosDeOrdenamiento = new String[]{"BubbleSort", "ShellSort", "SelectionSort", "BubbleSortWithSignal", "ShakerSort", "QuickSort"};
        //Se definen los titulos que llevarán las columnas de la tabla.
        String[] titulosDeLasColumnas = new String[]{"Método \\ Tiempo", "Mejor caso", "Peor caso", "Caso mixto", "Caso aleatorio"};
        Object[][] contenidoDeLaTabla = new Object[6][5];
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < contenidoDeLaTabla.length; i++) {
            contenidoDeLaTabla[i][0] = metodosDeOrdenamiento[i];
            contenidoDeLaTabla[i][1] = probarMetodosDeOrdenamiento(datosBestCase, i);
            contenidoDeLaTabla[i][2] = probarMetodosDeOrdenamiento(datosWorstCase, i);
            contenidoDeLaTabla[i][3] = probarMetodosDeOrdenamiento(datosMixedCase, i);
            contenidoDeLaTabla[i][4] = probarMetodosDeOrdenamiento(datosRandomCase, i);
        }
        long fin = System.currentTimeMillis();
        System.out.println("Se han probado todos los métodos en " + (fin - inicio) + " ms.");
        //Declarar y crear un objeto de tipo tabla.
        Tabla comparacionDeMetodosDeOrdenamiento = new Tabla(null, titulosDeLasColumnas, null);
        //Hacer que el tamaño de la tabla no se pueda cambiar.
        comparacionDeMetodosDeOrdenamiento.setResizable(false);
        //Comprimir el espacio en la tabla manteniendo todos los elementos.
        comparacionDeMetodosDeOrdenamiento.pack();
        //Centrando la ventana en la pantalla.
        comparacionDeMetodosDeOrdenamiento.setLocationRelativeTo(null);
        //mostrando la tabla.
        comparacionDeMetodosDeOrdenamiento.setVisible(true);

    }

    private static String compararMetodosDeBusqueda(int[] datos, int datoABuscar) {
        String[] metodosDeBusqueda = new String[]{"Búsqueda secuencial.", "Búsqueda binaria", "Búsqueda hash."};
        String mensaje = "";
        for (int i = 0; i <= 3; i++) {
            mensaje += "El método " + metodosDeBusqueda[i] + " tardó " + probarMetodosDeBusqueda(i, datos, datoABuscar) + " en encontrar el elemento. \n";
        }
        return mensaje;
    }

    private static long probarMetodosDeBusqueda(int metodoElegido, int[] datos, int datoABuscar) {
        //Variable de tipo long donde se almacena el momento exacto en que
        //el método de búsqueda es llamado y termina.
        long tiempoDeInicio, tiempoDeFinalizacion;
        //Inicializando el tiempo de inicio.
        tiempoDeInicio = System.currentTimeMillis();
        switch (metodoElegido) {
            case 1:
                tiempoDeInicio = System.currentTimeMillis();
                busquedaSecuencial(datos, datoABuscar);
                break;
            case 2:
                tiempoDeInicio = System.currentTimeMillis();
                busquedaBinaria(datos, datoABuscar);
                break;
            case 3:
                tiempoDeInicio = System.currentTimeMillis();
                busquedaHash(datos, datoABuscar);
                break;
        }
        //Almacenando el momento en que finaliza el método.
        tiempoDeFinalizacion = System.currentTimeMillis();
        //Regresando el tiempo de ejecución al restar el tiempo de inicio
        //del tiempo final. El tiempo se regresa en milisegundos.
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
        //el método de ordenamiento es llamado y termina.
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
                shellSort(datos);
                break;
            case 3:
                tiempoDeInicio = System.currentTimeMillis();
                selectionSort(datos);
                break;
            case 4:
                tiempoDeInicio = System.currentTimeMillis();
                bubbleSortWithSignal(datos);
                break;
            case 5:
                tiempoDeInicio = System.currentTimeMillis();
                shakerSort(datos);
                break;
            case 6:
                tiempoDeInicio = System.currentTimeMillis();
                quickSort(datos);
                break;
        }
        //Almacenando el momento en que finaliza el método.
        tiempoDeFinalizacion = System.currentTimeMillis();
        //Regresando el tiempo de ejecución al restar el tiempo de inicio
        //del tiempo final. El tiempo se regresa en milisegundos.
        return tiempoDeFinalizacion - tiempoDeInicio;
    }
}