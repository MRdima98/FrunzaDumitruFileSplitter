package Interface;

import javax.swing.*;

public class FinalGui extends JPanel {

    public JPanel GUI;
    FinalGui1_SplitAndMergeRow SM;
    FinalGui2_JTable T;
    FinalGui3_StartAndStop SS;
    public FinalGui(){
        SM=new FinalGui1_SplitAndMergeRow(T);
        T=new FinalGui2_JTable();
        SS=new FinalGui3_StartAndStop();

        GUI=new JPanel();
        GUI.setLayout(new BoxLayout(GUI,BoxLayout.PAGE_AXIS));
        GUI.add(SM);
        GUI.add(T);
        GUI.add(SS);
        add(GUI);
    }
}
