package appLaunchTwo.GUI;


import appLaunchTwo.Classes.Program;
import appLaunchTwo.Logic.HandlerProgram;
import appLaunchTwo.Logic.MyFileIO;
import appLaunchTwo.Logic.TableModelProgram;
import appLaunchTwo.Test.ProcessLoad;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.LIGHT_GRAY;


public class FrameExecuting extends JFrame implements ActionListener, ListSelectionListener {

    private final String LOAD = "LOAD";
    private final String ADD = "ADD";
    private final String DEL = "DEL";
    private final String EDIT = "EDIT";
    private final String COPY = "COPY";
    private final String FIND = "FIND";
    private final String LAUNCH = "LAUNCH";
    private final String FINISHPR = "FINISH PROGRAM";
    private final String CLOSE = "CLOSE";

    private JTextField txtFileName = new JTextField();
    private JTextField txtFileExt = new JTextField();
    private JTextArea txtFoundFiles = new JTextArea();
    private JTextArea txtFileSave = new JTextArea();

    private JList<String> lists;
// ---------------- for JDIALOG findDialog -----------

// ---------------------------------------------------
//    private String[] str = {"ASDF","QQWEE","QADDAF"};
    private List<String> list = new ArrayList<>();

    private HandlerProgram handlerProgram = new HandlerProgram();

    JTable tableProgram = new JTable();

    private  JPanel panelJList = new JPanel();
    private   Process myappProcess, path;
    MyFileIO myFileIO = new MyFileIO();


    public FrameExecuting() throws HeadlessException, IOException {
            GridBagLayout grid  = new GridBagLayout();
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridwidth = GridBagConstraints.REMAINDER;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.insets = new Insets(5,5,0,5);

        lists = new JList();

        JFrame jFrame = new JFrame();

        jFrame.setTitle("THE APPLICATION FOR FINDING AND LAUNCHING PROGRAMS");

            jFrame.getContentPane().setBackground(Color.CYAN);
            JPanel panelLeft = new JPanel();
            JPanel panelRight = new JPanel();
            JPanel panelTop = new JPanel();
            JPanel panelBottom = new JPanel();
            JPanel panelCenter = new JPanel();

            panelLeft.setLayout(grid);
            panelLeft.setPreferredSize(new Dimension(200,30));

            panelLeft.add(createButton(grid,constraints,LOAD,LOAD));
            panelLeft.add(createButton(grid,constraints,ADD,ADD));
            panelLeft.add(createButton(grid,constraints,EDIT,EDIT));
            panelLeft.add(createButton(grid,constraints,COPY,COPY));
            panelLeft.add(createButton(grid,constraints,LAUNCH,LAUNCH));
            panelLeft.add(createButton(grid,constraints,DEL,DEL));

            panelRight.setPreferredSize(new Dimension(200,30));
            panelRight.setLayout(grid);

            grid.setConstraints(txtFoundFiles,constraints);


            grid.setConstraints(txtFileName,constraints);
            grid.setConstraints(txtFileExt,constraints);
            grid.setConstraints(txtFileSave,constraints);
            // -----
                MyFileIO myFileIO = new MyFileIO();

        //---------------


            txtFileSave.setText("programmms");
            myFileIO.setNameFile("programs");
            panelRight.add(txtFileSave);
            panelRight.add(createButton(grid,constraints,FIND,FIND));
      //      panelRight.add(createButton(grid,constraints,FINISHPR,FINISHPR));
            panelRight.add(createButton(grid,constraints,CLOSE,CLOSE));


        //jFrame.getContentPane().setBackground(Color.CYAN);
        tableProgram.setRowHeight(20);
        tableProgram.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       TableColumn tableColumn;
    //    tableProgram.getColumnModel().getColumn(0).setPreferredWidth(10);
      /* tableColumn.setPreferredWidth(10);*/
         //   tableProgram.setPreferredSize(new Dimension(300,400));

            JScrollPane jScrollPane = new JScrollPane(tableProgram);
             jScrollPane.setPreferredSize(new Dimension(700,300));
             //jScrollPane.setMaximumSize(new Dimension(800,700));


            JMenuBar jMenuBar = new JMenuBar();
            JMenu jMenu = new JMenu();
            JMenuItem jMenuFile = new JMenuItem("File");
            JMenuItem jMenuOpen = new JMenuItem("Open");
            JMenuItem jMenuClose = new JMenuItem("Close");

            jMenu.add(jMenuFile);
            jMenu.add(jMenuOpen);
            jMenu.add(jMenuClose);

            jMenuBar.add(jMenuFile);
            jMenuBar.add(jMenuOpen);
            jMenuBar.add(jMenuClose);

            jFrame.setJMenuBar(jMenuBar);

           // panelCenter.add(jScrollPane,BorderLayout.NORTH);

        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
//                tabWindow.addTab(...);
            jFrame.add(jScrollPane,BorderLayout.NORTH);
            }
        });


        grid.setConstraints(panelBottom,constraints);
            panelBottom.add(panelJList);
            panelBottom.setBackground(Color.LIGHT_GRAY);
            panelLeft.setBackground(new Color(200,189, 190, 200));
            panelRight.setBackground(new Color(200,189, 190, 200));

        jFrame.add(panelBottom,BorderLayout.SOUTH);



