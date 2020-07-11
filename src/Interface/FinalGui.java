package Interface;

import javax.swing.*;

/**
 * This is the class FinalGui, it contains every panel of the program
 */
public class FinalGui extends JPanel {
    private JPanel GUI;
    JTableGui tableGui;
    StartButton SS;
    SplitAndMergeGui splitAndMergeGui;

    /**
     * This is the constructor of the class, it contains {@link JTableGui} ,{@link StartButton} and {@link SplitAndMergeGui} panel
     */
    public FinalGui(){
        tableGui =new JTableGui();
        splitAndMergeGui=new SplitAndMergeGui(tableGui);
        SS=new StartButton(tableGui);
        GUI=new JPanel();
        GUI.setLayout(new BoxLayout(GUI,BoxLayout.PAGE_AXIS));
        GUI.add(splitAndMergeGui);
        GUI.add(tableGui);
        GUI.add(SS);
        add(GUI);
    }
}
