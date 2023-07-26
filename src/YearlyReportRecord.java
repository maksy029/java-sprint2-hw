public class YearlyReportRecord {

    final int month;
    final double amount;
    final boolean isExpense;

    YearlyReportRecord(int month, double amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
