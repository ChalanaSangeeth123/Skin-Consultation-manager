public interface SkinConsultationManager {
    void addDoctor();
    void deleteDoctor();
    void printTheListOfDoctors();
    void saveInToFile() ;
    void readBackTheFile();
    void openGUI();
    void getTable();
    void getDoctorInformation(String licenceNo);
}

