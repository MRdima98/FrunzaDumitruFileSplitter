package Interface;

import Listeners.MergeAddToQueueListener;

import javax.swing.*;

public class Merge3_AddToQueue extends JPanel {

    private JButton AddToQueue;
    private JPanel MergeRow3;

    public Merge3_AddToQueue(FinalGui2_JTable T){

        MergeRow3=new JPanel();
        AddToQueue= new JButton("Add to queue");
        AddToQueue.addActionListener(new MergeAddToQueueListener(T));
        MergeRow3.add(AddToQueue);
        add(MergeRow3);
    }
}
