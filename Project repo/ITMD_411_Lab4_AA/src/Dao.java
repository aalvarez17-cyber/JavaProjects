import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao extends BankRecords {
    //Declare DB objects 
    DBConnect conn = null;

	// Constructor for Data Access Object (Dao)
	public Dao() { //Create database object instance
	 conn = new DBConnect();
    }

    public void createTable() {
        Connection connection = null;
        Statement stmt = null;

        try {
            // Open a connection
            System.out.println("Connecting to a selected database to create Table...");
            System.out.println("Connected database successfully...");

            //Execute create query
            System.out.println("Creating table in given database...");

            connection = conn.connect();
            stmt = connection.createStatement();

            String sql = "CREATE TABLE al_alv_tab" + 
                        "(pid INTEGER not NULL AUTO_INCREMENT, " +
                        " id VARCHAR(10), " +
                        " income numeric(8,2), " + 
                        " pep VARCHAR(4), " + 
                        " PRIMARY KEY ( pid ))";
                            
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } 
        
        catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

        finally{
            //Closes statment
            if (stmt != null){
                try {
                    stmt.close();
                } 

                catch (SQLException se) {
                    se.printStackTrace();
                }
            }

            //Closes connection 
            if (connection != null){
                try {
                    connection.close();
                } 
                catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }


    public void insertRecords(BankRecords[] robjs) {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            // Execute a query
            System.out.println("Inserting records into the table...");

            //Avoids having malicous input from being interpreted as commands
            String sql = "INSERT INTO al_alv_tab(id, income, pep) VALUES (?, ?, ?)";
            connection = conn.connect();
            prepStmt = connection.prepareStatement(sql);

            
            // Include all object data to the database table
            for (int i = 0; i < robjs.length; ++i) {
                //Get id, income, and pep data from records
                String id = robjs[i].getId();
                double income = robjs[i].getIncome(); 
                String pep = robjs[i].getPep();
                
                prepStmt.setString(1, id);
                prepStmt.setDouble(2, income);
                prepStmt.setString(3, pep);
                prepStmt.executeUpdate();
            }
        } 

        catch (SQLException se){ 
            se.printStackTrace(); 
        }

        finally{
            //Closes statment
            if (prepStmt != null){
                try {
                    prepStmt.close();
                } 

                catch (SQLException se) {
                    se.printStackTrace();
                }
            }

            //Closes connection 
            if (connection != null){
                try {
                    connection.close();
                } 
                catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public ResultSet retrieveRecords() throws SQLException{
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            connection = conn.connect();
            //Selects all collumns while limiting them to only 50
            //Pep column is order by descending order
            String sql = "SELECT * FROM al_alv_tab ORDER BY pep DESC LIMIT 10";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        } 
        
        catch (SQLException se) {
            se.printStackTrace();
            return null; 
        }
    }
}
    
