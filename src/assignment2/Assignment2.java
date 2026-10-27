package assignment2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment2 extends JFrame implements ActionListener {
    
    // Components
    JRadioButton birdBtn;
    JRadioButton catBtn;
    JRadioButton dogBtn;
    JRadioButton rabbitBtn;
    JRadioButton pigBtn;
    ButtonGroup group;
    JLabel imageLabel;

    public Assignment2() {
        setTitle("RadioButtonDemo");
        setSize(450, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        birdBtn = new JRadioButton("Bird");
        catBtn = new JRadioButton("Cat");
        dogBtn = new JRadioButton("Dog");
        rabbitBtn = new JRadioButton("Rabbit");
        pigBtn = new JRadioButton("Pig");

        // Group the buttons
        group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        // Add action listeners
        birdBtn.addActionListener(this);
        catBtn.addActionListener(this);
        dogBtn.addActionListener(this);
        rabbitBtn.addActionListener(this);
        pigBtn.addActionListener(this);

        // Panel on the left for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(birdBtn);
        panel.add(catBtn);
        panel.add(dogBtn);
        panel.add(rabbitBtn);
        panel.add(pigBtn);

        // Image label
        imageLabel = new JLabel();

        // Default selection matching assignment sample
        pigBtn.setSelected(true);
        setImage("pig.jpg");

        // Add to frame
        add(panel);
        add(imageLabel);

        setLocationRelativeTo(null);
    }

    // Helper method to load and scale the picture so it fits inside the window
    private void setImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image img = icon.getImage();
        // Scale to fit nicely next to the buttons
        Image scaledImg = img.getScaledInstance(200, 160, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImg));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = "";

        if (e.getSource() == birdBtn) {
            pet = "Bird";
            setImage("bird.jpg");
        } else if (e.getSource() == catBtn) {
            pet = "Cat";
            setImage("cat.jpg");
        } else if (e.getSource() == dogBtn) {
            pet = "Dog";
            setImage("dog.jpg");
        } else if (e.getSource() == rabbitBtn) {
            pet = "Rabbit";
            setImage("rabbit.jpg");
        } else if (e.getSource() == pigBtn) {
            pet = "Pig";
            setImage("pig.jpg");
        }

        // Show selection pop-up message box
        JOptionPane.showMessageDialog(this, "You selected " + pet);
    }

    public static void main(String[] args) {
        Assignment2 demo = new Assignment2();
        demo.setVisible(true);
    }
}