package Listeners;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserListener implements ActionListener {

    private String Path;
    private FileChooser fileChooser;

    public FileChooserListener(){
        fileChooser=new FileChooser();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Choose File")){


        }
    }
}
