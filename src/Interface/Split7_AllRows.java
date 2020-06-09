package Interface;

import javax.swing.*;

public class Split7_AllRows extends JPanel {
    private JPanel SplitRows;
    private FinalGui2_JTable T;
    Split1_Label r1=new Split1_Label();
    Split2_FileChooser r2= new Split2_FileChooser();
    Split3_SplitInKB r3=new Split3_SplitInKB();
    Split4_SplitandCrypt r4=new Split4_SplitandCrypt();
    Split5_SplitInNumberOfParts r5=new Split5_SplitInNumberOfParts();
    Split6_AddToQueueButton r6;

    public Split7_AllRows(FinalGui2_JTable T){
        r6 = new Split6_AddToQueueButton(T);

        SplitRows=new JPanel();
        SplitRows.setLayout(new BoxLayout(SplitRows,BoxLayout.PAGE_AXIS));
        SplitRows.add(r1);
        SplitRows.add(r2);
        SplitRows.add(r3);
        SplitRows.add(r4);
        SplitRows.add(r5);
        SplitRows.add(r6);
        add(SplitRows);
    }
}
