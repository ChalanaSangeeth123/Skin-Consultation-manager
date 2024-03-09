import java.time.LocalDate;

public class Consultation {
    private LocalDate date;
    private String notes;
    private String timeslot;
    private String cost;
    private String licenceNo;
    private String patientId;

    public Consultation(LocalDate date, String notes, String timeslot, String cost, String licenceNo, String patientId) {
        this.date = date;
        this.notes = notes;
        this.timeslot = timeslot;
        this.cost = cost;
        this.licenceNo = licenceNo;
        this.patientId = patientId;
    }

    //getter for date
    public LocalDate getDate() {
        return date;
    }

    //getter for Notes
    public String getNotes() {
        return notes;
    }

    //getter for time
    public String getTimeslot() {
        return timeslot;
    }

    //getter for Cost
    public String getCost() {
        return cost;
    }

    //Getter for licence Number
    public String getLicenceNo() {
        return licenceNo;
    }


    //Getter for PatientId
    public String getPatientId() {
        return patientId;
    }

    //setter for set date
    public void setDate() {
        this.date = date;
    }

    //setter for set Notes
    public void setNotes() {
        this.notes = notes;
    }

    //setter for set Time
    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    //setter for set cost
    public void setCost() {
        this.cost = cost;
    }

    //Setter for licence no
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    //Setter for PatientId
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}





