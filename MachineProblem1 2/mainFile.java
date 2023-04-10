//Pair: Ivan James Lo & Pretty Faith Misuarez
//Computer Programming 2 | Class 4-301

import java.util.*; //library that can load the contents of the java.util package

public class mainFile {
    
    //the options that the user can do after inputting some details
    static void menu(){

		System.out.println("\n-----------------------------------------");
        System.out.println("|          Interactactive Menu          |");
        System.out.println("|---------------------------------------|");
        System.out.println("|                                       |");
        System.out.println("|     Choose an option to perform:)     |");
        System.out.println("|                                       |");
        System.out.println("|---------------------------------------|");
        System.out.println("|                                       |");
        System.out.println("| 1.) Display ALL Information           |"); //displays ALL information including the deduction components
        System.out.println("| 2.) Add another set of Employee Info  |"); //add another set of employees (1-10)
        System.out.println("| 3.) Delete ALL Information            |");
        System.out.println("| 4.) Exit Program!                     |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");

	}
    
    //main method
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int userChoice;
        boolean programInUsed = true;

        System.out.println("\n************** EMPLOYEE'S SEMI-MONTHLY NET PAY CALCULATOR **************");
        System.out.println("\nHello! To know your Semi-Monthly Net Pay, please fill up the following prompts!\n");

        semiMonthlyNetPay.body(); //calls the body method on the other file

        menu();

        while(programInUsed){
            System.out.print("\nPlease choose the desired option: ");
            userChoice = scan.nextInt();

            //checks whether the userChoice is valid or not
            if (userChoice > 0 && userChoice < 5){

                switch (userChoice){

                    case 1:{
                        semiMonthlyNetPay.read(); //calls the read method on the other file 
                        menu(); //will display the menu again just in case the there will be a long list that would cover the menu at the start
                        break;
                    }

                    case 2:{
                        semiMonthlyNetPay.body(); //calls the body method on the other file so that users can input another set of 1-10 employees
                        menu(); //will display the menu again for convenience
                        break;
                    }

                    case 3:{
                        semiMonthlyNetPay.clearData(); //calls the clearData method on the other file to erase the data in the txt file
                        break;
                    }

                    case 4:{
                        System.out.println("\n**** Thank you for using Employee's Semi-Monthly Net Pay Calculator ****\n");
                        programInUsed = false; //means the program is no longer in use; the user exits the program
                        break;
                    }

                }

            }
            
        }
        scan.close();
    }

}