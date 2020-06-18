package Interface;

import Logic.SplitByKb;
import Logic.SplitInParts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StardAndStopButton extends JPanel implements ActionListener {

    private ArrayList<String> filePathList;
    private JPanel StartAndStopRow;
    private JButton start;
    private JButton stop;
    SplitByKb splitByKb;
    SplitInParts splitInParts;
    JTableGui T;
    SplitAndMergeGui SM;


    public StardAndStopButton(){

        T=new JTableGui();
        SM=new SplitAndMergeGui(T);
        filePathList=SM.getFilePathListInKb();
        StartAndStopRow=new JPanel();
        StartAndStopRow.setLayout(new BoxLayout(StartAndStopRow,BoxLayout.LINE_AXIS));
        start=new JButton("Start");
        start.addActionListener(this);
        stop=new JButton("Stop");
        StartAndStopRow.add(start);
        StartAndStopRow.add(Box.createRigidArea(new Dimension(100,0)));
        StartAndStopRow.add(stop);
        add(StartAndStopRow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(start)) {
            while(!filePathList.equals(null)) {
                if (filePathList.get(0).equals("1")) {
                    splitByKb = new SplitByKb(filePathList.get(1), Integer.parseInt(filePathList.get(2)));
                    splitByKb.splitFileByKb();
                    for(int i=0;i<3;i++)
                        filePathList.remove(0);
                }
                if(filePathList.get(0).equals("3")){
                    splitInParts=new SplitInParts(filePathList.get(1),Integer.parseInt(filePathList.get(2)));
                    splitInParts.splitFileInParts();
                    for(int i=0;i<3;i++)
                        filePathList.remove(0);
                }
            }
        }

    }
}
