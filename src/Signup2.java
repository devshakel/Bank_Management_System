import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    JTextField aadharno_textField, panno_textField ;
    JComboBox income_combobox,category_combobox,religion_combobox,educationqualification_combobox,Occupation_combobox;
    JRadioButton scyes,scno,eayes,eano;
    JButton next;
    String formno;
    Signup2(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel formno_label = new JLabel("APPLICATION FORM NO. " +formno);
        formno_label.setFont(new Font("Railway", Font.BOLD, 38));
        formno_label.setBounds(140, 20, 600, 40);
        add(formno_label);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails_label = new JLabel("Page 2 : Additional Details");
        additionalDetails_label.setFont(new Font("Railway", Font.BOLD,22));
        additionalDetails_label.setBounds(290,80,400,30);
        add(additionalDetails_label);

        JLabel religion_label = new JLabel("Religion");
        religion_label.setFont(new Font("Railway", Font.BOLD,20));
        religion_label.setBounds(100, 140, 100, 30);
        add(religion_label);

        String []varReligion={"Hindu","Muslim","Sikh","Christian","Other"};
        religion_combobox = new JComboBox(varReligion);
        religion_combobox.setBounds(400,140,300,30);
        religion_combobox.setBackground(Color.WHITE);
        add(religion_combobox);



        JLabel category_label = new JLabel("Category: ");
        category_label.setFont(new Font("Railway", Font.BOLD, 20));
        category_label.setBounds(100, 190, 200, 30);
        add(category_label);

        String []varCategory = {"General","OBC","SC","ST","Other"};
        category_combobox = new JComboBox(varCategory);
        category_combobox.setBounds(400,190,300,30);
        category_combobox.setBackground(Color.WHITE);
        add(category_combobox);

        JLabel income_label = new JLabel("Income: ");
        income_label.setFont(new Font("Railway", Font.BOLD,20));
        income_label.setBounds(100, 240, 200, 30);
        add(income_label);

        String []varIncome={"<50,000","<1,50,000","2,50,000","<5,00,000","Upto 10,00,000"};
        income_combobox = new JComboBox(varIncome);
        income_combobox.setBounds(400,240,300,30);
        income_combobox.setBackground(Color.WHITE);
        add(income_combobox);


        JLabel education_label = new JLabel("Educational: ");
        education_label.setFont(new Font("Railway", Font.BOLD, 20));
        education_label.setBounds(100, 290, 200, 30);
        add(education_label);

        JLabel qualification_label = new JLabel("Qualification: ");
        qualification_label.setFont(new Font("Railway", Font.BOLD, 20));
        qualification_label.setBounds(100, 320, 200, 30);
        add(qualification_label);

        String []varEducationQualification={"BELOW 10TH","10TH","10+2","UG","PG","DOCTORATE"};
        educationqualification_combobox = new JComboBox(varEducationQualification);
        educationqualification_combobox.setBounds(400,310,300,30);
        educationqualification_combobox.setBackground(Color.WHITE);
        add(educationqualification_combobox);

        JLabel occupation_label = new JLabel("Occupation: ");
        occupation_label.setFont(new Font("Railway", Font.BOLD, 20));
        occupation_label.setBounds(100, 370, 200, 30);
        add(occupation_label);

        String []varOccupation={"Salaried","Self-Employed","Business","Student","Retired"};
        Occupation_combobox = new JComboBox(varOccupation);
        Occupation_combobox.setBounds(400,370,300,30);
        Occupation_combobox.setBackground(Color.WHITE);
        add(Occupation_combobox);

        JLabel panno_label = new JLabel("PAN No: ");
        panno_label.setFont(new Font("Railway", Font.BOLD, 20));
        panno_label.setBounds(100, 420, 200, 30);
        add(panno_label);

        panno_textField = new JTextField();
        panno_textField.setFont(new Font("Railway", Font.BOLD, 14));
        panno_textField.setBounds(400, 420, 300, 30);
        add(panno_textField);

        JLabel aadharno_label = new JLabel("AADHAR No: ");
        aadharno_label.setFont(new Font("Railway", Font.BOLD, 20));
        aadharno_label.setBounds(100, 470, 200, 30);
        add(aadharno_label);

        aadharno_textField = new JTextField();
        aadharno_textField.setFont(new Font("Railway", Font.BOLD, 14));
        aadharno_textField.setBounds(400, 470, 300, 30);
        add(aadharno_textField);

        JLabel seniorcitizen_label = new JLabel("SENIOR CITIZEN: ");
        seniorcitizen_label.setFont(new Font("Railway", Font.BOLD, 20));
        seniorcitizen_label.setBounds(100, 520, 200, 30);
        add(seniorcitizen_label);

        scyes = new JRadioButton("YES");
        scyes.setBounds(400,520,90,30);
        scyes.setBackground(Color.WHITE);
        add(scyes);

        scno = new JRadioButton("NO");
        scno.setBounds(500,520,120,30);
        scno.setBackground(Color.WHITE);
        add(scno);

        ButtonGroup seniorcitizengroup = new ButtonGroup();
        seniorcitizengroup.add(scyes);
        seniorcitizengroup.add(scno);

        JLabel existingaccount_label = new JLabel("EXISTING ACCOUNT: ");
        existingaccount_label.setFont(new Font("Railway", Font.BOLD, 20));
        existingaccount_label.setBounds(100, 570, 400, 30);
        add(existingaccount_label);

        eayes = new JRadioButton("YES");
        eayes.setBounds(400,570,90,30);
        eayes.setBackground(Color.WHITE);
        add(eayes);

        eano = new JRadioButton("NO");
        eano.setBounds(500,570,120,30);
        eano.setBackground(Color.WHITE);
        add(eano);

        ButtonGroup existingaccountgroup = new ButtonGroup();
        existingaccountgroup.add(eayes);
        existingaccountgroup.add(eano);



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
    public void actionPerformed(ActionEvent ae){
//        String formno = ;
        String religion =(String) religion_combobox.getSelectedItem();
        String category = (String) category_combobox.getSelectedItem();
        String income = (String) income_combobox.getSelectedItem();
        String education = (String) educationqualification_combobox.getSelectedItem();
        String occupation = (String) Occupation_combobox.getSelectedItem();
        String panno=panno_textField.getText();
        String aadharno = aadharno_textField.getText();
        String seniorcitizen = null;
        if(scyes.isSelected()){
            seniorcitizen="YES";
        }else if(scno.isSelected()){
            seniorcitizen="NO";
        }
        String existingaccount = null;
        if(eayes.isSelected()){
            existingaccount="YES";
        }else if(eano.isSelected()){
            existingaccount="NO";
        }
        try {
            if (panno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pan No. is Required");
            } else if(aadharno.isEmpty()){
                JOptionPane.showMessageDialog(null, "Aadhar No. is Required");
            }
            else {
                Conn c = new Conn();
                String querry = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + panno + "','" + aadharno + "','" + seniorcitizen + "','" + existingaccount + "')";
                c.s.executeUpdate(querry);
                c.s.close();
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
