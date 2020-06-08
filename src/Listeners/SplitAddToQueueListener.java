package Listeners;

import Interface.FinalGui2_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplitAddToQueueListener implements ActionListener {

    FinalGui2_JTable T=new FinalGui2_JTable();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add to queue"))
            T.AddRow();
    }
}
