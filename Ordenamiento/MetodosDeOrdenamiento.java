package Ordenamiento;

/**
 * Created by Javier Sánchez on 03/11/2016.
 **/
public class MetodosDeOrdenamiento {
    private MetodosDeOrdenamiento() {
        //Constructor privado para que sea imposible crear instancias de ésta clase.
    }

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     *
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSort(int[] datos) {
        //Verifica que la referencia lleve a un objeto creado.
        if (datos != null) {
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos.length; j++) {
                    //En caso de que el valor a la derecha sea menor, los intercambia.
                    if (datos[j] > datos[j + 1]) {
                        int auxiliar = datos[j];
                        datos[j] = datos[j + 1];
                        datos[j + 1] = auxiliar;
                    }
                }
            }
        } else {
            System.err.println("El conjunto de valores esta vacío.");
        }
    }

    /**
     * metodo de ordenamiento que implementa el algoritmo Shell      *       * @param  datos   conjunto de valores enteros a ordenar      * @return     sin retorno
     */
    public static void shellSort(int[] datos) {
        int intervalo, i;
        boolean seRealizaronIntercambios;
        System.out.println("tamaño: " + datos.length);
        //muestra(datos);
        intervalo = datos.length + 1;
        while (intervalo > 1) {
            intervalo /= 2;
            seRealizaronIntercambios = true;
            System.out.println("intervalo: " + intervalo);
            while (seRealizaronIntercambios) {
                seRealizaronIntercambios = false;
                i = 0;
                while ((i + intervalo) < datos.length) {
                    if (datos[i] > datos[i + intervalo]) {
                        intercambia(datos, i, i + intervalo);
                        seRealizaronIntercambios = true;
                    }
                    i += 1;
                }
            }
            //muestra(datos);
        }
    }

    /**
     * Método de ordenamiento por inserción
     * Dicho método de ordenamiento es una manera muy natural de ordenar para un ser humano.
     * Puede usarse fácilmente para ordenar un mazo de cartas numeradas en forma arbitraria.
     * Requiere O(n²) operaciones para ordenar una lista de n elementos.
     *
     * @param datos que es el conjunto de valores a ordenar.
     **/

    public static void selectionSort(int[] datos) {
        if (datos != null) {
            for (int i = datos.length - 1; i > 0; i--) {
                int indiceConElValorMasAlto = indiceConElValorMasAlto(datos, i + 1);
                int auxiliar = datos[i];
                datos[i] = datos[indiceConElValorMasAlto];
                datos[indiceConElValorMasAlto] = auxiliar;
            }
        }
    }

    /**
     * Metodo privado que regresa el índice que contiene el valor más alto en un conjunto de datos.
     *
     * @param datos          que es el conjunto de datos sobre el cual buscará.
     * @param limiteSuperior que es el limite donde terminará la búsqueda.
     * @return indiceConElValorMasAlto que es la posición que contiene el mayor valor del arreglo.
     **/
    private static int indiceConElValorMasAlto(int[] datos, int limiteSuperior) {
        int indiceConElValorMasAlto = 0;
        for (int i = 0; i < limiteSuperior; i++) {
            if (datos[indiceConElValorMasAlto] < datos[i]) {
                indiceConElValorMasAlto = i;
            }
        }
        return indiceConElValorMasAlto;

    }

    /**
     * El algoritmo Shell sort mejora el ordenamiento por inserción comparando elementos
     * separados por un espacio de varias posiciones. Esto permite que un elemento
     * haga "pasos más grandes" hacia su posición esperada. Los pasos múltiples sobre los
     * datos se hacen con tamaños de espacio cada vez más pequeños. El último paso del ShellSort
     * es un simple ordenamiento por inserción, pero para entonces, ya está garantizado que los
     * datos del vector están casi ordenados.
     *
     * @param datos que es el conjunto de valores a ordenar.
    public static void shellSort(int[] datos) {
    if (datos != null) {
    int pasoActual = datos.length / 2;
    while (pasoActual > 0) {
    for (int i = 0; i < (datos.length - pasoActual); i++) {
    int j = i;
    while (j >= 0 && datos[j] > datos[j + pasoActual]) {
    int temp = datos[j];
    datos[j] = datos[j + pasoActual];
    datos[j + pasoActual] = temp;
    j--;
    }
    }
    pasoActual = pasoActual / 2;
    }
    }
    }
     **/

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     * En caso de haber hecho ningún movimiento en alguna de las "pasadas", el conjunto esta ordenado.
     *
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSortWithSignal(int[] datos) {
        if (datos != null) {
            for (int i = 0; i < datos.length; i++) {
                boolean huboMovimientos = false;
                for (int j = 0; j < datos.length; j++) {
                    if (datos[j] > datos[j + 1]) {
                        int aux = datos[j];
                        datos[j] = datos[j + 1];
                        datos[j + 1] = aux;
                        huboMovimientos = true;
                    }
                }
                if (!huboMovimientos) {
                    return;
                }
            }
        }
    }

    /**
     * Método shakeSort o de ordenación por agitación que ordena los elementos recorriéndolos de un lado a otro
     * En cada iteración da dos pasadas al conjunto ordenando el valor
     *
     * @param datos que es el conjunto de valores a ordenar.
     **/
    public static void shakerSort(int[] datos) {
        //Se verifica que el conjunto de datos exista
        if (datos != null) {
            int limiteSuperior = datos.length - 1, limiteInferior = 0, auxiliar;
            //Cada iteración sacude los elementos del conjunto hasta que estén ordenados.
            for (int i = 0; i < datos.length / 2; i++) {
                //Pasada de izquierda a derecha
                //En caso de que el valor a la derecha sea menor, los intercambia.
                for (int j = limiteInferior; j < limiteSuperior; j++) {
                    if (datos[j] > datos[j + 1]) {
                        auxiliar = datos[j];
                        datos[j] = datos[j + 1];
                        datos[j + 1] = auxiliar;
                    }
                }
                //Se decrementa el limite superior debido a que dicho índice tiene el valor que le corresponde.
                limiteSuperior--;
                //Pasada de izquierda a derecha
                //En caso de que el valor a la izquierda sea menor, los intercambia.
                for (int k = limiteSuperior; k > limiteInferior; k--) {
                    if (datos[k] < datos[k - 1]) {
                        auxiliar = datos[k];
                        datos[k] = datos[k - 1];
                        datos[k + 1] = auxiliar;
                    }
                }
                //Se incrementa el limite inferior debido a que dicho índice posee el valor que le corresponde.
                limiteInferior++;
            } //Aquí termina cada pasada
        }
    }

    /**
     * Método que intercambia dos valores en un conjunto.
     *
     * @param datos que es el conjunto sobre el cual operar
     * @param i     que es uno de los valores a intercambiar.
     * @param j     que es otro de los valores a intercambiar.
     **/
    private static void intercambia(int[] datos, int i, int j) {
        //Se salva el contenido del valor1 en una variable auxiliar.
        int auxiliar = datos[i];
        //Se asigna a la posición i el valor en la posición j.
        datos[i] = datos[j];
        //Se asigna a j el valor original de i.
        datos[j] = auxiliar;
    }
}