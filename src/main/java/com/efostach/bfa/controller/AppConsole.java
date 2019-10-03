package com.efostach.bfa.controller;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppConsole {

    private String sourceFilepath = "./src/main/java/com/efostach/bfa/resources/files";
    private Integer countThreads = Runtime.getRuntime().availableProcessors();
    private File[] listFiles = new File(sourceFilepath).listFiles();

    public void run() {
        ExecutorService es = Executors.newFixedThreadPool(countThreads);

        assert listFiles != null;
        for (File entity : listFiles) {
            es.submit(new ThreadSafeFileReader(entity));
        }
        es.shutdown();
    }
}
