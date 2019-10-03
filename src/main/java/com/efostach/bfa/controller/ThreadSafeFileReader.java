package com.efostach.bfa.controller;

import java.io.*;

public class ThreadSafeFileReader implements Runnable {
    private static String backupFilepath = "./src/main/java/com/efostach/bfa/resources/backup/backup_";
    private File file;

    public ThreadSafeFileReader(File file) {
        this.file = file;
        new Thread(this).start();
    }

    @Override
    public void run() {
        FileOutputStream fout = null;

        try (FileInputStream fin = new FileInputStream(file)) {
            fout = new FileOutputStream(new File(backupFilepath + file.getName()));
            Integer data = fin.read();
            while (!data.equals(-1)) {
                fout.write(data);
                data = fin.read();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла ввода");
            }
        }
    }
}


