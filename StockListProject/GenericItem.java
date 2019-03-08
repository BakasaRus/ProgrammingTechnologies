package StockListProject;

public class GenericItem {
    public int ID;
	public String name;
	public float price;

	public GenericItem analog;
	public Category category = Category.GENERAL;

	void printAll(){
        System.out.printf("ID: %d\nName: %s\nPrice: %5.2f\nCategory: %s\n", ID, name, price, category.name());
    }
}