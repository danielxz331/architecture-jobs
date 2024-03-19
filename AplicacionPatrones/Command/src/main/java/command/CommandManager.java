/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.HashMap;
import command.impl.*;
/**
 *
 * @author daniel
 */
public class CommandManager {
    private static CommandManager commandManager;

    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =
       new HashMap<String, Class<? extends ICommand>>();

    private CommandManager() {
       registCommand(EchoCommand.COMMAN_NAME, EchoCommand.class);
       registCommand(DirCommand.COMMAND_NAME, DirCommand.class);
       registCommand(DateTimeCommand.COMMAND_NAME, DateTimeCommand.class);
       registCommand(MemoryCommand.COMMAN_NAME, MemoryCommand.class);
       registCommand(FileCommand.COMMAND_NAME, FileCommand.class);
       registCommand(ExitCommand.COMMAND_NAME, ExitCommand.class);
       registCommand(BatchCommand.COMMAND_NAME, BatchCommand.class);
       registCommand(WaitAndSayHello.COMMAND_NAME, WaitAndSayHello.class);
    }

    public static synchronized CommandManager getIntance() {
      if (commandManager == null) {
          commandManager = new CommandManager();
      }

      return commandManager;
    }
    
    public ICommand getCommand(String commandName) {
        if (COMMANDS.containsKey(commandName.toUpperCase())) {
        try {
            return COMMANDS.get(commandName.toUpperCase()).newInstance();
        } catch (Exception e) {
        e.printStackTrace();
        return new ErrorCommand();
        }
    } else {
        return new NotFoundCommand();
        }
    }

    public void registCommand(String commandName, Class<? extends ICommand> command) {
        COMMANDS.put(commandName.toUpperCase(), command);
    }
    
    public static synchronized CommandManager getInstance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
        }
 
 }

