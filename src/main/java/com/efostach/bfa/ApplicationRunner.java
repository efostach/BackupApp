package com.efostach.bfa;

import com.efostach.bfa.controller.ThreadSafeFileReader;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationRunner {
    public static void main(String[] args) {

        String sourceFilepath = "./src/main/java/com/efostach/bfa/resources/files";
        Integer countThreads = Runtime.getRuntime().availableProcessors();
        File[] listFiles = new File(sourceFilepath).listFiles();

        ExecutorService es = Executors.newFixedThreadPool(countThreads);

        assert listFiles != null;
        for(File entity : listFiles) {
            es.submit(new ThreadSafeFileReader(entity));
        }
        es.shutdown();
    }
}

