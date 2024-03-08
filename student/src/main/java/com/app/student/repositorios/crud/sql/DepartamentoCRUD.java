package com.app.student.repositorios.crud.sql;

import com.app.student.aplicacion.Departamento;
import com.app.student.interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class DepartamentoCRUD implements CRUD<Departamento> {

    private Connection conexion;

    public DepartamentoCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(Departamento departamento) {
        String query = "INSERT INTO departamento (id, nombre) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, departamento.getId());
            statement.setString(2, departamento.getNombre());
            statement.executeUpdate();
            System.out.println("Departamento creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Departamento.");
            e.printStackTrace();
        }
    }

    @Override
    public Departamento getById(int id) {
        String query = "SELECT * FROM departamento WHERE id = ?";
        String nombre = "";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nombre = resultSet.getString("nombre");
                System.out.println("Departamento obtenido con el id: " + id + "y el nombre: " + nombre);

            } else {
                System.out.println("El Departamento con id: " + id + " no existe");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Departamento(id, nombre);
    }

    @Override
    public List<Departamento> getAll() {
        String query = "SELECT * FROM departamento";
        List<Departamento> Lista =  new ArrayList();
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Lista.add(new Departamento(id, nombre));
            }
            return Lista;
        } catch (SQLException e) {
            e.printStackTrace();
        return null;
        }
    }

    @Override
    public void update(int id, Departamento departamento) {
        String query = "UPDATE departamento SET id = ?, nombre = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, departamento.getId());
            statement.setString(2, departamento.getNombre());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Departamento editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Departamento.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM departamento WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Departamento eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Departamento.");
            e.printStackTrace();
        }
    }
}
