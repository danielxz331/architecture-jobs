package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Programa;
import com.app.student.repositorios.crud.sql.ProgramaCRUD;
import com.app.student.interfaces.Repositorio;

import java.sql.Connection;

public class ProgramaRepositorio implements Repositorio<Programa> {

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    ProgramaCRUD programaCRUD = new ProgramaCRUD(connection);

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
