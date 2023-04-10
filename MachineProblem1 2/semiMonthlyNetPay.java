import java.util.ArrayList; //library for ArrayList
import java.util.Scanner; //library for Scanner
import java.io.File; //library for File (creating txt file)
import java.io.FileWriter; //library for FileWriter (enable writing something in the txt file)
import java.io.IOException; //library for Exception (if there are errors)
import java.io.PrintWriter; //library for PrintWriter (print what has been inputted by the user to the txt file)

public class semiMonthlyNetPay{

    //to determine the case of the employee based on their gross pay input and this will be used in the next method
    public static int numberCase(ArrayList<Double> grossPay){
        
        int n = 0;

        for (int j = 0; j < grossPay.size(); j++){

            if (grossPay.get(j) < 10417){
                n = 1;
            }
            else if(grossPay.get(j) >= 10417 && grossPay.get(j) <= 16666){
                n = 2;
            }
            else if(grossPay.get(j) >= 16667 && grossPay.get(j) <= 33332){
                n = 3;
            }
            else if(grossPay.get(j) >= 33333 && grossPay.get(j) <= 83332){
                n = 4;
            }
            else if(grossPay.get(j) >= 83333 && grossPay.get(j)<= 333332){
                n = 5;
            }
            else{
                n = 6;
            }

        }

        return n;
    }

    //to solve for their withholding tax in each case or compensation range
    public static double withholdingTax(ArrayList<Double> grossPay, int numCase){
        double t = 0;
        
        for (int j = 0; j < grossPay.size(); j++){

            switch (numCase){
                case 1:
                    t = 0.0;
                    break;
                case 2:
                    t = ((grossPay.get(j) - 10417) * 0.15);
                    break;
                case 3:
                    t = ((grossPay.get(j) - 16667) * 0.20) + 937.50;
                    break;
                case 4:
                    t = ((grossPay.get(j) - 33333) * 0.25) + 4270.70;
                    break;
                case 5:
                    t = ((grossPay.get(j) - 83333) * 0.30) + 16770.70;
                    break;
                case 6:
                    t = ((grossPay.get(j) - 333333) * 0.35) + 91770.70;
                    break;
            }

        }
       
        return t;
    }

