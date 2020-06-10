package Listeners;

import Interface.FinalGui2_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplitAddToQueueListener implements ActionListener {


    private FinalGui2_JTable T;
    SplitFileChooserListener splitFileChooserListener;

    public SplitAddToQueueListener(FinalGui2_JTable T){
        this.T=T;
        splitFileChooserListener=new SplitFileChooserListener();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add to queue"))
            T.AddRow(new Object[]{"Split",splitFileChooserListener.getFileDim(),splitFileChooserListener.getFilePath(),""});

    }

}
