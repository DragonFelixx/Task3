package company.vel;

import company.vel.actionListeners.ButtonCheckListener;
import company.vel.actionListeners.ButtonReadFileListener;
import company.vel.actionListeners.*;
import javax.swing.*;

public class Frame extends JFrame
{
    private JPanel panel;
    private JTextField inputDataField;
    private JTextField outputDataField;
    private JButton buttonCheck;
    private JButton buttonReadFile;
    private JLabel inputTextLabel;
    private JLabel outputTextLabel;

    public Frame()
    {
        super("Checking the correctness of the bracket structure");

        panel = new JPanel();
        buttonCheck = new JButton("Check");
        buttonReadFile = new JButton("Read data from file");
        inputTextLabel = new JLabel("Enter a brackets");
        outputTextLabel = new JLabel("Result");
        inputDataField = new JTextField();
        outputDataField = new JTextField();

        addActionToButtons();
        addComponentsToPanel();
        initFrame(panel);
    }

    private void addActionToButtons()
    {
        buttonCheck.addActionListener(new ButtonCheckListener(inputDataField, outputDataField));
        buttonReadFile.addActionListener(new ButtonReadFileListener(inputDataField));
    }

    private void addComponentsToPanel()
    {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(inputTextLabel);
        panel.add(inputDataField);
        panel.add(buttonCheck);
        panel.add(buttonReadFile);
        panel.add(outputTextLabel);
        panel.add(outputDataField);
    }

    private void initFrame(JPanel panel)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 500, 210);
        this.setContentPane(panel);
        this.setVisible(true);
    }
}
