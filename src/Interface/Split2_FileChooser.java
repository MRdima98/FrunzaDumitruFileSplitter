package Interface;

import Listeners.SplitFileChooserListener;



import javax.swing.*;


public class Split2_FileChooser extends JPanel {
    private JPanel SplitRow2;
    private JButton Choose;
    private JTextField Blank;

    SplitFileChooserListener FC=new SplitFileChooserListener();

    public Split2_FileChooser(){
        SplitRow2=new JPanel();
        SplitRow2.setLayout(new BoxLayout(SplitRow2,BoxLayout.LINE_AXIS));
        Choose=new JButton("Choose File");
        Choose.addActionListener(FC);
        Blank=new JTextField(15);
        Blank.setEditable(false);
        SplitRow2.add(Choose);
        SplitRow2.add(Blank);
        add(SplitRow2);
    }
}
