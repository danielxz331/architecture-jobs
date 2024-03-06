package com.app.student.repositorios;

import com.app.student.AplicacionSolid.ConexionDB;
import com.app.student.AplicacionSolid.Estudiante;
import com.app.student.crud.EstudianteCRUD;
import com.app.student.crudArchivos.EstudiantesInscritos;
import com.app.student.interfaces.Repositorio;
import java.sql.Connection;

public class EstudianteRepositorio implements Repositorio<Estudiante>{

    ConexionDB conexion = ConexionDB.getInstance();
    Connection connection = conexion.getConexion();

    EstudianteCRUD crudEstudiante = new EstudianteCRUD(connection);
    EstudiantesInscritos estudianteInscritos = new EstudiantesInscritos();


    @Override
    public void crear(Estudiante estudiante) {
        // guarda en base de datos
        crudEstudiante.crear( estudiante );

        // guarda en archivos
        estudianteInscritos.agregarEstudiante(estudiante);
        estudianteInscritos.persistir();
    }


    @Override
    public Estudiante obtener(int id) {
        return crudEstudiante.obtener(id);
    }


    @Override
    public void editar(int id, Estudiante estudiante) {
        crudEstudiante.editar(id, estudiante);
        estudianteInscritos.editarEstudianteArchivo(id, estudiante);
    }


    @Override
    public void eliminar(int id) {
        crudEstudiante.eliminar(id);
        estudianteInscritos.eliminarEstudianteArchivo(id);
    }
}
