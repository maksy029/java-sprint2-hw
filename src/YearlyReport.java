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

    //прибыль по каждому месяцу
    public double getMonthlyProfit (int month) {
        double monthlyProfit=0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            monthlyProfit=getMonthlyIncomes(month) - getMonthlyExpenses(month);
            }
          return monthlyProfit;
    }

    public double getAvgExpenses () {
        double avgExpenses = 0;
        double sumAllExpenses=0;
        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (yRecord.isExpense) {
                sumAllExpenses = sumAllExpenses+yRecord.amount;
                avgExpenses=sumAllExpenses/yearlyReportRecords.size();
            }
        }
        return avgExpenses;
    }

    public double getAvgIncomes() {
        double avgIncomes = 0;
        double sumAllIncomes = 0;

        for (YearlyReportRecord yRecord : yearlyReportRecords) {
            if (!yRecord.isExpense) {
                sumAllIncomes = sumAllIncomes + yRecord.amount;
                avgIncomes = sumAllIncomes / yearlyReportRecords.size();
            }
        }
        return avgIncomes;
    }


}



