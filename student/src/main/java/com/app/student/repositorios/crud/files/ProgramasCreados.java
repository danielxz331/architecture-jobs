package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.app.student.aplicacion.Departamento;
import com.app.student.aplicacion.Estudiante;
import com.app.student.aplicacion.Programa;
import com.app.student.interfaces.VisualizarInformacion;
import com.app.student.interfaces.CRUD;
public class ProgramasCreados implements VisualizarInformacion, CRUD<Programa>{

    String pathProyecto = System.getProperty("user.dir");
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/programas.txt";

    private File archivo = new File(rutaArchivo);

    private ArrayList<Programa> listado = new ArrayList();


    @Override
    public void create(Programa programa) {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(programa.toString()+"\r\n");

            archivoEscribir.close();

            System.out.println("Programa agregado correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Programa getById(int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Programa"+"{id="+id)) {
                    System.out.println(lineaLeida);
                    String[] partes = lineaLeida.split(",");
                    String idProgramaStr = partes[0].split("=")[1].replaceAll("\\D+", "");
                    int idPrograma = Integer.parseInt(idProgramaStr);
                    String nombre = partes[1].split("=")[1];
                    String semestresStr = partes[2].split("=")[1].replaceAll("\\D+", "");
                    int semestres = Integer.parseInt(semestresStr);
                    String idDireccionStr = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int direccion = Integer.parseInt(idDireccionStr);

                    return new Programa(idPrograma, nombre, semestres, direccion);
                }
            }

            archivoLeer.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Programa> getAll() {
        try {

            String lineaLeida = "";

            List<Programa> list = new ArrayList();

            if (archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    String[] partes = lineaLeida.split(",");
                    String idProgramaStr = partes[0].split("=")[1].replaceAll("\\D+", "");
                    int idPrograma = Integer.parseInt(idProgramaStr);
                    String nombre = partes[1].split("=")[1];
                    String semestresStr = partes[2].split("=")[1].replaceAll("\\D+", "");
                    int semestres = Integer.parseInt(semestresStr);
                    String idDireccionStr = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int direccion = Integer.parseInt(idDireccionStr);

                    list.add(new Programa(idPrograma, nombre, semestres, direccion));
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
    public void update(int id, Programa programa) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Programa"+"{id="+id)) {
                    lineaLeida = programa.toString();
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
                if (lineaLeida.contains("Programa"+"{id=" + id)) {
                    System.out.println(lineaLeida);
                    System.out.println("Programa eliminado correctamente");
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

    @Override
    public String nombreClase() {
        return "ProgramasCreados";
    }

    @Override
    public String informacionObjeto() {
        String objetos = this.recorrerLista(listado);

        return objetos;
    }

    @Override
    public void persistir() {
        for (Programa programa : this.listado) {

            this.create(programa);

        }

        this.listado.clear();
    }

    public String recorrerLista(ArrayList<Programa> lista)
    {
        String objetos = "";

        for (Programa programa : lista) {

            objetos += programa.toString()+"\r\n";
        }

        return objetos;
    }
}
