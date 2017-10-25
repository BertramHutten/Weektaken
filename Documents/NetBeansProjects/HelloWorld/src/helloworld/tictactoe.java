

package helloworld;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

       

public class tictactoe extends JFrame implements ActionListener {

    /**
     * declaratie van globale variabelen en button array Merk op: access
     * modifiers staan op private. Final variabelen in hoofdletters
     *
     */
    private static JButton[][] button;  //declaratie van de array in array (geneste list in Python)
    private static final int XAS = 3, YAS = 3;  // Grootte van de array
    private JPanel panel, panelInfo, panelHeader; // Panels
    private static final String TITEL = "Tic Tac Toe 4 BioInformatics";  //Titel
    private static String imagePad, seperator = "/"; // Seperator forward slash zowel voor Unix als Windows geschikt
    private static ImageIcon leeg, kruisje, rondje, vraagteken;  //images
    private static JLabel messageLabel, headerLabel;  //labels met informatieve teksten
    int m = 0;

    /**
     * Applicatie: main method, instantiering van frame (deze class) en
     * initialisering van GUI
     */
    public static void main(String[] args) {
        tictactoe frame = new tictactoe();
        setImages();
        frame.setTitle(TITEL);
        frame.setSize(250, 280);
        frame.createGUI();
        frame.setVisible(true);
        // Zet icon voor programma
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imagePad + "icon.jpg"));

    }

    /**
     * Zoeken en laden van images Pas hier je pad aan naar de images als de
     * images niet worden gevonden of als je andere images wilt gebruiken.
     */
    private static void setImages() {
        imagePad = System.getProperty("java.class.path") + seperator + "helloworld" + seperator;
        imagePad = imagePad.substring(imagePad.indexOf(':') + 1);
        //System.out.println("Image pad: " + imagePad);
        leeg = new ImageIcon(imagePad + "leeg.jpg");
        kruisje = new ImageIcon(imagePad + "kruisje.jpg");
        rondje = new ImageIcon(imagePad + "rondje.jpg");
        vraagteken = new ImageIcon(imagePad + "question.jpg");
    }

    /**
     * Geef een bericht over de status van het spel Merk op dat deze methode
     * overloaded is
     *
     * @param message String die een bericht weergeeft in de status console
     *
     * @param tooltip Mouse over bericht
     *
     */
    private static void message(String message, String tooltip) {
        messageLabel.setText(message);
        messageLabel.setToolTipText(tooltip);
    }

    private static void message(String message) {
        message(message, message);
    }

    /**
     * Creatie van de Graphical User Interface
     */
    private void createGUI() {
        button = new JButton[XAS][YAS]; // Declareer de button array
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Zorg dat het window gesloten wordt
        Container window = getContentPane(); // Creatie van een Window waarin twee JPanels worden geplaatst
        window.setLayout(new FlowLayout()); // Zet flowLayout in het Window

        panel = new JPanel();
        panel.setLayout(new GridLayout(XAS, YAS, 5, 5));// GridLayout om in een matrix van 3 bij 3 de velden te plaatsen
        panel.setPreferredSize(new Dimension(160, 160));
        panel.setBackground(Color.BLACK);
        panelInfo = new JPanel();
        panelInfo.setMaximumSize(new Dimension(200, 100));
        panelInfo.setLayout(new FlowLayout());
        panelInfo.setBackground(Color.GRAY);
        panelHeader = new JPanel();
        panelHeader.setMaximumSize(new Dimension(250, 20));
        panelHeader.setPreferredSize(new Dimension(250, 20));
        panelHeader.setLayout(new FlowLayout());
        panelHeader.setBackground(Color.lightGray);
        messageLabel = new JLabel("");
        headerLabel = new JLabel("Bioinformatica Tic Tac Toe");
        panelInfo.add(messageLabel);
        panelHeader.add(headerLabel);

        // Voeg aan het window de twee panels toe
        window.add(panelHeader);
        window.add(panel);
        window.add(panelInfo);

        //Geneste for-loop om de buttons te vullen en te tekenen
        for (int x = 0; x < XAS; x++) {
            for (int y = 0; y < YAS; y++) {
                button[x][y] = new JButton();
                button[x][y].addActionListener(this);
                button[x][y].setIcon(leeg);
                button[x][y].setRolloverIcon(vraagteken);
                panel.add(button[x][y]);
            }
        }
        message("Rondje mag beginnen");
    }

    /*
     * Actie indien de button geklikt is Hier vindt de afhandeling van het
     * klikken van een button plaats. Er zijn 9 buttons die op basis van de
     * source onderscheiden kunnen worden. Zorg dat indien een button wordt
     * geklikt deze een rondje of kruisje krijgt afhankelijk van wie er aan zet
     * is. Controleer na het plaatsten van het rondje of kruisje of iemand 3 op
     * een rij heeft of wanneer het laatste vakje is ingevuld of er iemand
     * gewonnen heeft.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        /**
         * Code om events af te vangen en te reageren Tip werk met aanroep van
         * methodes en neem niet alle code in deze methode op
         */
        Object buttonPressed = event.getSource();
        m++;
        /*
         * Als voorbeeld is hier opgenomen de boolean expressie
         * om te achterhalen of het vakje linksboven is aangeklikt
         * Bouw hieromheen een loop (of geneste loop?) met daarin
         * een if structuur om een kruisje danwel een rondje op de
         * button te plaatsen
         */
        /*
        for (int x = 0; x < XAS; x++) {
            for (int y = 0; y < YAS; y++) {
                if(buttonPressed==button[x][y]){
                    System.out.println("het is x " + x);
                    System.out.println("en deze y " + y);
                    button[x][y].setIcon(kruisje);
                }        
            }
        }
        */
        // cast um naar een JButton
        
        if((m%2) == 0) {
        ((JButton)buttonPressed).setIcon(kruisje);
        message("Rondje mag ");
        ((JButton)buttonPressed).setEnabled(false); 
        }
        if ((m%2) == 1) {
        ((JButton)buttonPressed).setIcon(rondje);
        message("Kruisje mag ");
        ((JButton)buttonPressed).setEnabled(false); 
        
        if((m == 9)){
            JOptionPane.showMessageDialog(null, "niemand wint sukkels");
            System.exit(0);
        }
            
        }
        //1ste rij horizontaal
        if (button[0][0].getIcon()!=leeg && button[0][0].getIcon()==button[0][1].getIcon() && button[0][0].getIcon() == button[0][2].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        } 
        //2de rij horizontaal
        if (button[1][0].getIcon()!=leeg && button[1][0].getIcon()==button[1][1].getIcon() && button[1][0].getIcon() == button[1][2].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //3de rij horizontaal
        if (button[2][0].getIcon()!=leeg && button[2][0].getIcon()==button[2][1].getIcon() && button[2][0].getIcon() == button[2][2].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //1ste rij verticaal
        if (button[0][0].getIcon()!=leeg && button[0][0].getIcon()==button[1][0].getIcon() && button[0][0].getIcon() == button[2][0].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //2de rij verticaal
        if (button[0][1].getIcon()!=leeg && button[0][1].getIcon()==button[1][1].getIcon() && button[0][1].getIcon() == button[2][1].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //3de rij verticaal
        if (button[0][2].getIcon()!=leeg && button[0][2].getIcon()==button[1][2].getIcon() && button[0][2].getIcon() == button[2][2].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //schuin links rechts
        if (button[0][0].getIcon()!=leeg && button[0][0].getIcon()==button[1][1].getIcon() && button[1][1].getIcon() == button[2][2].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }
        //schuin rechts links
        if (button[0][2].getIcon()!=leeg && button[0][2].getIcon()==button[1][1].getIcon() && button[1][1].getIcon() == button[2][0].getIcon()){
        JOptionPane.showMessageDialog(null, "Je hebt gewonnen");
        System.exit(0);
        }                          
    }
}