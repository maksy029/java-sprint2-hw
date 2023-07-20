import java.util.HashMap;
import java.util.ArrayList;

public class ReportManager {
    HashMap<Integer, MonthlyReport> monthlyReports = new HashMap<>();
    ArrayList<YearlyReport> yearlyReports = new ArrayList<>();


    public void readMonthlyReport() {
        FileReader fileReader = new FileReader();

        for (int i = 1; i < 4; i++) {
            String fileName = "m.20210" + i + ".csv";
            ArrayList<String> lines = fileReader.readFileContents(fileName); // item_name,is_expense,quantity,unit_price

            if (lines.isEmpty()) {
                System.out.println("Файл " + fileName + " пустой!");
                return;
            }

            ArrayList<MonthlyReportRecord> expenses = new ArrayList<>();
            ArrayList<MonthlyReportRecord> incomes = new ArrayList<>();

            for (int j = 1; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] values = line.split(",");
                String itemName = values[0];

                boolean isExpense = Boolean.parseBoolean(values[1]);
                int quantity = Integer.parseInt(values[2]);
                int unitPrice = Integer.parseInt(values[3]);

                MonthlyReportRecord monthlyReportRecord = new MonthlyReportRecord(itemName, isExpense, quantity, unitPrice);

                if (monthlyReportRecord.getExpense()) {
                    expenses.add(monthlyReportRecord);
                } else {
                    incomes.add(monthlyReportRecord);
                }
            }
            monthlyReports.put(i, new MonthlyReport(expenses, incomes));
            System.out.println("Файл " + fileName + " считан");
        }
    }

    public void readYearlyReport() {
        FileReader fileReader = new FileReader();
        String fileName = "y.2021.csv";
        ArrayList<String> lines = fileReader.readFileContents(fileName);

        if (lines.isEmpty()) {
            System.out.println("Файл " + fileName + " пустой!");
            return;
        }

        ArrayList<YearlyReportRecord> yearlyReportRecords = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] values = line.split(",");

            int month = Integer.parseInt(values[0]);
            double amount = Double.parseDouble(values[1]);
            boolean isExpense = Boolean.parseBoolean(values[2]);

            YearlyReportRecord yearlyReportRecord = new YearlyReportRecord(month, amount, isExpense);
            yearlyReportRecords.add(yearlyReportRecord);
            yearlyReports.add(new YearlyReport(yearlyReportRecords));
        }
        System.out.println("Файл " + fileName + " считан");
    }

    public void compareMonthlyVsYearlyReport() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчет не считан");
            return;
        } else if (yearlyReports == null) {
            System.out.println("Годовой отчет не считан");
            return;
        }

    }

    public void printAllMonthlyReport() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчет не считан");
            return;
        }

    }
    
    
    public void printYearlyReport() {
        if (yearlyReports == null) {
            System.out.println("Годовой отчет не считан");
            return;
        }

    }
}
