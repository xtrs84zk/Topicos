package Ordenamiento;
import java.util.Random;

/** Created by xtrs84zk on 03/11/2016. **/
public class generadorDeDatos {
    private generadorDeDatos(){
    }
    /**Método bestCase que regresa el mejor caso de ordenamiento posible.
     * @param longitud que es la longitud requerida del conjunto de datos.
     * @return mejorCasoDeOrdenamiento que es un conjunto ordenado de datos.**/
    public static int[] bestCase(int longitud){
        //Se crea el conjunto que contendrá el mejor caso de ordenamiento.
        int[] mejorCasoDeOrdenamiento = new int[longitud];
        //Se llena el conjunto con valores ordenados (en forma ascendiente).
        for(int i = 0; i<longitud; i++) mejorCasoDeOrdenamiento[i] = (i + 1);
        //Se regresa el conjunto creado.
        return mejorCasoDeOrdenamiento;
    }
    /** Método worstCase que genera el peor caso de ordenamiento posible.
     * @param longitud que es la longitud de los datos requerida. **/
    public static int[] worstCase(int longitud){
        //Se crea el conjunto que contendrá el peor caso de ordenamiento.
        int[] peorCasoDeOrdenamiento = new int[longitud];
        //Se llena el conjunto con valores sin ordenar (en forma ascendiente).
        for(int i = 0; i<longitud; i++){
            peorCasoDeOrdenamiento[i] = longitud-i;
        }
        //Se regresa el conjunto creado.
        return peorCasoDeOrdenamiento;
    }
    /** Método mixedCase que se encarga de crear un arreglo de enteros con
     * un porcentaje de ordenación dado por el usuario. El resto del arreglo
     * será llenado con valores aleatorios.
     * @param longitud que es la longitud total que tendrán los datos.
     * @param porcentaje que es el porcentaje de ordenamiento que tendrán los datos.
     * @return mixedCase que es un arreglo de enteros parcialmente ordenado.**/
    public static int[] mixedCase(int longitud, int porcentaje) throws Exception{
        //En caso de que la probabilidad recibida sea 0, se regresa el peor caso.
        if(porcentaje == 0) return worstCase(longitud);
        //En caso de que la probabilidad recibida sea 100, se regresa el mejor caso.
        if(porcentaje == 100) return bestCase(longitud);
        //En caso de que el porcentaje recibido sea inútil para la operacion, se lanza una excepcion.
        if(porcentaje<1 || porcentaje>100) throw new Exception("El porcentaje dado no es válido.");
        //Se crea el objeto Random con nombre aleatorio.
        Random aleatorio = new Random();
        //Se define la cantidad de elementos en el conjunto que estarán ordenados
        int cantidadDeElementosQueEstaranOrdenados = (longitud*(porcentaje/100));
        //Se declara e inicializa el conjunto con el mejor caso.
        int[] bestCase = bestCase(cantidadDeElementosQueEstaranOrdenados);
        //Se crea el conjunto del caso mixto.
        int[] mixedCase = new int[longitud];
        //Se copian la cantidad de valores ordenados del mejor caso al caso mixto.
        System.arraycopy(bestCase, 0, mixedCase, 0, bestCase.length-1);
        //Se llena el resto del arreglo con valores generados aleatorioamente.
        for(int i = cantidadDeElementosQueEstaranOrdenados+1; i<longitud; i++){
            mixedCase[i] = aleatorio.nextInt();
        }
        //Finalmente se regresa el conjunto creado.
        return mixedCase;
    }

    public static int[] randomCase(int longitud) throws Exception{
        int[] casoAleatorio = new int[0];
        if(longitud>0){
            casoAleatorio = new int[longitud];
        } else {
            throw new Exception("La longitud es menor a uno.");
        }
        return casoAleatorio;
    }
}
