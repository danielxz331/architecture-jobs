package com.app.student.aplicacion;

/**
 *
 * @author daniel
 */
public class Programa {

    private int id;

    private String nombre;

    private int semestres;

    private int direccionId;

    public Programa(int id, String nombre, int semestres, int direccionId) {
        this.id = id;
        this.nombre = nombre;
        this.semestres = semestres;
        this.direccionId = direccionId;
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

    public int getDireccion() {
        return direccionId;
    }

    public void setDireccion(int direccionId) {
        this.direccionId = direccionId;
    }

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nombre=" + nombre + ", semestres=" + semestres + ", direccion=" + direccionId + '}';
    }
}
