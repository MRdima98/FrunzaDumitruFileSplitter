package Interface;

import javax.swing.*;

public class FinalGui extends JPanel {

    private JPanel GUI;


    JTableGui T;
    StardAndStopButton SS;
    SplitAndMergeGui splitAndMergeGui;

    public FinalGui(){

        T=new JTableGui();
        splitAndMergeGui=new SplitAndMergeGui(T);
        SS=new StardAndStopButton();
        GUI=new JPanel();
        GUI.setLayout(new BoxLayout(GUI,BoxLayout.PAGE_AXIS));
        GUI.add(splitAndMergeGui);
        GUI.add(T);
        GUI.add(SS);
        add(GUI);
    }
}
