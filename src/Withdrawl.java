import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amounntWithdraw_textField;
    String pinNumber;
    Withdrawl(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);

        JLabel text_label = new JLabel("Enter the amount you want to Withdraw");
        text_label.setForeground(Color.WHITE);
        text_label.setFont(new Font("System", Font.BOLD, 16));
        text_label.setBounds(170,300,400,20);
        image_label.add(text_label);

        amounntWithdraw_textField = new JTextField();
        amounntWithdraw_textField.setFont(new Font("Railway", Font.BOLD, 22));
        amounntWithdraw_textField.setBounds(170,350,320,25);
        image_label.add(amounntWithdraw_textField);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(400,458,100,30);
        withdraw.addActionListener(this);
        image_label.add(withdraw);

        back = new JButton("Back");
        back.setBounds(400,492,100,30);
        back.addActionListener(this);
        image_label.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String withdrawAmount = amounntWithdraw_textField.getText();
            Date date = new Date();
            if(withdrawAmount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to diposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String querry = "insert into bank values('" + pinNumber + "','" + date + "','withdraw','" + withdrawAmount + "')";
                    conn.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null,"Rs"+withdrawAmount+" Withdrawl Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
