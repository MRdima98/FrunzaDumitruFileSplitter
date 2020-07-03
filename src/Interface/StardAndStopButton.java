package Interface;

import Logic.*;

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
    SplitAndCrypt splitAndCrypt;
    JTableGui T;
    SplitAndMergeGui splitAndMergeGui;
    MergeByKb mergeByKb;
    MergeByParts mergeByParts;
    MergeFromCrypt mergeFromCrypt;

    public StardAndStopButton(){

        T=new JTableGui();
        splitAndMergeGui =new SplitAndMergeGui(T);
        filePathList= splitAndMergeGui.getFilePathListInKb();
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
            for(int j=0;j<filePathList.size();j++) {
                if (filePathList.size()!=0 && filePathList.get(0).equals("SplitByKb")) {
                    splitByKb = new SplitByKb(filePathList.get(1), Integer.parseInt(filePathList.get(2)));
                    splitByKb.splitFileByKb();
                    for(int i=0;i<3;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("SplitAndCrypt")){
                    splitAndCrypt =new SplitAndCrypt(filePathList.get(1),filePathList.get(2),Integer.parseInt(filePathList.get(3)));
                    splitAndCrypt.defaultSplitAndCrypt();
                    for(int i=0;i<4;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("SplitInParts")){
                    splitInParts=new SplitInParts(filePathList.get(1),Integer.parseInt(filePathList.get(2)));
                    splitInParts.splitFileInParts();
                    for(int i=0;i<3;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("Merge")){
                    if(filePathList.get(1).indexOf("eqpar")!=-1){
                        mergeByKb =new MergeByKb();
                        mergeByKb.mergeFile(getFileName(filePathList.get(1)),filePathList.get(1),deleteLastIndex(filePathList.get(1)));
                    }
                    if(filePathList.get(1).indexOf("inparts")!=-1){
                        mergeByParts=new MergeByParts();
                        mergeByParts.mergeFile(getFileName(filePathList.get(1)),filePathList.get(1),deleteLastIndex(filePathList.get(1)));
                    }
                    if(filePathList.get(1).indexOf("crypt")!=-1){
                        mergeFromCrypt=new MergeFromCrypt(filePathList.get(2));
                        mergeFromCrypt.decryptAndMerge(getFileName(filePathList.get(1)),filePathList.get(1),deleteLastIndex(filePathList.get(1)));
                    }
                    for(int i=0;i<2;i++)
                        filePathList.remove(0);
                }
            }
        }
    }

    public String getFileName(String str){
        if(str!=null & str.length()>0)
            str=str.substring(0,str.length()-1);
        if(filePathList.get(1).indexOf("eqpar")!=-1)
            str=str.substring(0,str.indexOf("eqpar")-1);
        if(filePathList.get(1).indexOf("inparts")!=-1)
            str=str.substring(0,str.indexOf("inparts")-1);
        if(filePathList.get(1).indexOf("crypt")!=-1)
            str=str.substring(0,str.indexOf("crypt")-1);
        return str;
    }

    public String deleteLastIndex(String str){
        if(str!=null & str.length()>0)
            str=str.substring(0,str.length()-1);
        return str;
    }
}
