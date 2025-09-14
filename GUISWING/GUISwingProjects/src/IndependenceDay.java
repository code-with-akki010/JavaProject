import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndependenceDay extends JFrame {

    private float scale = 1f; // for button scaling
    private boolean growing = true; // pulse direction
    private float textHue = 0f; // for cycling text colors

    public IndependenceDay() {
        setTitle("Panel with Background Image");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background panel with animated gradient
        JPanel backgroundPanel = new JPanel() {
            Image background = new ImageIcon("day.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        // Create button
        JButton centerButton = new JButton("✨ Jai Hind! Celebrate Freedom ✨");
        centerButton.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
        centerButton.setForeground(Color.YELLOW);
        centerButton.setBackground(new Color(255, 102, 0));
        centerButton.setFocusPainted(false);
        centerButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 153, 0), 5, true),
                BorderFactory.createEmptyBorder(15, 30, 15, 30)));
        centerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        centerButton.setToolTipText("🎉 Click to honor our Independence! 🎉");

        // Hover effect
        centerButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                centerButton.setBackground(new Color(0, 153, 0));
                centerButton.setForeground(new Color(255, 215, 0));
                centerButton.setFont(centerButton.getFont().deriveFont(30f));
            }

        });

        // Button click
        centerButton.addActionListener(_ -> openImageFrame("akki.jpg"));

        // Add button to panel
        backgroundPanel.add(centerButton, new GridBagConstraints(
                0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(20, 20, 20, 20), 0, 0));
        

        // Add animations using Timer
        Timer animationTimer = new Timer(30, _ -> {
           
            // Button pulse animation
            if (growing) {
                scale += 0.005f;
                if (scale >= 1.05f)
                    growing = false;
            } else {
                scale -= 0.005f;
                if (scale <= 0.95f)
                    growing = true;
            }
            centerButton.setFont(centerButton.getFont().deriveFont(28f * scale));

            // Text color cycling
            textHue += 0.01f;
            if (textHue > 1)
                textHue = 0;
            centerButton.setForeground(Color.getHSBColor(textHue, 1f, 1f));

            backgroundPanel.repaint();
        });
        animationTimer.start();

        setContentPane(backgroundPanel);
    }

    // Method to open a new frame showing an image with fade-in animation
    private void openImageFrame(String imagePath) {
        JFrame imageFrame = new JFrame("Image Viewer");
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(imagePath).getImage();
            float alpha = 0f; // start fully transparent

            public JPanel startFade() {
                Timer fadeTimer = new Timer(30, e -> {
                    alpha += 0.02f;
                    if (alpha >= 1f) {
                        alpha = 1f;
                        ((Timer) e.getSource()).stop();
                    }
                    repaint();
                });
                fadeTimer.start();
                return this;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imgWidth = img.getWidth(null);
                int imgHeight = img.getHeight(null);
                double imgAspect = (double) imgWidth / imgHeight;
                double panelAspect = (double) panelWidth / panelHeight;

                int drawWidth, drawHeight;
                if (imgAspect > panelAspect) {
                    drawWidth = panelWidth;
                    drawHeight = (int) (panelWidth / imgAspect);
                } else {
                    drawHeight = panelHeight;
                    drawWidth = (int) (panelHeight * imgAspect);
                }
                int x = (panelWidth - drawWidth) / 2;
                int y = (panelHeight - drawHeight) / 2;

                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g2d.drawImage(img, x, y, drawWidth, drawHeight, this);
            }
        }.startFade();

        imageFrame.add(imagePanel);
        imageFrame.setSize(800, 600);
        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IndependenceDay().setVisible(true));
    }
}
