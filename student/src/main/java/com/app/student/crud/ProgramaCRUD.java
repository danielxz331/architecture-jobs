package com.app.student.crud;

import com.app.student.AplicacionSolid.Programa;
import com.app.student.AplicacionSolid.Lugar;
import com.app.student.interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class ProgramaCRUD implements CRUD<Programa>{

    private Connection conexion;

    public ProgramaCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(Programa programa) {
        String query = "INSERT INTO programa (id, nombre, semestre, lugar_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, programa.getId());
            statement.setString(2, programa.getNombre());
            statement.setInt(3, programa.getSemestres());
            statement.setInt(4, programa.getDireccion().getId());
            statement.executeUpdate();
            System.out.println("Programa creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Programa.");
            e.printStackTrace();
        }
    }

    @Override
    public Programa obtener(int id) {
        String query = "SELECT * FROM programa WHERE id = ?";
        String nombre = "";
        int semestre = 1;
        int lugar_id = 1;

        CRUD<Lugar> lugarCRUD = new LugarCRUD(conexion);

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nombre = resultSet.getString("nombre");
                semestre = resultSet.getInt("semestre");
                lugar_id = resultSet.getInt("lugar_id");
                System.out.println("Programa obtenido con el id: " + id + " y el nombre: " + nombre);
            } else {
                System.out.println("El Programa con id: " + id + " no existe");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Lugar lugar_asociado = lugarCRUD.obtener(lugar_id);
        return new Programa(id, nombre, semestre, lugar_asociado);
    }

    @Override
    public void editar(int id, Programa programa) {
        String query = "UPDATE programa SET id = ?, nombre = ?, semestre = ?, lugar_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, programa.getId());
            statement.setString(2, programa.getNombre());
            statement.setInt(3, programa.getSemestres());
            statement.setInt(4, programa.getDireccion().getId());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Programa editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Programa.");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM programa WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Programa eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Programa.");
            e.printStackTrace();
        }
    }

}
