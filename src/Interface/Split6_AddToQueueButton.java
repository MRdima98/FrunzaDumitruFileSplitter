package Interface;

import Listeners.SplitAddToQueueListener;

import javax.swing.*;

public class Split6_AddToQueueButton extends JPanel {

    private JPanel SplitRow7;
    private JButton AddToQueue;
    SplitAddToQueueListener SL;


    public Split6_AddToQueueButton(FinalGui2_JTable T){
        SL=new SplitAddToQueueListener(T);
        SplitRow7=new JPanel();
        AddToQueue=new JButton("Add to queue");
        AddToQueue.addActionListener(SL);
        SplitRow7.add(AddToQueue);
        add(SplitRow7);
    }

}
