/*
* MortgageClass
*  Programmer: Albert Duenas
   Date: 10-11-22
   Version: 1.2
   Description: A java class that calculates mortgages. Has private data members principal amount, term, and rate.
   * Has getters and setters for private members. No getters and setters for monthly payment*/

public class MortgageClass {
    //private data members
    private double principalAmount;
    private int term;
    private double rate;
    //no getters and setters because this information is controlled
    private double monthlyPayment =0;

    public MortgageClass(double principalAmount, int term, double rate){
        this.principalAmount = principalAmount;
        this.term = term;
        this.rate = rate;

    }
    // Getters and Setters
    public void setPrincipalAmount(double principalAmount){
        this.principalAmount = principalAmount;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setRate(int term){
        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    public void setTerm(double rate){
        this.rate = rate;
    }

    public int getTerm() {
        return term;
    }
    //class method to calculate monthly payment
    public void calculateMonthlyPayment(){
        //Calculating monthly rate
        rate =  (rate/1200.0);

        //Calculating term in months
        term = term * 12;

        //Calculating monthly payment
        monthlyPayment =  (principalAmount * rate / (1.0 - Math.pow(rate + 1, -term)));
    }
    //class method to print out monthly payment
    public void printMonthlyPayment(){
        System.out.format("This is your monthly payment: %.2f", monthlyPayment);
    }
}

