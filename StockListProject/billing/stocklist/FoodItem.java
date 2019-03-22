package StockListProject.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    protected Date dateOfIncome;
    protected short expires;

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        super();
        this.category = Category.FOOD;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, new Date(), expires);
    }

    public FoodItem(String name) {
        this(name, 0, null, new Date(), (short) 60);
    }

    public void printAll() {
        super.printAll();
        System.out.printf("Date of income: %s\nExpires: %d\n", dateOfIncome, expires);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                dateOfIncome.equals(foodItem.dateOfIncome);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    public Object clone() throws CloneNotSupportedException {
        FoodItem cloned = (FoodItem) super.clone();

        cloned.dateOfIncome = (Date) dateOfIncome.clone();
        cloned.expires = expires;

        return cloned;
    }

    public String toString() {
        return "FoodItem{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analog=" + analog +
                ", category=" + category +
                ", dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                '}';
    }
}
