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

    private int programaId;

    private int direccionid;

    public Estudiante(String nombres, String apellidos, int id, int codigo, int programa, int direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.codigo = codigo;
        this.programaId = programa;
        this.direccionid = direccion;
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

    public int getPrograma() {
        return programaId;
    }

    public void setPrograma(int programaId) {
        this.programaId = programaId;
    }

    public int getDireccion() {
        return direccionid;
    }

    public void setDireccion(int direccion) {
        this.direccionid = direccion;
    }


    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", apellidos=" + apellidos + ", nombres=" + nombres + ", codigo=" + codigo + ", programa=" + programaId + ", direccion=" + direccionid + '}';
    }

}
