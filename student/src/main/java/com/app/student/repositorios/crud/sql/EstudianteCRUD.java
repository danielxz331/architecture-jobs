package com.app.student.repositorios.crud.sql;

import com.app.student.interfaces.CRUD;
import com.app.student.aplicacion.Estudiante;
import com.app.student.aplicacion.Lugar;
import com.app.student.aplicacion.Programa;
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
public class EstudianteCRUD implements CRUD<Estudiante>{

    private Connection conexion;

    public EstudianteCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(Estudiante estudiante) {
        String query = "INSERT INTO estudiante (id, nombres, apellidos, codigo, programa_id, lugar_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getNombres());
            statement.setString(3, estudiante.getApellidos());
            statement.setDouble(4, estudiante.getCodigo());
            statement.setInt(5, estudiante.getPrograma());
            statement.setInt(6, estudiante.getDireccion());
            statement.executeUpdate();
            System.out.println("Estudiante creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Estudiante.");
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante getById(int id) {
        String query = "SELECT * FROM estudiante WHERE id = ?";
        String nombres = "";
        String apellidos = "";
        int codigo = 1;
        int programa_id = 1;
        int lugar_id = 1;

        CRUD<Programa> programaCRUD = (CRUD<Programa>) new ProgramaCRUD(conexion);
        CRUD<Lugar> lugarCRUD = (CRUD<Lugar>) new LugarCRUD(conexion);

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nombres = resultSet.getString("nombres");
                apellidos = resultSet.getString("apellidos");
                codigo = resultSet.getInt("codigo");
                programa_id = resultSet.getInt("programa_id");
                lugar_id = resultSet.getInt("lugar_id");
                System.out.println("Estudiante obtenido con el id: " + id + " y los nombres: " + nombres);
            } else {
                System.out.println("El Estudiante con id: " + id + " no existe");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Estudiante(nombres, apellidos, id, codigo, programa_id, lugar_id);
    }

    @Override
    public List<Estudiante> getAll() {
        String query = "SELECT * FROM estudiante";
        List<Estudiante> Lista = new ArrayList();
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                int codigo = resultSet.getInt("codigo");
                int programa_id = resultSet.getInt("programa_id");
                int lugar_id = resultSet.getInt("lugar_id");
                Lista.add(new Estudiante(nombres, apellidos, id, codigo, programa_id, lugar_id));
            }
            return Lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(int id, Estudiante estudiante) {
        String query = "UPDATE estudiante SET id = ?, nombres = ?, apellidos = ?, codigo = ?, programa_id = ?, lugar_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getNombres());
            statement.setString(3, estudiante.getApellidos());
            statement.setDouble(4, estudiante.getCodigo());
            statement.setInt(5, estudiante.getPrograma());
            statement.setInt(6, estudiante.getDireccion());
            statement.setInt(7, id);
            statement.executeUpdate();
            System.out.println("Estudiante editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Estudiante.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM estudiante WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Estudiante eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Estudiante.");
            e.printStackTrace();
        }
    }
}
