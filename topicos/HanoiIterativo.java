package topicos;
import java.util.Stack;
/** Created on 09/10/2016 **/
public class HanoiIterativo {
    //Declarar variables e inicializar objetos.
    // Pila que "emula" las llamadas recursivas.
    private static Stack pilaDeMovimientos = new Stack();
    // Variable del movimiento actual. Es de tipo long para soportar valores que un int no soportaría.
    private static long movimientoActual;
    // Método que imprime los movimientos de un disco.

    /** Constructor para la clase HanoiIterativo.
     * Llama al método "resolverHanoi" con la cantidad de discos a usar. **/
    public HanoiIterativo(int cantidadDeDiscos) {
        if(cantidadDeDiscos>=1) resolverHanoi(cantidadDeDiscos);
    }

    /** Método que implementa el algoritmo de Hanoi iterativo.
     * Recibe la cantidad de discos enviada por el constructor.**/
    private static void resolverHanoi(int cantidadDeDiscos) {

        int origen = 1; // pila de origen
        int destino = 3; // pila de  destino
        int auxiliar = 2; // pila auxiliar

        //Guardando los datos del movimiento en la variable datosDelMovimientoActual.
        String datosDelMovimientoActual = cantidadDeDiscos + "," + origen + "," + destino + "," + auxiliar;

        pilaDeMovimientos.push(datosDelMovimientoActual);

        // El juego puede continuar mientras la pila de discos no esté vacía.
        while (!pilaDeMovimientos.empty()) {

            // quando cantidadDeDiscos > 1, devemos empilhar um novo comando
            if (cantidadDeDiscos > 1) {

                // Decrementando la cantidad de discos (el disco a mover)
                cantidadDeDiscos--;
                //Se divide la expresión "datosDelMovimiento" para obtener origen, destino y auxiliar.
                String[] datosDelMovimiento = datosDelMovimientoActual.split(",");
                origen = Integer.parseInt(datosDelMovimiento[1]);
                destino = Integer.parseInt(datosDelMovimiento[2]);
                auxiliar = Integer.parseInt(datosDelMovimiento[3]);

                // isto seria uma chamada recursiva...
                datosDelMovimientoActual = cantidadDeDiscos + "," + origen + "," + auxiliar + "," + destino;

                // empilha o novo comando
                pilaDeMovimientos.push(datosDelMovimientoActual);

                // caso contrário, devemos desempilhar
                // e executar um movimento
            } else {

                //desempilha um comando
                datosDelMovimientoActual = (String) pilaDeMovimientos.pop();

                //Se divide la expresión "datosDelMovimiento" para obtener origen, destino y auxiliar.
                String[] datosDelMovimiento = datosDelMovimientoActual.split(",");
                //Se asigna a cada variable su valor.
                cantidadDeDiscos = Integer.parseInt(datosDelMovimiento[0]);
                origen = Integer.parseInt(datosDelMovimiento[1]);
                destino = Integer.parseInt(datosDelMovimiento[2]);
                auxiliar = Integer.parseInt(datosDelMovimiento[3]);

                //Llamada al método mover
                mover(origen, destino);

                // Si la cantidad de discos es mayor a 1, se mete a la pila un comando después del movimiento.
                if (cantidadDeDiscos > 1) {
                    cantidadDeDiscos--; //Se decrementa la cantidad de discos.
                    // Se agrupan los datos del movimiento y se meten a la pila.
                    datosDelMovimientoActual = cantidadDeDiscos + "," + auxiliar + "," + destino + "," + origen;
                    pilaDeMovimientos.push(datosDelMovimientoActual);
                }

            }

        }

    }
    /**Método que realiza los movimientos imprimiendo desde y hacia donde se moverá el disco
     * Recibe los parámetros origen y destino.
     * No tiene retorno. **/
    private static void mover(int origen, int destino) {
        //Se incrementa el número de movimiento actual.
        movimientoActual++;
        //Se hace (imprime) el movimiento.
        System.out.println("Movimiento " +movimientoActual + ": Mueve el  disco desde " + origen + " hacia " + destino +  ".");
    }
}