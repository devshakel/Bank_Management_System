import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener {

    JTextField ynameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pinTextField;
    JButton next;
    JRadioButton male, female, otherG, married, unmarried, divorced;
    JComboBox state_combobox;
    JDateChooser dateChooser;
    Long random;
    String formno,yname,fname,dob,gender,email,marital,address,city,state,pin;
    Signup1() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno_label = new JLabel("APPLICATION FORM NO. " + random);
        formno_label.setFont(new Font("Railway", Font.BOLD, 38));
        formno_label.setBounds(140, 20, 600, 40);
        add(formno_label);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");

        JLabel yname_label = new JLabel("Name: ");
        yname_label.setFont(new Font("Railway", Font.BOLD, 20));
        yname_label.setBounds(100, 140, 100, 30);
        add(yname_label);

        ynameTextField = new JTextField();
        ynameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        ynameTextField.setBounds(300, 140, 400, 30);
        add(ynameTextField);

        JLabel fname_label = new JLabel("Father's Name: ");
        fname_label.setFont(new Font("Railway", Font.BOLD, 20));
        fname_label.setBounds(100, 190, 200, 30);
        add(fname_label);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob_label = new JLabel("Date of Birth: ");
        dob_label.setFont(new Font("Railway", Font.BOLD, 20));
        dob_label.setBounds(100, 240, 200, 30);
        add(dob_label);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender_label = new JLabel("Gender: ");
        gender_label.setFont(new Font("Railway", Font.BOLD, 20));
        gender_label.setBounds(100, 290, 200, 30);
        add(gender_label);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380, 290, 90, 30);
        female.setBackground(Color.WHITE);
        add(female);

        otherG = new JRadioButton("Other");
        otherG.setBounds(480, 290, 120, 30);
        otherG.setBackground(Color.WHITE);
        add(otherG);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherG);

        JLabel email_label = new JLabel("Email: ");
        email_label.setFont(new Font("Railway", Font.BOLD, 20));
        email_label.setBounds(100, 340, 200, 30);
        add(email_label);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Railway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        divorced = new JRadioButton("Divorced");
        divorced.setBounds(510, 390, 90, 30);
        divorced.setBackground(Color.WHITE);
        add(divorced);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(divorced);

        JLabel address_label = new JLabel("Address: ");
        address_label.setFont(new Font("Railway", Font.BOLD, 20));
        address_label.setBounds(100, 440, 200, 30);
        add(address_label);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city_label = new JLabel("City: ");
        city_label.setFont(new Font("Railway", Font.BOLD, 20));
        city_label.setBounds(100, 490, 200, 30);
        add(city_label);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state_label = new JLabel("State: ");
        state_label.setFont(new Font("Railway", Font.BOLD, 20));
        state_label.setBounds(100, 540, 200, 30);
        add(state_label);

        String []varState={"ANDHRA PRADESH","ARUNACHAL PRADESH","ASSAM","BIHAR","CHHATTISGARH","GOA","GUJRAT","HARYANA","HIMACHAL PRADESH","JHARKHAND","KARNATAKA","KERALA","MADHYA PRADESH","MAHARASHTRA","MANIPUR","MEGHALAYA","MIZORAM","NAGALAND","ODISHA","PUNJAB","RAJASTHAN","SIKKIM","TAMIL NADU","TELANGANA","TRIPURA","UTTARAKHAND","UTTAR PRADESH","WEST BENGAL"};
        state_combobox = new JComboBox(varState);
        state_combobox.setBounds(300,540,400,30);
        state_combobox.setBackground(Color.WHITE);
        add(state_combobox);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Railway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Railway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        next = new JButton("SAVE & Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 660, 140, 30);
        add(next);
        next.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        formno = "" + random;
        yname = ynameTextField.getText();
        fname = fnameTextField.getText();
        dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (otherG.isSelected()) {
            gender = "Other";
        }
        email = emailTextField.getText();
        marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (divorced.isSelected()) {
            marital = "Divorced";
        }
        address = addressTextField.getText();
        city = cityTextField.getText();
        state = (String) state_combobox.getSelectedItem();
        pin = pinTextField.getText();

        try {
            if (yname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.isEmpty()){
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }else if(email.isEmpty()){
                JOptionPane.showMessageDialog(null, "Email is Required");
            }else if(address.isEmpty()){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }else if(city.isEmpty()){
                JOptionPane.showMessageDialog(null, "City is Required");
            }else if(pin.isEmpty()){
                JOptionPane.showMessageDialog(null, "Pin Code is Required");
            }else {
                Conn c = new Conn();
                String querry = "insert into signup1 values('" + formno + "','" + yname + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(querry);
                c.s.close();
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup1();
    }
}
