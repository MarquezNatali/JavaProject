package com.nati;

import javax.swing.*;
import java.awt.*;

public class VentanaAgenda extends JFrame {

    private MateriaDAO materiaDAO = new MateriaDAO();
    private TareaDAO tareaDAO = new TareaDAO();

    public VentanaAgenda() {
        setTitle("Agenda Escolar");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color fondo = new Color(245, 240, 255);
        Color boton = new Color(180, 160, 220);

        JTabbedPane pestañas = new JTabbedPane();

        JPanel panelMaterias = new JPanel(new BorderLayout(10, 10));
        panelMaterias.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelMaterias.setBackground(fondo);

        JPanel formMaterias = new JPanel(new GridLayout(3, 2, 10, 10));
        formMaterias.setBackground(fondo);

        JTextField txtMateria = new JTextField();
        JTextField txtProfesor = new JTextField();
        JTextArea areaMaterias = new JTextArea();
        areaMaterias.setEditable(false);

        JButton btnAgregarMateria = new JButton("Agregar materia");
        JButton btnListarMaterias = new JButton("Listar en consola");

        btnAgregarMateria.setBackground(boton);
        btnListarMaterias.setBackground(boton);

        formMaterias.add(new JLabel("Materia:"));
        formMaterias.add(txtMateria);
        formMaterias.add(new JLabel("Profesor:"));
        formMaterias.add(txtProfesor);
        formMaterias.add(btnAgregarMateria);
        formMaterias.add(btnListarMaterias);

        panelMaterias.add(formMaterias, BorderLayout.NORTH);
        panelMaterias.add(new JScrollPane(areaMaterias), BorderLayout.CENTER);

        btnAgregarMateria.addActionListener(e -> {
            materiaDAO.insertarMateria(txtMateria.getText(), txtProfesor.getText());
            areaMaterias.append("Materia agregada: " + txtMateria.getText() + " - " + txtProfesor.getText() + "\n");
            txtMateria.setText("");
            txtProfesor.setText("");
        });

        btnListarMaterias.addActionListener(e -> {
            materiaDAO.listarMaterias();
            JOptionPane.showMessageDialog(this, "Materias listadas en la consola.");
        });

        JPanel panelTareas = new JPanel(new BorderLayout(10, 10));
        panelTareas.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelTareas.setBackground(fondo);

        JPanel formTareas = new JPanel(new GridLayout(6, 2, 10, 10));
        formTareas.setBackground(fondo);

        JTextField txtTitulo = new JTextField();
        JTextField txtDescripcion = new JTextField();
        JTextField txtFecha = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtMateriaId = new JTextField();
        JTextArea areaTareas = new JTextArea();
        areaTareas.setEditable(false);

        JButton btnAgregarTarea = new JButton("Agregar tarea");
        JButton btnListarTareas = new JButton("Listar en consola");

        btnAgregarTarea.setBackground(boton);
        btnListarTareas.setBackground(boton);

        formTareas.add(new JLabel("Título:"));
        formTareas.add(txtTitulo);
        formTareas.add(new JLabel("Descripción:"));
        formTareas.add(txtDescripcion);
        formTareas.add(new JLabel("Fecha AAAA-MM-DD:"));
        formTareas.add(txtFecha);
        formTareas.add(new JLabel("Estado:"));
        formTareas.add(txtEstado);
        formTareas.add(new JLabel("ID Materia:"));
        formTareas.add(txtMateriaId);
        formTareas.add(btnAgregarTarea);
        formTareas.add(btnListarTareas);

        panelTareas.add(formTareas, BorderLayout.NORTH);
        panelTareas.add(new JScrollPane(areaTareas), BorderLayout.CENTER);

        btnAgregarTarea.addActionListener(e -> {
            try {
                int materiaId = Integer.parseInt(txtMateriaId.getText());

                tareaDAO.insertarTarea(
                        txtTitulo.getText(),
                        txtDescripcion.getText(),
                        txtFecha.getText(),
                        txtEstado.getText(),
                        materiaId
                );

                areaTareas.append("Tarea agregada: " + txtTitulo.getText() + " | " + txtFecha.getText() + "\n");

                txtTitulo.setText("");
                txtDescripcion.setText("");
                txtFecha.setText("");
                txtEstado.setText("");
                txtMateriaId.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: revisá la fecha y el ID de materia.");
            }
        });

        btnListarTareas.addActionListener(e -> {
            tareaDAO.listarTareas();
            JOptionPane.showMessageDialog(this, "Tareas listadas en la consola.");
        });

        pestañas.addTab("Materias", panelMaterias);
        pestañas.addTab("Tareas", panelTareas);

        add(pestañas);
    }
}