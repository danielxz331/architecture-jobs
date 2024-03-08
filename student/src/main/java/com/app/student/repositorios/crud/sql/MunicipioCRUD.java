package com.app.student.repositorios.crud.sql;

import com.app.student.aplicacion.Municipio;
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
public class MunicipioCRUD implements CRUD<Municipio>{

    private Connection conexion;

    public MunicipioCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(Municipio municipio) {

        String query = "INSERT INTO municipio (id, nombre, departamento_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, municipio.getId());
            statement.setString(2, municipio.getNombre());
            statement.setInt(3, municipio.getDepartamento());
            statement.executeUpdate();
            System.out.println("Municipio creado con éxito.");

        } catch (SQLException e) {

            System.out.println("Error al crear el Municipio.");
            e.printStackTrace();

        }
    }

    @Override
     public Municipio getById(int id) {
        String query = "SELECT * FROM municipio WHERE id = ?";
        String nombre = "";
        int departamento_id = 1;
        CRUD<Departamento> departamento = new DepartamentoCRUD(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nombre = resultSet.getString("nombre");
                departamento_id = resultSet.getInt("departamento_id");
                System.out.println("Municipio obtenido con el id: " + id + "y el nombre: " + nombre);
            } else {
                System.out.println("El Municipio con id: " + id + " no existe");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Municipio(id, nombre, departamento_id);
    }

    @Override
    public List<Municipio> getAll() {
        String query = "SELECT * FROM municipio";
        List<Municipio> list = new ArrayList();
        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                list.add(new Municipio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("departamento_id")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error al obtener los Municipios.");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(int id, Municipio municipio) {
        String query = "UPDATE municipio SET id = ?, nombre = ?, departamento_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, municipio.getId());
            statement.setString(2, municipio.getNombre());
            statement.setInt(3, municipio.getDepartamento());
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Municipio editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Municipio.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM municipio WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Municipio eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Municipio.");
            e.printStackTrace();
        }
    }
}