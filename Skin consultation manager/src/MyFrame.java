import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
class MyFrame extends JFrame implements ActionListener { //https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/
    // Components of the Form
    private final LocalDate date1;
    private final String notes;
    private final String time;
    private final String licenceNo;
    private final JLabel title;
    private final JTextField tName;
    private final JTextField tSurName;
    private final JTextField tMobileNo;
    private final JRadioButton male;
    private final JRadioButton female;
    private final JComboBox date;
    private final JComboBox month;
    private final JComboBox year;
    private final JLabel tPatientsId;
    private final JCheckBox term;
    private final JButton sub;
    private final JButton resetButton;
    private final JTextArea tout;
    private final JLabel res;
    private final JTextArea resAdd;
    static ArrayList<Consultation> consultations = new ArrayList<Consultation>();
    static ArrayList <Patient> patients = new ArrayList<>();


    // constructor, to initialize the components
    // with default values.
    public MyFrame(LocalDate date1, String notes, String time, String licenceNo)
    {
        this.date1 = date1;
        this.notes = notes;
        this.time = time;
        this.licenceNo = licenceNo;


        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Patient details Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 16));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tName = new JTextField();
        tName.setFont(new Font("Arial", Font.PLAIN, 15));
        tName.setSize(190, 20);
        tName.setLocation(200, 100);
        c.add(tName);

        JLabel surName = new JLabel("Surname");
        surName.setFont(new Font("Arial", Font.PLAIN, 16));
        surName.setSize(100, 20);
        surName.setLocation(100, 150);
        c.add(surName);

        tSurName = new JTextField();
        tSurName.setFont(new Font("Arial", Font.PLAIN, 15));
        tSurName.setSize(190, 20);
        tSurName.setLocation(200, 150);
        c.add(tSurName);

        JLabel mobileNo = new JLabel("Mobile No");
        mobileNo.setFont(new Font("Arial", Font.PLAIN, 16));
        mobileNo.setSize(100, 20);
        mobileNo.setLocation(100, 200);
        c.add(mobileNo);

        tMobileNo = new JTextField();
        tMobileNo.setFont(new Font("Arial", Font.PLAIN, 15));
        tMobileNo.setSize(190, 20);
        tMobileNo.setLocation(200, 200);
        c.add(tMobileNo);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 16));
        gender.setSize(100, 20);
        gender.setLocation(100, 250);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 250);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 250);
        c.add(female);

        ButtonGroup genGp = new ButtonGroup();
        genGp.add(male);
        genGp.add(female);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setFont(new Font("Arial", Font.PLAIN, 16));
        dob.setSize(100, 20);
        dob.setLocation(100, 300);
        c.add(dob);

        String[] dates = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 300);
        c.add(date);

        String[] months = {"Jan", "feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sup", "Oct", "Nov", "Dec"};
        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(270, 300);
        c.add(month);

        String[] years = {"1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019"};
        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(340, 300);
        c.add(year);

        JLabel patientsId = new JLabel("Patient Id");
        patientsId.setFont(new Font("Arial", Font.PLAIN, 16));
        patientsId.setSize(100, 20);
        patientsId.setLocation(100, 350);
        c.add(patientsId);


        tPatientsId = new JLabel();
        tPatientsId.setFont(new Font("Arial", Font.PLAIN, 15));
        tPatientsId.setSize(110, 20);
        tPatientsId.setLocation(200, 350);
        c.add(tPatientsId);


        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(270, 450);
        resetButton.addActionListener(this);
        c.add(resetButton);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resAdd = new JTextArea();
        resAdd.setFont(new Font("Arial", Font.PLAIN, 15));
        resAdd.setSize(200, 75);
        resAdd.setLocation(580, 175);
        resAdd.setLineWrap(true);
        c.add(resAdd);

        setVisible(true);
    }


    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String name = tName.getText();
        String surName = tSurName.getText();
        String mobileNo = tMobileNo.getText();
        String gender;
        String dateOfBirth = year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + date.getSelectedItem();
        String patientId = "";
        String cost = "";
        String data1;
        try {
            if (patients.isEmpty()) {
                patientId = "001";
                tPatientsId.setText(patientId);
                cost = "15€";
                consultations.add(new Consultation(date1, notes, time, cost , licenceNo, patientId));
            } else {
                boolean patientExist = false;
                for (Patient patient : patients) {
                    if ((tName.getText() + " " + tSurName.getText()).equalsIgnoreCase(patient.getName() + " " + patient.getSurname())) {
                        patientId = patient.getPatientId();
                        tPatientsId.setText(patientId);
                        patientExist = true;
                        cost = "25€";
                        consultations.add(new Consultation(date1, notes, time, cost, licenceNo, patientId));
                        break;
                    }
                }
                if (!patientExist) {//if patientExist false it will be true
                    for (int i = 0; i < patients.size(); i++) {
                        for (int x = i + 1; x < patients.size(); x++) {
                            if (Integer.parseInt(patients.get(i).getPatientId()) <= Integer.parseInt(patients.get(x).getPatientId())) {
                                int no1 = Integer.parseInt(patients.get(x).getPatientId()) + 1;
                                patientId = "00" + no1;
                            }
                            else{
                                int no1 =  Integer.parseInt(patients.get(i).getPatientId()) + 1;
                                patientId = "00" + no1;
                            }
                        }
                    }
                    tPatientsId.setText(patientId);
                    cost = "15€";
                    consultations.add(new Consultation(date1, notes, time, cost, licenceNo, patientId));
                }
            }
        }catch (IndexOutOfBoundsException ignored) {
            System.out.println("Error occurred");
        }

        if (male.isSelected()) {
            gender = male.getText();
            data1 = "3. " + "Gender : Male" + "\n";
        }
        else {
            gender = female.getText();
            data1 = "3. " + "Gender : Female" + "\n";
        }
        patients.add(new Patient(name, surName, dateOfBirth, mobileNo, gender, patientId));

        //submit button
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data
                        = "1. " + "Name : "
                        + tName.getText() + " " + tSurName.getText() + "\n"
                        + "2. " + "Mobile : "
                        + tMobileNo.getText() + "\n";

                String data2 = "4. " + "Date Of Birth : " + dateOfBirth + "\n";
                String data3 = "5. " + "Patient Id : " + patientId + "\n";
                String data4 = "6. " + "Consultation Date: " + date1 + "\n" + "7. " + "Consultation Time: " + time + "\n" + "8. " + "Consultation Cost: "
                        + cost + "\n" + "9. " + "Doctor's licence No: " + licenceNo + "\n";
                String data5 = "10. " + "Notes: " + notes;

                tout.setText(data + data1 + data2 + data3 + data4 + data5);

                tout.setEditable(false);
                res.setText(" Appointment Added Successfully ");
            }
            else {
                tout.setText("");
                resAdd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }
        else if (e.getSource() == resetButton) {
            String def = "";
            tName.setText(def);
            tSurName.setText(def);
            title.setText(def);
            tMobileNo.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resAdd.setText(def);
        }
    }
}


