import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    JButton back_button;
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber= pinNumber;

        setLayout(null);

        JLabel mini_label = new JLabel();
        mini_label.setBounds(20,140,400,200);
        add(mini_label);

        JLabel bankName_label = new JLabel("Joy Bangla Bank");
        bankName_label.setBounds(340,20,400,50);
        bankName_label.setFont(new Font("Railway",Font.BOLD,30));
        add(bankName_label);

        JLabel cardNumber_label = new JLabel();
        cardNumber_label.setBounds(20,80,300,20);
        add(cardNumber_label);

        JLabel balance_label = new JLabel();
        balance_label.setBounds(20,400,300,20);
        add(balance_label);

        back_button = new JButton("BACK");
        back_button.setBounds(600,700,150,30);
        back_button.addActionListener(this);
        add(back_button);




        try{
            Conn conn = new Conn();
            ResultSet rs =  conn.s.executeQuery("select * from login where pinNUmber ='"+pinNumber+"'");
            while (rs.next()){
                cardNumber_label.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardNumber").substring(12));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Conn conn = new Conn();
            int balance = 0;
            ResultSet rs =  conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
            while (rs.next()){
                mini_label.setText(mini_label.getText() + "<html>" +  rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance_label.setText("Your account balance is Rs "+balance);
        }catch (Exception e){
            System.out.println(e);
        }

//        setSize(400,600);
//        setLocation(20,20);
//        getContentPane().setBackground(Color.WHITE);
//        setVisible(true);

        setSize(800,800);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back_button){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
