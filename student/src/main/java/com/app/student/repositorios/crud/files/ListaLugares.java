package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.app.student.aplicacion.Lugar;
import com.app.student.interfaces.VisualizarInformacion;
import com.app.student.interfaces.CRUD;

/**
 *
 * @author daniel
 */
public class ListaLugares implements VisualizarInformacion, CRUD<Lugar>{

    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/lista_lugares.txt";

    private File archivo = new File(rutaArchivo);

    private ArrayList<Lugar> lista= new ArrayList();

    public String recorrerLista(ArrayList<Lugar> lista)
    {
        String objetos = "";

        for (Lugar lugar : lista) {

            objetos += lugar.toString()+"\r\n";
        }

        return objetos;
    }

    @Override
    public String nombreClase()
    {
        return "ListaLugares";
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
        for (Lugar lugar : this.lista) {

            this.create(lugar);

        }

        this.lista.clear();
    }

    @Override
    public void create(Lugar lugar) {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(lugar.toString()+"\r\n");

            archivoEscribir.close();

            System.out.println("Lugar agregado correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Lugar getById(int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Lugar"+"{id="+id)) {
                    String[] partes = lineaLeida.split(",");
                    String direccion = partes[1].split("=")[1];
                    String idDepartamentoStr = partes[2].split("=")[1].replaceAll("\\D+", "");
                    int idDepartamento = Integer.parseInt(idDepartamentoStr);
                    String municipioIdStr = partes[3].split("=")[1].replaceAll("\\D+", "");
                    int municipioId = Integer.parseInt(municipioIdStr);

                    return new Lugar(id, direccion, idDepartamento, municipioId);
                }
            }

            archivoLeer.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Lugar> getAll() {
        return null;
    }

    @Override
    public void update(int id, Lugar lugar) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Lugar"+"{id="+id)) {
                    contenidoArchivo.append(lugar.toString()).append("\r\n");
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
    public void delete(int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Lugar"+"{id="+id)) {
                    System.out.println("Lugar eliminado correctamente");
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
