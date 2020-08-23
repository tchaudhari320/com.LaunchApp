package appLaunchTwo.Test;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReadDataFromHDD extends JFrame implements ActionListener, ListSelectionListener {
        private String nameFile;
        private String pathFile;

        JList jList = new JList();

    private final String SAVE = "SAVE";
    private final String FIND = "FIND";
    private final String CANCEL = "CANCEL";

    public ReadDataFromHDD() throws HeadlessException {
        JFrame jFrame = new JFrame("Test Read data From HDD");
        jFrame.setLayout(new GridLayout(3,3));

        createBtn();



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(100,50,500,400);
        jFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case SAVE:
                    //saveData();
                break;
            case FIND:
                    //
                break;
            case CANCEL:
                System.exit(0);
                break;
            default:
                System.out.println("DEFAULT");
                break;

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    private void createBtn(){

        JPanel panelBtn = new JPanel();
        panelBtn.setBounds(20,300,250,50);
        panelBtn.setLayout(new GridLayout(1,2));


        JButton buttonSave = new JButton("SAVE");
        buttonSave.setName("save");
        buttonSave.addActionListener(this);
        buttonSave.setActionCommand(SAVE);
        buttonSave.setBounds(50,300,80,30);

        panelBtn.add(buttonSave);
        add(panelBtn);

        JButton buttonFind = new JButton("FIND");
        buttonFind.setName("find");
        buttonFind.addActionListener(this);
        buttonFind.setActionCommand(FIND);
        buttonFind.setBounds(250,300,80,30);

        panelBtn.add(buttonFind);
        add(panelBtn);

        JButton buttonCancel = new JButton("CANCEL");
        buttonCancel.setName("cancel");
        buttonCancel.addActionListener(this);
        buttonCancel.setActionCommand(CANCEL);
        buttonCancel.setBounds(150,300,80,30);
        panelBtn.add(buttonCancel);
        add(panelBtn);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Test Read Data!");
        String dir = "c:\\Program Files (x86\\Notepad++\\)";
   // for(String it : new FilePathSearch().searchFile(dir)){
     //   System.out.println(it);
        long timeStart = System.currentTimeMillis();
     //int count =  new FilePathSearch().searchFile(dir);
       // System.out.println((System.currentTimeMillis()-timeStart));
       // System.out.println("count obj = "+count);
       /* String[] commands = {"cmd.exe", "C:\\batnics", "cmd.bat"};
        ProcessBuilder pb = new ProcessBuilder(commands);

        pb.start();*/

        //Process myappProcess = Runtime.getRuntime().exec("powershell.exe Start-Process cmd.exe -verb RunAs");
       }
    }

