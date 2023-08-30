import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back_button;
    String pinNumber;
    BalanceEnquiry(String pinNUmber){
        setLayout(null);
        this.pinNumber=pinNUmber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);


        back_button = new JButton("BACK");
        back_button.setBounds(355,518,150,30);
        back_button.addActionListener(this);
        image_label.add(back_button);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '" + pinNumber + "' ");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel balanceView_label = new JLabel("Your Current Balance is Rs " + balance);
        balanceView_label.setForeground(Color.WHITE);
        balanceView_label.setBounds(200,280,400,30);
        image_label.add(balanceView_label);



        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back_button) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
