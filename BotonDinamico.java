import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonDinamico extends JFrame implements ActionListener {

    JButton miBoton;
    JLabel etiqueta; // Agregamos una etiqueta para mostrar/ocultar
    boolean estadoEtiqueta = true; // Controla el estado de la etiqueta

    public BotonDinamico() {
        // Configuración de la ventana
        super("Ejemplo de Botón Dinámico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 1. Crear el botón
        miBoton = new JButton("Haz Clic");
        miBoton.addActionListener(this); // Añade el listener al botón

        // 2. Crear una etiqueta para mostrar/ocultar
        etiqueta = new JLabel("Este texto se puede mostrar/ocultar.");
        etiqueta.setVisible(true); // Inicialmente visible

        // Añadir los componentes a la ventana
        add(miBoton);
        add(etiqueta);

        // Empaquetar y hacer visible la ventana
        pack();
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miBoton) {
            // ----- Acción 1: Cambiar el color del botón -----
            Color colorAleatorio = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            miBoton.setBackground(colorAleatorio);
            miBoton.setForeground(Color.WHITE); // Para que el texto sea visible en fondos oscuros

            // ----- Acción 2: Mostrar una alerta personalizada -----
            JOptionPane.showMessageDialog(this,
                    "¡El botón fue clicado!", // Mensaje
                    "Alerta Personalizada",   // Título de la alerta
                    JOptionPane.INFORMATION_MESSAGE); // Icono

            // ----- Acción 3: Mostrar/ocultar la etiqueta -----
            estadoEtiqueta = !estadoEtiqueta; // Invierte el estado
            etiqueta.setVisible(estadoEtiqueta);
            pack(); // Repackear para ajustar el tamaño de la ventana a la nueva visibilidad de la etiqueta
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BotonDinamico();
            }
        });
    }
}

