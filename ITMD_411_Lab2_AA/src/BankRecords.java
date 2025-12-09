import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRecords extends Client {
    //Arrays to hold bank records
    static BankRecords robjs[] = new BankRecords[600];
    static ArrayList<List<String>> array = new ArrayList<>();

    //Bank Record Attribute
    private String id;

    private int age;

    private String sex;

    private String region;

    private double income;

    private String married;

    private int children;

    private String car;

    private String save_act;
    
    private String current_act;

    private String mortgage;

    private String pep;

    //Bank record getters
    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getRegion() {
        return region;
    }

    public double getIncome() {
        return income;
    }

    public String getMarried() {
        return married;
    }

    public int getChildren() {
        return children;
    }
    
    public String getCar() {
        return car;
    }

    public String getSave_act() {
        return save_act;
    }

    public String getCurrent_act() {
        return current_act;
    }

    public String getMortgage() {
        return mortgage;
    }

    public String getPep() {
        return pep;
    }

    //Bank record setters
    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setSave_act(String save_act) {
        this.save_act = save_act;
    }

    public void setCurrent_act(String current_act) {
        this.current_act = current_act;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }

    //Overiding abstract methods
    @Override
    public void readData(){
        BufferedReader br;
        try {
            //Initialize reader object and set file path to root of project
            br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));
		    String line;

            //Read each record in csv file
		    while ((line = br.readLine()) != null) {
                //Parse each record in csv file by a comma ( , )
                //Into a list stored in the arraylist-> Arrays
		        array.add(Arrays.asList(line.split(",")));
            }
        } 
        
        catch (IOException e) {
            System.out.println("There was an issue reading the file");
        }
    }

    @Override
    public void processData(){
        //Create index for array while iterating through arraylist
	    int idx = 0;

        //Create for each loop to cycle through arraylist of values and PASS that data into your record objects' setters 
		for (List<String> rowData: array) {
		    //Initialize array of objects
	        robjs[idx] = new BankRecords();
	
            //Call setters below and populate them, item by item
	        robjs[idx].setId(rowData.get(0)); //1st column
	        robjs[idx].setAge(Integer.parseInt(rowData.get(1))); 
	        robjs[idx].setSex(rowData.get(2)); 
            robjs[idx].setRegion(rowData.get(3));
	        robjs[idx].setIncome(Double.parseDouble(rowData.get(4))); 
            robjs[idx].setMarried(rowData.get(5));
	        robjs[idx].setChildren(Integer.parseInt(rowData.get(6))); 
	        robjs[idx].setCar(rowData.get(7)); 
	        robjs[idx].setSave_act(rowData.get(8)); 
	        robjs[idx].setCurrent_act(rowData.get(9)); 
	        robjs[idx].setMortgage(rowData.get(10)); 
	        robjs[idx].setPep(rowData.get(11)); //Last column

            //Continue processing arraylist item values into each array object-> robjs[] by index
            idx++;
        }        
    }

    @Override
    public void printData(){
        //Prints the heading with spacing
        String heading[] = {"ID", "AGE", "SEX", "REGION", "INCOME", "MARRIED", "CHILDREN", "CAR", "SAVE_ACT", "CURR_ACT", "MORTGAGE", "PEP"};
        for(int i = 0; i < 12; i++){
            System.out.printf("%-10s", heading[i]);
        }

        System.out.println("");
        
        //Prints client data and catches exeption if data is not present
        try{
            for(int i = 0; i < 25; i++){
                System.out.printf("%-9s %-8d %-8s %-11s %-11s %-9s %-7s %-10s %-11s %-8s %-7s %-10s %n", robjs[i].getId(), robjs[i].getAge(), robjs[i].getSex(), robjs[i].getRegion(), robjs[i].getIncome(), robjs[i].getMarried(), robjs[i].getChildren(), robjs[i].getCar(), robjs[i].getSave_act(), robjs[i].getCurrent_act(), robjs[i].getMortgage(), robjs[i].getPep());
            }
        } 

        catch (NullPointerException e) {
            System.out.println("DATA CANNOT BE FOUND");
        }
    }

}