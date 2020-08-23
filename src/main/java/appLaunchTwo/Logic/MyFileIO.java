package appLaunchTwo.Logic;


import appLaunchTwo.Classes.Program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileIO {
        private String pathFile;
        private String nameFile;

        public MyFileIO() {
            pathFile = "C://Java/";
            nameFile = "programs.txt";
        }

        public MyFileIO(String pathFile, String nameFile) {
            this.pathFile = pathFile;
            this.nameFile = nameFile;
        }

        public String getPathFile() {
            return pathFile;
        }

        public void setPathFile(String pathFile) {
            this.pathFile = pathFile;
        }

        public String getNameFile() {
            return nameFile;
        }

        public void setNameFile(String nameFile) {
            this.nameFile = nameFile;
        }

        public void writeFile(List<Program> recordList) throws IOException {
            FileWriter writer = new FileWriter(pathFile + nameFile);
            for (Program it : recordList) {
                writer.write(it.getId()  + "|" + it.getPath() + "|" + it.getName()+"|" + it.getDescription() );
                writer.append('\n');
            }
            writer.close();
        }

        public List<Program> readFile() throws IOException {
            FileReader reader = new FileReader(pathFile + nameFile);
            List<Program> recordList = new ArrayList<>();
            Program record = new Program();
            int ch, flag = 0;
            String str = new String();
            while ((ch = reader.read()) != -1) {
                str += (char) ch;
                if ((char) ch == '|' && flag == 0) {
                    record.setId(Integer.parseInt(str.substring(0,str.length()-1)));
                    str = "";
                    flag++;
                } else if ((char) ch == '|' && flag == 1) {
                    record.setPath(str.substring(0,str.length()-1));
                    str = "";
                    flag++;
                } else if ((char) ch == '|' && flag == 2) {
                    record.setName(str.substring(0,str.length()-1));
                    str = "";
                    flag++;
                } else if ((char) ch == '|' && flag == 3) {
                    record.setDescription(str.substring(0,str.length()-1));
                    str = "";
                    flag++;
                } else if ((char) ch == '\n') {
                    recordList.add(new Program(record.getId(),  record.getPath(), record.getName(),record.getDescription()));
                    str = "";
                    flag = 0;
                }
            }
            return recordList;
        }
    }


