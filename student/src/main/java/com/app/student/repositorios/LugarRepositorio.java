package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Lugar;
import com.app.student.repositorios.crud.sql.LugarCRUD;
import com.app.student.repositorios.crud.files.ListaLugares;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;
import java.util.List;

public class LugarRepositorio implements Repositorio<Lugar>{

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    LugarCRUD lugarCRUD = new LugarCRUD(connection);
    ListaLugares listaLugares = new ListaLugares();

    @Override
    public void create(Lugar lugar) {
        // guarda en base de datos
        lugarCRUD.create( lugar );

        // guarda en archivos
        listaLugares.create(lugar);
    }

    @Override
    public Lugar get(int id) {
        return listaLugares.getById(id);
    }

    @Override
    public List<Lugar> getAll() {
        return lugarCRUD.getAll();
    }

    @Override
    public void update(int id, Lugar lugar) {
        lugarCRUD.update(id, lugar);
        listaLugares.update(id, lugar);
    }

    @Override
    public void delete(int id) {
        lugarCRUD.delete(id);
        listaLugares.delete(id);
    }
}