    //to solve for SSS given the range compensation of the employees gross pay
    public static double sssComputation(ArrayList<Double> grossPay){
        
        ArrayList<Double> monthlyGrossPay = new ArrayList<>();
        double monthlySalaryCredit = 1;
        double EE = 1;
        double EEkinsenas; //the EE will be divided by 2 since EE is monthly and the one we are solving is for semi-monthly only
        
        for (int j = 0; j < grossPay.size(); j++){
            
            //gross pay would be multiplied to 2 to get the monthly gross pay 
            //this is needed because the range in the table shown is in monthly
            monthlyGrossPay.add(grossPay.get(j) * 2);

            if (monthlyGrossPay.get(j) >= 0 && monthlyGrossPay.get(j) <= 4249.99){
                monthlySalaryCredit = 4000.00;
            }
            else if (monthlyGrossPay.get(j) >= 4250 && monthlyGrossPay.get(j) <= 4749.99){
                monthlySalaryCredit = 4500.00;
            }
            else if (monthlyGrossPay.get(j) >= 4750 && monthlyGrossPay.get(j) <= 5249.99){
                monthlySalaryCredit = 5000.00;
            }
            else if (monthlyGrossPay.get(j) >= 5250 && monthlyGrossPay.get(j) <= 5749.99){
                monthlySalaryCredit = 5500.00;
            }
            else if (monthlyGrossPay.get(j) >= 5750 && monthlyGrossPay.get(j) <= 6249.99){
                monthlySalaryCredit = 6000.00;
            }
            else if (monthlyGrossPay.get(j) >= 6250 && monthlyGrossPay.get(j) <= 6749.99){
                monthlySalaryCredit = 6500.00;
            }
            else if (monthlyGrossPay.get(j) >= 6750 && monthlyGrossPay.get(j) <= 7249.99){
                monthlySalaryCredit = 7000.00;
            }
            else if (monthlyGrossPay.get(j) >= 7250 && monthlyGrossPay.get(j) <= 7749.99){
                monthlySalaryCredit = 7500.00;
            }
            else if (monthlyGrossPay.get(j) >= 7750 && monthlyGrossPay.get(j) <= 8249.99){
                monthlySalaryCredit = 8000.00;
            }
            else if (monthlyGrossPay.get(j) >= 8250 && monthlyGrossPay.get(j) <= 8749.99){
                monthlySalaryCredit = 8500.00;
            }
            else if (monthlyGrossPay.get(j) >= 8750 && monthlyGrossPay.get(j) <= 9249.99){
                monthlySalaryCredit = 9000.00;
            }
            else if (monthlyGrossPay.get(j) >= 9250 && monthlyGrossPay.get(j) <= 9749.99){
                monthlySalaryCredit = 9500.00;
            }
            else if (monthlyGrossPay.get(j) >= 9750 && monthlyGrossPay.get(j) <= 10249.99){
                monthlySalaryCredit = 10000.00;
            }
            else if (monthlyGrossPay.get(j) >= 10250 && monthlyGrossPay.get(j) <= 10749.99){
                monthlySalaryCredit = 10500.00;
            }
            else if (monthlyGrossPay.get(j) >= 10750 && monthlyGrossPay.get(j) <= 11249.99){
                monthlySalaryCredit = 11000.00;
            }
            else if (monthlyGrossPay.get(j) >= 11250 && monthlyGrossPay.get(j) <= 11749.99){
                monthlySalaryCredit = 11500.00;
            }
            else if (monthlyGrossPay.get(j) >= 11750 && monthlyGrossPay.get(j) <= 12249.99){
                monthlySalaryCredit = 12000.00;
            }
            else if (monthlyGrossPay.get(j) >= 12250 && monthlyGrossPay.get(j) <= 12749.99){
                monthlySalaryCredit = 12500.00;
            }
            else if (monthlyGrossPay.get(j) >= 12750 && monthlyGrossPay.get(j) <= 13249.99){
                monthlySalaryCredit = 13000.00;
            }
            else if (monthlyGrossPay.get(j) >= 13250 && monthlyGrossPay.get(j) <= 13749.99){
                monthlySalaryCredit = 13500.00;
            }
            else if (monthlyGrossPay.get(j) >= 13750 && monthlyGrossPay.get(j) <= 14249.99){
                monthlySalaryCredit = 14000.00;
            }
            else if (monthlyGrossPay.get(j) >= 14250 && monthlyGrossPay.get(j) <= 14749.99){
                monthlySalaryCredit = 14500.00;
            }
            else if (monthlyGrossPay.get(j) >= 14750 && monthlyGrossPay.get(j) <= 15249.99){
                monthlySalaryCredit = 15000.00;
            }
            else if (monthlyGrossPay.get(j) >= 15250 && monthlyGrossPay.get(j) <= 15749.99){
                monthlySalaryCredit = 15500.00;
            }
            else if (monthlyGrossPay.get(j) >= 15750 && monthlyGrossPay.get(j) <= 16249.99){
                monthlySalaryCredit = 16000.00;
            }
            else if (monthlyGrossPay.get(j) >= 16250 && monthlyGrossPay.get(j) <= 16749.99){
                monthlySalaryCredit = 16500.00;
            }
            else if (monthlyGrossPay.get(j) >= 16750 && monthlyGrossPay.get(j) <= 17249.99){
                monthlySalaryCredit = 17000.00;
            }
            else if (monthlyGrossPay.get(j) >= 17250 && monthlyGrossPay.get(j) <= 17749.99){
                monthlySalaryCredit = 17500.00;
            }
            else if (monthlyGrossPay.get(j) >= 17750 && monthlyGrossPay.get(j) <= 18249.99){
                monthlySalaryCredit = 18000.00;
            }
            else if (monthlyGrossPay.get(j) >= 18250 && monthlyGrossPay.get(j) <= 18749.99){
                monthlySalaryCredit = 18500.00;
            }
            else if (monthlyGrossPay.get(j) >= 18750 && monthlyGrossPay.get(j) <= 19249.99){
                monthlySalaryCredit = 19000.00;
            }
            else if (monthlyGrossPay.get(j) >= 19250 && monthlyGrossPay.get(j) <= 19749.99){
                monthlySalaryCredit = 19500.00;
            }
            else if (monthlyGrossPay.get(j) >= 19750){
                monthlySalaryCredit = 20000.00;
            }

        }

        EE = monthlySalaryCredit * 0.045;
        EEkinsenas = EE / 2;

        return EEkinsenas;
   }

    //to sovle for PhilHealth
    public static double philHealthComputation(ArrayList<Double> grossPay){
        double ph = 0;
        for (int j = 0; j < grossPay.size(); j++){
            ph = grossPay.get(j) * 0.02; 
        }
        return ph;
   }

    //to solve for Pag-Ibig
    public static double pagIbigComputation(ArrayList<Double> grossPay){
        double pi = 50;
        return pi;
   }

