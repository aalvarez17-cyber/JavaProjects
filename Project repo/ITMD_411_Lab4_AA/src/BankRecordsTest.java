import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BankRecordsTest{
    public static void main(String[] args) throws Exception {
        //Creates new bank record
        BankRecords record = new BankRecords();

        
        //Reads, processes, and prints data
        record.readData();
        record.processData();
        record.printData();

        System.out.println("");


        //Provides the current time and student name
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Alexis Alvarez\n");
    }
}
