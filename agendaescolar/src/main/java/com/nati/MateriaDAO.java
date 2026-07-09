package com.nati;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MateriaDAO {

    public void insertarMateria(String nombre, String profesor) {
        String sql = "INSERT INTO materias (nombre, profesor) VALUES (?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, profesor);
            ps.executeUpdate();

            System.out.println("Materia agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar la materia.");
            e.printStackTrace();
        }
    }

    public void listarMaterias() {
        String sql = "SELECT * FROM materias ORDER BY id";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- LISTA DE MATERIAS ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Materia: " + rs.getString("nombre") +
                    " | Profesor: " + rs.getString("profesor")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al listar materias.");
            e.printStackTrace();
        }
    }

    public void modificarMateria(int id, String nuevoNombre, String nuevoProfesor) {
        String sql = "UPDATE materias SET nombre = ?, profesor = ? WHERE id = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoProfesor);
            ps.setInt(3, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Materia modificada correctamente.");
            } else {
                System.out.println("No existe una materia con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar materia.");
            e.printStackTrace();
        }
    }

    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materias WHERE id = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Materia eliminada correctamente.");
            } else {
                System.out.println("No existe una materia con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar materia.");
            e.printStackTrace();
        }
    }
}