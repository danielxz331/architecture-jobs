/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import aplicacionsolid.Estudiante;
import aplicacionsolid.Lugar;
import aplicacionsolid.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import interfaces.CRUD;

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
    public void crear(Estudiante estudiante) {
        String query = "INSERT INTO estudiante (id, nombres, apellidos, codigo, programa_id, lugar_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getNombres());
            statement.setString(3, estudiante.getApellidos());
            statement.setDouble(4, estudiante.getCodigo());
            statement.setInt(5, estudiante.getPrograma().getId());
            statement.setInt(6, estudiante.getDireccion().getId());
            statement.executeUpdate();
            System.out.println("Estudiante creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Estudiante.");
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante obtener(int id) {
        String query = "SELECT * FROM estudiante WHERE id = ?";
        String nombres = "";
        String apellidos = "";
        int codigo = 1;
        int programa_id = 1;
        int lugar_id = 1;

        CRUD<Programa> programaCRUD = new ProgramaCRUD(conexion);
        CRUD<Lugar> lugarCRUD = new LugarCRUD(conexion);

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

        Programa programa_asociado = programaCRUD.obtener(programa_id);
        Lugar lugar_asociado = lugarCRUD.obtener(lugar_id);
        
        return new Estudiante(nombres, apellidos, id, codigo, programa_asociado, lugar_asociado);
    }

    @Override
    public void editar(int id, Estudiante estudiante) {
        String query = "UPDATE estudiante SET id = ?, nombres = ?, apellidos = ?, codigo = ?, programa_id = ?, lugar_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getNombres());
            statement.setString(3, estudiante.getApellidos());
            statement.setDouble(4, estudiante.getCodigo());
            statement.setInt(5, estudiante.getPrograma().getId());
            statement.setInt(6, estudiante.getDireccion().getId());
            statement.setInt(7, id);
            statement.executeUpdate();
            System.out.println("Estudiante editado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar el Estudiante.");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
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