//            jFrame.add(panelBottom.add(new JLabel("  First ")));
            jFrame.add(panelLeft,BorderLayout.WEST);
            jFrame.add(panelRight,BorderLayout.EAST);
  //          jFrame.add(panelTop.add(new JLabel("asf")));
            jFrame.add(panelCenter,BorderLayout.CENTER);


            jFrame.setBounds(200,50,900,500);
          //  loadTable();
    //    jFrame.getContentPane().setBackground(new Color(0,220,250));
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }


    private JButton createButton(GridBagLayout grid, GridBagConstraints constraints, String title, String action) {
        JButton button = new JButton(title);
        button.setName(title);
        button.setOpaque(true);
        button.setBackground((LIGHT_GRAY));
        button.setActionCommand(action);
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(150,30));
        grid.setConstraints(button,constraints);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch(action){
            case LOAD:
                try {
                    loadTableFromFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case ADD:
                try {
                    addProgram();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case EDIT:
                try {
                    editProgram();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case COPY:
                try {
                    copyProgram();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case DEL:
                try {
                    delProgram();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case FIND:
                try {
                    findFrame("");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case FINISHPR:
               panelJList.add(loadProc());
                break;
            case LAUNCH:
                try {
                    launchProgram();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case CLOSE:
                System.exit(0);
                break;
        }
    }

    private JList loadProc() {
        return (new ProcessLoad().funcProc());
    }

    private void finishProgram() throws IOException {
        int strSel = tableProgram.getSelectedRow();
        String program = "cmd.exe";
        if(strSel != -1){
    //
            //        System.out.println(handlerProgram.findProgram(Integer.parseInt(tableProgram.getModel().getValueAt(strSel,0).toString())));
           Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
           // myappProcess.destroy();
            myappProcess.destroyForcibly();
        }
    }

    private void findFrame(String dir) throws IOException {
        FindDialog findDialog = new FindDialog();
    }

    private void launchProgram() throws IOException {
        int strSel = tableProgram.getSelectedRow();

        if(strSel != -1){
            int id = Integer.parseInt(tableProgram.getModel().getValueAt(strSel,0).toString());
            String programPath = handlerProgram.findProgram(id).getPath();
         //   System.out.println(programPath);
           if(programPath.endsWith("exe") && !programPath.contains("\\"))
                    myappProcess = Runtime.getRuntime().exec("powershell.exe Start-Process "+programPath+" -verb RunAs");
            //Process myappProcess = Runtime.getRuntime().exec("powershell.exe Start-Process -FilePath java.exe -Argument '-jar runasadmin.jar' -verb RunAs");
               // Проверить
           else if(programPath.endsWith("txt") ||programPath.endsWith("docx")||programPath.endsWith("doc")
                   ||programPath.endsWith("png")||programPath.endsWith("jpeg")||programPath.endsWith("jpg")  )
           {

               try {
                   Desktop desktop = Desktop.getDesktop();

               desktop.open(new File(programPath));

               }catch(IOException e){
                   System.out.println(e);
                   JOptionPane.showMessageDialog(this,e);
               }
               System.out.println(programPath+" Done.");

               System.out.println("File is jpg");
           }
           else if(programPath.contains("\\"))
            path = Runtime.getRuntime().exec(programPath);
        }else JOptionPane.showMessageDialog(this,"Please to select row!");

    }


    public void loadTable() throws IOException {
        List<Program> programList =  myFileIO.readFile();//handlerProgram.getProgramList();

        TableModelProgram tableModelProgram = new TableModelProgram(programList);
        //tableProgram.setModel(tableModelProgram);
        tableProgram.setModel(new DefaultTableModel());
    }

    public void loadTableFromFile() throws IOException {
        List<Program> programList = myFileIO.readFile(); // handlerProgram.getProgramList();

        handlerProgram.setProgramList(programList);
        TableModelProgram tableModelProgram = new TableModelProgram(programList);
        tableProgram.setModel(tableModelProgram);
    }

    private void copyProgram() throws IOException {
        int strSel = tableProgram.getSelectedRow();
        if(strSel != -1){
            int id = Integer.parseInt(tableProgram.getModel().getValueAt(strSel,0).toString());
            handlerProgram.copyProgram(handlerProgram.findProgram(id));
            myFileIO.writeFile(handlerProgram.getProgramList());
            loadTable();
        }else JOptionPane.showMessageDialog(this,"YOU NEED TO SELECT ROW!");
    }

    private void editProgram() throws IOException {
        int strSel = tableProgram.getSelectedRow();

        if (strSel != -1) {
            int id = Integer.parseInt(tableProgram.getModel().getValueAt(strSel, 0).toString());
            EditDialog editDialog = new EditDialog(handlerProgram.findProgram(id));
            if (editDialog.isSave()) {
                handlerProgram.updateProgram(editDialog.getProgram());
               myFileIO.writeFile(handlerProgram.getProgramList());
                loadTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "ddd YOU NEED TO SELECT ROW!");
        }
    }

    private void delProgram() throws IOException {
        int strSel = tableProgram.getSelectedRow();
        if(strSel != -1){
            int id =Integer.parseInt(tableProgram.getModel().getValueAt(strSel,0).toString());
            handlerProgram.deleteProgram(id);
            myFileIO.writeFile(handlerProgram.getProgramList());
            loadTable();
        }else{
            JOptionPane.showMessageDialog(this,"YOU NEED TO SELECT ROW!");
        }
    }

    private void addProgram() throws IOException {
        Program program = new Program();//3, "main.cpp", "C:\\appRes", "Source file C++");

        EditDialog editDialog = new EditDialog(program);
            if(editDialog.isSave()){
                handlerProgram.addProgram(editDialog.getProgram());
                myFileIO.writeFile(handlerProgram.getProgramList());
                loadTable();
            }
    }

    // ------------------------- FIND START

    public void findProgram2(String dir) {
        File path = new File(dir);
        String[] files = path.list();
        int count = 0;
        for (String it : files) {
            txtFoundFiles.append(it + "\n");
        }
    }

    //-----------------------------

        public File[] findProgram(String dir) throws IOException {
            String ext = "exe";
            File path = new File(dir);
            File[] files = path.listFiles();
            for(File it : files){

                if(it.isDirectory())
                    try {
                        findProgram(it.toString());
                    }catch(Exception e){
               //         System.out.println("Error "+ e);
                    }
                if(it.getName().endsWith(ext) && !(it.getName().startsWith("uninstal") || (it.getParent().endsWith("updater")) || (it.getName().startsWith("updater") ))) {
                    txtFoundFiles.append(it + "\n");
                    //txtFoundFiles.append(it + "\n");
               //     System.out.println(it);
                    //  if(flag > 2) break;
                    //    Process process = Runtime.getRuntime().exec(it.getAbsolutePath());

                }

            }
            return files;
        }

// -------------------


    private void findProgram(String dir,String ext) throws IOException {

        File path = new File(dir);
        try {
            File[] files = path.listFiles();
            for(File it:files){
              if(it.isDirectory())findProgram(it.toString(),ext);
                if(it.getName().endsWith(ext))
                    list.add(it.toString());
                    txtFoundFiles.setText(it.getAbsolutePath().toString());
            }

        }catch (Exception e){
          //  System.out.println("Error "+ e);
        }
   //     panelJList.add(new JButton("ADD to LIST?"));
    }
// ----------------------------- END FIND
// ----
/*
final JFileChooser fc = new JFileChooser();
    final DirectoryChooser directoryChooser = new DirectoryChooser();
    private void openFile() throws IOException {
        int returnVal = fc.showOpenDialog(menuOpen);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            System.out.println((file.getAbsolutePath()));
            if(file.getName().endsWith("txt") || file.getName().endsWith("xlsx")||
                    file.getName().endsWith("docx")||
                    file.getName().endsWith("docx")||
                    file.getName().endsWith("xls"))
                textArea.append(readFile(file.getAbsolutePath()));
            else if(file.getName().endsWith("png") ||
                    file.getName().endsWith("jpg") ||
                    file.getName().endsWith("jpeg")||
                    file.getName().endsWith("tiff") ||
                    file.getName().endsWith("bmp")){
                textArea.setVisible(false);
                openImage(file.getAbsolutePath());
                //  System.out.println("Graphics");
            }
            else {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(file.getAbsolutePath()));
                System.out.println("Done.");

            }
            //   log.append("Opening: " + file.getName() + "." + newline);
        } else {
            // log.append("Open command cancelled by user." + newline);
        }
    }
*/

/*
    private void openImage(String absolutePath) {
        frame.setVisible(false);
        ImageFrame imageFrame = new ImageFrame(new File(absolutePath));
        imageFrame.setVisible(true);
    }

    public String readFile(String nameFile) throws IOException {
        FileReader reader = new FileReader(nameFile);
        String text = "";
        int ch = -1;
        while ((ch = reader.read()) != -1) {
            text += (char) ch;
        }
        reader.close();
        return text;
    }
*/




    // ----------




    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
