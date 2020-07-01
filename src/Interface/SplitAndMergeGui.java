package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class SplitAndMergeGui extends JPanel implements ActionListener {

    private JCheckBox splitCheckBox;
    private JCheckBox mergeCheckBox;
    private JCheckBox inKbCheckBox;
    private JCheckBox cryptCheckBox;
    private JCheckBox inPartsCheckBox;

    private JPanel chooseFilePanel;
    private JPanel checkBoxesPanel;
    private JPanel textFieldsPanel;
    private JPanel addToQueuePanel;
    private JPanel inKbLabelAndText;
    private JPanel cryptLabelAndText;
    private JPanel inPartsLabelAndText;
    private JPanel splitAndMergePanel;

    private JLabel inKbLabel;
    private JLabel cryptLabel;
    private JLabel inPartsLabel;
    private JLabel cryptDimLabel;
    private JLabel rowNumberLabel;

    private JButton chooseFileButton;
    private JButton addToQueueButton;
    private JButton removeFromQueue;

    private JTextField inKbText;
    private JTextField cryptText;
    private JTextField inPartsText;
    private JTextField blank;
    private JTextField cryptDimText;
    private JTextField rowNumber;

    JTableGui T;

    private JFileChooser fileChooser;
    private File file;
    private static ArrayList<String> filePathList;

    public SplitAndMergeGui(JTableGui T){

        this.setLayout(new BorderLayout());
        this.T=T;
        filePathList =new ArrayList<String>();

        fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        splitAndMergePanel=new JPanel();
        splitAndMergePanel.setLayout(new BoxLayout(splitAndMergePanel,BoxLayout.PAGE_AXIS));
        chooseFilePanel=new JPanel();
        checkBoxesPanel =new JPanel();
        checkBoxesPanel.setLayout(new BoxLayout(checkBoxesPanel,BoxLayout.PAGE_AXIS));
        textFieldsPanel=new JPanel();
        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel,BoxLayout.PAGE_AXIS));
        addToQueuePanel=new JPanel();
        inKbLabelAndText=new JPanel(new FlowLayout(0,10,0));
        cryptLabelAndText=new JPanel(new FlowLayout(0,10,0));
        inPartsLabelAndText=new JPanel(new FlowLayout(0,13,0));


        splitCheckBox=new JCheckBox("Split");
        splitCheckBox.addActionListener(this);
        mergeCheckBox=new JCheckBox("Merge");
        mergeCheckBox.addActionListener(this);
        splitAndMergePanel.add(splitCheckBox);
        splitAndMergePanel.add(mergeCheckBox);

        inKbCheckBox=new JCheckBox("Split by kb");
        inKbCheckBox.addActionListener(this);
        cryptCheckBox=new JCheckBox("Split and crypt");
        inPartsCheckBox=new JCheckBox("Split in parts");
        checkBoxesPanel.add(inKbCheckBox);
        checkBoxesPanel.add(cryptCheckBox);
        checkBoxesPanel.add(inPartsCheckBox);

        chooseFileButton=new JButton("Choose file");
        chooseFileButton.addActionListener(this);
        blank=new JTextField(15);
        blank.setEditable(false);
        chooseFilePanel.add(chooseFileButton);
        chooseFilePanel.add(blank);

        inKbText=new JTextField(7);
        inKbText.addActionListener(this);
        inKbLabel=new JLabel("kb");
        inKbLabelAndText.add(inKbLabel);
        inKbLabelAndText.add(inKbText);
        cryptText=new JTextField(7);
        cryptText.addActionListener(this);
        cryptLabel=new JLabel("key");
        cryptDimText=new JTextField(7);
        cryptDimText.addActionListener(this);
        cryptDimLabel=new JLabel("kb");
        cryptLabelAndText.add(cryptDimLabel);
        cryptLabelAndText.add(cryptDimText);
        cryptLabelAndText.add(cryptLabel);
        cryptLabelAndText.add(cryptText);
        inPartsText=new JTextField(7);
        inPartsText.addActionListener(this);
        inPartsLabel=new JLabel("n");
        inPartsLabelAndText.add(inPartsLabel);
        inPartsLabelAndText.add(inPartsText);
        textFieldsPanel.add(inKbLabelAndText);
        textFieldsPanel.add(cryptLabelAndText);
        textFieldsPanel.add(inPartsLabelAndText);

        addToQueueButton=new JButton("Add to queue");
        removeFromQueue=new JButton("Remove From queue");
        removeFromQueue.addActionListener(this);
        addToQueueButton.addActionListener(this);
        rowNumber=new JTextField(3);
        rowNumberLabel=new JLabel("row num");
        addToQueuePanel.add(addToQueueButton);
        addToQueuePanel.add(removeFromQueue);
        addToQueuePanel.add(rowNumberLabel);
        addToQueuePanel.add(rowNumber);

        add(chooseFilePanel,BorderLayout.PAGE_START);
        add(checkBoxesPanel,BorderLayout.CENTER);
        add(textFieldsPanel,BorderLayout.LINE_END);
        add(addToQueuePanel,BorderLayout.PAGE_END);
        add(splitAndMergePanel,BorderLayout.LINE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(splitCheckBox.isSelected())
            mergeCheckBox.setEnabled(false);
        if(!splitCheckBox.isSelected())
            mergeCheckBox.setEnabled(true);
        if(mergeCheckBox.isSelected())
            splitCheckBox.setEnabled(false);
        if(!mergeCheckBox.isSelected())
            splitCheckBox.setEnabled(true);

        if(splitCheckBox.isSelected() & e.getSource().equals(addToQueueButton) & inKbCheckBox.isSelected()){
            T.addRow(new Object[]{"Split by kb",file.length()/1024 + " kb",file.getAbsolutePath(),""});
            filePathList.add("SplitByKb");
            filePathList.add(file.getAbsoluteFile().toString());
            filePathList.add(inKbText.getText());
            inKbText.setText("");

        }


        if(splitCheckBox.isSelected() & cryptCheckBox.isSelected() & e.getSource().equals(addToQueueButton)){
            T.addRow(new Object[]{"Split and crypt",file.length()/1024 + " kb",file.getAbsolutePath(),""});
            filePathList.add("SplitAndCrypt");
            filePathList.add(file.getAbsoluteFile().toString());
            filePathList.add(cryptText.getText());
            filePathList.add(cryptDimText.getText());
            cryptText.setText("");
        }


        if(splitCheckBox.isSelected() & inPartsCheckBox.isSelected() & e.getSource().equals(addToQueueButton)){
            T.addRow(new Object[]{"Split in parts",file.length()/1024 + " kb",file.getAbsolutePath()});
            filePathList.add("SplitInParts");
            filePathList.add(file.getAbsoluteFile().toString());
            filePathList.add(inPartsText.getText());
            inPartsText.setText("");
        }


        if(mergeCheckBox.isSelected() & e.getSource().equals(addToQueueButton)){
            T.addRow(new Object[]{"Merge",file.length()/1024,file.getAbsolutePath(),""});
            filePathList.add("Merge");
            filePathList.add(file.getAbsoluteFile().toString());
        }


        if(e.getSource().equals(chooseFileButton)){
            int returnVal=fileChooser.showOpenDialog(SplitAndMergeGui.this);
            if(returnVal==JFileChooser.APPROVE_OPTION){
                file=fileChooser.getSelectedFile();
            }
        }

        if(T.getRowsCount()!=0 & e.getSource().equals(removeFromQueue)){
            T.removeRow(Integer.parseInt(rowNumber.getText())-1);
            rowNumber.setText("");
        }


    }

    public ArrayList<String> getFilePathListInKb(){return filePathList;}
}
