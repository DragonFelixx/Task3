package company.vel;

public class GuiMain
{
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Frame();
            }
        });
    }
}
