package com.nati;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAgenda ventana = new VentanaAgenda();
            ventana.setVisible(true);
        });
    }
}