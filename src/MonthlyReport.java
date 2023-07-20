import java.util.ArrayList;

public class MonthlyReport {

    ArrayList<MonthlyReportRecord> expenses;
    ArrayList<MonthlyReportRecord> incomes;


    public MonthlyReport(ArrayList<MonthlyReportRecord> expenses, ArrayList<MonthlyReportRecord> incomes) {
        this.expenses = expenses;
        this.incomes = incomes;
    }

    public String nameOfMonth() {
        return null;
    }

    public String topProduct() {
        return null;
    }
}
