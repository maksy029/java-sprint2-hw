import java.util.HashMap;
import java.util.ArrayList;

public class ReportManager {
    HashMap<Integer, MonthlyReport> monthlyReports = new HashMap<>();
    YearlyReport yearlyReport;

    public void readMonthlyReport() {
        FileReader fileReader = new FileReader();

        for (int i = 1; i < 4; i++) {
            String fileName = "m.20210" + i + ".csv";
            ArrayList<String> lines = fileReader.readFileContents(fileName);

            if (lines.isEmpty()) {
                System.out.println("Файл " + fileName + " пустой!");
                return;
            }
            ArrayList<MonthlyReportRecord> monthlyReportRecords = new ArrayList<>();

            for (int j = 1; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] values = line.split(",");
                String itemName = values[0];

                boolean isExpense = Boolean.parseBoolean(values[1]);
                int quantity = Integer.parseInt(values[2]);
                int unitPrice = Integer.parseInt(values[3]);

                MonthlyReportRecord monthlyReportRecord = new MonthlyReportRecord(itemName, isExpense, quantity, unitPrice);
                monthlyReportRecords.add(monthlyReportRecord);
            }
            monthlyReports.put(i, new MonthlyReport(monthlyReportRecords));
            System.out.println("Файл " + fileName + " считан");
        }
    }

    public String readYearlyReport() {
        FileReader fileReader = new FileReader();
        String fileName = "y.2021.csv";
        ArrayList<String> lines = fileReader.readFileContents(fileName);

        if (lines.isEmpty()) {
            System.out.println("Файл " + fileName + " пустой!");
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
        }
        yearlyReport = new YearlyReport(yearlyReportRecords);

        System.out.println("Файл " + fileName + " считан");
        return fileName;
    }

    public void compareMonthlyVsYearlyReport() {
        if (monthlyReports.size() == 0 || yearlyReport.yearlyReportRecords.isEmpty()) {
            System.out.println("Отчеты не считаны! Для сверки необходимо считать отчеты: " +
                    "воспользуйся командами - '1' и '2'!");
        } else {
            for (int i = 1; i < 4; i++) {
                MonthlyReport monthlyReport = monthlyReports.get(i);
                if (yearlyReport.getMonthlyExpenses(i) == monthlyReport.getSumMonthlyExpenses()) {
                    System.out.println("Ошибок по расходам в месяце: " + i + " - нет!");
                } else {
                    System.out.println("Ошибка по расходам в месяце: " + i);
                }
                if (yearlyReport.getMonthlyIncomes(i) == monthlyReport.getSumMonthlyIncomes()) {
                    System.out.println("Ошибок по доходам в месяце: " + i + " - нет!");
                } else {
                    System.out.println("Ошибка по доходам в месяце: " + i);
                }
            }
        }
    }

    public void printAllMonthlyReport() {
        if (monthlyReports.size() == 0) {
            System.out.println("Месячные отчеты не считаны! Воспользуйся командой - '1'!");
        } else {
            for (int i = 1; i < 4; i++) {
                MonthlyReport monthlyReport = monthlyReports.get(i);
                System.out.println("Рассматриваемый месяц: " + i);
                System.out.println("Самый прибыльный товар: '"
                        + monthlyReport.getTopIncomesNameProduct()
                        + "', продано на сумму - " + monthlyReport.getMaxSumIncomesTopProduct());
                System.out.println("Самая большая трата за товар: '"
                        + monthlyReport.getTopExpensesNameProduct()
                        + "', на который портачено - " + monthlyReport.getMaxSumExpensesTopProduct());
            }
        }
    }

    public void printYearlyReport() {
        if (yearlyReport.yearlyReportRecords.isEmpty()) {
            System.out.println("Годовой отчет не считан");
        } else {
            System.out.println("Рассматриваемый год: " + readYearlyReport());
            for (int i = 1; i < 4; i++) {
                System.out.println("Прибыль за месяц: " + i + " = " + yearlyReport.getMonthlyProfit(i));
            }
            System.out.println("Средний расход за год: " + yearlyReport.getAvgExpenses());
            System.out.println("Средний доход за год: " + yearlyReport.getAvgIncomes());
        }
    }
}
