package appLaunchTwo.GUI;

import appLaunchTwo.Classes.Program;
import appLaunchTwo.Logic.HandlerProgram;
import appLaunchTwo.Logic.MyFileIO;
import appLaunchTwo.Test.DirContentNIO;
import appLaunchTwo.Test.FilePathSearch;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FindDialog extends JDialog implements ActionListener, ListSelectionListener {

    private JTextField txtFileName = new JTextField();
    private JTextField txtProgram = new JTextField();
    private JTextArea txtFoundFiles = new JTextArea();
    private JList<String> lists;


    private final String SAVE = "SAVE";
    private final String FIND = "FIND";
    private final String CANCEL = "CANCEL";
    private final String SHOWINFO = "SHOWINFO";
    private  static String   pathDefault  = null; //"C:\\Program Files (x86)\\";
    private JList listFindDialog = new JList();
    private   List<String> resFiles = new ArrayList<>();
    private JList listINFO = new JList();

    private static int flag = 0;

    private HandlerProgram handlerProgram = new HandlerProgram();
    MyFileIO myFileIO = new MyFileIO();

    public FindDialog() throws IOException {
        //setLayout(null);
         createBtnSC();
         add(createTxtArea());
         JPanel panelRight = new JPanel();
      txtFileName.setText("C:\\Program Files (x86)\\");

      //  getContentPane().setBackground(new Color(60,50,60));
        panelRight.add(txtFileName);

        panelRight.add(txtProgram);

        panelRight.setLayout(new GridLayout(2,6));

     //   panelRight.setBackground(new Color(10,40,80));
        add(panelRight,BorderLayout.NORTH);

       pathDefault = txtFileName.getText();

        setModal(true);
        setBounds(100,50,500,400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      //  pack();
        setVisible(true);

    }


    private void initTxtArea(List<String> files) {
        DefaultListModel dfm = new DefaultListModel();
        listFindDialog.setModel(dfm);

        for(String it:files){
            dfm.addElement(it);

        }
    }


 private JPanel createTxtArea() {

     JPanel panel = new JPanel();
     panel.setLayout(new GridLayout(2,2));
    listFindDialog.addListSelectionListener(this);
     panel.add(new JScrollPane(listFindDialog),BorderLayout.CENTER);
     panel.setBackground(new Color(90,140, 150, 100));
     return panel;
    }

    private void createBtnSC() {
        setTitle("TYPE THE FOLDER NAME MANUALLY!");
        JPanel panelBtn = new JPanel();
        panelBtn.setBounds(80,300,350,30);
        panelBtn.setLayout(new GridLayout(1,2));


        JButton buttonSave = new JButton("SAVE");
        buttonSave.setName("save");
        buttonSave.addActionListener(this);
        buttonSave.setActionCommand(SAVE);
        buttonSave.setBounds(100,300,350,30);

        panelBtn.add(buttonSave);
        add(panelBtn);

        JButton buttonFind = new JButton("FIND");
        buttonFind.setName("find");
        buttonFind.addActionListener(this);
        buttonFind.setActionCommand(FIND);
        buttonFind.setBounds(250,200,350,30);

        panelBtn.add(buttonFind);
        add(panelBtn);

        JButton buttonShowInfo = new JButton(SHOWINFO);
        buttonShowInfo.setName("showinfo");
        buttonShowInfo.addActionListener(this);
        buttonShowInfo.setActionCommand(SHOWINFO);
        buttonShowInfo.setBounds(200,300,350,30);

        panelBtn.add(buttonShowInfo);
        add(panelBtn);

        JButton buttonCancel = new JButton("CANCEL");
        buttonCancel.setName("cancel");
        buttonCancel.addActionListener(this);
        buttonCancel.setActionCommand(CANCEL);
        buttonCancel.setBounds(200,300,350,30);
        panelBtn.add(buttonCancel);
        add(panelBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case SAVE:
                try {
                    handlerProgram.setProgramList(myFileIO.readFile());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                handlerProgram.addProgram(new Program(handlerProgram.getProgramList().size(),listFindDialog.getSelectedValue().toString(),"",""));
                try {
                    myFileIO.writeFile(handlerProgram.getProgramList());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case FIND:
                List<String> stringList = new ArrayList<>();

                if(txtProgram.getText().isEmpty()) {
                 //   System.out.println("Empty" + txtFileName.getText()+txtProgram.getText());
                   stringList = new FilePathSearch().searchDir(txtFileName.getText().toString()+txtProgram.getText().toString(),'1');
                 //  stringList = new DirContentNIO().readFiles();

                }
                else {
                  //  System.out.println("There is word here "+txtProgram.getText());
                    try {
                        stringList = new FilePathSearch().searchFile(txtFileName.getText().toString()+txtProgram.getText().toString());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    //stringList = new FilePathSearch().searchDir("C:\\Program Files (x86)\\Adobe");

                }
                txtProgram.setText("");
                 initTxtArea(stringList);

                break;
            case SHOWINFO:
                showinfoFunc();
                break;
            case CANCEL:
                setVisible(false);
                break;
        }
    }

    private void showinfoFunc() {
      List<String> listInfo = new ArrayList<>();
       /* listInfo.add("https://overcoder.net/q/137598/java-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-%D0%BE%D1%82-%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8-%D0%B0%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%B0#:~:text=%D0%92%20%D0%BC%D0%B5%D0%BD%D1%8E%20%22%D0%9F%D1%83%D1%81%D0%BA%22%20%D0%B2%D0%B2%D0%B5%D0%B4%D0%B8%D1%82%D0%B5%20cmd,%D0%B1%D1%83%D0%B4%D0%B5%D1%82%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%D1%82%D1%8C%20%D1%81%20%D0%BF%D1%80%D0%B0%D0%B2%D0%B0%D0%BC%D0%B8%20%D0%B0%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%B0.");
        listInfo.add("  Process myappProcess = Runtime.getRuntime().exec(\"powershell.exe Start-Process <program.exe> -verb RunAs\"");//Запуск cmd etc
        listInfo.add(" Process myappProcess = Runtime.getRuntime().exec(\"powershell.exe Start-Process notepad.exe -verb RunAs\");");// Запуск для jar.  Mot prove
       */
        listInfo.add("FOR TEST!");
        initTxtArea(listInfo);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        txtProgram.setText("");
        try {
            txtProgram.setText(listFindDialog.getSelectedValue().toString());
        }catch(Exception er){
     //       System.out.println("Error txtProgram "+er);
        }
        }
    }



