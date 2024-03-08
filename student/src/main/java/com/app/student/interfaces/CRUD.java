package com.app.student.interfaces;

import java.util.List;

/**
 *
 * @author daniel
 */
public interface CRUD<Obj> {

    void create(Obj objeto);

    Obj getById(int id);

    List<Obj> getAll();

    void update(int id, Obj objeto);

    void delete(int id);
}
