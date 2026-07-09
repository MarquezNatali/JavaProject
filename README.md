# JavaProject
# Agenda Escolar

Agenda Escolar es una aplicación desarrollada en **Java** utilizando **Swing** para la interfaz gráfica y **PostgreSQL** como base de datos. El proyecto permite administrar materias y tareas, almacenando la información de forma persistente en una base de datos relacional.

---

# Funcionalidades

- Agregar materias.
- Registrar el profesor correspondiente a cada materia.
- Agregar tareas asociadas a una materia.
- Almacenar toda la información en PostgreSQL.
- Interfaz gráfica desarrollada con Java Swing.

---

# Tecnologías utilizadas

- Java
- Maven
- Swing
- JDBC
- PostgreSQL

---

# Requisitos

Antes de ejecutar el proyecto es necesario tener instalado:

- Java JDK
- Apache Maven
- PostgreSQL

---

# Configuración de la base de datos

1. Crear una base de datos llamada:

```sql
agendaescolar
```

2. Ejecutar el archivo **agendaescolar.sql** incluido en este repositorio para crear automáticamente las tablas necesarias.

3. Configurar el usuario y la contraseña de PostgreSQL en el archivo:

```
src/main/java/com/nati/Conexion.java
```
Modificando los siguientes valores según la configuración del equipo:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/agendaescolar";
private static final String USUARIO = "...";
private static final String PASSWORD = "...";
```

# Ejecutar el proyecto

Desde la carpeta del proyecto ejecutar:

```bash
mvn clean compile "exec:java" "-Dexec.mainClass=com.nati.App"
```


# Notas

- El proyecto utiliza JDBC para la comunicación con PostgreSQL.
- La información ingresada desde la aplicación se almacena directamente en la base de datos.
- Si se modifica el usuario, contraseña o puerto de PostgreSQL, esos datos deben actualizarse en `Conexion.java` antes de ejecutar la aplicación.
