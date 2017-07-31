package com.perets.test;

import java.io.File;

/**
 * Created by Алексей on 29.07.2017.
 */
public class Counter implements Runnable {

    // link to folder
    private String link;

    // sequence number of link
    private int sequenceNumber;

    // number of counted files
    private int countedFiles;

    public String getLink() {
        return link;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public int getCountedFiles() {
        return countedFiles;
    }

    public Counter(final int sequenceNumber, final String link) {
        this.sequenceNumber = sequenceNumber;
        this.link = link;
    }

    @Override
    public void run() {
        numberOfFiles(link);
        View.showResults(this);
        OutputFile.writeCsvFile(this);
    }

    private Integer numberOfFiles(final String Link) {
        File file = new File(Link);
        File[] files = file.listFiles();

        for (File path : files) {
            if (FolderData.isInterrupt() == true) {
                break;
            }
            if (path.isDirectory()) {
                numberOfFiles(path.getPath());
            }
            if (path.isFile()) {
                countedFiles++;
            }
        }
        return countedFiles;
    }
}