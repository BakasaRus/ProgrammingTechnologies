package StockListProject.billing.stocklist;

import java.util.Objects;

public class GenericItem implements Cloneable {
    protected int ID;
    protected String name;
    protected float price;

    protected GenericItem analog;
    protected Category category = Category.GENERAL;

    static int currentID = 0;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, Category category) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    void printAll() {
        System.out.printf("ID: %d\nName: %s\nPrice: %5.2f\nCategory: %s\n", ID, name, price, category.name());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID &&
                Float.compare(that.price, price) == 0 &&
                name.equals(that.name) &&
                Objects.equals(analog, that.analog) &&
                category == that.category;
    }

    public int hashCode() {
        return Objects.hash(ID, name, price, analog, category);
    }

    public Object clone() throws CloneNotSupportedException {
        GenericItem cloned = (GenericItem) super.clone();

        cloned.ID = GenericItem.currentID++;
        cloned.name = name;
        cloned.price = price;
        cloned.category = category;
        if (analog != null)
            cloned.analog = (GenericItem) analog.clone();

        return cloned;
    }

    public String toString() {
        return "GenericItem{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analog=" + analog +
                ", category=" + category +
                "}";
    }
}