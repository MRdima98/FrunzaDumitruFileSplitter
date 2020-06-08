package Interface;

import javax.swing.*;

public class FinalGui extends JPanel {

    public JPanel GUI;
    FinalGui1_SplitAndMergeRow SM=new FinalGui1_SplitAndMergeRow();
    FinalGui2_JTable T=new FinalGui2_JTable();
    FinalGui3_StartAndStop SS=new FinalGui3_StartAndStop();
    public FinalGui(){
        GUI=new JPanel();
        GUI.setLayout(new BoxLayout(GUI,BoxLayout.PAGE_AXIS));
        GUI.add(SM);
        GUI.add(T);
        GUI.add(SS);
        add(GUI);
    }
}
