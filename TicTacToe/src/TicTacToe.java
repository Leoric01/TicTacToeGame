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
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(50, 38, 38));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout((new BorderLayout()));
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font ("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void firstTurn() throws InterruptedException {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {

    }

    public void xWins(int a, int b, int c) {

    }

    public void oWins(int a, int b, int c) {

    }
}
