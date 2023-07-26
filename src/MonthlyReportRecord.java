public class MonthlyReportRecord {
    final String itemName;
    final boolean isExpense;
    final int quantity;
    final int unitPrice;

    MonthlyReportRecord(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}

