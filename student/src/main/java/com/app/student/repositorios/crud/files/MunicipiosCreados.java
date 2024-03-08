package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.app.student.aplicacion.Municipio;
import com.app.student.interfaces.VisualizarInformacion;
import com.app.student.interfaces.CRUD;


/**
 *
 * @author daniel
 */
public class MunicipiosCreados implements VisualizarInformacion, CRUD<Municipio>{
    private ArrayList<Municipio> lista= new ArrayList();
    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/municipios.txt";

    private File archivo = new File(rutaArchivo);

    public String recorrerLista(ArrayList<Municipio> lista)
    {
        String objetos = "";

        for (Municipio municipio : lista) {

            objetos += municipio.toString()+"\r\n";
        }

        return objetos;
    }

    @Override
    public String nombreClase() {
        return "MunicipiosCreados";
    }

    @Override
    public String informacionObjeto() {
        String objetos = this.recorrerLista(lista);

        return objetos;
    }

    @Override
    public void persistir()
    {
        for (Municipio municipio : this.lista) {

            this.create(municipio);

        }

        this.lista.clear();
    }

    @Override
    public void create(Municipio municipio) {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(municipio.toString()+"\r\n");

            archivoEscribir.close();

            System.out.println("Municipio agregado correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Municipio getById(int id) {
        try {

            String lineaLeida = "";

            if (archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    if (lineaLeida.contains("Municipio"+"{id="+id)) {
                        String[] partes = lineaLeida.split(",");
                        String nombre = partes[1].split("=")[1];
                        String idDepartamentoStr = partes[2].split("=")[1].replaceAll("\\D+", "");
                        int idDepartamento = Integer.parseInt(idDepartamentoStr);
                        return new Municipio(id, nombre, idDepartamento);
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
    public List<Municipio> getAll() {
        return null;
    }

    @Override
    public void update(int id, Municipio municipio) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Municipio"+"{id="+id)) {
                    lineaLeida = municipio.toString();
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
                if (lineaLeida.contains("Municipio"+"{id="+id)) {
                    System.out.println(lineaLeida);
                    System.out.println("Municipio eliminado correctamente");
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
