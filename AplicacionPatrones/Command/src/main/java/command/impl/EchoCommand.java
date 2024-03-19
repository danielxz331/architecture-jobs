/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.impl;

import java.io.OutputStream;
import java.util.Arrays; 

/**
 *
 * @author daniel
 */
public class EchoCommand extends BaseCommand{
    
    public static final String COMMAN_NAME = "echo";

    @Override
    public String getCommandName() {
        return COMMAN_NAME; 
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = getCommandName() + " " + Arrays.toString(args);
        write(out, message); 
    }
    
}
