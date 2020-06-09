package Interface;

import javax.swing.*;

public class FinalGui1_SplitAndMergeRow extends JPanel {

    private JPanel MergeSplitRow;
    Merge4_AllRows M=new Merge4_AllRows();
    Split7_AllRows S;

    public FinalGui1_SplitAndMergeRow(FinalGui2_JTable T){
        S=new Split7_AllRows(T);
        MergeSplitRow=new JPanel();
        MergeSplitRow.setLayout(new BoxLayout(MergeSplitRow,BoxLayout.LINE_AXIS));
        MergeSplitRow.add(S);
        MergeSplitRow.add(M);
        add(MergeSplitRow);
    }
}
