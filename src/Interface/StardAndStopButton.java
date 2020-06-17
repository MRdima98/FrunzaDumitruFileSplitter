package Interface;

import Logic.SplitByKb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StardAndStopButton extends JPanel implements ActionListener {

    private JPanel StartAndStopRow;
    private JButton start;
    private JButton stop;
    SplitByKb splitByKb;
    JTableGui T;

    public StardAndStopButton(){

        splitByKb=new SplitByKb();

        StartAndStopRow=new JPanel();
        StartAndStopRow.setLayout(new BoxLayout(StartAndStopRow,BoxLayout.LINE_AXIS));
        start=new JButton("Start");
        start.addActionListener(this);
        stop=new JButton("Stop");
        StartAndStopRow.add(start);
        StartAndStopRow.add(Box.createRigidArea(new Dimension(100,0)));
        StartAndStopRow.add(stop);
        add(StartAndStopRow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(start)){
            splitByKb.splitFile();
            System.out.println("Funzia");
        }

    }
}
