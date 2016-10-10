package topicos;
import java.util.InputMismatchException;
import java.util.Scanner;
/** Created on 06/10/2016. **/
public class TorresDeHanoi {
    /** Método main. Se encarga de mostrar al usuario las instrucciones y colectar la cantidad de discos que se usará en el programa.
     * Llama al método Hanoi y le envía la cantidad de discos que debe usar, además del método de solución.
     * Si la excepción IllegalArgumentException es atrapada, la cantidad que introdujo el usuario no es válida.
     * Si la excepción InputMismatchException es atrapada, el usuario introdujo valores de tipo incorrecto.**/
    public static void main(String[] args) {
        int cantidad, opcion; //Declarar variables.
        cantidad = 0; //Inicializar variable cantidad
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.println("Torres de Hanoi.");
        System.out.println("Para jugar, sólo necesito la cantidad de discos. Debe ser al menos 2.");
        do { //Menú para elegir el método de resolución.
            System.out.println("¿De qué forma quieres que lo resuelva?");
            System.out.println("1. Recursiva        2. Iterativa");
            opcion = entrada.nextInt();
        } while (opcion != 1 && opcion != 2); //Pedir al menos una vez o hasta obtener una opción correcta.
        do { //En caso de recibir un parámetro incorrecto, debe seguir pidiendo el valor.
            try { //El método Hanoi lanza excepciones, hay que estar preparados para atraparlas.
                System.out.print("¿Cuántos discos usaré? "); //Pidiendo al usuario la cantidad de discos.
                cantidad = entrada.nextInt(); // Almacenando la cantidad de discos.
                Hanoi(cantidad, opcion);//Llamada al método Hanoi.
            } catch (IllegalArgumentException e) { //La excepción IllegalArgumentException es atrapada.
                System.out.print("Necesito al menos dos discos para trabajar. ");
            } catch (InputMismatchException e) { //La excepción InputMismatchException es atrapada.
                System.out.print("Necesito un valor entero.");
                return; //Terminar el método main para evitar más errores.
            } catch (Exception e) { //Cualquier otra excepción es atrapada.
                System.out.println("Error desconocido: " + e);
                return; //Terminar el método main para evitar más errores.
            }
        } while (cantidad < 2); //La cantidad se seguirá pidiendo mientras se reciba una inválida.
    }

    /** Método que recibe la cantidad de discos con los que se plantea resolver.
     * Recibe además el método con que se desea resolver, ya sea recursividad o iteratividad.
     * Llama al método recursivo en caso de que el número sea valido.
     * Si la cantidad es insuficiente (menor a dos) lanzará una excepción del tipo IllegalArgumentsException.
     * En caso de recibir una letra o algún valor que no sea del tipo int, lanzará la excepción InputMismatchException. **/
    private static  void Hanoi(int cantidad, int metodo) throws Exception {
        if (cantidad >= 2) {
            if (metodo == 1) { //Cuando el usuario elige el modo recursivo.
                System.out.println("Modo recursivo.");
                System.out.println("Los movimientos a realizar son: ");
                int columna1 = 1; //Aquí es donde están todos los discos al inicio.
                int columna2 = 2; //Esta es la columna auxiliar que se utilizará para mover los discos.
                int columna3 = 3; //Esta es la columna de destino, a donde se planea mover los discos.
                hanoiRecursivo(cantidad, columna1, columna2, columna3); //Método recursivo.
                System.out.println("Usando esos movimientos, podrás resolverlo. ;) ");
                return;
            } else if (metodo == 2) { //Cuando el usuario elige el modo iterativo.
                System.out.println("Modo iterativo.");
                //hanoiIterativo();
            }
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
    private static void hanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) { //Caso base
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
        }
        else { //Caso recursivo
            hanoiRecursivo(n - 1, origen, destino, auxiliar);
            //Llamar al método recursivo con exactamente la misma información, sólo que con un disco debajo en el origen.
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
            //Muestra en un mensaje hacia donde moverá el disco dependiendo de los paramtetros dados.
            hanoiRecursivo(n - 1, auxiliar, origen, destino);
            //Llamar al método recursivo diciéndole que mueva el disco inferior de la columna auxiliar a la tercera.
        }
    }
}