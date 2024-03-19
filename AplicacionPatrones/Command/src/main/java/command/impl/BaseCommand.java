/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.impl;

import java.io.OutputStream;
import command.ICommand;

/**
 *
 * @author daniel
 */
public abstract class BaseCommand implements ICommand{

    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args, OutputStream out);
    
    public void write(OutputStream out, String message) {
      try {
        out.write(message.getBytes());
        out.flush();
      } catch (Exception e) {
         e.printStackTrace();
      }
    } 
    
}
