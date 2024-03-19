/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daniel
 */
public class CommandUtil {

    public static String[] tokenizerArgs(String args) {
        List<String> tokens = new ArrayList<>();
        char[] charArray = args.toCharArray();

        String contact = "";
        boolean inText = false;
        for (char c : charArray) {
            if (c == ' ' && !inText) {
                if (contact.length() != 0) {
                    tokens.add(contact);
                    contact = "";
                }
            } else if (c == '"') {
                if (inText) {
                    tokens.add(contact);
                    contact = "";
                    inText = false;
                } else {
                    inText = true;
                }
            } else {
                contact += c;
            }
        }
        if (contact.trim().length() != 0) {
            tokens.add(contact.trim());
        }

        String[] argsArray = new String[tokens.size()];
        argsArray = tokens.toArray(argsArray);
        return argsArray;
    }

    public static void main(String[] args) {
        String command = "file -an c:/dummy/dummy.txt \"Hola mundo tres veces\"";
        String[] tokens = CommandUtil.tokenizerArgs(command);
        System.out.println(Arrays.toString(tokens));
    }
}
