package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Municipio;
import com.app.student.repositorios.crud.sql.MunicipioCRUD;
import com.app.student.repositorios.crud.files.MunicipiosCreados;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;

public class MunicipioRepositorio implements Repositorio<Municipio>{

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    MunicipioCRUD municipioCRUD = new MunicipioCRUD(connection);
    MunicipiosCreados municipiosCreados = new MunicipiosCreados();

    @Override
    public void create(Municipio municipio) {
        // guarda en base de datos
        municipioCRUD.create(municipio);

        // guarda en archivos
        municipiosCreados.create(municipio);
    }

    @Override
    public Municipio get(int id) {
        return municipioCRUD.get(id);
    }

    @Override
    public void update(int id, Municipio municipio) {
        municipioCRUD.update(id, municipio);
        municipiosCreados.update(id, municipio);
    }

    @Override
    public void delete(int id) {
        municipioCRUD.delete(id);
        municipiosCreados.delete(id);
    }
}
