package com.perets.test;

import org.jnativehook.NativeHookException;

public class Main {

    public static void main(String[] args) throws NativeHookException {

        // get program arguments
        String input = args[0];
        String output = args[1];

        // clear .csv file
        OutputFile.clearCSV(output);

        // create key listener
        Thread keyListener = new Thread(new KeyListener());
        keyListener.start();



        FolderData appLogic = new FolderData(input, output);
        appLogic.createThreadsForCountFiles();
    }


}
