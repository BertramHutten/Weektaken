
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
        
        textField = new JTextField("Coordinate");
        label = new JLabel("x");
        textField2 = new JTextField("Coordinate");
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


        
        textField.addActionListener(this);
        textField2.addActionListener(this);

    }    
    @Override
        public void actionPerformed (ActionEvent event){


        int x = Integer.parseInt(textField.getText());
        int y = Integer.parseInt(textField2.getText());

            
        Graphics paper = panel.getGraphics();
        
        
        paper.clearRect(0, 0, 400, 400);
        
        //super.paintComponents(paper);
        //bovenste lijn
        paper.drawLine(50 + x,45 + y,115 + x,115 + x);
        //onderste lijn
        paper.drawLine(45 + x,165 + y,100 + x,130 + y);
        paper.setColor(Color.red);
        paper.fillOval(100 + x,100 + y,50 ,50);
        paper.setColor(Color.BLUE);
        // bovenste ball
        paper.fillOval(25 + x,20 + y,35, 35);
        //onderste ball
        paper.fillOval(25 + x,150 + y,35,35);

        }
        
        
    }

        
        




