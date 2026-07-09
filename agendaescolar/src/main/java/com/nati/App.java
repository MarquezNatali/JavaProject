package com.nati;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MateriaDAO dao = new MateriaDAO();

        int opcion;

        do {
            System.out.println("\n===== AGENDA ESCOLAR =====");
            System.out.println("1. Agregar materia");
            System.out.println("2. Listar materias");
            System.out.println("3. Modificar materia");
            System.out.println("4. Eliminar materia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la materia: ");
                    String nombre = sc.nextLine();

                    System.out.print("Profesor: ");
                    String profesor = sc.nextLine();

                    dao.insertarMateria(nombre, profesor);
                    break;

                case 2:
                    dao.listarMaterias();
                    break;

                case 3:
                    System.out.print("ID de la materia a modificar: ");
                    int idModificar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre de la materia: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nuevo profesor: ");
                    String nuevoProfesor = sc.nextLine();

                    dao.modificarMateria(idModificar, nuevoNombre, nuevoProfesor);
                    break;

                case 4:
                    System.out.print("ID de la materia a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();

                    dao.eliminarMateria(idEliminar);
                    break;

                case 0:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}