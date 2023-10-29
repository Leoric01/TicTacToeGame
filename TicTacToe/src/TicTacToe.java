import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    public TicTacToe() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(50, 38, 38));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout((new BorderLayout()));
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textfield);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();
        check();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("0");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals("X") && buttons[i + 1].getText().equals("X") && buttons[i + 2].getText().equals("X")) {
                xWins(i, i + 1, i + 2);
                return;
            }
            if (buttons[i].getText().equals("O") && buttons[i + 1].getText().equals("O") && buttons[i + 2].getText().equals("O")) {
                oWins(i, i + 1, i + 2);
                return;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals("X") && buttons[i + 3].getText().equals("X") && buttons[i + 6].getText().equals("X")) {
                xWins(i, i + 3, i + 6);
                return;
            }
            if (buttons[i].getText().equals("O") && buttons[i + 3].getText().equals("O") && buttons[i + 6].getText().equals("O")) {
                oWins(i, i + 3, i + 6);
                return;
            }
        }
        // Check diagonals
        if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
            return;
        }
        if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
            return;
        }
        if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
            return;
        }
        if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
            return;
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.LIGHT_GRAY);
        buttons[b].setBackground(Color.LIGHT_GRAY);
        buttons[c].setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X WINS");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.LIGHT_GRAY);
        buttons[b].setBackground(Color.LIGHT_GRAY);
        buttons[c].setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O WINS");
    }
}
