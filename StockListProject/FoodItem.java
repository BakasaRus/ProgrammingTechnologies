package StockListProject;

import java.util.Date;

public class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    public void printAll() {
        super.printAll();
        System.out.printf("Date of income: %s\nExpires: %d\n", dateOfIncome, expires);
    }
}
