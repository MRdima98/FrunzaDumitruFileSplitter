package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class JTableGui extends JPanel {

    public JTable table;
    public DefaultTableModel model;
    private JScrollPane scrollPane;


    public JTableGui(){

        model=new DefaultTableModel(new Object[]{"Type","Dimension","Path","Progress"},0);

        table=new JTable(model);
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500,150));
        add(scrollPane);
    }

    public void addRow(Object[] object){model.addRow(object);}
    public void removeRow(int index){model.removeRow(index);}
    public int getRowsCount(){return model.getRowCount();}

}
