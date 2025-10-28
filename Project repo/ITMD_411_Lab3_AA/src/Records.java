import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


public class Records extends BankRecords{
    static FileWriter fw = null;

	public Records() {
		try {
			fw = new FileWriter("bankrecords.txt");
		} 
        
        catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) throws Exception {
        //Creates new bank record
        BankRecords record = new BankRecords();

        
        //Reads, processes, and prints data
        record.readData();
        record.processData();
        record.printData();

        System.out.println("");

        Records br = new Records();
		br.readData();

		//Call functions
		AvgComp();
        FemaleAccountInfo();
        MaleCarAndChildByRegion();

		try {
			fw.close();
		} 
        
        catch (IOException e) {
			e.printStackTrace();
		}

        System.out.println("");

        //Provides the current time and student name
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Alexis Alvarez\n");
	}

    //Methods for Data Analysis
    private static void AvgComp() {
        
        //Sorts Sex in array
        Arrays.sort(robjs, new SexComparator()); 

        int maleCt = 0, femCt = 0;
        double maleInc = 0, femInc = 0;
        
        for (BankRecords robj : robjs) {
            if (robj.getSex().equals("FEMALE")) {
                femInc += robj.getIncome();
                femCt++;
            } 
            else if(robj.getSex().equals("MALE")) {
                maleInc += robj.getIncome();
                maleCt++;
            }
        }
			 
		//Displays resulting averages to console and to file
		double avgFemInc = femInc/femCt;
        double avgMaleInc = maleInc/maleCt;

        System.out.println("Data Analytic Results:");
        System.out.println("");
        System.out.printf("Average income for Females: $%.2f", (avgFemInc));
        System.out.println("");
        System.out.printf("Average income for Males: $%.2f", (avgMaleInc));
        System.out.println("");



		try {
            fw.write("Average income for Females: $" + String.format("%.2f", avgFemInc) + "\n");
            fw.write("Average income for Males: $" + String.format("%.2f", avgMaleInc) +  "\n");
            fw.write("\n");
		} 

		catch (IOException e) {
			e.printStackTrace();
		}
	}

    //Method which gives female account information
    private static void FemaleAccountInfo(){
        int femCt = 0;

        for (BankRecords robj : robjs) {
            if (robj.getSex().equals("FEMALE") && robj.getMortgage().equals("YES") && robj.getSave_act().equals("YES")) {
                femCt++;
            } 
        }

        System.out.println("");
        System.out.println("Number of Females with a Mortgage and Savings Account: " + femCt + "\n");

        try {
            fw.write("Number of Females with a Mortgage and Savings Account: " + femCt + "\n");
            fw.write("\n");

		} 

		catch (IOException e) {
			e.printStackTrace();
		}
    }

    //Method to provide Males with a child and car by region
    private static void MaleCarAndChildByRegion(){
        Arrays.sort(robjs, new LocationComparator());

        int maleCity = 0;
        int maleTown = 0;
        int maleRural = 0;
        int maleSuburban = 0;

        for (BankRecords robj : robjs) {
            if (robj.getSex().equals("MALE") && robj.getRegion().equals("INNER_CITY")  && robj.getChildren() == 1 && robj.getCar().equals("YES")) {
                maleCity++;
            } 

            if (robj.getSex().equals("MALE") && robj.getRegion().equals("TOWN")  && robj.getChildren() == 1 && robj.getCar().equals("YES")) {
                maleTown++;
            }

            if (robj.getSex().equals("MALE") && robj.getRegion().equals("RURAL")  && robj.getChildren() == 1 && robj.getCar().equals("YES")) {
                maleRural++;
            }

            if (robj.getSex().equals("MALE") && robj.getRegion().equals("SUBURBAN")  && robj.getChildren() == 1 && robj.getCar().equals("YES")) {
                maleSuburban++;
            }
        }

        System.out.println("Innercity Region Males with 1 car & child: " + maleCity);
        System.out.println("Rural Region Males with 1 car & child: " + maleRural);
        System.out.println("Suburban Region Males with 1 car & child: " + maleSuburban);
        System.out.println("Town Region Males with 1 car & child: " + maleTown);

        try {
            fw.write("Innercity Region Males with 1 car & child: " + maleCity + "\n");
            fw.write("Rural Region Males with 1 car & child:" + maleRural + "\n");
            fw.write("Suburban Region Males with 1 car & child:" + maleSuburban + "\n");
            fw.write("Town Region Males with 1 car & child:" + maleTown + "\n");

		} 

		catch(IOException e) {
			e.printStackTrace();
		}
    }
}



