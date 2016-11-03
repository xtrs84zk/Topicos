package Ordenamiento;

import java.util.Random;

/** Created by xtrs84zk on 03/11/2016. **/
class Generador {
    private Generador(){
    }
    public static int[] bestCase(int longitud){
        int[] mejorCasoDeOrdenamiento = new int[longitud];
        for(int i = 0; i<longitud; i++){
            mejorCasoDeOrdenamiento[i] = (i+1);
        }
        return mejorCasoDeOrdenamiento;
    }

    public static int[] worstCase(int longitud){
        int[] peorCasoDeOrdenamiento = new int[longitud];
        for(int i = 0; i<longitud; i++){
            peorCasoDeOrdenamiento[i] = longitud-i;
        }
        return peorCasoDeOrdenamiento;
    }

    public static int[] randomCase(int longitud, int porcentaje) throws Exception{
        if(porcentaje<1 || porcentaje>100){
            throw new Exception("El porcentaje dado no es válido.");
        }
        int[] casoAleatorio = new int[longitud];
        Random aleatorio = new Random();
        int[] bestCase = bestCase(longitud);
        int[] worstCase = worstCase(longitud);
        for(int i = 0; i<longitud; i++){
            int random = aleatorio.nextInt(100);
            if(random <= porcentaje){
                casoAleatorio[i] = bestCase[i];
            } else {
                casoAleatorio[i] = worstCase[i];
            }
        }
        return casoAleatorio;
    }
}
