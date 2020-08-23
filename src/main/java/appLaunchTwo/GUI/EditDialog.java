package appLaunchTwo.GUI;

import appLaunchTwo.Classes.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDialog extends JDialog implements ActionListener {
    private final String SAVE = "SAVE";
    private final String CANCEL = "CANCEL";

    private boolean save = false;

    private final JTextField txtId = new JTextField();
    private final JTextField txtPath = new JTextField();
    private final JTextField txtFile = new JTextField();
    private final JTextField txtDescription = new JTextField();


    public EditDialog(Program program) throws HeadlessException {

        setLayout(null);
        buildBtn();
        buildField();
        initFiled(program);

        getContentPane().setBackground(new Color(90,140, 150, 100));
        setModal(true);
        setBounds(100,50,310,340);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initFiled(Program program) {
        txtId.setText(program.getId() + "");
        txtPath.setText(program.getPath());
        txtFile.setText(program.getName());
        txtDescription.setText(program.getDescription());
    }

    private void buildField() {
        JLabel labelId = new JLabel("ID");
        labelId.setBorder(BorderFactory.createEtchedBorder());
        labelId.setBounds(10,10,80,30);
//        add(labelId);

        txtId.setBorder(BorderFactory.createEtchedBorder());
        txtId.setBounds(110,10,200,30);
        add(txtId);

        JLabel labelPath = new JLabel("PATH");
        labelPath.setBorder(BorderFactory.createEtchedBorder());
        labelPath.setBounds(10,50,80,30);
        add(labelPath);

        txtPath.setBorder(BorderFactory.createEtchedBorder());
        txtPath.setBounds(110,50,200,30);
        add(txtPath);

        JLabel labelFile = new JLabel("FILE");
        labelFile.setBorder(BorderFactory.createEtchedBorder());
        labelFile.setBounds(10,90,80,30);
        add(labelFile);

        txtFile.setBorder(BorderFactory.createEtchedBorder());
        txtFile.setBounds(110,90,200,30);
        add(txtFile);

        JLabel labelDescription = new JLabel("DESCRIPTION");
        labelDescription.setBorder(BorderFactory.createEtchedBorder());
        labelDescription.setBounds(10,130,80,30);
        add(labelDescription);

        txtDescription.setBorder(BorderFactory.createEtchedBorder());
        txtDescription.setBounds(110,130,200,30);
        add(txtDescription);

    }

    private void buildBtn() {
        JButton buttonSave = new JButton("SAVE");
        buttonSave.addActionListener(this);
        buttonSave.setActionCommand(SAVE);
        buttonSave.setBounds(50,250,80,40);
        add(buttonSave);

        JButton buttonCancel = new JButton("CANCEL");
        buttonCancel.addActionListener(this);
        buttonCancel.setActionCommand(CANCEL);
        buttonCancel.setBounds(150,250,80,40);
        add(buttonCancel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case SAVE:
                save = SAVE.equals(action);
                setVisible(false);
            case CANCEL:
                setVisible(false);
        }

    }

    public boolean isSave(){
        return save;
    }

    public Program getProgram(){
        Program record = new Program(Integer.parseInt(txtId.getText()),txtPath.getText(),txtFile.getText(),txtDescription.getText());
        return record;
    }
}
