package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalGui2_JTable extends JPanel implements ActionListener {

    public JTable table;
    public DefaultTableModel model;
    private JScrollPane scrollPane;

    private JButton b;

    public FinalGui2_JTable(){


        b=new JButton("Add to queue");
        b.addActionListener(this);

        model=new DefaultTableModel(new Object[]{"uno","due","tre","quattro"},0);
        table=new JTable(model);
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500,150));
        add(b);
        add(scrollPane);


    }

    public void AddRow(){
        model.addRow(new Object[]{"pappa","cacca","pippi","calze"});
        System.out.println(model.getRowCount());
        model.fireTableRowsUpdated(0,model.getRowCount());
        model.fireTableDataChanged();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b))
            AddRow();
    }
}
