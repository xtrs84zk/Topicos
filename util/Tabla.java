package util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created on 29/11/2016
 **/
public class Tabla extends JFrame {

    /**
     * La clase JFrame utiliza serialización, por ende debe ser implementada
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor para la clase Tabla que inicializa los valores
     * con parámetros dados.
     *
     * @param titulosDeLasColumnas un conjunto de títulos.
     * @param contenidoDeLaTabla   que serán las celdas de la tabla.
     * @param tituloDeLaVentana    que es el titulo que se asignará a la ventana.
     */
    public Tabla(Object[][] contenidoDeLaTabla, String[] titulosDeLasColumnas, String tituloDeLaVentana) {
        //Se llama al constructor de JFrame para darle un título a la ventana.
        super(tituloDeLaVentana);
        //Creando un modelo de tabla en base a uno predefinido.
        DefaultTableModel modeloDeTablaConPlantilla = new DefaultTableModel(contenidoDeLaTabla, titulosDeLasColumnas) {
            /** La clase JFrame utiliza serialización, por ende debe ser implementada. **/
            private static final long serialVersionUID = 1L;

            /** Haciendo que la tabla no sea editable.**/
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        //Creando la tabla con el modelo
        final JTable table = new JTable(modeloDeTablaConPlantilla);
        //Definiendo el tamaño de la tabla.
        table.setPreferredScrollableViewportSize(new Dimension(400, 100));

        //Creando deslizadores vertical y horizontal (en caso de ser necesarios)
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Hacer aparecer el deslizador horizontal.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();

        //Agregándolo al panel.
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        //Manage the output using WindowsAdapter. When closed the table, display the averages
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //La ventana ha sido cerrada.
            }
        });
    }
}

