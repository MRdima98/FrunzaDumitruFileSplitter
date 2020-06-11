package Listeners;

import Interface.FinalGui2_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SplitAddToQueueListener implements ActionListener {


    private FinalGui2_JTable T;
    SplitFileChooserListener SF;

    public SplitAddToQueueListener(FinalGui2_JTable T){
        this.T=T;
        SF=new SplitFileChooserListener();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add to queue"))
            T.AddRow(new Object[]{"Split",SF.getFileDim() + "byte",SF.getFilePath(),""});

    }
}
