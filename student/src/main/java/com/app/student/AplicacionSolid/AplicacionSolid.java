package com.app.student.AplicacionSolid;

import com.app.student.seeds.DATA_SEED;
/**
 *
 * @author daniel
 */
public class AplicacionSolid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DATA_SEED dataSeed = new DATA_SEED();
        dataSeed.ejecutar();

    };

};
