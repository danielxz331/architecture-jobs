/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import aplicacionsolid.Municipio;
import aplicacionsolid.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import interfaces.CRUD;

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
    public void crear(Municipio municipio) {

        String query = "INSERT INTO municipio (id, nombre, departamento_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, municipio.getId());
            statement.setString(2, municipio.getNombre());
            statement.setInt(3, municipio.getDepartamento().getId());
            statement.executeUpdate();
            System.out.println("Municipio creado con éxito.");

        } catch (SQLException e) {

            System.out.println("Error al crear el Municipio.");
            e.printStackTrace();

        }
    }
    
    @Override
    public Municipio obtener(int id) {
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
        Departamento departamento_asociado = departamento.obtener(departamento_id);
        return new Municipio(id, nombre, departamento_asociado);
    }
    
    @Override
    public void editar(int id, Municipio municipio) {
        String query = "UPDATE municipio SET id = ?, nombre = ?, departamento_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, municipio.getId());
            statement.setString(2, municipio.getNombre());
            statement.setInt(3, municipio.getDepartamento().getId());
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Municipio editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Municipio.");
            e.printStackTrace();
        }
    }
    
    @Override
    public void eliminar(int id) {
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
