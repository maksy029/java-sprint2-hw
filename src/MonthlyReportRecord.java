public class MonthlyReportRecord {
   String itemName;
   boolean isExpense;
   int quantity;
   int unitPrice;

    MonthlyReportRecord(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName=itemName;
        this.isExpense=isExpense;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }


    public boolean getExpense() {

        return isExpense;
    }


}

