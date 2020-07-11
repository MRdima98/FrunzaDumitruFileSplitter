import Interface.FinalGui;

import javax.swing.*;

/**
 * @author Frunza Dumitru
 * @version 1.0
 */

public class frame extends JFrame {
    public static void main(String[] args){
        /**
         * This is the main class, it creates the frame and loads the panels
         */
        JFrame frame=new JFrame();
        FinalGui gui=new FinalGui();
        frame.add(gui);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(200,200,700,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
