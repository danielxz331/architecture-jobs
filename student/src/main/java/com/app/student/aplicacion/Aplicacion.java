package com.app.student.aplicacion;

import com.app.student.seeds.DATA_SEED;
/**
 *
 * @author daniel
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DATA_SEED dataSeed = new DATA_SEED();
        dataSeed.ejecutar();

    };

};
