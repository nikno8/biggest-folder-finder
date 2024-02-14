package org.example;

import java.io.File;

public class ParametrsBag {

    private long limit;
    private String path;

    public ParametrsBag(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Укажите два параметра");
        }
        limit = 0;
        path = "";
        for (int i = 0; i < 4; i += 2){
            if (args[i].equals("-l") ){
                limit = SizeCalculator.getSizeFromHumanReadable(args[i+1]);
            } else if (args[i].equals("-d")){
                path = args[i+1];
            }
        }

        if (limit <= 0){
            throw new IllegalArgumentException("Лимит указан неверно");
        }
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()){
            throw new IllegalArgumentException("Путь к папке указан неверно");
        }

    }

    public long getLimit() {
        return limit;
    }

    public String getPath() {
        return path;
    }
}
