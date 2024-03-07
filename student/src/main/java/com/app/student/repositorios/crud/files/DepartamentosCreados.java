package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;

import com.app.student.aplicacion.Departamento;
import com.app.student.interfaces.VisualizarInformacion;
import com.app.student.interfaces.CRUD;

/**
 *
 * @author daniel
 */
public class DepartamentosCreados implements VisualizarInformacion, CRUD<Departamento> {

    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/departamentos.txt";

    private File archivo = new File(rutaArchivo);

    private ArrayList<Departamento> lista = new ArrayList();

    public String recorrerLista(ArrayList<Departamento> lista)
    {
        String objetos = "";

        for (Departamento departamento : lista) {

            objetos += departamento.toString()+"\r\n";
        }

        return objetos;
    }

    @Override
    public String nombreClase()
    {
        return "DepartamentosCreados";
    }

    @Override
    public String informacionObjeto()
    {
        String objetos = this.recorrerLista(lista);

        return objetos;
    }

    @Override
    public void persistir()
    {

        for (Departamento departamento : this.lista) {

            this.create(departamento);

        }

        this.lista.clear();
    }

    @Override
    public void create(Departamento departamento) {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(departamento.toString()+"\r\n");

            archivoEscribir.close();

            System.out.println("Departamento agregado correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Departamento get(int id) {
        try {

            String lineaLeida = "";

            if (archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    if (lineaLeida.contains("Departamento"+"{id="+id)) {
                        String[] partes = lineaLeida.split(",");
                        String[] idParte = partes[0].split("=");
                        String[] nombreParte = partes[1].split("=");
                        return new Departamento(Integer.parseInt(idParte[1]), nombreParte[1]);
                    }
                }

                archivoLeer.close();
            } else {
                System.out.println("No encuentra el archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Departamento departamento) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Departamento"+"{id="+departamento.getId())) {
                    lineaLeida = departamento.toString();
                }
                contenidoArchivo.append(lineaLeida).append("\r\n");
            }

            archivoLeer.close();

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "utf-8"));
            archivoEscribir.write(contenidoArchivo.toString());
            archivoEscribir.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Departamento"+"{id="+id)) {
                    System.out.println(lineaLeida);
                    System.out.println("Departamento eliminado correctamente");
                }
                else {
                    contenidoArchivo.append(lineaLeida).append("\r\n");
                }
            }

            archivoLeer.close();

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "utf-8"));
            archivoEscribir.write(contenidoArchivo.toString());
            archivoEscribir.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
