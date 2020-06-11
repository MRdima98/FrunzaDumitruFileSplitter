package Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MergeFileChooserListener extends JPanel implements ActionListener {

    private JFileChooser fileChooser;
    private static File mergeFile;

    public MergeFileChooserListener(){
        fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Choose File")){
            int returnVal=fileChooser.showOpenDialog(MergeFileChooserListener.this);
            if(returnVal==JFileChooser.APPROVE_OPTION){
                mergeFile=fileChooser.getSelectedFile();
            }
        }
    }

    public long getFileDim(){
        return mergeFile.length();
    }

    public String getFilePath(){
        return mergeFile.getAbsolutePath();
    }


}
