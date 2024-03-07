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
    public void crear(Municipio municipio) {
        // guarda en base de datos
        municipioCRUD.crear(municipio);

        // guarda en archivos
        municipiosCreados.agregarMunicipio(municipio);
        municipiosCreados.persistir();
    }

    @Override
    public Municipio obtener(int id) {
        return municipioCRUD.obtener(id);
    }

    @Override
    public void editar(int id, Municipio municipio) {
        municipioCRUD.editar(id, municipio);
        municipiosCreados.editarMunicipioArchivo(id, municipio);
    }

    @Override
    public void eliminar(int id) {
        municipioCRUD.eliminar(id);
        municipiosCreados.eliminarMunicipioArchivo(id);
    }
}
