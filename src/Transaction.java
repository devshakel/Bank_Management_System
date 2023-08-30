import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit_button, cashWithdraw_button, fastCash_button, miniStatement_button, pinChange_button, balanceEnquiry_button, logOut_button;
    String pinNumber;
    Transaction(String pinNumber){
        setLayout(null);
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label= new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);

        JLabel text1 = new JLabel("Please select your Transaction");
        text1.setBounds(210,300,700,35);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setForeground(Color.WHITE);
        image_label.add(text1);

        deposit_button = new JButton("DEPOSIT");
        deposit_button.setBounds(170,418,150,30);
        deposit_button.addActionListener(this);
        image_label.add(deposit_button);

        cashWithdraw_button = new JButton("CASH WITHDRAW");
        cashWithdraw_button.setBounds(350,415,150,30);
        cashWithdraw_button.addActionListener(this);
        image_label.add(cashWithdraw_button);

        fastCash_button = new JButton("FAST CASH");
        fastCash_button.setBounds(170,450,150,30);
        fastCash_button.addActionListener(this);
        image_label.add(fastCash_button);

        miniStatement_button = new JButton("MINI STATEMENT");
        miniStatement_button.setBounds(350,450,150,30);
        miniStatement_button.addActionListener(this);
        image_label.add(miniStatement_button);

        pinChange_button = new JButton("PIN CHANGE");
        pinChange_button.setBounds(350,485,150,30);
        pinChange_button.addActionListener(this);
        image_label.add(pinChange_button);

        balanceEnquiry_button = new JButton("BALANCE ENQUIRY");
        balanceEnquiry_button.setBounds(170,485,150,30);
        balanceEnquiry_button.addActionListener(this);
        image_label.add(balanceEnquiry_button);

        logOut_button = new JButton("LOG OUT");
        logOut_button.setBounds(350,520,150,30);
        logOut_button.addActionListener(this);
        image_label.add(logOut_button);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==logOut_button){
            setVisible(false);
//            System.exit(0);
            new Login().setVisible(true);
        } else if (ae.getSource() == deposit_button) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==cashWithdraw_button) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastCash_button){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource()==pinChange_button) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if( ae.getSource() == balanceEnquiry_button){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource()==miniStatement_button){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
