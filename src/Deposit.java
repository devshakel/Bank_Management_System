import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back_button;
    JTextField amounntDeposit_textField;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);

        JLabel text_label = new JLabel("Enter the amount you want to diposit");
        text_label.setForeground(Color.WHITE);
        text_label.setFont(new Font("System", Font.BOLD, 16));
        text_label.setBounds(170,300,400,20);
        image_label.add(text_label);

        amounntDeposit_textField = new JTextField();
        amounntDeposit_textField.setFont(new Font("Railway", Font.BOLD, 22));
        amounntDeposit_textField.setBounds(170,350,320,25);
        image_label.add(amounntDeposit_textField);

        deposit = new JButton("Diposit");
        deposit.setBounds(400,458,100,30);
        deposit.addActionListener(this);
        image_label.add(deposit);

        back_button = new JButton("BACK");
        back_button.setBounds(400,490,100,30);
        back_button.addActionListener(this);
        image_label.add(back_button);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String depositAmount = amounntDeposit_textField.getText();
            Date date = new Date();
            if(depositAmount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to diposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String querry = "insert into bank values('" + pinNumber + "','" + date + "','Deposit','" + depositAmount + "')";
                    conn.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null,"Rs"+depositAmount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back_button) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
