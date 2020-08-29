import java.sql.SQLOutput;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
      float mortgageTotal = readData("Amount left on mortgage: ");
      float interestRate = readData("Yearly interest rate: ") / 100;
      float numberOfYears = readData("Number of years left on mortgage: ");
      float numberOfPayments = numberOfYears * 12;

      printReport(mortgageTotal, interestRate, numberOfPayments);
      printPaymentSchedule(mortgageTotal, interestRate, numberOfPayments);
    }

    public static float readData(String prompt){
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }

    public static void printReport(float mortgageTotal, float interestRate, float numberOfYears) {
        double monthlyPayment = calculateMonthlyPayment(mortgageTotal, interestRate, numberOfYears);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyPayment);
    }

    public  static void printPaymentSchedule(float mortgageTotal, float interestRate, float numberOfYears){
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(int month = 1; month < numberOfYears * 12; month++) {
            System.out.println(Math.round(calculatePaymentSchedule(mortgageTotal, interestRate, numberOfYears, month)));
        }
    }

    public static double calculatePaymentSchedule(float mortgageTotal, float interestRate, float numberOfYears, float numberOfPaymentsMade){
        float monthlyInterest = interestRate / 12;
        float numberOfPayments = numberOfYears * 12;

        double balance = mortgageTotal *
                (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public static double calculateMonthlyPayment(float mortgageTotal, float interestRate, float months){
        float monthlyInterest = interestRate / 12;
        return mortgageTotal *
              ( monthlyInterest * Math.pow(1 + monthlyInterest, months))
              / (Math.pow(1 + monthlyInterest, months) - 1);
    }
}
