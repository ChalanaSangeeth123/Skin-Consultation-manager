import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class DoctorTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Name","Surname", "Date of Birth","Mobile Number","License Number","Specialisation"};
    private final ArrayList<Doctor> doctors;

    public  DoctorTableModel(ArrayList<Doctor> docList){
        doctors = docList;
    }

    public Class<?> getColumnClass(int columnIndex) {
        if (doctors.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
    @Override
    public int getRowCount() {
        return doctors.size();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object cell = null;
        if (columnIndex == 0){
            cell = doctors.get(rowIndex).getName();
        } else if (columnIndex == 1) {
            cell = doctors.get(rowIndex).getSurname();

        } else if (columnIndex == 2) {
            cell = doctors.get(rowIndex).getDateOfBirth();

        } else if (columnIndex == 3) {
            cell = doctors.get(rowIndex).getMobilNo();

        } else if (columnIndex == 4){
            cell = doctors.get(rowIndex).getLicenceNo();

        } else if(columnIndex == 5) {
            cell = doctors.get(rowIndex).getSpecialisation();

        }
        return cell;

    }

    public String getColumnName(int col){
        return columnNames[col];
    }
}


