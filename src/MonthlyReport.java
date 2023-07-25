import java.util.ArrayList;


public class MonthlyReport {
     ArrayList<MonthlyReportRecord> monthlyReportRecords;


    public MonthlyReport(ArrayList<MonthlyReportRecord> monthlyReportRecords) {
        this.monthlyReportRecords = monthlyReportRecords;
    }

    // посчитать все доходы за месяц по всем записям из внутреннего ArrayList<MonthlyReportRecord> monthlyReportRecords;
    public double getSumMonthlyIncomes() {
        double sumMonthlyIncomes=0;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (!mRecord.isExpense) {
                sumMonthlyIncomes=sumMonthlyIncomes+mRecord.unitPrice*mRecord.quantity;
            }
        }
        return sumMonthlyIncomes;
    }

    // то же самое для трат
    public double getSumMonthlyExpenses() {
        double sumMonthlyExpenses=0;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (mRecord.isExpense) {
                sumMonthlyExpenses = sumMonthlyExpenses+mRecord.unitPrice*mRecord.quantity;
            }

        }
        return sumMonthlyExpenses ;
    }


}