   //to save the inputs to a txt file
    public static void saveInput(int numberEmployees, ArrayList<String> username, ArrayList<Double> grossPay, ArrayList<Double> wTax, 
        ArrayList<Double> sss, ArrayList<Double> philHealth, ArrayList<Double> pagIbig, ArrayList<Double> totalDeduction, ArrayList<Double> netPay){

        boolean append = true; //in order to append what has been inputted by the user

    try{
        File file = new File ("inputs.txt"); //the file where the user's inputs will be saved is the inputs.txt
        FileWriter writer = new FileWriter (file, append);
        PrintWriter pw = new PrintWriter (writer);

        pw.println("*******************************************************************");
    
        for (int i = 1; i <= numberEmployees; i++){
            int index = i - 1;
            pw.println("-------------------------------------------------------------------");
            pw.println("Employee # " + i);
            pw.println("Name: " + username.get(index));
            pw.printf("Gross Pay: %.2f", grossPay.get(index));
            pw.println("\n\nCOMPONENTS OF DEDUCTION");
            pw.printf("Withholding Tax: %.2f", wTax.get(index));
            pw.printf("\nSSS: %.2f", sss.get(index));
            pw.printf("\nPhilHealth: %.2f", philHealth.get(index));
            pw.printf("\nPag-Ibig: %.2f", pagIbig.get(index));
            pw.printf("\nTotal Deduction: %.2f", totalDeduction.get(index));
            pw.printf("\n\n" + username.get(index) + "'s Semi-Monthly Net Pay: %.2f", netPay.get(index));
            pw.println("\n-------------------------------------------------------------------");
        }

        pw.println("*******************************************************************\n");
        pw.close();
    }
    catch(IOException e){
        System.out.println("Error in printInput method.");
    }
}

    //the body or chunk of the code
    public static void body() {
        
        Scanner scan = new Scanner(System.in);
    
        int numberEmployees = 1;
        
        //check whether the inputted number of employees is valid or not
        do{
            System.out.println("Please input 1-10 only OR 0 if you want to exit the program now. Thank you!");
            System.out.print("Number of Employees: "); //the number of employees who wants to know their semi-monthly net pay
            numberEmployees = scan.nextInt();
            scan.nextLine();
            System.out.println("");
            
            if (numberEmployees < 0 || numberEmployees > 10){
                System.out.println("Invalid number! Please input again.\n");
            }

        } while (numberEmployees < 0 || numberEmployees > 10);
       
        ArrayList<String> username = new ArrayList<String>();
        ArrayList<Double> grossPay = new ArrayList<Double>();
        ArrayList<Double> wTax = new ArrayList<Double>();
        ArrayList<Double> sss = new ArrayList<Double>();
        ArrayList<Double> philHealth = new ArrayList<Double>();
        ArrayList<Double> pagIbig= new ArrayList<Double>();
        ArrayList<Double> totalDeduction = new ArrayList<Double>(); 
        ArrayList<Double> netPay = new ArrayList<Double>();
        
        int countInput;
        
        for (countInput = 1; countInput <= numberEmployees; countInput++){

            int index = countInput - 1; //array index starts at 0
            
            System.out.println("-------------------------------------------------------------------"); //just for organization and design
            System.out.println("EMPLOYEE # " + countInput);
            System.out.print("Name: ");
            username.add(scan.nextLine());

            System.out.print("Gross Pay: ");
            grossPay.add(scan.nextDouble());
            scan.nextLine();

            int numCase = numberCase(grossPay);
                        
            wTax.add(withholdingTax(grossPay, numCase));
            sss.add(sssComputation(grossPay));
            philHealth.add(philHealthComputation(grossPay));
            pagIbig.add(pagIbigComputation(grossPay));
            totalDeduction.add(wTax.get(index) + sss.get(index) + philHealth.get(index) + pagIbig.get(index));

            netPay.add(grossPay.get(index) - totalDeduction.get(index));
            System.out.printf("\n"+ username.get(index) + "'s Semi-Monthly Net Pay: %.2f", netPay.get(index)); 

            System.out.println("\n-------------------------------------------------------------------");

        }
        
        saveInput(numberEmployees, username, grossPay, wTax, sss, philHealth, pagIbig, totalDeduction, netPay);

    }


//---------------------------------------------------------------------------------------------------------------------------
    
    //to display the inputted data by the user
    public static void read(){

        try{
            File file = new File("inputs.txt");
            Scanner read = new Scanner(file);
    
            //while there is a next line, the program will continue to read/display it
            while(read.hasNextLine()){
                System.out.println(read.nextLine());
            }
            read.close();
        }
        catch(IOException e){
            System.out.println("Error.");
        }
    }

    //to clear the txt file
    public static void clearData(){

        try{
            File file = new File("inputs.txt");
            FileWriter fw = new FileWriter(file, false); //false - it would not append the other texts rather than ""

            fw.write("");
            fw.close();

            System.out.println("Successfully cleared the text file.");
        }
        catch(IOException e){
            System.out.println("Error.");
        }
    }

}