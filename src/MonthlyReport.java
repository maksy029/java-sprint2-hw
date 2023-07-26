import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<MonthlyReportRecord> monthlyReportRecords;

    public MonthlyReport(ArrayList<MonthlyReportRecord> monthlyReportRecords) {
        this.monthlyReportRecords = monthlyReportRecords;
    }

    public double getSumMonthlyIncomes() {
        double sumMonthlyIncomes = 0;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (!mRecord.isExpense) {
                sumMonthlyIncomes = sumMonthlyIncomes + mRecord.unitPrice * mRecord.quantity;
            }
        }
        return sumMonthlyIncomes;
    }

    public double getSumMonthlyExpenses() {
        double sumMonthlyExpenses = 0;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (mRecord.isExpense) {
                sumMonthlyExpenses = sumMonthlyExpenses + mRecord.unitPrice * mRecord.quantity;
            }
        }
        return sumMonthlyExpenses;
    }

    public int getMaxSumIncomesTopProduct() {
        int maxSum = 0;
        int sum;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (!mRecord.isExpense) {
                sum = mRecord.unitPrice * mRecord.quantity;
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public String getTopIncomesNameProduct() {
        String topName = null;
        int maxSum = getMaxSumIncomesTopProduct();
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (mRecord.quantity * mRecord.unitPrice == maxSum) {
                topName = mRecord.itemName;
            }
        }
        return topName;
    }

    public int getMaxSumExpensesTopProduct() {
        int maxSum = 0;
        int sum;
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (mRecord.isExpense) {
                sum = mRecord.unitPrice * mRecord.quantity;
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public String getTopExpensesNameProduct() {
        String topName = null;
        int maxSum = getMaxSumExpensesTopProduct();
        for (MonthlyReportRecord mRecord : monthlyReportRecords) {
            if (mRecord.quantity * mRecord.unitPrice == maxSum) {
                topName = mRecord.itemName;
            }
        }
        return topName;
    }
}
