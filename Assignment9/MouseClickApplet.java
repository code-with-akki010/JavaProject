/* 
 Class to demonstrate Mouse Click Events using Swing.
 It creates a JFrame window, listens for mouse clicks, 
 and displays which mouse button (Left, Middle, Right) was clicked 
 along with the total number of clicks.

 It implements MouseListener interface methods, 
 uses JLabel to display instructions, 
 and shows results using JOptionPane dialog boxes.

 Author: Akshay Basak
 Date: 10-09-2025
*/
package Assignment9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseClickApplet extends JFrame implements MouseListener {
    int clickCount = 0;
    JLabel label;

    MouseClickApplet() {
        setTitle("Mouse Click Event Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Click anywhere inside the window!");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);

        addMouseListener(this); // attach mouse listener

        setVisible(true);
    }

    // Mouse events
    public void mouseClicked(MouseEvent me) {
        clickCount++;
        String buttonName = "";

        if (me.getButton() == MouseEvent.BUTTON1) {
            buttonName = "Left Button";
        } else if (me.getButton() == MouseEvent.BUTTON2) {
            buttonName = "Middle Button";
        } else if (me.getButton() == MouseEvent.BUTTON3) {
            buttonName = "Right Button";
        }

        JOptionPane.showMessageDialog(this,
                "You clicked " + buttonName + "\nTotal Clicks: " + clickCount,
                "Mouse Click Event",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public static void main(String[] args) {
        new MouseClickApplet();
    }
}
