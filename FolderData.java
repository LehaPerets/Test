package com.perets.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 29.07.2017.
 */

public class FolderData {

    private static InputFile inFile;
    private static String outFile;

    // folder link
    private String link;

    private List<Thread> counterThreads;

    // flag of count completion
    private static boolean interrupt = false;

    public static boolean isInterrupt() {
        return interrupt;
    }

    public static void setInterrupt(boolean interrupt) {
        FolderData.interrupt = interrupt;
    }

    public static String getOutFile() {
        return outFile;
    }

    public FolderData(final String inputLinks, final String outFile) {
        inFile = new InputFile();
        this.link = inputLinks;
        this.counterThreads = new ArrayList<Thread>();
        FolderData.outFile = outFile;
    }

    public void createThreadsForCountFiles() {
        try {
            int numberOfSequence = 0;
            // if the input file is empty
            if (inFile.parseInputFile(link).size() == 0) {
                System.out.println("No link");
                return;
            }
            for (String path : inFile.parseInputFile(this.link)) {
                numberOfSequence++;
                counterThreads.add(new Thread(new Counter(
                        numberOfSequence, path), path));
            }

            // starting threads
            for (Thread thread : counterThreads) {
                thread.start();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException " + ex);
        }
    }
}