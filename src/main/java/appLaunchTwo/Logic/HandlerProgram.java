package appLaunchTwo.Logic;

import appLaunchTwo.Classes.Program;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HandlerProgram {



    private List<Program> programList = new ArrayList<>();
    private static int flag = 0;

    public HandlerProgram() {
    /*    Program program1 = new Program(1, "test", "C:\\test", "Test Program");
        Program program2 = new Program(2, "main.exe", "C:\\app", "Execute file");
        Program program3 = new Program(3, "main.cpp", "C:\\appRes", "Source file C++");

        Program program4 = new Program(3, "test.txt", "C:\\txt", "TXT file");
        programList.add(program1);
        programList.add(program2);
        programList.add(program3);*/
    }

    public HandlerProgram(List<Program> programList) {
        this.programList = programList;
    }

    public void setProgramList(List<Program> programList){
        this.programList = programList;
    }

    public int addProgram(Program program){
      int id = generateId()+1;
            program.setId(id);
        if(programList.add(program)){

            return 0;
        }
        return -1;
    }

    private int generateId() {
            int id = programList.size();
            return id;
    }

    public Program findProgram(int id){
        return programList.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Program findProgram(String str){
        return programList.stream()
                .filter(programList -> str.equals(programList.getName()))
                .findAny()
                .orElse(findProgram(1));
    }

    public List<Program> getProgramList(){
        return programList;
    }

    public int deleteProgram(int id){
        Program temp = findProgram(id);
        if(temp != null){
            programList.remove(temp);
            return 0;
        }
        return -1;

    }

    public int updateProgram(Program program){
        Program changeProgram = findProgram(program.getId());
        if(changeProgram != null){
            changeProgram.setId(program.getId());
            changeProgram.setName(program.getName());
            changeProgram.setPath(program.getPath());
            changeProgram.setDescription(program.getDescription());
            return 0;
        }
        return -1;
    }

    public int copyProgram(Program program){
    int id = generateId() + 1;
    Program copiedProgram = new Program(id,program.getPath(),program.getName(),program.getDescription());
    programList.add(copiedProgram);

    return 0;
    }

    /**
     * This method for searching program on HDD
     * @author BOIKA
     * @version 1.0
     */
    public void searchFile(String dir ) throws IOException {
        String ext = "exe";
        File path = new File(dir);
        File[] files = path.listFiles();
        for(File it : files){

            if(it.isDirectory())
                try {
                    searchFile(it.toString());
                }catch(Exception e){
                    System.out.println("Error "+ e);
                }
            if(it.getName().endsWith(ext) && !(it.getName().startsWith("uninstal") || (it.getParent().endsWith("updater")) || (it.getName().startsWith("updater") ))) {
                System.out.println(it);
              //  if(flag > 2) break;
            //    Process process = Runtime.getRuntime().exec(it.getAbsolutePath());

            }

        }
        flag++;
    }

    public void searchNameProgram(String dir, String ext){
            File path = new File(dir);
            String[] files = path.list();
                int count = 0;
            for(String it:files){
                count++;
                if(count % 50 == 0) {
                    System.out.println("Press any key to continue...");
                    new Scanner(System.in).next();
                }
                    System.out.println(it);
            }

    }

}
