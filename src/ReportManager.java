
import java.util.HashMap;
import java.util.ArrayList;

public class ReportManager {
    HashMap<Integer, MonthlyReport> monthlyReports = new HashMap<>();
    YearlyReport yearlyReport;


    public void readMonthlyReport() {
        FileReader fileReader = new FileReader();

        for (int i = 1; i < 4; i++) {
            String fileName = "m.20210" + i + ".csv";
            ArrayList<String> lines = fileReader.readFileContents(fileName); // item_name,is_expense,quantity,unit_price

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

    public void readYearlyReport() {
        FileReader fileReader = new FileReader();
        String fileName = "y.2021.csv";
        ArrayList<String> lines = fileReader.readFileContents(fileName);

        if (lines.isEmpty()) {
            System.out.println("Файл " + fileName + " пустой!");
            return;
        }
        ArrayList<YearlyReportRecord> yearlyReportRecords= new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] values = line.split(",");

            int month = Integer.parseInt(values[0]);
            double amount = Double.parseDouble(values[1]);
            boolean isExpense = Boolean.parseBoolean(values[2]);

            YearlyReportRecord  yearlyReportRecord = new YearlyReportRecord(month, amount, isExpense);
            yearlyReportRecords.add(yearlyReportRecord);
        }
        yearlyReport = new YearlyReport(yearlyReportRecords);

        System.out.println("Файл " + fileName + " считан");
    }

    public void compareMonthlyVsYearlyReport() {
        if (monthlyReports.size() == 0) {
            System.out.println("Месячный отчет не считан");
        } else if (yearlyReport == null) {
            System.out.println("Годовой отчет не считан");
        } else {
            for (YearlyReportRecord yRecord : yearlyReport.yearlyReportRecords) {
                int sumExpenseMonth = 0;
                int sumIncomesMonth = 0;

                for (Integer month : monthlyReports.keySet()) {
                    for (MonthlyReportRecord mRecord : monthlyReports.get(month).monthlyReportRecords) {
                        if (mRecord.isExpense) {
                            sumExpenseMonth = sumExpenseMonth + mRecord.quantity * mRecord.unitPrice;
                        }
                    }
                }
                for (Integer month : monthlyReports.keySet()) {
                    for (MonthlyReportRecord mRecord : monthlyReports.get(month).monthlyReportRecords) {
                        if (!mRecord.isExpense) {
                            sumIncomesMonth = sumIncomesMonth + mRecord.quantity * mRecord.unitPrice;
                        }
                    }
                }
                System.out.println(sumExpenseMonth);
                System.out.println(sumIncomesMonth);
            }
        }
    }


                /*if (уRecord.isExpense) {
                    System.out.println("Расходов: "+ yRecord.amount+" за месяц: " + yRecord.month);
                }
                if (!yRecord.isExpense) {
                    System.out.println("Доходов: "+ yRecord.amount+" за месяц: " + yRecord.month);
                }
                }

            for (Integer month : monthlyReports.keySet()) {

                for (MonthlyReportRecord record : monthlyReports.get(month).monthlyReportRecords) {

                    if (!record.isExpense) {
                        sumIncomesMonth = sumIncomesMonth+record.quantity*record.unitPrice;
                    }
                }
                System.out.println("Расходов: " + sumExpenseMonth+" за месяц: "+ month);
                System.out.println("Доходов: "+ sumIncomesMonth+" за месяц: "+ month);
            }
            }*/



    public void printAllMonthlyReport() {
        if (monthlyReports.size() == 0) {
            System.out.println("Месячный отчет не считан");
            return;
        }
       /* for (Integer month : monthlyReports.keySet()) {
            for (int i = 0; i < monthlyReports.get(month).monthlyReportRecords.size(); i++) {
                monthlyReports.get(month).monthlyReportRecords.get(i); // тут получаем каждый элемент листа
            }
        }*/
    }

    public void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчет не считан");
            return;
        }

        /*for (YearlyReportRecord record : yearlyReport.yearlyReportRecords) {
            System.out.println("Месяц:" +record.month);
            System.out.println("Cумма:" +record.amount);
            System.out.println("Расход(true)/Доход(false):" +record.isExpense);
        }*/

    }
}
