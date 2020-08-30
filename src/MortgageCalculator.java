import java.util.Scanner;

public class MortgageCalculator {
    final static byte MONTHS_IN_A_YEAR = 12;
    final static byte _100_PERCENT = 100;

    public static void main(String[] args) {
      int mortgageTotal = (int) readData("Amount left on mortgage: ");
      float interestRate = (float) readData("Yearly interest rate: ") / _100_PERCENT;
      int numberOfYears = (int) readData("Number of years left on mortgage: ");
      int numberOfPayments = (int) (numberOfYears * MONTHS_IN_A_YEAR);

      printReport(mortgageTotal, interestRate, numberOfPayments);
      printPaymentSchedule(mortgageTotal, interestRate, numberOfPayments);
    }

    public static float readData(String prompt){
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }

    public static void printReport(int mortgageTotal, float interestRate, int numberOfYears) {
        double monthlyPayment = calculateMonthlyPayment(mortgageTotal, interestRate, numberOfYears);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyPayment);
    }

    public  static void printPaymentSchedule(int mortgageTotal, float interestRate, int numberOfYears){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(int month = 1; month <= (numberOfYears * MONTHS_IN_A_YEAR); month++) {
            System.out.println(Math.round(calculatePaymentSchedule(mortgageTotal, interestRate, numberOfYears, month)));
        }
    }

    public static double calculatePaymentSchedule(int mortgageTotal, float interestRate, int numberOfYears, int numberOfPaymentsMade){
        float monthlyInterest = interestRate / MONTHS_IN_A_YEAR;
        float numberOfPayments = numberOfYears * MONTHS_IN_A_YEAR;

        return mortgageTotal *
                (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateMonthlyPayment(int mortgageTotal, float interestRate, int months){
        float monthlyInterest = interestRate / MONTHS_IN_A_YEAR;
        return mortgageTotal *
              ( monthlyInterest * Math.pow(1 + monthlyInterest, months))
              / (Math.pow(1 + monthlyInterest, months) - 1);
    }
}
