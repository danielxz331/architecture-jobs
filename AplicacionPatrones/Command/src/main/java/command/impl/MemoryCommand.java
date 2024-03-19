/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.impl;

import java.io.OutputStream; 

/**
 *
 * @author daniel
 */
public class MemoryCommand extends BaseCommand{
    
    public static final String COMMAN_NAME = "memory";

    @Override
    public String getCommandName() {
        return COMMAN_NAME; 
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        double heap = Runtime.getRuntime().totalMemory() / 1000000d;
        double heapMax = Runtime.getRuntime().maxMemory() / 1000000d;
        double heapFree = Runtime.getRuntime().freeMemory() / 1000000d;

        String salida = "Heap: " + heap + "\nMax Heap: "
        + heapMax + "\nFree Heap: " + heapFree;
        write(out, salida);
     } 
    
}
