package Interface;

import javax.swing.*;
import java.awt.*;

public class Split4_SplitandCrypt extends JPanel {
    private JCheckBox CryptCheckBox;
    private JTextField Password;
    private JLabel Crypt;
    private JLabel Key;
    private JPanel SplitRow3;

    public Split4_SplitandCrypt(){
        SplitRow3=new JPanel();
        SplitRow3.setLayout(new BoxLayout(SplitRow3,BoxLayout.LINE_AXIS));
        CryptCheckBox=new JCheckBox();
        Crypt=new JLabel("Crypt");
        Key=new JLabel("Key");
        Password=new JTextField(7);
        SplitRow3.add(CryptCheckBox);
        SplitRow3.add(Crypt);
        SplitRow3.add(Box.createRigidArea(new Dimension(111,0)));
        SplitRow3.add(Key);
        SplitRow3.add(Box.createRigidArea(new Dimension(10,0)));
        SplitRow3.add(Password);
        add(SplitRow3);

    }

}
