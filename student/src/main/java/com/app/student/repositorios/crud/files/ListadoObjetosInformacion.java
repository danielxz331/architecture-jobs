package com.app.student.repositorios.crud.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import com.app.student.interfaces.VisualizarInformacion;

/**
 *
 * @author daniel
 */
public class ListadoObjetosInformacion {
    String pathProyecto = System.getProperty("user.dir"); // Obtiene el directorio actual del proyecto
    String rutaArchivo = pathProyecto + "/src/main/resources/persistencia/archivos/lista_objetos.txt";

    private File archivo = new File(rutaArchivo);

    private ArrayList<VisualizarInformacion> lista = new ArrayList();

    public void adicionar(VisualizarInformacion ilista){
        this.lista.add(ilista);
    }

    public void remover(VisualizarInformacion ilista) {
        this.lista.remove(ilista);
    }

    public void persistir()
    {
        for (VisualizarInformacion visualizarInformacion : this.lista) {

            this.guardarObjetos(visualizarInformacion);

        }

        this.lista.clear();
    }

    public void cargar()
    {
        for (VisualizarInformacion visualizarInformacion : this.lista) {

            String informacion_objeto = visualizarInformacion.informacionObjeto();

            System.out.println(informacion_objeto);
        }
    }

    public void guardarObjetos(VisualizarInformacion objeto)
    {
        try {

            if (archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter archivoEscribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

            archivoEscribir.write(objeto.informacionObjeto()+"\r\n");

            archivoEscribir.close();

            System.out.println("Objeto agregado correctamente"+"\r\n");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
