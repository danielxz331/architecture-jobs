package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Lugar;
import com.app.student.repositorios.crud.sql.LugarCRUD;
import com.app.student.repositorios.crud.files.ListaLugares;
import com.app.student.interfaces.Repositorio;
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
