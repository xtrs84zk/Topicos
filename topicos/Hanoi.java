package aplicacion.Topicos;

/** Created on 09/10/2016. **/
public class Hanoi {
    /** Método que recibe la cantidad de discos con los que se plantea resolver.
     * Llama al método recursivo en caso de que el número sea valido.
     * Si la cantidad es insuficiente (menor a dos) lanzará una excepción del tipo IllegalArgumentsException.
     * En caso de recibir una letra o algún valor que no sea del tipo int, lanzará la excepción InputMismatchException. **/
    public void Hanoi(int cantidad) throws Exception{
        if(cantidad >= 2) {
            System.out.println("Los movimientos a realizar son: ");
            int columna1 = 1; //Aquí es donde están todos los discos al inicio.
            int columna2 = 2; //Esta es la columna auxiliar que se utilizará para mover los discos.
            int columna3 = 3; //Esta es la columna de destino, a donde se planea mover los discos.
            HanoiRecursivo(cantidad, columna1, columna2, columna3); //Método recursivo.
            System.out.println("Usando esos movimientos, podrás resolverlo. ;) ");
            return;
        }
        //En caso de que la cantidad no cumpla los requisitos, se lanzará una excepción
        throw new IllegalArgumentException("El usuario introdujo una cantidad menor a dos.");
    }
    /** Método recursivo encargado de mostrar los movimientos necesarios para
     * resolver "las torres de Hanoi" con el número de discos recibido.
     * Se mueve el disco siguiendo la lógica: columna actual () hacia la pila de destino.
     * Haber llamado al método recursivo decrementando el número de disco asegura que, al final,
     * llegará al caso base; esto es, que habrá sólo un disco que mover cada vez.
     * Los discos pares se mueven en una dirección, los impares en otra.
     * Recibe el número de discos, la pila de origen, la  pila auxiliar y la pila de destino.**/
    private void HanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) { //Caso base
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
        }
        else { //Caso recursivo
            HanoiRecursivo(n - 1, origen, destino, auxiliar);
            //Llamar al método recursivo con exactamente la misma información, sólo que con un disco debajo en el origen.
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
            //Muestra en un mensaje hacia donde moverá el disco dependiendo de los paramtetros dados.
            HanoiRecursivo(n - 1, auxiliar, origen, destino);
            //Llamar al método recursivo diciéndole que mueva el disco inferior de la columna auxiliar a la tercera.
        }
    }
}
