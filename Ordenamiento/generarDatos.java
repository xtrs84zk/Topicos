package Ordenamiento;
import javax.swing.*;
import java.util.Random;

/** Created by Javier Sánchez on 03/11/2016. **/
public class generarDatos {
    private generarDatos(){
        //Constructor privado para que no se puedan crear objetos de esta clase.
    }
    /**Método bestCase que regresa el mejor caso de ordenamiento posible.
     * @param datos que es el conjunto de datos.**/
    public static void bestCase(int [] datos){
        //Se llena el conjunto con valores ordenados (en forma ascendiente).
        for(int i = 0; i<datos.length; i++) datos[i] = (i + 1);
    }

    /** Método worstCase que genera el peor caso de ordenamiento posible.
     * @param datos que son los datos requerida. **/
    public static void worstCase(int [] datos){
        //Se llena el conjunto con valores sin ordenar (en forma ascendiente).
        for(int i = 0; i<datos.length; i++) datos[i] = datos.length - i;
    }
    /** Método mixedCase que se encarga de crear un arreglo de enteros con
     * un porcentaje de ordenación dado por el usuario. El resto del arreglo
     * será llenado con valores aleatorios.
     * @param datos que es el conjunto total de datos.
     * @param porcentaje que es el porcentaje de ordenamiento que tendrán los datos.**/
    public static void mixedCase(int [] datos, int porcentaje) throws Exception{
        //En caso de que el porcentaje recibido sea inútil para la operacion, se lanza una excepcion.
        if(porcentaje<1 || porcentaje>100) throw new Exception("El porcentaje dado no es válido.");
        //Se crea el objeto Random con nombre aleatorio.
        Random aleatorio = new Random();
        //Se copian la cantidad de valores ordenados del mejor caso al caso mixto.
        int datosOrdenados = (datos.length*(porcentaje/100));
        //Se llena el resto del arreglo con valores generados aleatoriamente.
        for(int i = datosOrdenados+1; i<datos.length; i++){
            datos[i] = aleatorio.nextInt();
        }
        //Llenando la parte ordenada del arreglo.
        for(int j = 0; j<datosOrdenados; j++) datos[j] = j + 1;
    }
    /** Caso randomCase que regresa un arreglo aleatoriamente ordenado.+
     * @param datos que es conjunto de valores.**/
    public static void randomCase(int [] datos) throws Exception{
        //Se crea e inicializa un objeto de tipo Random llamado aleatorio.
        Random aleatorio = new Random();
        //Se crean e inicializan los conjuntos del caso aleatorio, mejor y peor caso
        //En caso de que la longitud recibida sea mayor a 0, se procede
        if(datos.length>0){
            datos = new int[datos.length];
            for(int i = 0; i<datos.length; i++){
                if(aleatorio.nextInt(1) == 0){
                    //en caso de que el aleatorio regrese un 1, se pone un valor ordenado.
                    datos[i] = i+1;
                } else { //En caso de recibir otro valor (un cero) se pone un valor sin ordenar.
                    datos[i] = datos.length-i;
                }
            }
            //En caso de recibir una longitud inválida, se lanza una excepción.
        } else {
            throw new Exception("La longitud es menor a uno.");
        }
    }
}