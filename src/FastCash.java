import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton rs100_button, rs500_button, rs1000_button,rs2000_button, rs5000_button, rs10000_button,rs20000_button, back_button;
    String pinNumber;
    FastCash(String pinNumber){
        setLayout(null);
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label= new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);

        JLabel text1 = new JLabel("Please select Withdrawl Amount");
        text1.setBounds(210,300,700,35);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setForeground(Color.WHITE);
        image_label.add(text1);

        rs100_button = new JButton("Rs 100");
        rs100_button.setBounds(170,418,150,30);
        rs100_button.addActionListener(this);
        image_label.add(rs100_button);

        rs500_button = new JButton("Rs 500");
        rs500_button.setBounds(355,418,150,30);
        rs500_button.addActionListener(this);
        image_label.add(rs500_button);

        rs1000_button = new JButton("Rs 1000");
        rs1000_button.setBounds(170,451,150,30);
        rs1000_button.addActionListener(this);
        image_label.add(rs1000_button);

        rs2000_button = new JButton("Rs 2000");
        rs2000_button.setBounds(355,451,150,30);
        rs2000_button.addActionListener(this);
        image_label.add(rs2000_button);

        rs5000_button = new JButton("Rs 5000");
        rs5000_button.setBounds(355,485,150,30);
        rs5000_button.addActionListener(this);
        image_label.add(rs5000_button);

        rs10000_button = new JButton("Rs 10000");
        rs10000_button.setBounds(170,485,150,30);
        rs10000_button.addActionListener(this);
        image_label.add(rs10000_button);

        rs20000_button = new JButton("Rs 20000");
        rs20000_button.setBounds(170,518,150,30);
        rs20000_button.addActionListener(this);
        image_label.add(rs20000_button);


        back_button = new JButton("BACK");
        back_button.setBounds(355,518,150,30);
        back_button.addActionListener(this);
        image_label.add(back_button);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back_button){
            setVisible(false);
            new Transaction(pinNumber);
        } else{
            String amount_withdrawl = ((JButton)ae.getSource()).getText().substring(3);
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"' ");
                int balance = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back_button && balance < Integer.parseInt(amount_withdrawl)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String querry = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount_withdrawl+"')";
                conn.s.executeUpdate(querry);
                JOptionPane.showMessageDialog(null,"Rs "+amount_withdrawl+" Debited Successfully");
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
