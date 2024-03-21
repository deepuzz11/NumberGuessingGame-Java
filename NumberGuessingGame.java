import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGuessingGame extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;
    private int targetNumber;
    private int attempts;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(800, 600); // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(220, 230, 255)); // Pale blue background

        initializeGame();

        JLabel instructionsLabel = new JLabel("Guess a number between 1 and 100:");
        instructionsLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        instructionsLabel.setForeground(Color.blue);
        instructionsLabel.setHorizontalAlignment(JLabel.CENTER);

        guessField = new JTextField(10);
        guessField.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        guessButton.setBackground(Color.green);
        guessButton.setForeground(Color.white);

        guessButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButtonSize(1.1);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButtonSize(1.0);
            }
        });

        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        resultLabel.setForeground(Color.red);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessField.getText());
                checkGuess(guess);
            }
        });

        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        topPanel.add(instructionsLabel);
        topPanel.add(guessField);
        topPanel.add(guessButton);
        topPanel.setBackground(new Color(220, 230, 255)); // Pale blue background
        add(topPanel, BorderLayout.NORTH);

        JPanel resultPanel = new JPanel(new GridLayout(1, 1));
        resultPanel.add(resultLabel);
        resultPanel.setBackground(new Color(220, 230, 255)); // Pale blue background
        add(resultPanel, BorderLayout.CENTER);
    }

    private void initializeGame() {
        targetNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
    }

    private void checkGuess(int guess) {
        attempts++;
        if (guess < targetNumber) {
            displayResult("Too low! Try again.");
        } else if (guess > targetNumber) {
            displayResult("Too high! Try again.");
        } else {
            displayResult("Congratulations! You've guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
            guessButton.setEnabled(false); // Disable the guess button after correct guess
        }
    }

    private void displayResult(String message) {
        resultLabel.setText(message);
        resultLabel.setForeground(Color.red);

        Timer timer = new Timer(100, new ActionListener() {
            private float alpha = 0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1.0f) {
                    ((Timer) e.getSource()).stop();
                }
                resultLabel.setForeground(new Color(1f, 0f, 0f, alpha));
            }
        });
        timer.setRepeats(true);
        timer.start();

        Timer timer2 = new Timer(3000, new ActionListener() {
            private float alpha = 1f;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0.0f) {
                    ((Timer) e.getSource()).stop();
                }
                resultLabel.setForeground(new Color(1f, 0f, 0f, alpha));
            }
        });
        timer2.setRepeats(true);
        timer2.setInitialDelay(2000);
        timer2.start();
    }

    private void animateButtonSize(double scaleFactor) {
        Dimension size = guessButton.getPreferredSize();
        size.setSize(size.getWidth() * scaleFactor, size.getHeight() * scaleFactor);
        guessButton.setPreferredSize(size);
        guessButton.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGame().setVisible(true);
            }
        });
    }
}
