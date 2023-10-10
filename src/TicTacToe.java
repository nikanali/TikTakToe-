import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    private Random random= new Random();
    private JFrame frame = new JFrame();
    private Panel titlePanel = new Panel();
    private Panel buttonsPanel=new Panel();
    private JLabel textLabel =new JLabel();
    private JButton[] buttons= new JButton[9];
    private boolean palyer1Turn;


    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(22, 57, 118));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textLabel.setBackground(new Color(65, 65, 129, 255));
        textLabel.setForeground(new Color(255, 255, 255, 255));
        textLabel.setFont(new Font("Times New Roman",Font.ITALIC,60));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);
        //above are for the text field
        //below are for the title panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,150);
        titlePanel.add(textLabel);
        //below are for buttons
        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(22, 57, 118, 255));

        for (int i=0; i<9;i++){
            buttons[i]=new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonsPanel);
        //below are code for running the game
        firstTurn();


    }

    public void firstTurn(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (random.nextInt(1)==0){
            palyer1Turn=true;
            textLabel.setText("X-Turn");
        }
        else {
            palyer1Turn=false;
            textLabel.setText("O-Turn");
        }
    }


    public void checkWinning(){
        //check X winning conditions
        if (    buttons[0].getText()=="X" &&
                buttons[1].getText()=="X" &&
                buttons[2].getText()=="X" ){
            xWins(0,1,2);
        }  if ( buttons[3].getText()=="X" &&
                    buttons[4].getText()=="X" &&
                    buttons[5].getText()=="X" ) {
            xWins(3,4,5);

        }  if (buttons[6].getText()=="X" &&
                buttons[7].getText()=="X" &&
                buttons[8].getText()=="X") {
            xWins(6,7,8);

        }
         if (buttons[0].getText()=="X" &&
                buttons[3].getText()=="X" &&
                buttons[6].getText()=="X") {
            xWins(0,3,6);

        }
         if (buttons[1].getText()=="X" &&
                buttons[4].getText()=="X" &&
                buttons[7].getText()=="X") {
            xWins(1,4,7);

        }
        if (buttons[2].getText()=="X" &&
                buttons[5].getText()=="X" &&
                buttons[8].getText()=="X") {
            xWins(2,5,8);

        }
         if (buttons[0].getText()=="X" &&
                buttons[4].getText()=="X" &&
                buttons[8].getText()=="X") {
            xWins(0,4,8);

        }
         if (buttons[2].getText()=="X" &&
                buttons[4].getText()=="X" &&
                buttons[6].getText()=="X") {
            xWins(2,4,6);

        }
         //Check O winning condition
        if (    buttons[0].getText()=="O" &&
                buttons[1].getText()=="O" &&
                buttons[2].getText()=="O" ){
            oWins(0,1,2);
        }  if ( buttons[3].getText()=="O" &&
                buttons[4].getText()=="O" &&
                buttons[5].getText()=="O" ) {
            oWins(3,4,5);

        }  if (buttons[6].getText()=="O" &&
                buttons[7].getText()=="O" &&
                buttons[8].getText()=="O") {
            oWins(6,7,8);

        }
        if (buttons[0].getText()=="O" &&
                buttons[3].getText()=="O" &&
                buttons[6].getText()=="O") {
            oWins(0,3,6);

        }
        if (buttons[1].getText()=="O" &&
                buttons[4].getText()=="O" &&
                buttons[7].getText()=="O") {
            oWins(1,4,7);

        }
        if (buttons[2].getText()=="O" &&
                buttons[5].getText()=="O" &&
                buttons[8].getText()=="O") {
            oWins(2,5,8);

        }
        if (buttons[0].getText()=="O" &&
                buttons[4].getText()=="O" &&
                buttons[8].getText()=="O") {
            oWins(0,4,8);

        }
        if (buttons[2].getText()=="O" &&
                buttons[4].getText()=="O" &&
                buttons[6].getText()=="O") {
            oWins(2,4,6);

        }


    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(new Color(0, 0, 0,255));
        buttons[b].setBackground(new Color(0, 0, 0,255));
        buttons[c].setBackground(new Color(0, 0, 0,255));

        for (int i=0;i<9;i++){

            buttons[i].setEnabled(false);
        }
        textLabel.setText("X Wins");

    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(new Color(0, 0, 0,255));
        buttons[b].setBackground(new Color(0, 0, 0,255));
        buttons[c].setBackground(new Color(0, 0, 0,255));

        for (int i=0;i<9;i++){

            buttons[i].setEnabled(false);
        }
        textLabel.setText("O Wins");

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<9;i++){

            if (e.getSource()==buttons[i]) {
                if (palyer1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(222, 0, 0, 255));
                        buttons[i].setText("X");
                        palyer1Turn = false;
                        textLabel.setText("O-Turn");
                        checkWinning();
                    }
                }
                else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(22, 57, 118, 255));
                        buttons[i].setText("O");
                        palyer1Turn=true;
                        textLabel.setText("X-Turn");
                        checkWinning();
                    }
            }

            }
        }

    }


}
