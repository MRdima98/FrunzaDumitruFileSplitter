import Interface.FinalGui;

import javax.swing.*;

public class frame extends JFrame {

    public static void main(String[] args){

        JFrame frame=new JFrame();
        FinalGui GUI=new FinalGui();
        frame.add(GUI);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(200,200,700,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
