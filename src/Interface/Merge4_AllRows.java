package Interface;

import javax.swing.*;
import java.awt.*;

public class Merge4_AllRows extends JPanel {

    private JPanel MergeRows;
    Merge1_Label r1=new Merge1_Label();
    Merge2_ChooseFile r2=new Merge2_ChooseFile();
    Merge3_AddToQueue r3;

    public Merge4_AllRows(FinalGui2_JTable T){
        MergeRows=new JPanel();
        r3=new Merge3_AddToQueue(T);
        MergeRows.setLayout(new BoxLayout(MergeRows,BoxLayout.PAGE_AXIS));
        MergeRows.add(r1);
        MergeRows.add(r2);
        MergeRows.add(Box.createRigidArea(new Dimension(0,94)));
        MergeRows.add(r3);
        add(MergeRows);
    }

}
