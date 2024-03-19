package com.app.student.aplicacion;

/**
 *
 * @author daniel
 */
public class Municipio {

    private int id;

    private String nombre;

    private int departamentoId;

    public Municipio(int id, String nombre, int departamentoId) {
        this.id = id;
        this.nombre = nombre;
        this.departamentoId = departamentoId;
    }

    public Municipio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDepartamento() {
        return departamentoId;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamentoId = departamentoId;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + ", departamento=" + departamentoId + '}';
    }

}
