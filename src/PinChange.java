import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;
    JPasswordField newPin,newRePin;
    JButton changePin_button,back_button;
    PinChange(String pinNumber){
        setLayout(null);
        this.pinNumber= pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label= new JLabel(i3);
        image_label.setBounds(0,0,900,900);
        add(image_label);

        JLabel text1 = new JLabel("Are you sure you want to Change your pin ?");
        text1.setBounds(170,300,500,25);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setForeground(Color.WHITE);
        image_label.add(text1);

        JLabel newPin_label = new JLabel("New PIN:");
        newPin_label.setBounds(165,418,180,25);
        newPin_label.setFont(new Font("System",Font.BOLD,16));
        newPin_label.setForeground(Color.WHITE);
        image_label.add(newPin_label);

        newPin = new JPasswordField();
        newPin.setFont(new Font("Railway", Font.BOLD,25));
        newPin.setBounds(360,418,150,25);
        add(newPin);

        JLabel rePin_label = new JLabel("Re-Enter New PIN:");
        rePin_label.setBounds(165,451,180,25);
        rePin_label.setFont(new Font("System",Font.BOLD,16));
        rePin_label.setForeground(Color.WHITE);
        image_label.add(rePin_label);

        newRePin = new JPasswordField();
        newRePin.setFont(new Font("Railway", Font.BOLD,25));
        newRePin.setBounds(360,451,150,25);
        add(newRePin);

        changePin_button = new JButton("CHANGE");
        changePin_button.setBounds(410,485,100,25);
        changePin_button.setForeground(Color.BLACK);
        changePin_button.setBackground(Color.WHITE);
        changePin_button.addActionListener(this);
        image_label.add(changePin_button);

        back_button = new JButton("BACK");
        back_button.setBounds(410,518,100,25);
        back_button.setForeground(Color.BLACK);
        back_button.setBackground(Color.WHITE);
        back_button.addActionListener(this);
        image_label.add(back_button);



        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== changePin_button) {
            try {
                String nwPin = newPin.getText();
                String reNePin = newRePin.getText();
                if (!nwPin.equals(reNePin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
//                    return;
                }
                if (nwPin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
//                    return;
                }else if (reNePin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new PIN");
//                    return;
                }else if(ae.getSource()==changePin_button) {
                    Conn conn = new Conn();
                    String querry1 = "update bank set pinNumber = '" + nwPin + "' where pinNumber = '" + pinNumber + "'";
                    String querry2 = "update login set pinNumber ='" + nwPin + "' where pinNumber = '" + pinNumber + "' ";
                    String querry3 = "update signup3 set pinNumber = '" + nwPin + "' where pinNumber = '" + pinNumber + "'";

                    conn.s.executeUpdate(querry1);
                    conn.s.executeUpdate(querry2);
                    conn.s.executeUpdate(querry3);

                    JOptionPane.showMessageDialog(null, "PIN Successfully Changed");

                    setVisible(false);

//                new Login().setVisible(true);

                    new Transaction(nwPin).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
