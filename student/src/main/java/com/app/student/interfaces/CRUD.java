package com.app.student.interfaces;

/**
 *
 * @author daniel
 */
public interface CRUD<Obj> {

    void crear(Obj objeto);

    Obj obtener(int id);

    void editar(int id, Obj objeto);

    void eliminar(int id);
}
