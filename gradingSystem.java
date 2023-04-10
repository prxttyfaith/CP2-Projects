//Pair: Lo & Misuarez
//Computer Programming 2 | Class 4-301

import java.util.ArrayList;     //library for ArrayList
import java.util.Scanner;       //library for Scanner
import java.io.File;            //library for File (creating txt file)
import java.io.FileWriter;      //library for FileWriter (enable writing something in the txt file)
import java.io.IOException;     //library for Exception (if there are errors)
import java.io.PrintWriter;     //library for PrintWriter (print what has been inputted by the user to the txt file)

public class gradingSystem {

    //to get input from user, specifically for the subject name, subject units, and the numeric grade(in percentage)
    public static void getInput(ArrayList<String> subject, ArrayList<Double> units,
    ArrayList<Double> numGrade, int totalSubNum){

        Scanner input = new Scanner(System.in);

        for (int j = 0; j < totalSubNum; j++){
            int sn = j + 1; //will be used for printing subject number in promts
            double ng;      //temporary numeric grade variable

            System.out.print("\nSubject " + sn + " name: " );
            subject.add(input.nextLine());  //get subject name

            System.out.print("Subject units : " );
            units.add(input.nextDouble());  //get subject units
            input.nextLine();

            do { //get percentage grade and check if it is NOT valid
                System.out.print("Percentage grade: " );
                ng = input.nextDouble();    //get percentage grade
                input.nextLine();

               if (ng < 0 || ng > 100)      //check if the grade inputted is not valid
                    System.out.println("Invalid grade, please input again." );
            }
            while (ng < 0 || ng > 100);     //while grade is not valid, loop again.
            numGrade.add(ng);

        }
    }

    //to get the corresponding letter grade of each numeric grade. store the values in letgrade arraylist.
    public static void letterGrade(ArrayList<String> lg, ArrayList<Double> ng){

        for (int j = 0; j < ng.size(); j++){

            if (ng.get(j) <= 100 && ng.get(j) >= 92)
                lg.add("A");

            if (ng.get(j) <= 91 && ng.get(j) >= 88)
                lg.add("B+");

            if (ng.get(j) <= 87 && ng.get(j) >= 84)
                lg.add("B");

            if (ng.get(j) <= 83 && ng.get(j) >= 80)
                lg.add("C+");

            if (ng.get(j) <= 79 && ng.get(j) >= 76)
                lg.add("C");

            if (ng.get(j) <= 75 && ng.get(j) >= 72)
                lg.add("D");

            if (ng.get(j) < 72)
                lg.add("F");
        }
    }

    //to get the corresponding quality point equivalent of each letter grade.
    //store the values in qpe arraylist
    public static void qualityPointEquivalent(ArrayList<String> lg, ArrayList<Double> qpe){

        for (int j = 0; j < lg.size(); j++){

            if (lg.get(j).equals("A"))
                qpe.add(4.0);

            if (lg.get(j).equals("B+"))
                qpe.add(3.5);

            if (lg.get(j).equals("B"))
                qpe.add(3.0);

            if (lg.get(j).equals("C+"))
                qpe.add(2.5);

            if (lg.get(j).equals("C"))
                qpe.add(2.0);

            if (lg.get(j).equals("D"))
                qpe.add(1.0);

            if (lg.get(j).equals("F"))
                qpe.add(0.0);
        }
    }

    //to compute for the product of units and qpe for each subject.
    //store the values in qpe arraylist (modify qpe arraylist))
    public static void productQpeUnits (ArrayList<Double> units, ArrayList<Double> qpe){

        for (int j = 0; j < qpe.size(); j++)
            qpe.set(j, (units.get(j) * qpe.get(j)));
    }

    //this function will compute for the sum of the elements in arraylist.
    public static double sum(ArrayList<Double> array){
        double total = 0.0;

        for (int j = 0; j < array.size(); j++)
            total = total + array.get(j);

        return total;
    }

    //to print the overall output
    public static void printOutput(ArrayList<String> subject, ArrayList<Double> units, ArrayList<Double> ng,
    ArrayList<String> lg, ArrayList<Double> qpe, double qpi){
        String divider = "+----------------------------------------------------------------------+";

        System.out.println("\n" + divider );
        System.out.printf("| %-35s | %-5s | %-6s | %-5s | %-5s |%n", "SUBJECT", "UNITS", "NG(%)", "LG", "QPE");
        System.out.println(divider);

        for (int j = 0; j < subject.size() ; j++)
            System.out.printf("| %-35s | %-5.2f | %-6.2f | %-5s | %-5.2f |%n",
            subject.get(j), units.get(j), ng.get(j), lg.get(j), (qpe.get(j)/units.get(j)));

        System.out.println(divider);
        System.out.println("  QPI: " + String.format("%.2f", qpi));

    }

    //to save the overall output in txt file
    public static void saveInfo(ArrayList<String> subject, ArrayList<Double> units, ArrayList<Double> ng,
    ArrayList<String> lg, ArrayList<Double> qpe, double qpi){

        String divider = "+----------------------------------------------------------------------+";
        boolean append = true; //to append what has been inputted by the user

        try {
            File file = new File ("info.txt");
            FileWriter fw = new FileWriter (file, append);
            PrintWriter pw = new PrintWriter (fw);

            pw.println("\n" + divider);
            pw.printf("| %-35s | %-5s | %-6s | %-5s | %-5s |%n", "SUBJECT", "UNITS", "NG(%)", "LG", "QPE");
            pw.println(divider);

            for (int j = 0; j < subject.size() ; j++)
                pw.printf("| %-35s | %-5.2f | %-6.2f | %-5s | %-5.2f |%n",
                subject.get(j), units.get(j), ng.get(j),lg.get(j), (qpe.get(j)/units.get(j)));

            pw.println(divider);
            pw.println("  QPI: " + String.format("%.2f", qpi));
            pw.close();

        }
        catch (IOException e){
            System.out.println("Error in printInfo method.");
        }
    }

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("\n-----------------------------QPI CALCULATOR-----------------------------");
        System.out.print("\nPlease input the number of subjects you have this semester: ");
        int totalSubNum = input.nextInt(); // get total subject number
        input.nextLine();

        ArrayList<String> subject   = new ArrayList<String> (); //create ArrayList for subject names
        ArrayList<String> letGrade  = new ArrayList<String> (); //create ArrayList for letter grades
        ArrayList<Double> units     = new ArrayList<Double> (); //create ArrayList for subject units
        ArrayList<Double> numGrade  = new ArrayList<Double> (); //create ArrayList for numeric grades (ex. 89,90,... and 4.0, 3.5,...)
        ArrayList<Double> qpe       = new ArrayList<Double> (); //create ArrayList for qpe


        getInput(subject, units, numGrade, totalSubNum);
        letterGrade(letGrade, numGrade);
        qualityPointEquivalent(letGrade, qpe);
        productQpeUnits(units, qpe);

        double qpeSum = sum(qpe);
        double unitsSum = sum(units);

        double qpi = qpeSum / unitsSum;

        printOutput(subject, units, numGrade, letGrade, qpe, qpi);
        saveInfo(subject, units, numGrade, letGrade, qpe, qpi);
    }
}
