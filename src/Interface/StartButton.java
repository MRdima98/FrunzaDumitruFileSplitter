package Interface;

import Logic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * This class contains the start button
 */
public class StartButton extends JPanel implements ActionListener {

    private ArrayList<String> filePathList;
    private JPanel startAndStopRow;
    private JButton start;
    SplitByKb splitByKb;
    SplitInParts splitInParts;
    SplitAndCrypt splitAndCrypt;
    JTableGui tableGui;
    SplitAndMergeGui splitAndMergeGui;
    MergeByKb mergeByKb;
    MergeFromCrypt mergeFromCrypt;

    /**
     * This is the constructor of StartButton
     * @param tableGui is the table contained in {@link JTableGui}
     */
    public StartButton(JTableGui tableGui){

        this.tableGui=tableGui;
        splitAndMergeGui =new SplitAndMergeGui(tableGui);
        filePathList= splitAndMergeGui.getFilePathList();
        startAndStopRow =new JPanel();
        startAndStopRow.setLayout(new BoxLayout(startAndStopRow,BoxLayout.LINE_AXIS));
        start=new JButton("Start");
        startAndStopRow.add(start);
        start.addActionListener(this);
        startAndStopRow.add(Box.createRigidArea(new Dimension(20,0)));
        add(startAndStopRow);

    }

    /**
     * This class initializes the splits/merges of the files
     * @param e is the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(start)) {
            for(int j=0;j<filePathList.size();j++) {
                if (filePathList.size()!=0 && filePathList.get(0).equals("SplitByKb")) {
                    splitByKb = new SplitByKb(filePathList.get(1), Integer.parseInt(filePathList.get(2)),Integer.parseInt(filePathList.get(3)),tableGui);
                    Thread kb=new Thread(splitByKb);
                    kb.start();
                    for(int i=0;i<4;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("SplitAndCrypt")){
                    splitAndCrypt =new SplitAndCrypt(filePathList.get(1),filePathList.get(2),Integer.parseInt(filePathList.get(3)),Integer.parseInt(filePathList.get(4)),tableGui);
                    Thread crypt=new Thread(splitAndCrypt);
                    crypt.start();
                    for(int i=0;i<5;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("SplitInParts")){
                    splitInParts=new SplitInParts(filePathList.get(1),Integer.parseInt(filePathList.get(2)),Integer.parseInt(filePathList.get(3)),tableGui);
                    Thread parts=new Thread(splitInParts);
                    parts.start();
                    for(int i=0;i<4;i++)
                        filePathList.remove(0);
                }
                if(filePathList.size()!=0 && filePathList.get(0).equals("Merge")){
                    if(filePathList.get(1).indexOf("eqpar")!=-1){
                        mergeByKb =new MergeByKb(getFileName(filePathList.get(1)),filePathList.get(1),tableGui,"eqpar",getNumSplit(filePathList.get(1),"eqpar"),Integer.parseInt(filePathList.get(2)));
                        Thread mergekb=new Thread(mergeByKb);
                        mergekb.start();
                    }
                    if(filePathList.get(1).indexOf("inparts")!=-1){
                        mergeByKb=new MergeByParts(getFileName(filePathList.get(1)),filePathList.get(1),tableGui,"inparts",getNumSplit(filePathList.get(1),"inparts"),Integer.parseInt(filePathList.get(2)));
                        Thread inparts=new Thread(mergeByKb);
                        inparts.start();
                    }
                    if(filePathList.get(1).indexOf("crypt")!=-1 && filePathList.get(3)!=null){
                        mergeFromCrypt=new MergeFromCrypt(filePathList.get(3),getFileName(filePathList.get(1)),filePathList.get(1),tableGui,"crypt",getNumSplit(filePathList.get(1),"crypt"),Integer.parseInt(filePathList.get(2)));
                        Thread crypt=new Thread(mergeFromCrypt);
                        crypt.start();
                    }
                    for(int i=0;i<3;i++)
                        filePathList.remove(0);
                }

            }
        }
    }

    /**
     * This class returns the fileName of the merged output file
     * @param str is the string of the first part of the splitted file
     * @return the fileName of the output file
     */
    public String getFileName(String str){
        if(filePathList.get(1).indexOf("eqpar")!=-1)
            str=str.substring(0,str.indexOf("eqpar")-2);
        if(filePathList.get(1).indexOf("inparts")!=-1)
            str=str.substring(0,str.indexOf("inparts")-2);
        if(filePathList.get(1).indexOf("crypt")!=-1)
            str=str.substring(0,str.indexOf("crypt")-2);
        return str;
    }

    /**
     * This class finds out how many splits we have
     * @param path is the path of the file
     * @param extension is the extension of the file
     * @return an int of the number of splits
     */
    public int getNumSplit(String path,String extension){
        int i=1;
        File f=new File(path);
        while(f.exists()){
            i++;
            f=new File(path=path.substring(0,path.indexOf(extension)-2) + i + "." + extension);
        }
        i--;
        return i;
    }
}
