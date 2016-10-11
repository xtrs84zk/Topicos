package topicos;

import java.util.Stack;

public class HanoiIterativo {

    private Stack columnas[];

    // Constructor para el total de aros
    public HanoiIterativo(int aros) {
        columnas = new Stack[3];
        // Se inicializan las columnas vacias
        columnas[0] = new Stack();
        columnas[1] = new Stack();
        columnas[2] = new Stack();
        // Colocamos en la primera las fichas, de mayor a menor
        for (int i=aros;i>0;i--) columnas[0].push(i);
    }

    // Muestra el estado actual
    public void Mostrar() {
        for (int i=0;i<3;i++) {
            System.out.print("Col. "+i+": ");
            System.out.println("");
        }
    }

    // Mueve de la columna origen a la columna destino 1 disco
    public void Mover(int origen, int destino) {
        // Mostramos en pantalla lo que hacemos
        Mostrar();
        System.out.println("Movemos desde ("+origen+") hasta ("+destino+")");
        System.out.println("");
        // Y luego, lo hacemos, claro
        columnas[destino].push(columnas[origen].pop());
    }
}