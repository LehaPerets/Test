package com.perets.test;

import java.util.Formatter;

/**
 * Created by Алексей on 29.07.2017.
 */
public class View {

    static {
        Formatter fmt = new Formatter();
        System.out.println("Press <Esc> to cancel");
        System.out
                .println("----------------------------------------------------------------------------");
        fmt.format("%-4s| %-10s| %-21s ", "Sequential number", "Number of files found", "Source path for search");
        System.out.println(fmt);
        System.out
                .println("----------------------------------------------------------------------------");
        fmt.close();
    }

    public static void showResults(Counter counter) {
        Formatter fmt = new Formatter();
        if (FolderData.isInterrupt() == false) {
            fmt.format("%-4d             | %-15d      | %-22s", counter.getSequenceNumber(),
                    counter.getCountedFiles(), counter.getLink());
            System.out.println(fmt);
        } else {
            fmt.format("%-4d             | %-15d      | %-22s %-10s", counter.getSequenceNumber(),
                    counter.getCountedFiles(), counter.getLink(), "Cancelled");
            System.out.println(fmt);
        }
        fmt.close();
    }
}