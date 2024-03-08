package com.app.student.services;

import com.app.student.aplicacion.Departamento;
import com.app.student.interfaces.ICrudServices;
import com.app.student.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class DepartmentServices implements ICrudServices<Departamento> {

    private DepartamentoRepositorio departamentoRepositorio;

    public DepartmentServices(){
        this.departamentoRepositorio = new DepartamentoRepositorio();
    }

    @Override
    public List<Departamento> getAll() {
        return departamentoRepositorio.getAll();
    }

    @Override
    public Departamento getById(int id) {
        return departamentoRepositorio.get(id);
    }

    @Override
    public void save(Departamento object) {
        departamentoRepositorio.create(object);
    }

    @Override
    public void delete(int id) {
        departamentoRepositorio.delete(id);
    }
}
