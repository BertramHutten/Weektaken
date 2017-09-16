import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField extends JFrame 
{
    JPanel jp = new JPanel();
    JLabel jl = new JLabel("input 1");
    JTextField jt = new JTextField(30);
        
    public TextField()
    {
        setTitle("Test Textfield");
        setVisible(true);
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jp.add(jt);
        
        jt.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e)
            {
                String input = jt.getText();
                jl.setText(input);
            
            }
        });
        jp.add(jl);
        add(jp);

        
    }
    public static void main(String[] args)
    {
        TextField t = new TextField();
    }
    
}
