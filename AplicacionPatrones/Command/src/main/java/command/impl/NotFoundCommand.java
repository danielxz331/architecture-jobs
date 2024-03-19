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
public class NotFoundCommand extends BaseCommand {

    private static final String COMMAND_NAME = "NOT FOUND";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        write(out, "Comando no encontrado");
    }
}
