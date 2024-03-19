/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.impl;

import command.ICommand;
import java.io.OutputStream;

/**
 *
 * @author daniel
 */
public class ExitCommand implements ICommand{

    public static final String COMMAND_NAME = "exit";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        System.exit(0);
    }
    
}
