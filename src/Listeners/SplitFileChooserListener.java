package Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SplitFileChooserListener extends JPanel implements ActionListener {

    private String path;
    private JFileChooser fileChooser;
    private long fileDim;
    private File myFile;

    public SplitFileChooserListener(){
        fileChooser =new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Choose File")){
            int returnVal= fileChooser.showOpenDialog(SplitFileChooserListener.this);
            myFile=fileChooser.getSelectedFile();
            setFileDim(myFile.length());
            setFilePath(myFile.getAbsolutePath());
        }
    }

    public void setFilePath(String p){
        path=p;
    }

    public void setFileDim(long fileDim){
        this.fileDim=fileDim;
    }

    public String getFilePath(){
        return path;
    }

    public long getFileDim(){
        return fileDim;
    }
}
