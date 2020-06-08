package Interface;

import javax.swing.*;

public class FinalGui1_SplitAndMergeRow extends JPanel {

    private JPanel MergeSplitRow;
    Merge4_AllRows M=new Merge4_AllRows();
    Split7_AllRows S=new Split7_AllRows();

    public FinalGui1_SplitAndMergeRow(){

        MergeSplitRow=new JPanel();
        MergeSplitRow.setLayout(new BoxLayout(MergeSplitRow,BoxLayout.LINE_AXIS));
        MergeSplitRow.add(S);
        MergeSplitRow.add(M);
        add(MergeSplitRow);
    }
}
