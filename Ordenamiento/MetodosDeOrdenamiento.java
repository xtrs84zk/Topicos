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
                for (int j = 0; j < datos.length - 1; j++) {
                    //En caso de que el valor a la derecha sea menor, los intercambia.
                    if (datos[j] > datos[j + 1]) {
                        intercambia(datos, j, j + 1);
                    }
                }
            }
        } else {
            System.err.println("El conjunto de valores esta vacío.");
        }
    }

    /**
     * Método de ordenamiento que implementa el algoritmo Shell.
     * @param  datos   conjunto de valores enteros a ordenar
     */
    public static void shellSort(int[] datos) {
        int iteracion, i;
        boolean seRealizaronIntercambios;
        iteracion = datos.length + 1;
        while (iteracion > 1) {
            iteracion /= 2;
            seRealizaronIntercambios = true;
            while (seRealizaronIntercambios) {
                seRealizaronIntercambios = false;
                i = 0;
                while ((i + iteracion) < datos.length) {
                    if (datos[i] > datos[i + iteracion]) {
                        intercambia(datos, i, i + iteracion);
                        seRealizaronIntercambios = true;
                    }
                    i += 1;
                }
            }
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
                intercambia(datos, i, indiceConElValorMasAlto);
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
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     * En caso de haber hecho ningún movimiento en alguna de las "pasadas", el conjunto esta ordenado.
     *
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSortWithSignal(int[] datos) {
        if (datos != null) {
            int i = 0;
            while (i < datos.length) {
                boolean huboMovimientos = false;
                for (int j = 0; j < datos.length - 1; j++) {
                    if (datos[j] > datos[j + 1]) {
                        intercambia(datos, j, j + 1);
                        huboMovimientos = true;
                    }
                }
                if (!huboMovimientos) {
                    return;
                }
                i++;
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
            int limiteSuperior = datos.length - 1, limiteInferior = 0;
            //Cada iteración sacude los elementos del conjunto hasta que estén ordenados.
            for (int i = 0; i < datos.length / 2; i++) {
                //Pasada de izquierda a derecha
                //En caso de que el valor a la derecha sea menor, los intercambia.
                for (int j = limiteInferior; j < limiteSuperior; j++) {
                    if (datos[j] > datos[j + 1]) {
                        intercambia(datos, j, j + 1);
                    }
                }
                //Se decrementa el limite superior debido a que dicho índice tiene el valor que le corresponde.
                limiteSuperior--;
                //Pasada de izquierda a derecha
                //En caso de que el valor a la izquierda sea menor, los intercambia.
                for (int k = limiteSuperior; k > limiteInferior; k--) {
                    if (datos[k] < datos[k - 1]) {
                        intercambia(datos, k, k - 1);
                    }
                }
                //Se incrementa el limite inferior debido a que dicho índice posee el valor que le corresponde.
                limiteInferior++;
            } //Aquí termina cada pasada
        }
    }

    public static void quickSort(int[] datos) {
        if (datos != null && datos.length > 1) {
            quickSortRecursivo(datos, 0, datos.length - 1);
        } else {
            System.err.println("Hubo un error al ordenar usando quicksort.");
            //quickSortIterativo(datos);
        }
    }
    /**
     * Método de ordenamiento rápido basado en la técnica de divide y vencerás.
     *
     * @param datos que es el conjunto de datos a ordenar.
     * @indiceInferior que será el conjunto a la indiceInferior  al ordenar.
     * @indiceSuperior que será el conjunto derecho al ordenar.
     **/
    private static void quickSortRecursivo(int[] datos, int indiceInferior, int indiceSuperior) {
        //Mejor caso
        if (indiceSuperior <= indiceInferior || indiceInferior >= indiceSuperior) {
            //Aqui no se hace nada y termina el caso.
        }
        //Caso recursivo
        else {
            int i = indiceInferior + 1;

            //Dividiendo el arreglo
            int j = indiceInferior + 1;
            while (j <= indiceSuperior) {
                if (datos[indiceInferior] > datos[j]) {
                    intercambia(datos, j, i);
                    i++;
                }
                j++;
            }

            //Moviendo el pivote a la derecha del índice inicial
            datos[indiceInferior] = datos[i - 1];
            datos[i - 1] = datos[indiceInferior];

            //Llamada al método quickSortRecursivo a la izquierda y a la derecha del índice inicial del pivote
            quickSortRecursivo(datos, indiceInferior, i - 2);
            quickSortRecursivo(datos, i, indiceSuperior);
        }
    }

    public static void quickSortIterativo() {

    }

    /**
     * Método que intercambia dos valores en un conjunto.
     *
     * @param datos que es el conjunto sobre el cual operar.
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

    /**
     * Método que regresa el contenido de un arreglo de enteros.
     * El método crea un String y concatena ahí los valores.
     *
     * @param datos que es el conjunto de datos a mostrar.
     * @return temporal que contiene los valores del conjunto.
     **/
    public static String muestra(int[] datos) {
        //Variable temporal donde se almacenará el contenido del conjunto datos.
        String temporal = "Mostrando los valores en el conjunto. \n";
        //Foreach que recorre el arreglo concatenando cada valor en temporal.
        for (int dato : datos) {
            temporal += ("[" + dato + "], ");
        }
        //Se regresa el String.
        return temporal;
    }
}