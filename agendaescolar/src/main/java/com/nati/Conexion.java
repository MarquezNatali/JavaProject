package com.nati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:postgresql://localhost:5432/agendaescolar";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "Natali777";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión exitosa a PostgreSQL");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar con PostgreSQL");
            e.printStackTrace();
            return null;
        }
    }
}