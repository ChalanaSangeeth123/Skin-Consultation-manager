import java.io.Serializable;
public class Doctor extends Person implements Serializable {
    private String licenceNo;
    private String specialisation;

    public Doctor(){

    }

    public Doctor(String name, String surname, String dateOfBirth, String mobileNo, String licenceNo1, String specialisation1) {
        super(name, surname, dateOfBirth, mobileNo);
        licenceNo = licenceNo1;
        specialisation = specialisation1;
    }

    //Getter for licence Number
    public String getLicenceNo() {
        return licenceNo;
    }

    //Getter for specialisation
    public String getSpecialisation() {
        return specialisation;
    }

    //Setter for specialisation
    public void setLicenceNo(String licenceNo1) {
        this.licenceNo = licenceNo1;
    }

    //Setter for specialisation
    public void setSpecialisation(String specialisation1) {
        this.specialisation = specialisation1;
    }


}
