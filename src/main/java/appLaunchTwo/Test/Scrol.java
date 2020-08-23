package appLaunchTwo.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scrol extends JFrame implements ActionListener {

    private final String CLOSE = "CLOSE";
    private final String SAVE = "SAVE";

    private JScrollPane scrollPane = new JScrollPane();

    private JTextArea textArea = new JTextArea();
    private JList jList = new JList();

    public Scrol() throws HeadlessException {
        JFrame jFrame = new JFrame("TITLE");

// - --------Scroll TextArea
        /*textArea.setText("TEXT AREA");
        textArea.setBounds(10,10,300,300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));

        panel.add(new JScrollPane(textArea),BorderLayout.CENTER);
*/

        // -----------------------
        jList = new JList();
        JPanel panelList = new JPanel();
        DefaultListModel dfm = new DefaultListModel();
        jList.setModel(dfm);

        dfm.addElement("FF0FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF1FF");
        dfm.addElement("FF2FF");

        System.out.println(dfm.getElementAt(1));

        panelList.setLayout(new GridLayout(2,2));
        panelList.add(new JScrollPane(jList),BorderLayout.CENTER);



        jFrame.add(panelList);
        jFrame.setBounds(100,50,400,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);



    }


    public JPanel jListTest(){
        jList = new JList();
        JPanel panelList = new JPanel();
        DefaultListModel dfm = new DefaultListModel();
        jList.setModel(dfm);

        dfm.addElement("FFFF");
        dfm.addElement("FFFF");
        dfm.addElement("FFFF");

        panelList.setLayout(new GridLayout(2,2));
        panelList.add(jList);

        return panelList;


    }

    public static void main(String[] args) {
        System.out.println("Scroll");
        Scrol scrol = new Scrol();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
