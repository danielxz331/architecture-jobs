package com.app.student.repositorios;

import com.app.student.aplicacion.ConexionDB;
import com.app.student.aplicacion.Estudiante;
import com.app.student.repositorios.crud.sql.EstudianteCRUD;
import com.app.student.repositorios.crud.files.EstudiantesInscritos;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;
import java.util.List;

public class EstudianteRepositorio implements Repositorio<Estudiante>{

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    EstudianteCRUD crudEstudiante = new EstudianteCRUD(connection);
    EstudiantesInscritos estudianteInscritos = new EstudiantesInscritos();


    @Override
    public void create(Estudiante estudiante) {
        // guarda en base de datos
        crudEstudiante.create( estudiante );

        // guarda en archivos
        estudianteInscritos.create(estudiante);
    }


    @Override
    public Estudiante get(int id) {
        return estudianteInscritos.getById(id);
    }

    @Override
    public List<Estudiante> getAll() {
        return estudianteInscritos.getAll();
    }


    @Override
    public void update(int id, Estudiante estudiante) {
        crudEstudiante.update(id, estudiante);
        estudianteInscritos.update(id, estudiante);
    }


    @Override
    public void delete(int id) {
        crudEstudiante.delete(id);
        estudianteInscritos.delete(id);
    }
}
