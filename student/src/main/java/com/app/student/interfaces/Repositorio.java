package com.app.student.interfaces;

public interface Repositorio<Obj> {

    void create(Obj objeto);

    Obj get(int id);

    void update(int id, Obj objeto);

    void delete(int id);

}

