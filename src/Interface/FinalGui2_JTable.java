package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class FinalGui2_JTable extends JPanel {

    public JTable table;
    public DefaultTableModel model;
    private JScrollPane scrollPane;


    public FinalGui2_JTable(){

        model=new DefaultTableModel(new Object[]{"Type","Dimension","Path","Progress"},0);

        table=new JTable(model);
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500,150));
        add(scrollPane);
    }

    public void AddRow(Object[] object){model.addRow(object);}

    public void AddMergeRow(){
        model.addRow(new Object[]{"Merge","","",""});
    }

    public void AddSplitRow(){
        model.addRow(new Object[]{"Split","","",""});
    }

}
