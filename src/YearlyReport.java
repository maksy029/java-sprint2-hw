import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearlyReportRecord> yearlyReportRecords;

    public YearlyReport(ArrayList<YearlyReportRecord> yearlyReportRecords) {
        this.yearlyReportRecords = yearlyReportRecords;
    }

    // тут надо достать из внутреннего списка запись с расходами за переданный в параметрах месяц и вернуть их сумму
    public double getMonthlyExpenses(int month) {
        double monthlyExpenses = 0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (month == yRecord.month && yRecord.isExpense) {
                monthlyExpenses = yRecord.amount;
            }
        }
        return monthlyExpenses;
    }

    // а тут то же самое для доходов
    public double getMonthlyIncomes(int month) {
        double monthlyIncomes = 0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (month == yRecord.month && !yRecord.isExpense) {
                monthlyIncomes = yRecord.amount;
            }
        }
        return monthlyIncomes;
    }
}



