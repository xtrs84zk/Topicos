package aplicacion;

import java.util.Scanner;

/** Created by xtrs84zk on 06/10/2016. **/
public class TorresDeHanoi {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Cuántos discos usaré? ");
        int n = entrada.nextInt();
        System.out.println("Movimientos:");
        Hanoi(n);
    }

    private static void Hanoi(int n){
        if(n >= 0) {
            int origen = 1;
            int auxiliar = 2;
            int destino = 3;
            HanoiRecursivo(n, origen, auxiliar, destino);
            return;
        }
        System.out.println( "El número tiene que ser al menos cero.");

    }
    private static void HanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) {
            System.out.println("mover disco de " + origen + " a " + destino);
            return;
        }
        else {
            HanoiRecursivo(n - 1, origen, destino, auxiliar);
            System.out.println("mover disco de " + origen + " a " + destino);
            HanoiRecursivo(n - 1, auxiliar, origen, destino);
        }
    }
}
