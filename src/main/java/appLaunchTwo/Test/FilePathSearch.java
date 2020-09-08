package appLaunchTwo.Test;

import java.io.File;

import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePathSearch {
    private String nameFile;
    private String pathFile;
    private    List<String> fileList = new ArrayList<>();
    private    List<String> stringList = new ArrayList<>();
    private static int flag = 0;

    public FilePathSearch() {
    }

    public List<String> searchDir(String dir,char ch) {
//        System.out.println("ALL DIRECTORIES and FILES ONLY NAME");
        File path = new File(dir);
        String[] allObj = path.list();

        for (String it : allObj) {
            try {
             //   if (it.endsWith("exe")) {
               //     System.out.println("Execute FIle " + it);
                    stringList.add(it);
               // } else {
            //        System.out.println(" " + it);
                    stringList.add(it);
                //}
            }catch(Exception e){
        //        System.out.println("Error "+e);
            }
        }
        return stringList;
    }

    public List<String> searchDir(String dir, int n) {
        File path = new File(dir);
        OnlyExt onlyExt = new OnlyExt("exe");
        String[] files = path.list((FilenameFilter) onlyExt);

    //    System.out.println("ALL DIRECTORIES and FILES ABSOLUTELY PATHS ");

        for (String it : files) {
            try {
              //  if (it.isDirectory()) {
     //               System.out.println("<DIR> " + it);
                    fileList.add(it.toString());
                //} else {
                   // System.out.println("<File> " + it);
                 //   fileList.add(it.toString());
               // }
            }catch(Exception e){
              //  System.out.println("Error +"+e);
            }
        }
        return fileList;
    }

        //          METHOD WITH RECURSION
    public List<String> searchDir(String dir){

             File path = new File(dir);
             File[] files = path.listFiles();

            for(File it:files) {
                if (it.isDirectory()) {
                    try {
                       searchDir(it.toString());
                    }catch (Exception e){
              //          System.out.println("Error "+e);
                    }
                }
                if(it.getName().endsWith("exe"))
                fileList.add(it.toString());
              /*  if (it.isDirectory()) {
                  System.out.println("<DIR> " + it);
                    fileList.add(it.toString());
                } else {
                    System.out.println("<File> " + it);
                    fileList.add(it.toString());
                }*/
            }
        return fileList;

    }


    public List<String> searchFile(String dir ) throws IOException {
        String ext = "exe";
        File path = new File(dir);
        File[] files = path.listFiles();

        for(File it : files){

            if(it.isDirectory())
                try {
                    searchFile(it.toString());
                }catch(Exception e){
          //          System.out.println("Error "+ e);
                }
            if(it.getName().endsWith(ext) && !(it.getName().startsWith("uninstal") || (it.getParent().endsWith("updater")) || (it.getName().startsWith("updater") ))) {
               // System.out.println(it);
                stringList.add(it.toString());
                //  if(flag > 2) break;
                //    Process process = Runtime.getRuntime().exec(it.getAbsolutePath());

            }

        }
        flag++;
        return stringList;
    }

  /*  public static void main(String[] args) {
       // for(String it :  new FilePathSearch().searchDir("C:\\Program Files (x86)\\"+"Adobe")) {
      //      System.out.println(it);
   //     }
    }*/
}
