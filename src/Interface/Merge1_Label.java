package Interface;

import javax.swing.*;

public class Merge1_Label extends JPanel {

    private JPanel MergeRow1;
    private JLabel Merge;

    public Merge1_Label(){
        MergeRow1=new JPanel();
        Merge=new JLabel("Merge Panel");
        MergeRow1.add(Merge);
        add(MergeRow1);
    }
}
