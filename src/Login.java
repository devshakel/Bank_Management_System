import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{

    JButton signin,clear1,clear2,signup,exit;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("CARD No.");
        cardno.setFont(new Font("Railway", Font.BOLD,20));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,20));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Osward", Font.BOLD,20));
        pin.setBounds(120, 220, 230, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14 ));
        add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear1 = new JButton("CLEAR");
        clear1.setBounds(550, 150, 100, 25);
        clear1.setBackground(Color.BLACK);
        clear1.setForeground(Color.WHITE);
        clear1.addActionListener(this);
        add(clear1);

        clear2 = new JButton("CLEAR");
        clear2.setBounds(550, 220, 100, 30);
        clear2.setBackground(Color.BLACK);
        clear2.setForeground(Color.WHITE);
        clear2.addActionListener(this);
        add(clear2);



        signup = new JButton("SIGN UP");
        signup.setBounds(430, 300, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        exit = new JButton("Exit");
        exit.setBounds(350,350,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);


        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear1){
            cardTextField.setText("");
        } else if (ae.getSource()==clear2) {
            pinTextField.setText("");
        }else if(ae.getSource()==exit){
            System.exit(0);
        } else if(ae.getSource() == signin){
            try{
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String querry ="select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'  ";
            ResultSet rs = conn.s.executeQuery(querry);
            if(rs.next()){
                setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
            }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource()== signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);

    }
}

