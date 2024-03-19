/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CommandMain {

    public static void main(String[] args) {
        System.out.println("Command Line is Start");
        CommandManager manager = CommandManager.getInstance();

        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if (line.trim().length() == 0) {
                continue;
            }
            String[] commands = CommandUtil.tokenizerArgs(line);
            String commandName = commands[0];
            String[] commandArgs = null;
            if (commands.length > 1) {
                commandArgs = Arrays.copyOfRange(commands, 1, commands.length);
            }
            ICommand command = manager.getCommand(commandName);
            command.execute(commandArgs, System.out);
            System.out.println("");
        }
    }
}
