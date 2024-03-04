package repositorio;

import aplicacionsolid.ConexionDB;
import crud.EstudianteCRUD;
import crud.LugarCRUD;
import crudarchivos.EstudiantesInscritos;
import crudarchivos.ListaLugares;
import interfaces.Repositorio;
import aplicacionsolid.Lugar;

import java.sql.Connection;

public class LugarRepositorio implements Repositorio<Lugar>{

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    LugarCRUD lugarCRUD = new LugarCRUD(connection);
    ListaLugares listaLugares = new ListaLugares();

    @Override
    public void crear(Lugar lugar) {
        // guarda en base de datos
        lugarCRUD.crear( lugar );

        // guarda en archivos
        listaLugares.agregarLugar(lugar);
        listaLugares.persistir();
    }

    @Override
    public Lugar obtener(int id) {
        return lugarCRUD.obtener(id);
    }

    @Override
    public void editar(int id, Lugar lugar) {

    }

    @Override
    public void eliminar(int id) {

    }
}
