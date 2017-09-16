
package helloworld;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class MyGUI extends JFrame implements ActionListener {
    
    private JTextField textField;
    private JTextField textField2;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JLabel label2;

    public static void main(String[] args) {
        MyGUI frame = new MyGUI();
        frame.setTitle("Watermolecuul Bertram");
        frame.setSize (400,400);
        frame.createGUI();
        frame.setVisible(true);
    }
    
    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout (new FlowLayout());
        
        textField = new JTextField("50");
        label = new JLabel("x");
        textField2 = new JTextField("50");
        label2 = new JLabel("y");
        window.add(textField);
        window.add(label);
        window.add(textField2);
        window.add(label2);
        
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,250));
        panel.setBackground(Color.white);
        window.add(panel);
        
        button = new JButton ("Teken water molecuul");
        button.addActionListener((ActionListener) this);
        window.add(button);

    }    
    @Override
        public void actionPerformed (ActionEvent event){
        Graphics paper = panel.getGraphics();
        paper.drawLine(60,55,115,100);
        paper.drawLine(60,130,100,130);
        paper.setColor(Color.red);
        paper.fillOval(100,100,50,50);
        paper.setColor(Color.BLUE);
        paper.fillOval(10,20,50,50);
        paper.fillOval(10,100,50,50);

        
     
    }   
} 
    



