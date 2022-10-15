/*
* MortgageCalculatorV3
*  Programmer: Albert Duenas
   Date: 10-11-22
   Version: 1.2
   Description: A java program that utilizes the mortgage class to calculate mortgage payments. This program prompts the user
   * for values and passes them in to the mortgage class constructor. Then calls mortgage class methods to calculate and display
   * mortgage payments.*/
import java.util.Scanner;
public class MortgageCalculatorV3 {
    private static MortgageClass mortgageClass;

    public static String[] userPrompt(){
        //Declaring new scanner class
        Scanner sc = new Scanner (System.in);

        //Asking used what principal amount is
        System.out.println("What is the principal amount?");
        String principalAmount = sc.nextLine();

        //Asking user what how long the term is
        System.out.println("What is the term?");
        String term = sc.nextLine();

        //Asking user what the interest rate is
        System.out.println("What is the interest rate?");
        String rate = sc.nextLine();

        String[] userInputs={principalAmount, term, rate};
        return userInputs;
    }
    public static boolean checkForNegative(double value){
        return value>=0;
    }

    public static void main(String[] args) {
        System.out.println("Testing mortgage class with negative principal amount");
        MortgageClass mortgageClassNegativePrincipalAmount = new MortgageClass (-6, 7, 8);
        mortgageClassNegativePrincipalAmount.dataValidation();

        System.out.println("Testing mortgage class with negative term");
        MortgageClass mortgageClassNegativeTerm = new MortgageClass(100006, -7, 9 );
        mortgageClassNegativePrincipalAmount.dataValidation();

        System.out.println("Testing mortgage class with negative rate");
        MortgageClass mortgageClassNegativeRate = new MortgageClass(100004, 7, -3);
        mortgageClassNegativePrincipalAmount.dataValidation();

        System.out.println("Testing mortgage class with principal amount of of range 100000 and 2000000");
        MortgageClass mortgageClassPrincipalAmountOutOfRange = new MortgageClass(3, 7, 3);
        mortgageClassNegativePrincipalAmount.dataValidation();

        // Grabbing user input and storing it in array
        String[] userInputs=userPrompt();
        // Parsing principal amount from string to double
        double principalAmount=Double.parseDouble(userInputs[0]); // returns double primitive;
        // Parsing term from string to int
        int term = Integer.parseInt(userInputs[1]);
        // Parsing rate from string to double
        double rate=Double.parseDouble(userInputs[2]);

        mortgageClass = new MortgageClass(principalAmount, term, rate);
        if(mortgageClass.dataValidation()) {
            mortgageClass.calculateMonthlyPayment();
            mortgageClass.printMonthlyPayment();
        }
    }
}
