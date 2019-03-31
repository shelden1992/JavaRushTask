package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    public List<Path> getFoundFiles() {

        return foundFiles;
    }

    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException { // path START, current director.
        //
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String string = new String(Files.readAllBytes(file));
        boolean containsName = true;
        boolean stringContent = true;
        boolean maxSizes = true;
        boolean minSizes = true;


        if (attrs.isDirectory())
            return FileVisitResult.CONTINUE;


        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            containsName = false;


        }
        if (partOfContent != null && !string.contains(partOfContent)) {
            stringContent = false;

        }
        if ( minSize !=0 && content.length < minSize) {
//            foundFiles.add(file);
            minSizes = false;

        }
        if (maxSize != 0 && content.length > maxSize) {
//            foundFiles.add(file);
            maxSizes = false;
        }


        if (containsName&& stringContent && maxSizes && minSizes){
            foundFiles.add(file);
        }







//
        return super.visitFile(file, attrs);
    }


}
