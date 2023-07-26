import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                reportManager.readMonthlyReport();
            } else if (command == 2) {
                reportManager.readYearlyReport();
            } else if (command == 3) {
                reportManager.compareMonthlyVsYearlyReport();
            } else if (command == 4) {
                reportManager.printAllMonthlyReport();
            } else if (command == 5) {
                reportManager.printYearlyReport();
            } else if (command == 0) {
                System.out.println("До скорой встречи!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет! Попробуй снова!\n");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты;");
        System.out.println("2 - Считать годовой отчёт;");
        System.out.println("3 - Сверить отчёты;");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах;");
        System.out.println("5 - Вывести информацию о годовом отчёте;");
        System.out.println("0 - Выход.");
    }
}

