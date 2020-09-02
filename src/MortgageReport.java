import java.text.NumberFormat;

public class MortgageReport {
    private Calculator calculator;

    public MortgageReport(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printReport() {
        double monthlyPayment = calculator.calculateMonthlyPayment();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyPayment);
    }

    public void printPaymentSchedule(
    ) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        int month;
        for(month = 1; month <= (calculator.numberOfYears * Calculator.MONTHS_IN_A_YEAR); month++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(calculator.calculatePaymentSchedule(month)));
        }
    }
}
