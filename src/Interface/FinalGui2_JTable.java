package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class FinalGui2_JTable extends JPanel {

    public JTable table;
    public DefaultTableModel model;
    private JScrollPane scrollPane;


    public FinalGui2_JTable(){

        model=new DefaultTableModel(new Object[]{"uno","due","tre","quattro"},0);
        table=new JTable(model);
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500,150));
        add(scrollPane);
    }

    public void AddRow(){
        model.addRow(new Object[]{"pappa","cacca","pippi","calze"});
        System.out.println(model.getRowCount());
        model.fireTableRowsUpdated(0,model.getRowCount());
        model.fireTableDataChanged();

    }
}
