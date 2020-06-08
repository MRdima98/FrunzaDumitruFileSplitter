package Interface;

import javax.swing.*;
import java.awt.*;

public class Split5_SplitInNumberOfParts extends JPanel  {
    private JPanel SplitRow4;
    private JCheckBox PartsCheckbox;
    private JLabel SplitInParts;
    private JLabel Num;
    private JTextField NumberOfParts;

    public Split5_SplitInNumberOfParts(){
        SplitRow4=new JPanel();
        SplitRow4.setLayout(new BoxLayout(SplitRow4,BoxLayout.LINE_AXIS));
        PartsCheckbox=new JCheckBox();
        SplitInParts=new JLabel("Split in parts");
        Num=new JLabel("num");
        NumberOfParts=new JTextField(7);
        SplitRow4.add(PartsCheckbox);
        SplitRow4.add(SplitInParts);
        SplitRow4.add(Box.createRigidArea(new Dimension(66,0)));
        SplitRow4.add(Num);
        SplitRow4.add(Box.createRigidArea(new Dimension(10,0)));
        SplitRow4.add(NumberOfParts);
        add(SplitRow4);
    }
}
