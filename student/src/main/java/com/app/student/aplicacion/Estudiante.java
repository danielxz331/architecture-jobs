package com.app.student.aplicacion;

/**
 *
 * @author daniel
 */
public class Estudiante {

    private String nombres;

    private String apellidos;

    private int id;

    private int codigo;

    private Programa programa;

    private Lugar direccion;

    public Estudiante(String nombres, String apellidos, int id, int codigo, Programa programa, Lugar direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.codigo = codigo;
        this.programa = programa;
        this.direccion = direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Lugar getDireccion() {
        return direccion;
    }

    public void setDireccion(Lugar direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", apellidos=" + apellidos + ", nombres=" + nombres + ", codigo=" + codigo + ", programa=" + programa + ", direccion=" + direccion + '}';
    }

}
