package Interface;

import javax.swing.*;

public class Split1_Label extends JPanel {
    private JPanel SplitRow1;
    private JLabel Split;

    public Split1_Label(){
        SplitRow1=new JPanel();
        Split=new JLabel(("Split Panel"));
        SplitRow1.add(Split);
        add(SplitRow1);
    }
}
