package Ordenamiento;

import java.util.Random;

/** Created by xtrs84zk on 03/11/2016. **/
public class MetodosDeOrdenamiento {
    private MetodosDeOrdenamiento() {

    }

    /** Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie. **/
    public static void bubbleSort(int[] aOrdenar) {
        if (aOrdenar != null && aOrdenar.length != 0) {
            for (int i = 0; i < aOrdenar.length; i++) {
                for (int j = 0; i < aOrdenar.length; i++) {
                    if (aOrdenar[i] > aOrdenar[i + 1]) {
                        int aux = aOrdenar[i];
                        aOrdenar[i] = aOrdenar[i + 1];
                        aOrdenar[i + 1] = aux;
                    }
                }
            }
        }
    }
    /** Método de ordenamiento por inserción
     * El algoritmo Shell sort mejora el ordenamiento por inserción comparando elementos
     * separados por un espacio de varias posiciones. Esto permite que un elemento
     * haga "pasos más grandes" hacia su posición esperada. Los pasos múltiples sobre los
     * datos se hacen con tamaños de espacio cada vez más pequeños. El último paso del ShellSort
     * es un simple ordenamiento por inserción, pero para entonces, ya está garantizado que los
     * datos del vector están casi ordenados.**/
    public static void seleccionIndirecta(int[] aOrdenar){
        int limiteSuperior, posicionActual;
        limiteSuperior = aOrdenar.length-1;
        Random p = new Random();
        int i =0;
        while (limiteSuperior>=0){
            int aleatorio = p.nextInt(limiteSuperior) + 1;
            //Moviendo el contenido dependiendo de si esta ordenado

            if(aOrdenar[aleatorio] < aOrdenar[aleatorio-1]){
                int auxiliar = aOrdenar[i-1];
                aOrdenar[i-1] = aOrdenar[i];
                aOrdenar[i] = auxiliar;
            }
            limiteSuperior--;
            i++;
        }
    }

    public static void seleccionDirecta(int[] aOrdenar){

    }
}
