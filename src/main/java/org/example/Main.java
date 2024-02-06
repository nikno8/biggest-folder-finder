package org.example;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "C:/Users/nikit/OneDrive/Рабочий стол";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);

//        System.out.println(getFolderSize(file));

        long duration = (System.currentTimeMillis() - start) / 1000;
        System.out.println(duration + " seconds");
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        long sum = 0;
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}