import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton saving_account_rbutton,fixedDiposit_rbutton,current_rbutton,recurringDiposit_rbutton;
    JCheckBox atm_checkbox,internetBanking_checkbox,mobileBanking_checkbox,emailandsmsAlerts_checkbox,chequebook_checkbox,estatement_checkbox,declarationPage3_checkbox;
    JButton submitButton,cancelButtonS3;
    String formno;
    Signup3(String formno){
        setLayout(null);

        this.formno=formno;

        JLabel l1 = new JLabel("Page 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type_label = new JLabel("ACCOUNT TYPE");
        type_label.setFont(new Font("Railway",Font.BOLD,22));
        type_label.setBounds(100,140,200,30);
        add(type_label);

        saving_account_rbutton = new JRadioButton("Savings Account");
        saving_account_rbutton.setFont(new Font("Railway", Font.BOLD,14));
        saving_account_rbutton.setBounds(100,180,150,30);
        saving_account_rbutton.setBackground(Color.WHITE);
        add(saving_account_rbutton);

        fixedDiposit_rbutton = new JRadioButton("Fixed Deposit Account");
        fixedDiposit_rbutton.setFont(new Font("Railway", Font.BOLD,14));
        fixedDiposit_rbutton.setBounds(350,180,250,30);
        fixedDiposit_rbutton.setBackground(Color.WHITE);
        add(fixedDiposit_rbutton);

        current_rbutton = new JRadioButton("Current Account");
        current_rbutton.setFont(new Font("Railway", Font.BOLD,14));
        current_rbutton.setBounds(100,220,150,30);
        current_rbutton.setBackground(Color.WHITE);
        add(current_rbutton);

        recurringDiposit_rbutton = new JRadioButton("Recurring Deposit Account");
        recurringDiposit_rbutton.setFont(new Font("Railway", Font.BOLD,14));
        recurringDiposit_rbutton.setBounds(350,220,250,30);
        recurringDiposit_rbutton.setBackground(Color.WHITE);
        add(recurringDiposit_rbutton);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(saving_account_rbutton);
        accountTypeGroup.add(fixedDiposit_rbutton);
        accountTypeGroup.add(current_rbutton);
        accountTypeGroup.add(recurringDiposit_rbutton);

        JLabel NewCardno_label = new JLabel("CARD No.:");
        NewCardno_label.setFont(new Font("Railway",Font.BOLD,22));
        NewCardno_label.setBounds(100,300,200,30);
        add(NewCardno_label);

        JLabel showCardno_label = new JLabel("XXXX-XXXX-XXXX-4184");
        showCardno_label.setFont(new Font("Railway",Font.BOLD,22));
        showCardno_label.setBounds(330,300,300,30);
        showCardno_label.setBackground(Color.WHITE);
        add(showCardno_label);


        JLabel showCardnoDetails_label = new JLabel("Your 16 Digit Card Number");
        showCardnoDetails_label.setFont(new Font("Railway",Font.BOLD,12));
        showCardnoDetails_label.setBounds(100,330,300,15);
        showCardnoDetails_label.setBackground(Color.WHITE);
        add(showCardnoDetails_label);

        JLabel newPin_label = new JLabel("PIN No.: ");
        newPin_label.setFont(new Font("Railway",Font.BOLD,22));
        newPin_label.setBounds(100,370,200,30);
        newPin_label.setBackground(Color.WHITE);
        add(newPin_label);

        JLabel showPin_label = new JLabel("XXXX");
        showPin_label.setFont(new Font("Railway",Font.BOLD,22));
        showPin_label.setBounds(330,370,300,30);
        showPin_label.setBackground(Color.WHITE);
        add(showPin_label);

        JLabel showPinDetails_label = new JLabel("Your 4 Digit Pin Number");
        showPinDetails_label.setFont(new Font("Railway",Font.BOLD,12));
        showPinDetails_label.setBounds(100,400,300,15);
        showPinDetails_label.setBackground(Color.WHITE);
        add(showPinDetails_label);

        JLabel servicesRequired_label = new JLabel("Services Required: ");
        servicesRequired_label.setFont(new Font("Railway",Font.BOLD,22));
        servicesRequired_label.setBounds(100,450,300,30);
        servicesRequired_label.setBackground(Color.WHITE);
        add(servicesRequired_label);

        atm_checkbox = new JCheckBox("ATM CARD");
        atm_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        atm_checkbox.setBackground(Color.WHITE);
        atm_checkbox.setBounds(100,500,200,30);
        add(atm_checkbox);

        internetBanking_checkbox = new JCheckBox("INTERNET BANKING");
        internetBanking_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        internetBanking_checkbox.setBackground(Color.WHITE);
        internetBanking_checkbox.setBounds(350,500,200,30);
        add(internetBanking_checkbox);

        mobileBanking_checkbox = new JCheckBox("MOBILE BANKING");
        mobileBanking_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        mobileBanking_checkbox.setBackground(Color.WHITE);
        mobileBanking_checkbox.setBounds(100,550,200,30);
        add(mobileBanking_checkbox);

        emailandsmsAlerts_checkbox = new JCheckBox("EMAIL & SMS ALERTS");
        emailandsmsAlerts_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        emailandsmsAlerts_checkbox.setBackground(Color.WHITE);
        emailandsmsAlerts_checkbox.setBounds(350,500,200,30);
        add(emailandsmsAlerts_checkbox);

        chequebook_checkbox = new JCheckBox("CHEQUE BOOK");
        chequebook_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        chequebook_checkbox.setBackground(Color.WHITE);
        chequebook_checkbox.setBounds(350,550,200,30);
        add(chequebook_checkbox);

        estatement_checkbox = new JCheckBox("E-STATEMENT");
        estatement_checkbox.setFont(new Font("Railway",Font.BOLD,16));
        estatement_checkbox.setBackground(Color.WHITE);
        estatement_checkbox.setBounds(100,600,200,30);
        add(estatement_checkbox);

        declarationPage3_checkbox = new JCheckBox("I hereby declare the above entered details are correct to the best of my knowledge.");
        declarationPage3_checkbox.setFont(new Font("Railway",Font.BOLD,12));
        declarationPage3_checkbox.setBackground(Color.WHITE);
        declarationPage3_checkbox.setBounds(100,680,600,30);
        add(declarationPage3_checkbox);

        cancelButtonS3 = new JButton("Cancel");
        cancelButtonS3.setBackground(Color.BLACK);
        cancelButtonS3.setForeground(Color.WHITE);
        cancelButtonS3.setFont(new Font("Railway", Font.BOLD, 14));
        cancelButtonS3.setBounds(420,720,100,30);
        cancelButtonS3.addActionListener(this);
        add(cancelButtonS3);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Railway", Font.BOLD, 14));
        submitButton.setBounds(220,720,100,30);
        submitButton.addActionListener(this);
        add(submitButton);







        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submitButton){
            String accountType = "";
            if(saving_account_rbutton.isSelected()){
                accountType = "Saving Account";
            } else if (fixedDiposit_rbutton.isSelected()) {
                accountType="Fixed Diposit Account";
            } else if (current_rbutton.isSelected()) {
                accountType="Current Account";
            } else if (recurringDiposit_rbutton.isSelected()) {
                accountType="Recurring Diposit Account";
            }
            Random random = new Random();
            String cardNumber = ""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L ) + 1000L);

            String facility = "";
            if(atm_checkbox.isSelected()){
                facility = facility + " ATM CARD";
            } else if (internetBanking_checkbox.isSelected()) {
                facility = facility + " INTERNET BANKING";
            } else if (mobileBanking_checkbox.isSelected()) {
                facility = facility + " MOBILE BANKING";
            } else if (emailandsmsAlerts_checkbox.isSelected()) {
                facility = facility + " EMAIL & SMS ALERTS";
            } else if (chequebook_checkbox.isSelected()) {
                facility = facility + " CHEQUE BOOK";
            } else if (estatement_checkbox.isSelected()) {
                facility = facility + " E-STATEMENT";
            }
            try {
                if (accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
                    Conn conn = new Conn();
                    String querry3= "insert into signup3 values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String querry4= "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(querry3);
                    conn.s.executeUpdate(querry4);
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardNumber+"\n Pin: "+pinNumber);
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {

        new Signup3("");
    }
}
