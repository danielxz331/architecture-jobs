/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package command;

import java.io.OutputStream;

/**
 *
 * @author daniel
 */
public interface ICommand {
    public String getCommandName();
    public void execute(String[] args, OutputStream out);
}
