package Ordenamiento;

import java.util.Random;

/** Created by xtrs84zk on 03/11/2016. **/
public class MetodosDeOrdenamiento {
    private MetodosDeOrdenamiento() {

    }

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     *
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSort(int[] datos) {
        if (datos != null && datos.length != 0) {
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; i < datos.length; i++) {
                    if (datos[i] > datos[i + 1]) {
                        int aux = datos[i];
                        datos[i] = datos[i + 1];
                        datos[i + 1] = aux;
                    }
                }
            }
        }
    }

    /**
     * Método de ordenamiento por inserción
     * El algoritmo Shell sort mejora el ordenamiento por inserción comparando elementos
     * separados por un espacio de varias posiciones. Esto permite que un elemento
     * haga "pasos más grandes" hacia su posición esperada. Los pasos múltiples sobre los
     * datos se hacen con tamaños de espacio cada vez más pequeños. El último paso del ShellSort
     * es un simple ordenamiento por inserción, pero para entonces, ya está garantizado que los
     * datos del vector están casi ordenados.
     **/
    public static void seleccionIndirecta(int[] datos) {
        int limiteSuperior, posicionActual;
        limiteSuperior = datos.length - 1;
        Random random = new Random();
        int i = 0;
        while (limiteSuperior >= 0) {
            int aleatorio = random.nextInt(limiteSuperior) + 1;
            //Moviendo el contenido dependiendo de si esta ordenado
            if (datos[aleatorio] < datos[aleatorio - 1]) {
                int auxiliar = datos[i - 1];
                datos[i - 1] = datos[i];
                datos[i] = auxiliar;
            }
            limiteSuperior--;
            i++;
        }
    }

    public static void shellSort(int[] datos) {
    }

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     * En caso de no haber hecho ningun movimiento en alguna de las "pasadas", el algoritmo ha terminado.
     *
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSortWithControlVariable(int[] datos) {
        if (datos != null && datos.length != 0) {
            for (int i = 0; i < datos.length; i++) {
                int movimientos = 0;
                for (int j = 0; i < datos.length; i++) {
                    if (datos[i] > datos[i + 1]) {
                        int aux = datos[i];
                        datos[i] = datos[i + 1];
                        datos[i + 1] = aux;
                        movimientos++;
                    }
                    if (movimientos > 0) {
                        return;
                    }
                }
            }
        }
    }
    /** Método shakeSort o de ordenación por agitación que ordena los elementos recorriéndolos de un lado a otro
     * @param datos que es el conjunto de enteros a ordenar.**/
    public static void shakeSort(int[] datos) {
        if (datos != null) { //Se verifica que el conjunto de datos exista
            if (datos.length != 0) { //Se verifica que su longitud sea mayor a cero
                int limiteSuperior = datos.length - 1, limiteInferior = 0, direccionActual = 0;
                for (int i = 0; i < datos.length; i++) {
                    if (direccionActual == 0) {
                        //En caso de que la dirección sea 0,  se ordenarán de derecha a izquierda,
                        // en caso de que sea 1; se ordenarán voy de izquierda a derecha.
                        for (int j = limiteInferior; j < limiteSuperior; j++) {
                            if (datos[j] > datos[j + 1]) {
                                int aux = datos[j];
                                datos[j] = datos[i + 1];
                                datos[j + 1] = aux;
                            }
                        }
                        direccionActual = 1;
                    } else {
                        for (int j = limiteInferior; j < limiteSuperior; j--) {
                            if (datos[j] <= datos[j + 1]) {
                                int aux = datos[j];
                                datos[j] = datos[i + 1];
                                datos[j + 1] = aux;
                            }
                        }
                        direccionActual = 0;
                    }
                }
            }
        }
    }
}