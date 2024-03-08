package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Departamento;
import com.app.student.repositorios.crud.sql.DepartamentoCRUD;
import com.app.student.repositorios.crud.files.DepartamentosCreados;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;
import java.util.List;

public class DepartamentoRepositorio implements Repositorio<Departamento> {

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    DepartamentoCRUD crudDepartamento = new DepartamentoCRUD(connection);
    DepartamentosCreados departamentosCreados = new DepartamentosCreados();


    @Override
    public void create(Departamento departamento) {
        // guarda en base de datos
        crudDepartamento.create(departamento);

        // guarda en archivos
        departamentosCreados.create(departamento);
    }


    @Override
    public Departamento get(int id) {

        return crudDepartamento.getById(id);
    }

    @Override
    public List<Departamento> getAll() {
        return departamentosCreados.getAll();
    }


    @Override
    public void update(int id, Departamento departamento) {
        crudDepartamento.update(id, departamento);
        departamentosCreados.update(id, departamento);
    }


    @Override
    public void delete(int id) {
        crudDepartamento.delete(id);
        departamentosCreados.delete(id);
    }
}
