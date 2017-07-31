package com.perets.test;

import com.csvreader.CsvWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Алексей on 29.07.2017.
 */
public class OutputFile {

    public static void clearCSV(String outputFile) {
        try {
            FileWriter fstream = new FileWriter(outputFile);
            BufferedWriter bufstream = new BufferedWriter(fstream);
            bufstream.write("");
            bufstream.close();
        } catch (IOException ex) {
            System.out.println("File not found " + ex);
        }
    }

    public static void writeCsvFile(Counter counter) {
        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(FolderData.getOutFile(), true), ';');
            csvOutput.write(counter.getLink());
            csvOutput.write(Integer.toString(counter.getCountedFiles()));
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
    }
}