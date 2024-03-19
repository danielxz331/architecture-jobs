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
public class WaitAndSayHello extends AsyncCommand {

    public static final String COMMAND_NAME = "waithello";

    @Override
    public void executeOnBackground(String[] args, OutputStream out) {
        if (args == null || args.length < 1) {
            write(out, "Parámetros insuficientes");
            return;
        }

        Long time = null;
        try {
            time = Long.parseLong(args[0]);
        } catch (Exception e) {
            write(out, "Tiempo inválido");
            return;
        }

        try {
            Thread.sleep(time.longValue());
            write(out, "Hello!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

}

