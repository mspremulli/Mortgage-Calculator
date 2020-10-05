public class Calculator {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int _100_PERCENT = 100;

    public int principle;
    public float interestRate;
    public int numberOfYears;

    public Calculator(int mortgageTotal, float interestRate, int numberOfYears) {
        this.principle = mortgageTotal;
        this.interestRate = interestRate;
        this.numberOfYears = numberOfYears;
    }

    public double calculatePaymentSchedule(int numberOfPaymentsMade ) {
        float monthlyInterest =  1 + interestRate / MONTHS_IN_A_YEAR;
        float numberOfPayments = numberOfYears * MONTHS_IN_A_YEAR;


        return principle *
                (Math.pow(monthlyInterest, numberOfPayments) - Math.pow(monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateMonthlyPayment() {
        float monthlyInterest = 1 + interestRate / MONTHS_IN_A_YEAR;
        int months = numberOfYears * MONTHS_IN_A_YEAR;
        return principle *
                ( monthlyInterest * Math.pow(monthlyInterest, months))
                / (Math.pow(monthlyInterest, months) - 1);
    }

}
