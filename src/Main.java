public class Main {
    public static void main(String[] args) {
        int mortgageTotal = (int) Calculator.readData("Amount left on mortgage: ");
        float interestRate = Calculator.readData("Yearly interest rate: ") / Calculator._100_PERCENT;
        int numberOfYears = (int) Calculator.readData("Number of years left on mortgage: ");

        var calculator = new Calculator(mortgageTotal, interestRate, numberOfYears);

        var report = new MortgageReport(calculator);
        report.printReport();
        report.printPaymentSchedule();
    }
}
