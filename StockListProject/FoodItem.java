package StockListProject;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    public void printAll() {
        super.printAll();
        System.out.printf("Date of income: %s\nExpires: %d\n", dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                dateOfIncome.equals(foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FoodItem cloned = (FoodItem) super.clone();

        cloned.dateOfIncome = (Date) dateOfIncome.clone();
        cloned.expires = expires;

        return cloned;
    }
}
