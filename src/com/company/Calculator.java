package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JFrame frame;
    JTextField screen;
    JPanel panel;
    JButton numButtons[] = new JButton[10];
    JButton operationButtons[] = new JButton[7];
    JButton multiplyButton, minButton, plusButton, divisionButton;
    JButton dotButton, equButton, clrButton, negativeButton;
    Font font = new Font("Century",Font.PLAIN,38);
    char operator;

    double num1=0;
    double num2=0;
    double result=0;

    Calculator() {
        // MainFrame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setPreferredSize(new Dimension(420,550));

        //Screen
        screen = new JTextField();
        screen.setBounds(30,30,340,50);
        screen.setEditable(false);
        screen.setFont(font);
        screen.setForeground(new Color(140, 140, 110));
        screen.setBackground(new Color(240, 240, 200));
        screen.setHorizontalAlignment(SwingConstants.TRAILING);

        //operation buttons
        multiplyButton = new JButton("*");
        minButton = new JButton("-");
        plusButton = new JButton("+");
        divisionButton = new JButton("/");
        negativeButton = new JButton("+/-");
        dotButton = new JButton(".");
        equButton = new JButton("=");

        operationButtons[0]=multiplyButton;
        operationButtons[1]=minButton;
        operationButtons[2]=plusButton;
        operationButtons[3]=divisionButton;
        operationButtons[4]=negativeButton;
        operationButtons[5]=dotButton;
        operationButtons[6]=equButton;

        for (int i=0;i<=6;i++){
            operationButtons[i].setSize(50,50);
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFocusable(false);
            operationButtons[i].setFont(new Font("Century",Font.PLAIN,25));
            operationButtons[i].setBackground(new Color(240, 240, 200));
        }
        for (int i=0;i<=9;i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setSize(50,50);
            numButtons[i].setFocusable(false);
            numButtons[i].setFont(font);
            numButtons[i].setBackground(new Color(240, 240, 200));
        }

        // grid panel
        panel = new JPanel();
        panel.setBounds(30,110,340,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multiplyButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(divisionButton);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(minButton);
        panel.add(negativeButton);
        panel.add(numButtons[0]);
        panel.add(plusButton);
        panel.add(dotButton);

        clrButton = new JButton("C");
        clrButton.setFont(font);
        clrButton.setBounds(30,420,165,50);
        clrButton.setFocusable(false);
        clrButton.setBackground(new Color(240, 240, 200));
        clrButton.addActionListener(this);

        equButton = new JButton("=");
        equButton.setFont(font);
        equButton.setBounds(205,420,165,50);
        equButton.setFocusable(false);
        equButton.setBackground(new Color(240, 240, 200));
        equButton.addActionListener(this);

        frame.add(clrButton);
        frame.add(equButton);
        frame.add(panel);
        frame.add(screen);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<=9;i++) {
            if(e.getSource()==numButtons[i]){
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==dotButton){
            screen.setText(screen.getText().concat((".")));
        }
        if(e.getSource()==plusButton){
            num1 = Double.parseDouble(screen.getText());
            screen.setText("");
            operator = '+';
        }
        if(e.getSource()==minButton){
            num1 = Double.parseDouble(screen.getText());
            screen.setText("");
            operator = '-';
        }
        if(e.getSource()==multiplyButton){
            num1 = Double.parseDouble(screen.getText());
            screen.setText("");
            operator = '*';
        }
        if(e.getSource()==divisionButton){
            num1 = Double.parseDouble(screen.getText());
            screen.setText("");
            operator = '/';
        }

        if(e.getSource()==negativeButton){
            double neg = Double.parseDouble(screen.getText());
            neg *= -1;
            screen.setText(String.valueOf(neg));
        }
        if(e.getSource()==clrButton){
            screen.setText("");
            num1=0;
        }

        if(e.getSource()==equButton) {
            num2 = Double.parseDouble(screen.getText());
            screen.setText("");

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
            }
            screen.setText(String.valueOf(result));
            num1=result;
        }
    }
}



