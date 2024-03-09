import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();
        String button;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Add a Doctor                       :A or a");
            System.out.println("Delete a Doctor                    :D or d");
            System.out.println("Print the list of the doctors      :P or p");
            System.out.println("Save information to a file         :S or s");
            System.out.println("load information                   :L or l");
            System.out.println("Open GUI                           :G or g");
            System.out.println("Exit                               :X or x");
            System.out.println("-------------------------------------------");
            System.out.print("Enter : ");

            button = input.next();
            System.out.println();
            if (button.equalsIgnoreCase("A")) {
                consultationManager.addDoctor();

            } else if (button.equalsIgnoreCase("D")) {
                consultationManager.deleteDoctor();

            } else if (button.equalsIgnoreCase("P")) {
                consultationManager.printTheListOfDoctors();

            } else if (button.equalsIgnoreCase("S")) {
                consultationManager.saveInToFile();

            } else if (button.equalsIgnoreCase("L")) {
                consultationManager.readBackTheFile();

            } else if (button.equalsIgnoreCase("G")) {
                consultationManager.openGUI();

            } else if (button.equalsIgnoreCase("X")) {
                System.out.println("Thank you!");
                break;
            }
        }
    }
}


