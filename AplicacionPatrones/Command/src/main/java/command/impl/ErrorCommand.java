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
public class ErrorCommand extends BaseCommand {

    private static final String COMMAND_NAME = "ERROR";

    @Override
    public String getCommandName() { 
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = "Error al invocar el comando";
        write(out, message);
    }

}
