package Interface;

import javax.swing.*;
import java.awt.*;

public class FinalGui3_StartAndStop extends JPanel {

    private JPanel StartAndStopRow;
    private JButton Start;
    private JButton Stop;

    public FinalGui3_StartAndStop(){

        StartAndStopRow=new JPanel();
        StartAndStopRow.setLayout(new BoxLayout(StartAndStopRow,BoxLayout.LINE_AXIS));
        Start=new JButton("Start");
        Stop=new JButton("Stop");
        StartAndStopRow.add(Start);
        StartAndStopRow.add(Box.createRigidArea(new Dimension(100,0)));
        StartAndStopRow.add(Stop);
        add(StartAndStopRow);
    }
}
