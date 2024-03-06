package com.app.student.crud;

import com.app.student.AplicacionSolid.Lugar;
import com.app.student.AplicacionSolid.Departamento;
import com.app.student.AplicacionSolid.Municipio;
import com.app.student.interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author daniel
 */
public class LugarCRUD implements CRUD<Lugar>{

    private Connection conexion;

    public LugarCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(Lugar lugar) {
        String query = "INSERT INTO lugar (id, direccion, departamento_id, municipio_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lugar.getId());
            statement.setString(2, lugar.getDireccion());
            statement.setInt(3, lugar.getDepartamento().getId());
            statement.setInt(4, lugar.getMunicipio().getId());
            statement.executeUpdate();
            System.out.println("Lugar creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Lugar.");
            e.printStackTrace();
        }
    }

    @Override
    public Lugar obtener(int id) {
        String query = "SELECT * FROM lugar WHERE id = ?";
        String direccion = "";
        int departamento_id = 1;
        int municipio_id = 1;

        CRUD<Departamento> departamentoCRUD = new DepartamentoCRUD(conexion);
        CRUD<Municipio> municipioCRUD = (CRUD<Municipio>) new MunicipioCRUD(conexion);

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                direccion = resultSet.getString("direccion");
                departamento_id = resultSet.getInt("departamento_id");
                municipio_id = resultSet.getInt("municipio_id");
                System.out.println("Lugar obtenido con el id: " + id + " y la dirección: " + direccion);
            } else {
                System.out.println("El Lugar con id: " + id + " no existe");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Departamento departamento_asociado = departamentoCRUD.obtener(departamento_id);
        Municipio municipio_asociado = municipioCRUD.obtener(municipio_id);
        return new Lugar(id, direccion, departamento_asociado, municipio_asociado);
    }

    @Override
    public void editar(int id, Lugar lugar) {
        String query = "UPDATE lugar SET id = ?, direccion = ?, departamento_id = ?, municipio_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lugar.getId());
            statement.setString(2, lugar.getDireccion());
            statement.setInt(3, lugar.getDepartamento().getId());
            statement.setInt(4, lugar.getMunicipio().getId());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Lugar editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Lugar.");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM lugar WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Lugar eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Lugar.");
            e.printStackTrace();
        }
    }

}
