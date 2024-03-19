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
public abstract class AsyncCommand extends BaseCommand {

    public void execute(final String[] args, final OutputStream out) {
        new Thread(new Runnable() {
            public void run() {
                executeOnBackground(args, out);
            }
        }).start();
    }

    public abstract void executeOnBackground(String[] args, OutputStream out);
}

