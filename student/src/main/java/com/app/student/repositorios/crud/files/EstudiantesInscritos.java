package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.app.student.aplicacion.Departamento;
import com.app.student.aplicacion.Estudiante;
import com.app.student.interfaces.VisualizarInformacion;
import com.app.student.interfaces.CRUD;

/**
 *
 * @author daniel
 */
public class EstudiantesInscritos implements VisualizarInformacion, CRUD<Estudiante>{

    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/estudiantes.txt";

    private File archivo = new File(rutaArchivo);

    private ArrayList<Estudiante> listado = new ArrayList();

    public String recorrerLista(ArrayList<Estudiante> lista)
    {
        String objetos = "";

        for (Estudiante estudiante : lista) {

            objetos += estudiante.toString()+"\r\n";
        }

        return objetos;
    }

    @Override
    public String nombreClase() {
        return "EstudiantesInscritos";
    }

    @Override
    public String informacionObjeto() {
        String objetos = this.recorrerLista(listado);

        return objetos;
    }

    @Override
    public void persistir()
    {
        for (Estudiante estudiante : this.listado) {

            this.create(estudiante);

        }

        this.listado.clear();
    }

    @Override
    public void create(Estudiante estudiante) {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(estudiante.toString()+"\r\n");

            archivoEscribir.close();

            System.out.println("Estudiante agregado correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Estudiante getById(int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Estudiante"+"{id="+id)) {
                    System.out.println(lineaLeida);
                    String[] partes = lineaLeida.split(",");
                    int idParte = Integer.parseInt(partes[0].split("=")[1]);
                    String nombresParte = partes[1].split("=")[1];
                    String apellidosParte = partes[2].split("=")[1];
                    int codigoParte = Integer.parseInt(partes[3].split("=")[1]);
                    String idProgramaStr = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int programaidParte = Integer.parseInt(idProgramaStr);
                    String idDireccionStr = partes[4].split("=")[1].replaceAll("\\D+", "");
                    int direccionIdParte = Integer.parseInt(idDireccionStr);
                    return new Estudiante(nombresParte, apellidosParte, idParte, codigoParte, programaidParte, direccionIdParte);
                }
            }

            archivoLeer.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Estudiante> getAll() {
        try {

            String lineaLeida = "";

            List<Estudiante> list = new ArrayList();

            if (archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    String[] partes = lineaLeida.split(",");
                    String idString = partes[0].split("=")[1].replaceAll("\\D+", "");
                    int idParte = Integer.parseInt(idString);
                    String nombresParte = partes[1].split("=")[1];
                    String apellidosParte = partes[2].split("=")[1];
                    String codigoString = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int codigoParte = Integer.parseInt(codigoString);
                    String idProgramaStr = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int programaidParte = Integer.parseInt(idProgramaStr);
                    String idDireccionStr = partes[4].split("=")[1].replaceAll("\\D+", "");
                    int direccionIdParte = Integer.parseInt(idDireccionStr);
                    list.add(new Estudiante(nombresParte, apellidosParte, idParte, codigoParte, programaidParte, direccionIdParte));
                }

                archivoLeer.close();
                return list;
            } else {
                System.out.println("No encuentra el archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Estudiante estudiante) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Estudiante"+"{id="+id)) {
                    lineaLeida = estudiante.toString();
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
                if (lineaLeida.contains("Estudiante"+"{id=" + id)) {
                    System.out.println(lineaLeida);
                    System.out.println("Estudiante eliminado correctamente");
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
