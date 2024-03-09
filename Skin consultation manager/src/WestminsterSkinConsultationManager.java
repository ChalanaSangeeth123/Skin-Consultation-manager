import java.io.*;
import java.util.*;
public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static final Doctor[] doctors = new Doctor[10]; //Doctor
    ArrayList<Doctor> array_list = new ArrayList<>(10);
    private int addedDoctorCount = 0;
    boolean isLicenceNoExist = false;
    Scanner input = new Scanner(System.in);

    // method for adding doctors
    @Override
    public void addDoctor() {
        System.out.println("Add Doctors to the list");
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.print("Enter the licence number Of the Doctor: ");
        String licenceNo = input.next();
        try {
            for (Doctor doctor : doctors) {
                if (doctor != null)// checking whether doctor array is not null
                {
                    if (Objects.equals(doctor.getLicenceNo(), licenceNo)) //checking whether licence number we added exists
                    {
                        isLicenceNoExist = true; //making isLicenceNoExist to true
                        break;
                    }
                }
            }
            if (isLicenceNoExist) {
                System.out.println();
                System.out.println("This Doctor is already in the list!"); // if the added licence No exist print
                isLicenceNoExist = false;
            } else {
                getDoctorInformation(licenceNo);
                addedDoctorCount += 1;
            }
        }catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println("Maximum Number of doctors have been added!");
        }
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
    }


    // method for delete doctors
    @Override
    public void deleteDoctor() {
        System.out.println("Delete Doctors from the list");
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.print("Enter the licence number Of the Doctor: ");
        String licenceNo = input.next();
        try {
            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i] != null)// checking whether doctor array is not null
                {
                    if (Objects.equals(doctors[i].getLicenceNo(), licenceNo)) //checking whether licence number we added exists
                    {
                        System.out.println();
                        System.out.println("Doctor " + doctors[i].getName() + " " + doctors[i].getSurname() + " Have been deleted from the list");
                        System.out.println();
                        doctors[i] = null; //removing the doctor object
                        doctors[i] = doctors[addedDoctorCount - 1];// swapping the null doctor object with the last doctor object added
                        doctors[addedDoctorCount - 1] = null;
                        addedDoctorCount--;
                        break;
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println("Error occurred");
        }
        array_list.removeIf(d -> licenceNo.equalsIgnoreCase(d.getLicenceNo()));
        System.out.println("-------------------------------------------------");
        System.out.println();
    }


    public  void printTheListOfDoctors(){
        System.out.println("Printing a list of doctors");
        System.out.println("---------------------------------------------------");
        System.out.println();
        try {
            for (int i = 0; i < addedDoctorCount; i++) {
                if (doctors[i] != null){ // checking whether doctor array is not null
                    for (int j = i + 1; j <= addedDoctorCount; j++) {
                        if (doctors[j] != null) {
                            if (doctors[i].getSurname().compareTo(doctors[j].getSurname()) > 0) {
                                Doctor temp = doctors[i];
                                doctors[i] = doctors[j];
                                doctors[j] = temp;

                            }
                        }
                    }
                    System.out.println("Doctor's name is " + doctors[i].getName());
                    System.out.println("Doctor's Surname is " + doctors[i].getSurname());
                    System.out.println("Doctor's Date of birth is " + doctors[i].getDateOfBirth());
                    System.out.println("Doctor's mobile number is " + doctors[i].getMobilNo());
                    System.out.println("Doctor's licence number is " + doctors[i].getLicenceNo());
                    System.out.println("Doctor's specialization is " + doctors[i].getSpecialisation());
                    System.out.println();
                }
            }
        }catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println("Error occurred");
        }
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    // Save data into a array
    public void saveInToFile() {
        System.out.println("Save program data to a file");
        System.out.println("-----------------------------------------------");
        try {
            FileWriter writer = new FileWriter("DoctorFile.txt");
            for (Doctor value : doctors) {
                if (value != null) {
                    writer.write(value.getSurname() + "  ");
                    writer.write(value.getName() + "  ");
                    writer.write(value.getDateOfBirth() + "  ");
                    writer.write(value.getMobilNo() + "  ");
                    writer.write(value.getLicenceNo() + "  ");
                    writer.write(value.getSpecialisation() + " ");
                    writer.write("\r\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Data have been stored in to a file Successfylly!");
        System.out.println();
        System.out.println("-------------------------------------------");
    }


    //Loading file data into the array
    @Override
    public void readBackTheFile() {
        System.out.println("Load program data from file");
        System.out.println("--------------------------------------------");
        //adding data to the array
        try {
            File myObj = new File("DoctorFile.txt");
            Scanner myReader = new Scanner(myObj);
            addedDoctorCount = 0;
            while (myReader.hasNextLine()) {
                Doctor doctor = new Doctor();
                String data = myReader.nextLine();// read line by line. One line include all data of one doctor.
                String[] parts = data.split("_");//split data parts by underscore. Data belong to one doctor.
                doctor.setSurname(parts[0]);
                doctor.setName(parts[1]);
                doctor.setDateOfBirth(parts[2]);
                doctor.setMobilNo(parts[3]);
                doctor.setLicenceNo(parts[4]);
                doctor.setSpecialisation(parts[5]);
                doctors[addedDoctorCount] = doctor;//doctor objects are added to the doctor array
                addedDoctorCount++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //adding data to the arraylist
        try {
            File myObj = new File("DoctorFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Doctor doctor = new Doctor();
                String data = myReader.nextLine();// read line by line. One line include all data of one doctor.
                String[] parts = data.split("_");//split data parts by underscore. Data belong to one doctor.
                doctor.setSurname(parts[0]);
                doctor.setName(parts[1]);
                doctor.setDateOfBirth( parts[2]);
                doctor.setMobilNo(parts[3]);
                doctor.setLicenceNo(parts[4]);
                doctor.setSpecialisation(parts[5]);
                array_list.add(doctor) ;//doctor objects are added to the doctor array
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Successfully loaded data!");
        System.out.println();
        System.out.println("----------------------------------------------");
    }


    @Override
    public void openGUI() {
        getTable();
    }

    @Override
    public void getTable() {
        DoctorTable d1 = new DoctorTable(array_list);
        d1.setVisible(true);
    }


    // Doctor information retriever
    public void getDoctorInformation(String licenceNo)
    {
        Doctor doctor = new Doctor();
        doctor.setLicenceNo(licenceNo);

        System.out.print("Enter the Name Of the Doctor: ");
        String name = input.next();
        doctor.setName(name);

        System.out.print("Enter the surName Of the Doctor: ");
        String surname = input.next();
        doctor.setSurname(surname);

        System.out.print("Enter the date of birth Of the Doctor: ");
        String dateOfBirth = input.next();
        doctor.setDateOfBirth(dateOfBirth);

        System.out.print("Enter the mobile number Of the Doctor: ");
        String mobileNo = input.next();
        doctor.setMobilNo(mobileNo);

        System.out.print("Enter the specialization Of the Doctor: ");
        String specialization = input.next();
        doctor.setSpecialisation(specialization);

        doctors[addedDoctorCount] = doctor;
        array_list.add(new Doctor(name, surname, dateOfBirth, mobileNo, licenceNo, specialization));
    }
}



