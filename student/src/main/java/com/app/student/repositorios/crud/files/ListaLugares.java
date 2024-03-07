package com.app.student.repositorios.crud.files;

import java.io.*;
import java.util.ArrayList;

import com.app.student.aplicacion.Lugar;
import com.app.student.interfaces.VisualizarInformacion;

/**
 *
 * @author daniel
 */
public class ListaLugares implements VisualizarInformacion{

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


    public void agregarLugar (Lugar lugar) {
        this.lista.add(lugar);
    }

    public void eliminarLugar (int id) {
        try {
            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
            StringBuilder contenidoArchivo = new StringBuilder();

            String lineaLeida;
            while ((lineaLeida = archivoLeer.readLine()) != null) {
                if (lineaLeida.contains("Lugar"+"{id="+id)) {
                    System.out.println(lineaLeida);
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

    public String obtenerLugares()
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

    public void guardarLugar(Lugar lugar)
    {
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

            this.guardarLugar(lugar);

        }

        this.lista.clear();
    }
}
