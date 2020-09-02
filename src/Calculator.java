import java.util.Scanner;

public class Calculator {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int _100_PERCENT = 100;

    public int mortgageTotal;
    public float interestRate;
    public int numberOfYears;

    public Calculator(int mortgageTotal, float interestRate, int numberOfYears) {
        this.mortgageTotal = mortgageTotal;
        this.interestRate = interestRate;
        this.numberOfYears = numberOfYears;
    }

    public double calculatePaymentSchedule(int numberOfPaymentsMade ) {
        float monthlyInterest =  interestRate / MONTHS_IN_A_YEAR;
        float numberOfPayments = numberOfYears * MONTHS_IN_A_YEAR;

        return mortgageTotal *
                (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateMonthlyPayment() {
        float monthlyInterest = interestRate / MONTHS_IN_A_YEAR;
        int months = numberOfYears * 12;
        return mortgageTotal *
                ( monthlyInterest * Math.pow(1 + monthlyInterest, months))
                / (Math.pow(1 + monthlyInterest, months) - 1);
    }

}
