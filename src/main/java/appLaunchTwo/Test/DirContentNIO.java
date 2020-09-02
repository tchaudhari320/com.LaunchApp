package appLaunchTwo.Test;

import javax.naming.directory.BasicAttribute;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public  class DirContentNIO extends SimpleFileVisitor<Path> {
    private String nameFile;
    private String pathFile;
    List<String> stringList = new ArrayList<>();

    public DirContentNIO() {
    }

    public DirContentNIO(String nameFile, String pathFile) {
        this.nameFile = "programs";
        this.pathFile = pathFile;
    }

    public List<String> readFiles(String dir) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dir))) {

            for (Path it : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(it, BasicFileAttributes.class);
                if (attributes.isDirectory())
                    System.out.println(it.getName(0).toString());
                stringList.add(it.getName(1).toString());
                // }
            }
        } catch (InvalidPathException | IOException e) {
            System.out.println("ERROR PATH " + e);
        }
        return stringList;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        if(path.toString().endsWith(".exe") || path.toString().endsWith(".zip"))
            stringList.add(path.toString());
        return FileVisitResult.CONTINUE;
    }
    public List<String> getFiles(){

           return stringList;
    }

}
