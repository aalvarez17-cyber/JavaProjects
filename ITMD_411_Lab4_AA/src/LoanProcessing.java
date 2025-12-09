import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoanProcessing extends BankRecords{
    public static void main(String[] args) {
        BankRecords br = new BankRecords();
        br.readData();
        br.processData();

        Dao dao = new Dao();
        dao.createTable();
        dao.insertRecords(robjs); //Inserts bank records

        // Create heading for display
        System.out.printf("%-20s %-20s %-20s %n", "ID:", "INCOME:", "PEP:");
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection connection = null;
        
        

        // Extract data from result set
        try {
            rs = dao.retrieveRecords(); //Fill result set object
                while (rs.next()) {
                    // Retrieve data by column name (i.e., for id,income,pep)
                    String id = rs.getString(2);
                    double income = rs.getDouble(3);
                    String pep = rs.getString(4);
                                        
                    // Display values for id,income,pep
                    System.out.printf("%-20s %-20s %-20s %n", id, income, pep);
                }
        } 

        catch (SQLException se) {
            se.printStackTrace(); 
        }

        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (connection != null) connection.close(); } catch (Exception e) {}
        }
    }
        
}
