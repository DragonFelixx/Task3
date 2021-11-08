package company.vel.actionListeners;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class ButtonReadFileListener implements ActionListener
{
    JTextField inputDataField;

    public ButtonReadFileListener(JTextField inputDataField)
    {
        this.inputDataField = inputDataField;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFileChooser fileChooser = new JFileChooser("tests\\");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            try
            {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                String line = br.readLine();
                inputDataField.setText(line);
                br.close();
            }
            catch (IOException fileNotFoundException)
            {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
