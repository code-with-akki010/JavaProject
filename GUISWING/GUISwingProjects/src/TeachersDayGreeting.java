import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TeachersDayGreeting extends JFrame {
    private JLabel messageLabel;
    private String fullMessage = "printf(\"Happy Teacher’s Day, Debugger of our Errors ❤️\");";
    private StringBuilder currentMessage = new StringBuilder();
    private int index = 0;
    private Timer typingTimer, colorTimer, binaryTimer;
    private float hue = 0f;
    private String[] binaries;
    private int[] yPositions;
    private Random rand = new Random();

    public TeachersDayGreeting() {
        setTitle("Teacher's Day Greeting - CS Style");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create message label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Consolas", Font.BOLD, 26));
        messageLabel.setForeground(Color.YELLOW);

        // Custom panel for binary animation
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.getHSBColor(hue, 0.6f, 0.15f));

                g.setFont(new Font("Monospaced", Font.BOLD, 18));
                g.setColor(Color.GREEN);

                for (int i = 0; i < binaries.length; i++) {
                    g.drawString(binaries[i], i * 30, yPositions[i]);
                }
            }
        };
        panel.setLayout(new BorderLayout());
        panel.add(messageLabel, BorderLayout.CENTER);

        getContentPane().add(panel);

        // Initialize binary rain
        int columns = 30;
        binaries = new String[columns];
        yPositions = new int[columns];
        for (int i = 0; i < columns; i++) {
            binaries[i] = rand.nextBoolean() ? "0" : "1";
            yPositions[i] = rand.nextInt(400);
        }

        // Typing animation
        typingTimer = new Timer(120, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (index < fullMessage.length()) {
                    currentMessage.append(fullMessage.charAt(index));
                    messageLabel.setText(currentMessage.toString());
                    index++;
                } else {
                    typingTimer.stop();
                }
            }
        });

        // Background color animation
        colorTimer = new Timer(60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hue += 0.002f;
                if (hue > 1) hue = 0;
                panel.repaint();
            }
        });

        // Binary falling animation
        binaryTimer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < binaries.length; i++) {
                    yPositions[i] += 20;
                    if (yPositions[i] > getHeight()) {
                        yPositions[i] = 0;
                        binaries[i] = rand.nextBoolean() ? "0" : "1";
                    }
                }
                panel.repaint();
            }
        });

        typingTimer.start();
        colorTimer.start();
        binaryTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TeachersDayGreeting().setVisible(true);
        });
    }
}
