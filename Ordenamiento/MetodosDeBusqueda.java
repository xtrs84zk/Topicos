package Ordenamiento;

/**
 * Created by Javier Sánchez on 01/12/2016.
 **/
public class MetodosDeBusqueda {
    /**
     * Constructor para la clase MetodosDeBusqueda
     * Es privado para que no sea posible crear objetos.
     **/
    private MetodosDeBusqueda() {
        //No se crearán objetos de ésta clase.
    }

    /**
     * Método que realiza una búsqueda secuencial en un conjunto de datos.
     *
     * @param datos           que es el conjunto de datos sobre el cual buscar.
     * @param elementoABuscar que es el elemento a buscar.
     * @return true en caso de encontrar el elemento.
     **/
    public static boolean busquedaSecuencial(int[] datos, int elementoABuscar) {
        //Variable para indicar la posición actual en el arreglo.
        int posicionActualEnElArreglo = 0;
        //Mientras no se salga de los límites del arreglo
        while (posicionActualEnElArreglo < datos.length) {
            //Comparar el elemento en la posición actual con el elemento a buscar.
            if (datos[posicionActualEnElArreglo] == elementoABuscar) {
                //En caso de ser iguales, regresar true.
                return true;
            }
            //Se incrementa la posición actual.
            posicionActualEnElArreglo++;
        }
        //Si se ha terminado de recorrer el arreglo sin encontrarlo, se regresa falso.
        return false;
    }

    /**
     * Método que realiza una búsqueda binaria sobre un conjunto de datos.
     * Sólo funciona si los datos están ordenados.
     *
     * @param datos           que es el conjunto de datos sobre el cual buscar.
     * @param elementoABuscar que es el elemento a buscar.
     * @return true en caso de haber encontrado el elemento.
     **/
    public static boolean busquedaBinaria(int[] datos, int elementoABuscar) {
        //Variable que contendrá el índice inferior actual.
        int limiteInferior = 0;
        //Variable que contendrá el límite superior actual.
        int limiteSuperior = datos.length - 1;
        //Variable que contendrá la posición actual para la búsqueda.
        int posicionActualEnElArreglo;
        //Mientras el índice inferior sea menor al superior
        while (limiteInferior <= limiteSuperior) {
            //Se cambia la posición actual a la mitad del arreglo.
            posicionActualEnElArreglo = (limiteInferior + limiteSuperior) / 2;
            //Si el elemento ha sido encontrado, se regresa true.
            if (datos[posicionActualEnElArreglo] == elementoABuscar)
                return true;
                //Si el elemento en dicha posición es menor al elemento buscado
            else if (datos[posicionActualEnElArreglo] < elementoABuscar) {
                //Se incrementa el límite inferior.
                limiteInferior = posicionActualEnElArreglo + 1;
            } else {
                //Se reduce el límite superior.
                limiteSuperior = posicionActualEnElArreglo - 1;
            }
        }
        //En caso de haber terminado de recorrer el arreglo sin encontrar
        //el elemento, se regresa false.
        return false;
    }

    /**
     * Método que realiza una búsqueda por hash en un conjunto de datos ordenados.
     **/
    public static boolean busquedaHash(int[] datos, int elementoABuscar) {
        //Aquí se hace el procedimiento para la búsqueda hash.
        return false;
    }
}