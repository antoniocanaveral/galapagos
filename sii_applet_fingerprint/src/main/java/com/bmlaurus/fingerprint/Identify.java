package com.bmlaurus.fingerprint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by acanaveral on 19/8/16.
 */
public class Identify extends JApplet {
    private JTextField txtCedula;
    private JButton btnBuscar;
    private JButton btnCapturar;
    private JButton btnEnroll;
    private Canvas cbHuella;
    private JLabel lblCedula;
    private JPanel pnlCanvas;
    private JTextArea textArea1;

    private void createUIComponents() {
        // TODO: place custom component creation code here

        cbHuella = new Canvas(); //134*149
        cbHuella.setBounds(0,0,134,149);
        cbHuella.setBackground(new java.awt.Color(255, 255, 255));
        pnlCanvas.add(cbHuella);
    }
}
