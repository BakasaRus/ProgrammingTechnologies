package StockListProject;

import java.util.Objects;

public class GenericItem implements Cloneable {
    public int ID;
	public String name;
	public float price;

	public GenericItem analog;
	public Category category = Category.GENERAL;

	void printAll(){
        System.out.printf("ID: %d\nName: %s\nPrice: %5.2f\nCategory: %s\n", ID, name, price, category.name());
    }

	@Override
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

	@Override
	public int hashCode() {
		return Objects.hash(ID, name, price, analog, category);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		GenericItem cloned = (GenericItem) super.clone();

		cloned.ID = ID;
		cloned.name = name;
		cloned.price = price;
		cloned.category = category;
		cloned.analog = analog;

		return cloned;
	}
}