package topicos;
import java.util.Stack;
/** Created on 09/10/2016 **/
public class HanoiIterativo {
    //Declarar variables e inicializar objetos.
    // Pila que "emula" las llamadas recursivas.
    private static Stack pilaDeMovimientos = new Stack();
    // Variable del movimiento actual. Es de tipo long para soportar valores que un int no soportaría.
    private static long movimientoActual;

    /** Constructor para la clase HanoiIterativo.
     * Llama al método "resolverHanoi" con la cantidad de discos a usar.
     * En caso de haber recibido una cantidad no válida, inicializará con dos.**/
    public HanoiIterativo(int cantidadDeDiscos) {
        if(cantidadDeDiscos>=1) resolverHanoi(cantidadDeDiscos);
        else resolverHanoi(2);
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
            if (cantidadDeDiscos > 1) {//Si la cantidad de discos es mayor a uno
                // Decrementando la cantidad de discos (el disco a mover)
                cantidadDeDiscos--;
                //Se divide la expresión "datosDelMovimiento" para obtener origen, destino y auxiliar.
                String[] datosDelMovimiento = datosDelMovimientoActual.split(",");
                origen = Integer.parseInt(datosDelMovimiento[1]);
                destino = Integer.parseInt(datosDelMovimiento[2]);
                auxiliar = Integer.parseInt(datosDelMovimiento[3]);
                //Se vuelve a agrupar, sólo que en diferente orden (como sería en una llamada recusiva)
                datosDelMovimientoActual = cantidadDeDiscos + "," + origen + "," + auxiliar + "," + destino;
                //Lo agrega a la pila
                pilaDeMovimientos.push(datosDelMovimientoActual);
            } else { //En caso de que no...
                //Se saca de la pila.
                datosDelMovimientoActual = (String) pilaDeMovimientos.pop(); //Parsing a String para almacenarlo.
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
        System.out.println("Movimiento " +movimientoActual + ": Mueve el  disco desde " +
                            origen + " hacia " + destino +  ".");
    }
}