package appLaunchTwo.Logic;

import appLaunchTwo.Classes.Program;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelProgram extends AbstractTableModel {
   private List<Program> programList = new ArrayList<>();

   private final String[] headers = {"ID","PATH","FILE","DESCRIPTION"};

    public TableModelProgram(List<Program> programList) {
            this.programList = programList;
    }

    @Override
    public int getRowCount() {
        return programList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Program program =programList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return program.getId();

            case 1:
                return program.getPath();
            case 2:
                return program.getName();
            default:
                return program.getDescription();
        }
    }
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
