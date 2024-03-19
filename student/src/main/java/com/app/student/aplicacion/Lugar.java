package com.app.student.aplicacion;

/**
 *
 * @author daniel
 */
public class Lugar {

    private int id;

    private String direccion;

    private int departamentoId;

    private int municipioId;

    public Lugar(int id, String direccion, int departamentoId, int municipioId) {
        this.id = id;
        this.direccion = direccion;
        this.departamentoId = departamentoId;
        this.municipioId = municipioId;
    }

    public Lugar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDepartamento() {
        return departamentoId;
    }

    public void setDepartamento(int departamento) {
        this.departamentoId = departamento;
    }

    public int getMunicipio() {
        return municipioId;
    }

    public void setMunicipio(int municipioId) {
        this.municipioId = municipioId;
    }


    @Override
    public String toString() {
        return "Lugar{" + "id=" + id + ", direccion=" + direccion + ", departamento=" + departamentoId + ", municipio=" + municipioId + '}';
    }

}
