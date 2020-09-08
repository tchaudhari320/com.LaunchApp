package appLaunchTwo.Test;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ProcessLoad extends JFrame{

    private JList proc;

    public JList funcProc(){
        DefaultListModel dfm = new DefaultListModel();
        proc = new JList();
        proc.setModel(dfm);

        try{
            String process;
            Process pr = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            while((process = input.readLine()) != null){
                //           System.out.println(process);
                dfm.addElement(process);
            }
            input.close();
        }catch (Exception err){
            err.printStackTrace();
        }
        return proc;
    }
/*

        public static void main(String[] args) {
            JFrame jFrame = new JFrame();
                jFrame.setBounds(100,50,500,400);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(new ProcessLoad().func());

            jFrame.setVisible(true);

        }
*/
}


