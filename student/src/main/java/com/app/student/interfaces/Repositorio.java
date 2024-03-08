package com.app.student.interfaces;

import java.util.List;

public interface Repositorio<Obj> {

    void create(Obj objeto);

    Obj get(int id);

    List<Obj> getAll();

    void update(int id, Obj objeto);

    void delete(int id);

}

