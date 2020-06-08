package Interface;

import javax.swing.*;
import java.awt.*;

public class Split3_SplitInKB extends JPanel {

    private JCheckBox KbCheckbox;
    private JTextField NumeroKB;
    private JLabel kb;
    private JLabel SplitByKB;
    private JPanel SplitRow2;

    public Split3_SplitInKB(){
        SplitRow2=new JPanel();
        SplitRow2.setLayout(new BoxLayout(SplitRow2,BoxLayout.LINE_AXIS));
        SplitByKB=new JLabel("Split by kb");
        kb=new JLabel("kb");
        KbCheckbox =new JCheckBox();
        NumeroKB=new JTextField(7);
        SplitRow2.add(KbCheckbox);
        SplitRow2.add(SplitByKB);
        SplitRow2.add(Box.createRigidArea(new Dimension(91,0)));
        SplitRow2.add(kb);
        SplitRow2.add(Box.createRigidArea((new Dimension(10,0))));
        SplitRow2.add(NumeroKB);
        add(SplitRow2);
    }
}
