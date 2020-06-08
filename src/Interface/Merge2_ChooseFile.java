package Interface;

import javax.swing.*;

public class Merge2_ChooseFile extends JPanel {

    private JPanel MergeRow2;
    private JButton MergeChooseFile;
    private JTextField Blank;

    public Merge2_ChooseFile(){

        MergeRow2=new JPanel();
        MergeRow2.setLayout(new BoxLayout(MergeRow2,BoxLayout.LINE_AXIS));
        MergeChooseFile=new JButton("Choose File");
        Blank=new JTextField(15);
        Blank.setEditable(false);
        MergeRow2.add(MergeChooseFile);
        MergeRow2.add(Blank);
        add(MergeRow2);
    }
}
