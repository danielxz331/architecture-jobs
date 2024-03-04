package repositorio;

import aplicacionsolid.ConexionDB;
import aplicacionsolid.Programa;
import crud.MunicipioCRUD;
import crud.ProgramaCRUD;
import crudarchivos.MunicipiosCreados;
import interfaces.Repositorio;

import java.sql.Connection;

public class ProgramaRepositorio implements Repositorio<Programa> {

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    ProgramaCRUD programaCRUD = new ProgramaCRUD(connection);
//    MunicipiosCreados municipiosCreados = new MunicipiosCreados();

    @Override
    public void crear(Programa programa) {
        // guarda en base de datos
        programaCRUD.crear(programa);
    }

    @Override
    public Programa obtener(int id) {
        return null;
    }

    @Override
    public void editar(int id, Programa programa) {

    }

    @Override
    public void eliminar(int id) {

    }
}
