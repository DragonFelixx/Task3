package company.vel.actionListeners;

import stack.MyStack;
import stack.stackExceptions.EmptyStackException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCheckListener implements ActionListener
{
    JTextField inputDataField;
    JTextField outputDataField;

    public ButtonCheckListener(JTextField inputDataField, JTextField outputDataField)
    {
        this.inputDataField = inputDataField;
        this.outputDataField = outputDataField;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String inputData = inputDataField.getText();
        try
        {
            boolean result = MyStack.checkCorrectBrackets(inputData);
            String message = "Brackets are placed " + (result ?  "correctly" : "incorrectly");
            if (!inputData.equals(""))
            {
                outputDataField.setText(message);
            }
            else
            {
                outputDataField.setText("No data to check");
            }

        } catch (EmptyStackException emptyStackException)
        {
            emptyStackException.printStackTrace();
        }
    }
}
