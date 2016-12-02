package Ordenamiento;

import javax.swing.*;
import java.util.LinkedList;

import static Ordenamiento.GenerarDatos.*;

/**
 * Created by Javier Sánchez on 01/12/2016.
 **/
public class SortAndSearchTest {
    public static void main(String[] args) {
        int[] datosBestCase, datosWorstCase, datosMixedCase, datosRandomCase;
        int cantidadDeDatos, opcion, porcentajeParaElCasoMixto;
        long tiempoDeEjecucion;
        boolean yaSeHanGeneradoDatos = false;
        LinkedList linkedList = new LinkedList();
        final String opciones = "¿Qué desea hacer?" +
                "1. Comparar métodos de ordenamiento. " +
                "2. Comparar métodos de búsqueda. " +
                "3. Generar datos." +
                "4. Salir.";
        //Se inicializan los conjuntos de datos
        datosBestCase = new int[0];
        datosWorstCase = new int[0];
        datosMixedCase = new int[0];
        datosRandomCase = new int[0];
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (opcion) {
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo.");
                    break;
                case 1:
                    if (yaSeHanGeneradoDatos) {
                        String[][] tabla = compararMetodosDeOrdenamiento(datosBestCase, datosWorstCase, datosMixedCase, datosRandomCase);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han generado datos.");
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
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya se han generado datos, ¿desea reemplazarlos?");
                    }

            }
        } while (opcion != 4);
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

    private static String[][] compararMetodosDeOrdenamiento(int[] datosBestCase, int[] datosWorstCase, int[] datosMixedCase, int[] datosRandomCase) {
        return null;
    }

    private static long compararMetodosDeBusqueda() {
        return 0;
    }
}
