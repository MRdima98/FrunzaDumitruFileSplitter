package Interface;

import javax.swing.*;

public class Merge3_AddToQueue extends JPanel {

    private JButton AddToQueue;
    private JPanel MergeRow3;

    public Merge3_AddToQueue(){

        MergeRow3=new JPanel();
        AddToQueue= new JButton("Add to queue");
        MergeRow3.add(AddToQueue);
        add(MergeRow3);
    }
}
