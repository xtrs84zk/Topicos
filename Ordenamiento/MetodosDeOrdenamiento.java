package Ordenamiento;
import java.util.Random;

/**
 * Created by Javier Sánchez on 03/11/2016.
 **/
public class MetodosDeOrdenamiento {
    private MetodosDeOrdenamiento() {
        //Constructor privado para que sea imposible crear instancias de ésta clase.
        }

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     * @param datos que es el conjunto de datos a ordenar.
     **/
    public static void bubbleSort(int[] datos){
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
     * Método de ordenamiento por inserción **/
    public static void seleccionIndirecta(int[] datos) {
        if (datos != null) {
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
    }
    /**
     * El algoritmo Shell sort mejora el ordenamiento por inserción comparando elementos
     * separados por un espacio de varias posiciones. Esto permite que un elemento
     * haga "pasos más grandes" hacia su posición esperada. Los pasos múltiples sobre los
     * datos se hacen con tamaños de espacio cada vez más pequeños. El último paso del ShellSort
     * es un simple ordenamiento por inserción, pero para entonces, ya está garantizado que los
     * datos del vector están casi ordenados.
     **/
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

    /**
     * Método de ordenamiento denominado burbuja, debido a que los valores "burbujean" hacía la superficie.
     * En caso de haber hecho ningún movimiento en alguna de las "pasadas", el algoritmo ha terminado.
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
     * @param datos que es el conjunto de enteros a ordenar.
     **/
    public static void shakerSort(int[] datos) {
        //Se verifica que el conjunto de datos exista
        if (datos != null) {
            int limiteSuperior = datos.length - 1, limiteInferior = 0, auxiliar;
            //Cada iteración sacude los elementos del conjunto hasta que estén ordenados.
            for (int i = 0; i < datos.length; i++) {
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
}