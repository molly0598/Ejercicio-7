import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppComparadorNumeros extends JFrame {
    private JTextField campoNum1;
    private JTextField campoNum2;
    private JLabel etiquetaResultado;

    public AppComparadorNumeros() {
        setTitle("Comparador de Números");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel etiquetaNum1 = new JLabel("Número 1:");
        campoNum1 = new JTextField();
        JLabel etiquetaNum2 = new JLabel("Número 2:");
        campoNum2 = new JTextField();
        JButton botonComparar = new JButton("Comparar");
        etiquetaResultado = new JLabel("", SwingConstants.CENTER);

        botonComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    double num1 = Double.parseDouble(campoNum1.getText());
                    double num2 = Double.parseDouble(campoNum2.getText());
                    String resultado = NumeroComparator.comparar(num1, num2);
                    etiquetaResultado.setText(resultado);
                } catch (NumberFormatException excepcion) {
                    etiquetaResultado.setText("Por favor, ingresa valores numéricos válidos.");
                }
            }
        });

        botonComparar.setPreferredSize(new Dimension(120, 40));
        botonComparar.setBackground(Color.BLUE);
        botonComparar.setForeground(Color.WHITE);

        panelPrincipal.add(etiquetaNum1);
        panelPrincipal.add(campoNum1);
        panelPrincipal.add(etiquetaNum2);
        panelPrincipal.add(campoNum2);
        panelPrincipal.add(botonComparar);
        panelPrincipal.add(etiquetaResultado);

        add(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AppComparadorNumeros();
        });
    }
}