public class Main {
    public static void main(String[] args) {
        int mortgageTotal = (int) ReadData.readData("Amount left on mortgage: ");
        float interestRate = ReadData.readData("Yearly interest rate: ") / Calculator._100_PERCENT;
        int numberOfYears = (int) ReadData.readData("Number of years left on mortgage: ");

        Calculator calculator = new Calculator(mortgageTotal, interestRate, numberOfYears);

        MortgageReport report = new MortgageReport(calculator);
        report.printReport();
        report.printPaymentSchedule();
    }
}
