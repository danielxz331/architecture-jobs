package com.app.student.interfaces;

/**
 *
 * @author daniel
 */
public interface CRUD<Obj> {

    void create(Obj objeto);

    Obj get(int id);

    void update(int id, Obj objeto);

    void delete(int id);
}
