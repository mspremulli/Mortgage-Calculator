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

    public static void printReport(float total, float rate, float years) {
        double monthlyPayment = calculateMonthlyPayment(total, rate, years);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyPayment);
    }

    public  static void printPaymentSchedule(float total, float rate, float years){
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        System.out.println();
    }

    public static double calculateMonthlyPayment(float total, float interest, float months){
        float monthlyInterest = interest / 12;
        return total *
              ( monthlyInterest * Math.pow(1 + monthlyInterest, months))
              / (Math.pow(1 + monthlyInterest, months) - 1);
    }
}
