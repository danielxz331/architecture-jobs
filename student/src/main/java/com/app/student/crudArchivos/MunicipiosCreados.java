package com.app.student.crudArchivos;

import java.io.*;
import java.util.ArrayList;

import com.app.student.AplicacionSolid.Municipio;
import com.app.student.interfaces.VisualizarInformacion;


/**
 *
 * @author daniel
 */
public class MunicipiosCreados implements VisualizarInformacion{
    private ArrayList<Municipio> lista= new ArrayList();
    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/municipios.txt";

    private File archivo = new File(rutaArchivo);

    public void agregarMunicipio (Municipio municipio) {
        this.lista.add(municipio);
    }

    public void eliminarMunicipioArchivo (int id) {
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

    public void editarMunicipioArchivo(int id, Municipio municipio)
    {
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

    public String obtenerMunicipios()
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

    public void guardarMunicipio(Municipio municipio)
    {
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

            this.guardarMunicipio(municipio);

        }

        this.lista.clear();
    }
}
