package com.javarush.task.task31.task3103;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {
//    public static List<Byte> listOfSizeFile=new ArrayList<>();

    public static byte[] readBytes(String fileName) throws Exception { // все байты файла
//        if (!Files.isDirectory(Paths.get(fileName))) {
        byte[] bytes=Files.readAllBytes(Paths.get(fileName));


        return bytes;
//       Files.walkFileTree(path, new MyFileVisitor( ) );
    }
//        Path path =Paths.get(fileName);
//
//       byte[] bytes =  new byte[listOfSizeFile.size()];
//       for (Byte longs: listOfSizeFile
//             ) {
//            System.out.println(longs);
//
//        }


    public static List<String> readLines(String fileName) throws Exception {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static void writeBytes(String fileName, byte[] bytes) throws Exception {
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws Exception {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//
//        try {
//            System.out.println(Arrays.toString(readBytes(scanner.nextLine())));
//            System.out.println( readLines(scanner.nextLine()).toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
//        @Override
//        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
//            listOfSizeFile.add(attrs.size());
//            return FileVisitResult.CONTINUE;
//        }

//
//        @Override
//        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            listOfSizeFile.add((byte) attrs.size());
//            return FileVisitResult.CONTINUE;
//        }
//    }
}
