import java.util.ArrayList;

public class YearlyReport {
    final ArrayList<YearlyReportRecord> yearlyReportRecords;

    public YearlyReport(ArrayList<YearlyReportRecord> yearlyReportRecords) {
        this.yearlyReportRecords = yearlyReportRecords;
    }

    public double getMonthlyExpenses(int month) {
        double monthlyExpenses = 0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (month == yRecord.month && yRecord.isExpense) {
                monthlyExpenses = yRecord.amount;
            }
        }
        return monthlyExpenses;
    }

    public double getMonthlyIncomes(int month) {
        double monthlyIncomes = 0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (month == yRecord.month && !yRecord.isExpense) {
                monthlyIncomes = yRecord.amount;
            }
        }
        return monthlyIncomes;
    }

    public double getMonthlyProfit(int month) {
        double monthlyProfit;
        monthlyProfit = getMonthlyIncomes(month) - getMonthlyExpenses(month);

        return monthlyProfit;
    }

    public double getAvgExpenses() {
        double avgExpenses;
        double sumAllExpenses = 0;
        int countExpenses = 0;

        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (yRecord.isExpense) {
                sumAllExpenses = sumAllExpenses + yRecord.amount;
                countExpenses++;
            }
        }
        avgExpenses = sumAllExpenses / countExpenses;
        return avgExpenses;
    }

    public double getAvgIncomes() {
        double avgIncomes;
        double sumAllIncomes = 0;
        int countIncomes = 0;

        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (!yRecord.isExpense) {
                sumAllIncomes = sumAllIncomes + yRecord.amount;
                countIncomes++;
            }
        }
        avgIncomes = sumAllIncomes / countIncomes;
        return avgIncomes;
    }
}



