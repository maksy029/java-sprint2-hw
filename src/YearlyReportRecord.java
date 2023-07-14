public class YearlyReportRecord {

    int month; // месяц, целое число, обозначается строго двумя цифрами, начиная с единицы, то есть 01 — «январь», а 11 — «ноябрь»;
    double amount; //сумма;
    boolean isExpense; //одно из двух значений: true или false. Обозначает, является ли запись тратой (true) или доходом (false).

    YearlyReportRecord(int month, double amount, boolean isExpense) {
        this.month=month;
        this.amount=amount;
        this.isExpense=isExpense;
    }

}
