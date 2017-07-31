package com.perets.test;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Алексей on 29.07.2017.
 */
public class InputFile {

    public ArrayList<String> parseInputFile(String File)
            throws FileNotFoundException {
        InputStreamReader inputFile = new InputStreamReader(
                new FileInputStream(File));
        BufferedReader bufRead = new BufferedReader(inputFile);
        String line;
        ArrayList<String> listOfPaths = new ArrayList<String>();
        int indexOfArray = 0;
        try {
            while ((line = bufRead.readLine()) != null) {
                listOfPaths.add(indexOfArray, line);
                indexOfArray++;
            }
            bufRead.close();
        } catch (IOException ex) {
            System.out.println("IO Exception " + ex);
        }
        return listOfPaths;
    }
}
