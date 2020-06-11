package Listeners;

import Interface.FinalGui2_JTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SplitFileChooserListener extends JPanel implements ActionListener {

    private JFileChooser fileChooser;
    private static File splitFile;


    public SplitFileChooserListener(){
        fileChooser =new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Choose File")){
            int returnVal= fileChooser.showOpenDialog(SplitFileChooserListener.this);
            if(returnVal==JFileChooser.APPROVE_OPTION) {
                splitFile=fileChooser.getSelectedFile();
            }
        }
    }

    public String getFilePath(){
        return splitFile.getAbsolutePath();
    }

    public long getFileDim(){
        return splitFile.length();
    }

}
