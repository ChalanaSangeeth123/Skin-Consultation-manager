import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class DoctorTable extends JFrame implements ActionListener {
    JTable DoctorTable;
    DoctorTableModel tableModel;
    JComboBox comboBox;
    JLabel t1;
    JLabel t2;
    JLabel date;
    JLabel timeslot;
    JTextField co1;
    JTextField co2;
    JLabel notes;
    JTextArea tNotes;
    final String secretKey = "secrete";
    JButton btn1; //check button
    JButton btn2; //submit button
    String licNo;
    ArrayList<Consultation> consultations = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    public DoctorTable(ArrayList<Doctor> doc) {
        this.tableModel = new DoctorTableModel(doc);
        this.doctors = doc;
        DoctorTable = new JTable(tableModel);

        setTitle("Patient Appointment System ");
        setLayout(new FlowLayout());

        setBounds(40, 40, 1500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DoctorTable.setAutoCreateRowSorter(true);
        DoctorTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        JScrollPane scrollPane = new JScrollPane(DoctorTable);
        scrollPane.setPreferredSize(new Dimension(1380, 300));
        DoctorTable.setBackground(Color.LIGHT_GRAY);

        JPanel p1 = new JPanel();
        p1.add(scrollPane);
        add(p1, BorderLayout.CENTER);

        //label for doctor selection
        t1 = new JLabel(" Select the Doctors' license no: ");
        t1.setFont(new Font("Arial", Font.PLAIN, 15));
        t1.setBackground(Color.LIGHT_GRAY);

        Iterator<Doctor> i = doc.iterator();
        ArrayList<String> names = new ArrayList<>();
        while (i.hasNext()) {
            Doctor d = i.next();
            names.add(d.getLicenceNo());
        }

        String[] name1 = names.toArray(new String[0]);
        comboBox = new JComboBox(name1);
        comboBox.addActionListener(this);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 15));

        //label for date
        date = new JLabel("Appointment date (YYYY-MM-DD): ");
        date.setFont(new Font("Arial", Font.PLAIN, 15));

        co1 = new JTextField();
        co1.setColumns(12);
        co1.setFont(new Font("Arial", Font.PLAIN, 15));
        co1.setForeground(Color.BLACK);
        co1.addActionListener(this);

        //label for time slot
        timeslot = new JLabel("Appointment Time (0000-2400): ");
        timeslot.setFont(new Font("Arial", Font.PLAIN, 15));

        co2 = new JTextField();
        co2.setColumns(12);
        co2.setFont(new Font("Arial", Font.PLAIN, 15));
        co2.setForeground(Color.BLACK);
        co2.addActionListener(this);

        //Notes
        notes = new JLabel("Notes: ");
        notes.setFont(new Font("Arial", Font.PLAIN, 15));

        tNotes = new JTextArea();
        tNotes.setColumns(20);
        tNotes.setFont(new Font("Arial", Font.PLAIN, 15));
        tNotes.setForeground(Color.BLACK);
        tNotes.setLineWrap(true);

        //Check button
        btn1 = new JButton("Check");
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        btn1.setFocusable(false);
        btn1.setForeground(Color.BLACK);
        btn1.setBorder(BorderFactory.createEtchedBorder());
        btn1.addActionListener(this);
        btn1.setEnabled(true);

        //Submit button
        btn2 = new JButton("Next");
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        btn2.setFocusable(false);
        btn2.setForeground(Color.BLACK);
        btn2.setBorder(BorderFactory.createEtchedBorder());
        btn2.addActionListener(this);
        btn2.setEnabled(false);

        t2 = new JLabel();
        t2.setFont(new Font("Arial", Font.PLAIN, 15));

        JPanel p2 = new JPanel();
        p2.add(t1);
        p2.add(comboBox);
        p2.add(date);
        p2.add(co1);
        p2.add(timeslot);
        p2.add(co2);
        add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel();
        p3.add(t2);
        p3.add(notes);
        p3.add(tNotes);
        p3.add(btn1);
        p3.add(btn2);
        add(p3, BorderLayout.CENTER);

        JPanel p4 = new JPanel();
        p4.add(t2);
        add(p4, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate bookDate = LocalDate.parse(co1.getText());
        ;
        String notes = tNotes.getText();
        String bookTime = co2.getText();
        int index = 0;
        boolean isRandomNumGenerated = false;
        String tempLicNum = (String) comboBox.getSelectedItem();

        if (e.getSource() == btn1) {
            consultations = MyFrame.consultations;
            if (consultations.isEmpty()) {
                licNo = (String) comboBox.getSelectedItem();
                t2.setText("Doctor is Available");
            } else {
                for (int i = 0; i < consultations.size(); i++) {
                    if (bookDate.equals(consultations.get(i).getDate()) && co2.getText().equals(consultations.get(i).getTimeslot()) && tempLicNum.equals(consultations.get(i).getLicenceNo())) {
                        index = (int) (Math.random() * doctors.size());
                        isRandomNumGenerated = true;
                        tempLicNum = doctors.get(index).getLicenceNo();
                        i = -1;
                    }
                }
                if (isRandomNumGenerated) {
                    t2.setText(doctors.get(index).getName() + " " + doctors.get(index).getSurname() + "(" + doctors.get(index).getLicenceNo() + ")" + "doctor is available at the submitted specific date and time");
                    licNo = doctors.get(index).getLicenceNo();
                } else {
                    licNo = (String) comboBox.getSelectedItem();
                    t2.setText("Doctor is Available");
                }
            }
            btn2.setEnabled(true);//making submit button enable
        } else if (e.getSource() == btn2) {//when submit button pressed
            MyFrame mf = new MyFrame(bookDate, notes, bookTime, licNo);
            mf.setVisible(true);
            this.setVisible(false);
            EncryptionDecryptionData aesEncryptionDecryption = new EncryptionDecryptionData();
            String encryptedString = aesEncryptionDecryption.encrypt(notes, secretKey);
            String decryptedString = aesEncryptionDecryption.decrypt(encryptedString, secretKey);
        }

    }

}