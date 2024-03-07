package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Departamento;
import com.app.student.repositorios.crud.sql.DepartamentoCRUD;
import com.app.student.repositorios.crud.files.DepartamentosCreados;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;

public class DepartamentoRepositorio implements Repositorio<Departamento> {

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    DepartamentoCRUD crudDepartamento = new DepartamentoCRUD(connection);
    DepartamentosCreados departamentosCreados = new DepartamentosCreados();


    @Override
    public void crear(Departamento departamento) {
        // guarda en base de datos
        crudDepartamento.crear(departamento);

        // guarda en archivos
        departamentosCreados.agregarDepartamento(departamento);
        departamentosCreados.persistir();
    }


    @Override
    public Departamento obtener(int id) {
        return crudDepartamento.obtener(id);
    }


    @Override
    public void editar(int id, Departamento departamento) {
        crudDepartamento.editar(id, departamento);
        departamentosCreados.editarDepartamentoArchivo(id, departamento);
    }


    @Override
    public void eliminar(int id) {
        crudDepartamento.eliminar(id);
        departamentosCreados.eliminarDepartamentoArchivo(id);
    }
}
