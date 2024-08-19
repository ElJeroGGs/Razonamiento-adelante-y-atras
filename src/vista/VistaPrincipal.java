package vista;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import control.ControlPrincipal;

import javax.swing.JScrollPane;
import modelo.Regla;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class VistaPrincipal extends JFrame implements ActionListener, ItemListener {

    private int selectedCount = 0;
    private static final int MAX_SELECTIONS = 3;

    ControlPrincipal ctrl;
    JTextPane MarcoRazonamientoAdelante;
    JTextPane MarcoRazonamientoAtras;
    ButtonGroup grupoObjetivos;

    JLabel Objetivo1 = new JLabel();
    JLabel Objetivo2 = new JLabel();

    JCheckBox HechosCheck1 = new JCheckBox("H1");
    JCheckBox HechosCheck2 = new JCheckBox("H2");
    JCheckBox HechosCheck3 = new JCheckBox("H3");
    JCheckBox HechosCheck4 = new JCheckBox("H4");
    JCheckBox HechosCheck5 = new JCheckBox("H5");
    JCheckBox HechosCheck6 = new JCheckBox("H6");
    JCheckBox HechosCheck7 = new JCheckBox("H7");
    JCheckBox HechosCheck8 = new JCheckBox("H8");
    JCheckBox HechosCheck9 = new JCheckBox("H9");

    JCheckBox[] checkBoxes = new JCheckBox[] {
            HechosCheck1, HechosCheck2, HechosCheck3, HechosCheck4, HechosCheck5, HechosCheck6, HechosCheck7,
            HechosCheck8, HechosCheck9
    };

    public void setCtrl(ControlPrincipal ctrl) {

        this.ctrl = ctrl;
    }

    public VistaPrincipal(Regla[] reglas) {
        this.setTitle("Razonamiento adelante y atrás");
        this.setSize(1800, 1000);
        this.setLayout(null);

        // Etiqueta de Conjunto de reglas
        JLabel ConjuntoReglas = new JLabel("Conjunto de reglas");
        ConjuntoReglas.setBounds(10, 10, 300, 50);
        ConjuntoReglas.setLocation(50, 10);
        ConjuntoReglas.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(ConjuntoReglas);

        // Marco de Reglas
        JEditorPane MarcoHechos = new JEditorPane();
        MarcoHechos.setBounds(10, 50, 450, 370);
        MarcoHechos.setLocation(50, 50);
        MarcoHechos.setFont(new java.awt.Font("Arial", 0, 30));

        for (int i = 0; i < reglas.length; i++) {

            int subindice = reglas[i].getSubindice();
            String[] condiciones = reglas[i].getCondiciones();
            String conclusion = reglas[i].getConclusion();

            MarcoHechos.setText(MarcoHechos.getText() + "R" + subindice + ": ");

            for (int j = 0; j < condiciones.length; j++) {
                MarcoHechos.setText(MarcoHechos.getText() + condiciones[j] + " y ");
            }
            MarcoHechos.setText(MarcoHechos.getText() + "entonces " + conclusion + "\n");

        }

        MarcoHechos.setEditable(false);
        this.add(MarcoHechos);
        // Etiqueta Datos de Entrada
        JLabel DatosEntrada = new JLabel("Datos de entrada");
        DatosEntrada.setBounds(10, 10, 200, 30);
        DatosEntrada.setLocation(850, 10);
        DatosEntrada.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(DatosEntrada);
        // Etiqueta Hechos
        JLabel Hechos = new JLabel("Hechos");
        Hechos.setBounds(10, 10, 200, 30);
        Hechos.setLocation(700, 40);
        Hechos.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(Hechos);
        // Etiqueta Objetivo
        JLabel Objetivo = new JLabel("Objetivo");
        Objetivo.setBounds(10, 10, 200, 30);
        Objetivo.setLocation(1100, 40);
        Objetivo.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(Objetivo);
        // Check Boxes de Hechos

        HechosCheck1.setBounds(10, 10, 200, 30);
        HechosCheck1.setLocation(700, 70);
        HechosCheck1.setText("H1");
        HechosCheck1.setActionCommand("H1");
        HechosCheck1.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck2.setBounds(10, 10, 200, 30);
        HechosCheck2.setLocation(700, 110);
        HechosCheck2.setText("H2");
        HechosCheck2.setActionCommand("H2");
        HechosCheck2.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck3.setBounds(10, 10, 200, 30);
        HechosCheck3.setLocation(700, 150);
        HechosCheck3.setText("H3");
        HechosCheck3.setActionCommand("H3");
        HechosCheck3.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck4.setBounds(10, 10, 200, 30);
        HechosCheck4.setLocation(700, 190);
        HechosCheck4.setText("H4");
        HechosCheck4.setActionCommand("H4");
        HechosCheck4.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck5.setBounds(10, 10, 200, 30);
        HechosCheck5.setLocation(700, 230);
        HechosCheck5.setText("H5");
        HechosCheck5.setActionCommand("H5");
        HechosCheck5.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck6.setBounds(10, 10, 200, 30);
        HechosCheck6.setLocation(700, 270);
        HechosCheck6.setText("H6");
        HechosCheck6.setActionCommand("H6");
        HechosCheck6.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck7.setBounds(10, 10, 200, 30);
        HechosCheck7.setLocation(700, 310);
        HechosCheck7.setText("H7");
        HechosCheck7.setActionCommand("H7");
        HechosCheck7.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck8.setBounds(10, 10, 200, 30);
        HechosCheck8.setLocation(700, 350);
        HechosCheck8.setText("H8");
        HechosCheck8.setActionCommand("H8");
        HechosCheck8.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck9.setBounds(10, 10, 200, 30);
        HechosCheck9.setLocation(700, 390);
        HechosCheck9.setText("H9");
        HechosCheck9.setActionCommand("H9");
        HechosCheck9.setFont(new java.awt.Font("Arial", 0, 25));

        HechosCheck1.addItemListener(this);
        HechosCheck2.addItemListener(this);
        HechosCheck3.addItemListener(this);
        HechosCheck4.addItemListener(this);
        HechosCheck5.addItemListener(this);
        HechosCheck6.addItemListener(this);
        HechosCheck7.addItemListener(this);
        HechosCheck8.addItemListener(this);
        HechosCheck9.addItemListener(this);

        this.add(HechosCheck1);
        this.add(HechosCheck2);
        this.add(HechosCheck3);
        this.add(HechosCheck4);
        this.add(HechosCheck5);
        this.add(HechosCheck6);
        this.add(HechosCheck7);
        this.add(HechosCheck8);
        this.add(HechosCheck9);

        // Radio Buttons de Objetivo

        JRadioButton ObjetivoRadioButton1 = new JRadioButton();
        ObjetivoRadioButton1.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton1.setLocation(1100, 70);
        ObjetivoRadioButton1.setText("H1");
        ObjetivoRadioButton1.setActionCommand("H1");
        ObjetivoRadioButton1.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton2 = new JRadioButton();
        ObjetivoRadioButton2.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton2.setLocation(1100, 110);
        ObjetivoRadioButton2.setText("H2");
        ObjetivoRadioButton2.setActionCommand("H2");
        ObjetivoRadioButton2.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton3 = new JRadioButton();
        ObjetivoRadioButton3.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton3.setLocation(1100, 150);
        ObjetivoRadioButton3.setText("H3");
        ObjetivoRadioButton3.setActionCommand("H3");
        ObjetivoRadioButton3.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton4 = new JRadioButton();
        ObjetivoRadioButton4.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton4.setLocation(1100, 190);
        ObjetivoRadioButton4.setText("H4");
        ObjetivoRadioButton4.setActionCommand("H4");
        ObjetivoRadioButton4.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton5 = new JRadioButton();
        ObjetivoRadioButton5.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton5.setLocation(1100, 230);
        ObjetivoRadioButton5.setText("H5");
        ObjetivoRadioButton5.setActionCommand("H5");
        ObjetivoRadioButton5.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton6 = new JRadioButton();
        ObjetivoRadioButton6.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton6.setLocation(1100, 270);
        ObjetivoRadioButton6.setText("H6");
        ObjetivoRadioButton6.setActionCommand("H6");
        ObjetivoRadioButton6.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton7 = new JRadioButton();
        ObjetivoRadioButton7.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton7.setLocation(1100, 310);
        ObjetivoRadioButton7.setText("H7");
        ObjetivoRadioButton7.setActionCommand("H7");
        ObjetivoRadioButton7.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton8 = new JRadioButton();
        ObjetivoRadioButton8.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton8.setLocation(1100, 350);
        ObjetivoRadioButton8.setText("H8");
        ObjetivoRadioButton8.setActionCommand("H8");
        ObjetivoRadioButton8.setFont(new java.awt.Font("Arial", 0, 25));

        JRadioButton ObjetivoRadioButton9 = new JRadioButton();
        ObjetivoRadioButton9.setBounds(10, 10, 200, 30);
        ObjetivoRadioButton9.setLocation(1100, 390);
        ObjetivoRadioButton9.setText("H9");
        ObjetivoRadioButton9.setActionCommand("H9");
        ObjetivoRadioButton9.setFont(new java.awt.Font("Arial", 0, 25));

        this.add(ObjetivoRadioButton1);
        this.add(ObjetivoRadioButton2);
        this.add(ObjetivoRadioButton3);
        this.add(ObjetivoRadioButton4);
        this.add(ObjetivoRadioButton5);
        this.add(ObjetivoRadioButton6);
        this.add(ObjetivoRadioButton7);
        this.add(ObjetivoRadioButton8);
        this.add(ObjetivoRadioButton9);

        // ButtonGroup de Objetivos

        grupoObjetivos = new ButtonGroup();
        grupoObjetivos.add(ObjetivoRadioButton1);
        grupoObjetivos.add(ObjetivoRadioButton2);
        grupoObjetivos.add(ObjetivoRadioButton3);
        grupoObjetivos.add(ObjetivoRadioButton4);
        grupoObjetivos.add(ObjetivoRadioButton5);
        grupoObjetivos.add(ObjetivoRadioButton6);
        grupoObjetivos.add(ObjetivoRadioButton7);
        grupoObjetivos.add(ObjetivoRadioButton8);
        grupoObjetivos.add(ObjetivoRadioButton9);

        // JButton de Iniciar

        JButton Iniciar = new JButton();
        Iniciar.addActionListener(this);
        Iniciar.setText("Iniciar Procesos");
        Iniciar.setBounds(1300, 180, 340, 90);
        Iniciar.setFont(new java.awt.Font("Arial", 0, 25));

        this.add(Iniciar);

        // Etiqueta de Razonamiento hacia adelante
        JLabel RazonamientoAdelante = new JLabel("Razonamiento hacia adelante");
        RazonamientoAdelante.setBounds(150, 450, 350, 30);
        RazonamientoAdelante.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(RazonamientoAdelante);

        // Etiqueta de Razonamiento hacia atras
        JLabel RazonamientoAtras = new JLabel("Razonamiento hacia atrás");
        RazonamientoAtras.setBounds(950, 450, 350, 30);
        RazonamientoAtras.setFont(new java.awt.Font("Arial", 0, 25));
        this.add(RazonamientoAtras);

        // Marco de Razonamiento Hacia Adelante
        MarcoRazonamientoAdelante = new JTextPane();
        MarcoRazonamientoAdelante.setEditable(false);

        MarcoRazonamientoAdelante.setBounds(10, 50, 750, 370);
        MarcoRazonamientoAdelante.setLocation(20, 500);
        MarcoRazonamientoAdelante.setFont(new java.awt.Font("Arial", 0, 20));

        // Le agregamos un scroll

        JScrollPane ScrollAdelante = new JScrollPane(MarcoRazonamientoAdelante);
        ScrollAdelante.setBounds(60, 500, 750, 370);

        this.add(ScrollAdelante);

        // Marco de Razonamiento Hacia Atras

        MarcoRazonamientoAtras = new JTextPane();
        MarcoRazonamientoAtras.setEditable(false);
        MarcoRazonamientoAtras.setFont(new java.awt.Font("Arial", 0, 20));
      

        // Le agregamos un scroll

        JScrollPane ScrollAtras = new JScrollPane(MarcoRazonamientoAtras);
        ScrollAtras.setBounds(860, 500, 750, 370);

        this.add(ScrollAtras);

        // Agregamos etiqueta de Objetivos Cumplidos

        
        Objetivo1.setBounds(70, 900, 800, 50);
        Objetivo1.setFont(new java.awt.Font("Arial", 0, 50));

        this.add(Objetivo1);

        Objetivo2.setBounds(860, 900, 800, 50);
        Objetivo2.setFont(new java.awt.Font("Arial", 0, 50));

        this.add(Objetivo2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void PintaMarco(String texto, String marco, String Objetivo) {

        switch (marco) {
            case "Adelante":

                MarcoRazonamientoAdelante.setText(texto);
                Objetivo1.setText(Objetivo);


                break;

            case "Atras":
                MarcoRazonamientoAtras.setText(texto);
                Objetivo2.setText(Objetivo);

                break;
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ButtonModel selectedModel = grupoObjetivos.getSelection();
        String Objetivo = null;
        String[] hechos = null;

        // Obtener los JCheckBox seleccionados
        ArrayList<String> selectedHechos = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedHechos.add(checkBox.getText());
            }
        }

        if (selectedHechos.size() > 1) {
            hechos = selectedHechos.toArray(new String[0]);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos dos hechos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Obtener el objetivo seleccionado

        if (selectedModel != null) {
            Objetivo = selectedModel.getActionCommand();
        } else {

            JOptionPane.showMessageDialog(this, "Debes escoger un objetivo", "Error", JOptionPane.ERROR_MESSAGE);

        }

        if (Objetivo != null && hechos != null) {
            this.ctrl.IniciarProcesos(hechos, Objetivo);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            selectedCount++;
        } else {
            selectedCount--;
        }
        if (selectedCount >= MAX_SELECTIONS) {
            disableUncheckedBoxes();
        } else {
            enableAllBoxes();
        }

    }

    private void disableUncheckedBoxes() {
        if (!HechosCheck1.isSelected())
            HechosCheck1.setEnabled(false);
        if (!HechosCheck2.isSelected())
            HechosCheck2.setEnabled(false);
        if (!HechosCheck3.isSelected())
            HechosCheck3.setEnabled(false);
        if (!HechosCheck4.isSelected())
            HechosCheck4.setEnabled(false);
        if (!HechosCheck5.isSelected())
            HechosCheck5.setEnabled(false);
        if (!HechosCheck6.isSelected())
            HechosCheck6.setEnabled(false);
        if (!HechosCheck7.isSelected())
            HechosCheck7.setEnabled(false);
        if (!HechosCheck8.isSelected())
            HechosCheck8.setEnabled(false);
        if (!HechosCheck9.isSelected())
            HechosCheck9.setEnabled(false);
    }

    private void enableAllBoxes() {
        HechosCheck1.setEnabled(true);
        HechosCheck2.setEnabled(true);
        HechosCheck3.setEnabled(true);
        HechosCheck4.setEnabled(true);
        HechosCheck5.setEnabled(true);
        HechosCheck6.setEnabled(true);
        HechosCheck7.setEnabled(true);
        HechosCheck8.setEnabled(true);
        HechosCheck9.setEnabled(true);
    }
};
