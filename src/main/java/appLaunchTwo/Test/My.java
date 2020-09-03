package appLaunchTwo.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class My {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\test";
        DirContentNIO dirContentNIO = new DirContentNIO();
        try {
            Files.walkFileTree(Paths.get(dir), dirContentNIO);
            dirContentNIO.getFiles();

        }catch(IOException e){
             e.printStackTrace();
        }


    }
}
