package StockListProject;

public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem();
        GenericItem item2 = new GenericItem();
        GenericItem item3 = new GenericItem();

        item1.ID = 1;
        item1.name = "Рафаэлло";
        item1.price = 249.90f;
        item1.analog = item1;

        item2.ID = 2;
        item2.name = "Милка";
        item2.price = 119.90f;
        item2.analog = item3;

        item3.ID = 3;
        item3.name = "Риттер Спорт";
        item3.price = 99.90f;
        item3.analog = item2;

        item1.printAll();
        item2.printAll();
        item3.printAll();
    }
}
