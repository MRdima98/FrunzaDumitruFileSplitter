package Listeners;

import Interface.FinalGui2_JTable;
import Interface.Merge3_AddToQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeAddToQueueListener implements ActionListener {

    FinalGui2_JTable MT;

    public MergeAddToQueueListener(FinalGui2_JTable MT){
        this.MT=MT;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add to queue"))
            MT.AddMergeRow();

    }
}
