package com.app.student.AplicacionSolid;

/**
 *
 * @author daniel
 */
public class Programa {

    private int id;

    private String nombre;

    private int semestres;

    private Lugar direccion;

    public Programa(int id, String nombre, int semestres, Lugar direccion) {
        this.id = id;
        this.nombre = nombre;
        this.semestres = semestres;
        this.direccion = direccion;
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

    public int getSemestres() {
        return semestres;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public Lugar getDireccion() {
        return direccion;
    }

    public void setDireccion(Lugar direccion) {
        this.direccion = direccion;
    }

}
