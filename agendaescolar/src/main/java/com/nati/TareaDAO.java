package com.nati;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TareaDAO {

    public void insertarTarea(String titulo, String descripcion, String fechaEntrega, String estado, int materiaId) {
        String sql = "INSERT INTO tareas (titulo, descripcion, fecha_entrega, estado, materia_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, descripcion);
            ps.setDate(3, java.sql.Date.valueOf(fechaEntrega));
            ps.setString(4, estado);
            ps.setInt(5, materiaId);

            ps.executeUpdate();
            System.out.println("Tarea agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar tarea.");
            e.printStackTrace();
        }
    }

    public void listarTareas() {
        String sql = "SELECT t.id, t.titulo, t.descripcion, t.fecha_entrega, t.estado, m.nombre AS materia " +
                     "FROM tareas t " +
                     "LEFT JOIN materias m ON t.materia_id = m.id " +
                     "ORDER BY t.fecha_entrega";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- LISTA DE TAREAS ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Título: " + rs.getString("titulo") +
                    " | Materia: " + rs.getString("materia") +
                    " | Entrega: " + rs.getDate("fecha_entrega") +
                    " | Estado: " + rs.getString("estado") +
                    " | Descripción: " + rs.getString("descripcion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al listar tareas.");
            e.printStackTrace();
        }
    }
}