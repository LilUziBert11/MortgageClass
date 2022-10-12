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
        // Grabbing user input and storing it in array
        String[] userInputs=userPrompt();
        // Parsing principal amount from string to double
        double principalAmount=Double.parseDouble(userInputs[0]); // returns double primitive;
        // Checking principal amount for non-negative
        if (!checkForNegative(principalAmount)){
            System.out.println("Please enter a non negative value for principal amount");
            return;
        }
        //Checking principal amount between 100000 and 2000000
        if (principalAmount<100000 || principalAmount>2000000) {
            System.out.println("Please enter a value between 100,000 and 1,000,000 (inclusive)");
            return;
        }
        // Parsing term from string to int
        int term = Integer.parseInt(userInputs[1]);
        // Checking term for non-negative
        if (!checkForNegative(term)){
            System.out.println("Please enter a non negative value for term amount");
            return;
        }
        // Parsing rate from string to double
        double rate=Double.parseDouble(userInputs[2]);
        // Checking rate for non-negative
        if (!checkForNegative(rate)){
            System.out.println("Please enter a non negative value for the rate amount");
            return;
        }
        mortgageClass = new MortgageClass(principalAmount, term, rate);
        mortgageClass.calculateMonthlyPayment();
        mortgageClass.printMonthlyPayment();
    }
}
