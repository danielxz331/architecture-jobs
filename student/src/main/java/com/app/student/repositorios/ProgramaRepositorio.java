package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Programa;
import com.app.student.repositorios.crud.sql.ProgramaCRUD;
import com.app.student.repositorios.crud.files.ProgramasCreados;
import com.app.student.interfaces.Repositorio;

import java.sql.Connection;
import java.util.List;

public class ProgramaRepositorio implements Repositorio<Programa> {

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    ProgramaCRUD programaCRUD = new ProgramaCRUD(connection);
    ProgramasCreados programasCreados = new ProgramasCreados();

    @Override
    public void create(Programa programa) {
        // guarda en base de datos
        programaCRUD.create(programa);
        programasCreados.create(programa);
    }

    @Override
    public Programa get(int id) {
        return programasCreados.getById(id);
    }

    @Override
    public List<Programa> getAll() {
        return programasCreados.getAll();
    }

    @Override
    public void update(int id, Programa programa) {
        programaCRUD.update(id,programa);
        programasCreados.update(id,programa);
    }

    @Override
    public void delete(int id) {
        programaCRUD.delete(id);
        programasCreados.delete(id);
    }
}
