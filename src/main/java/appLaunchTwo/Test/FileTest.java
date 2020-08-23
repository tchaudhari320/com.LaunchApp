package appLaunchTwo.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.jar.JarFile;

public class FileTest extends JFrame {


    public static void main(String[] args) {
        System.out.println("hello");
            new FileTest().recFileShow("c:\\Program Files");
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(100, 100);
        mainFrame.getContentPane().setBackground(Color.CYAN);
        mainFrame.setVisible(true);

       }

       public void recFileShow(String dir){
           File file = new File(dir);
          // try{
               File[] files = file.listFiles();

               for(File it: files) {
                    if(it.isDirectory())
                   {
                       // recFileShow(it.toString());
                    }

                   System.out.println(it.toString());
               }
           //}catch (Exception e){
             //  System.out.println("Error "+e);
           //}

       }
}
