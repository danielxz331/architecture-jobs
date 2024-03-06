package com.app.student.crudArchivos;

import java.io.*;
import java.util.ArrayList;
import com.app.student.AplicacionSolid.Estudiante;
import com.app.student.interfaces.VisualizarInformacion;

/**
 *
 * @author daniel
 */
public class EstudiantesInscritos implements VisualizarInformacion{

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



    public void agregarEstudiante (Estudiante estudiante) {
        this.listado.add(estudiante);
    }

    public void eliminarEstudianteArchivo (int id) {
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

    public void editarEstudianteArchivo(int id, Estudiante estudiante)
    {
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

    public String obtenerEstudiantes()
    {
        StringBuilder contenidoArchivo = new StringBuilder();

        try {

            String lineaLeida = "";

            if (archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    contenidoArchivo.append(lineaLeida).append("\n");
                }

                archivoLeer.close();
            } else {
                System.out.println("No encuentra el archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return contenidoArchivo.toString();
    }

    public void guardarEstudiante(Estudiante estudiante)
    {
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

            this.guardarEstudiante(estudiante);

        }

        this.listado.clear();
    }
}
