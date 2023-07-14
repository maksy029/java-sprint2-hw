import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ReportManager reportManager = new ReportManager();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                reportManager.readMonthlyReport();
            }
            else if (command == 2) {
                reportManager.readYearlyReport();
            }
            else if (command == 3) {
                reportManager.compareMonthlyVsYearlyReport();
            }
            else if (command == 4) {
                reportManager.printAllMonthlyReport();
            }
            else if (command == 5) {
                reportManager.printYearlyReport();
            }
            else if (command == 0) {
                System.out.println("До скорой встречи!");
                return;
            }
            else {
                System.out.println("Такой команды нет! Попробуй снова!");
                System.out.println(" ");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты;"); /* прочитать данные из файлов месячных отчётов, сохранить их в память программы;
        При выборе действия «считать все месячные отчёты» должно происходить считывание трёх файлов: m.202101.csv, m.202102.csv, m.202103.csv */
        System.out.println("2 - Считать годовой отчёт;"); /* прочитать данные из файла годового отчёта, сохранить их в память программы.
        При выборе действия «считать годовой отчёт» должно происходить считывание из одного файла: y.2021.csv */
        System.out.println("3 - Сверить отчёты;"); //по сохранённым данным проверить, сходятся ли отчёты за месяцы и за год.
        System.out.println("4 - Вывести информацию обо всех месячных отчётах;"); //по сохранённым данным вывести в консоль имеющуюся информацию.
        System.out.println("5 - Вывести информацию о годовом отчёте;"); // по сохранённым данным вывести в консоль имеющуюся информацию.
        System.out.println("0 - Выход.");
    }
}

