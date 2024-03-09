public class Patient extends Person{
    public String patientId;
    public String gender;

    public Patient(String name, String surname, String dateOfBirth, String mobileNo, String gender1, String patientId1) {
        super(name, surname, dateOfBirth, mobileNo);
        patientId = patientId1;
        gender = gender1;
    }

    //Getter for PatientId
    public String getPatientId(){
        return patientId;
    }

    //Getter for gender
    public String getGender(){
        return gender;
    }

    //Setter for PatientId
    public void setPatientId(String patientId1){
        this.patientId = patientId1;
    }

    //Setter for gender
    public void setGender(String gender1){
        this.gender = gender1;
    }

    public String toString(){
        return super.toString() + "\n" + this.patientId + "\n" + this.gender;
    }
}


