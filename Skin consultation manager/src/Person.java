public class Person  {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobilNo;

    public Person() {

    }

    public Person(String name1, String surname1, String dateOfBirth1, String mobilNo1) {
        name = name1;
        surname = surname1;
        dateOfBirth = dateOfBirth1;
        mobilNo = mobilNo1;
    }

    //Getter for name
    public String getName(){
        return name;
    }

    //Getter for surname
    public String getSurname(){
        return surname;
    }

    //Getter for Date Of Birth
    public String getDateOfBirth(){
        return dateOfBirth;
    }

    //Getter for mobile number
    public String getMobilNo(){
        return mobilNo;
    }

    //Setter for Name
    public void setName(String name1){
        this.name = name1;
    }

    //Setter for surname
    public void setSurname(String surname1){
        this.surname = surname1;
    }

    //Setter for Date Of Birth
    public void setDateOfBirth(String dateOfBirth1){
        this.dateOfBirth = dateOfBirth1;
    }

    //Setter for mobile number
    public void setMobilNo(String mobilNo1){
        this.mobilNo = mobilNo1;
    }

}

