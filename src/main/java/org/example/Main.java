package org.example;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {


    public static void main(String[] args) {
        for (String arg: args){
            System.out.println(arg);
        }
        ParametrsBag bag = new ParametrsBag(args);


        String folderPath = bag.getPath();
        long sizeLimit = bag.getLimit();
        File file = new File(folderPath);
        Node root = new Node(file);
        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root.toString(sizeLimit));;


        long duration = (System.currentTimeMillis() - start);
        System.out.println(duration + " ms");
    }




}