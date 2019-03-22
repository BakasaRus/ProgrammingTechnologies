package StockListProject;

public class Main {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();

        catalog.addItem(new GenericItem("Рафаэлло", 249.90f, Category.FOOD));
        catalog.addItem(new GenericItem("Милка", 119.90f, catalog.findItemByID(0)));
        catalog.addItem(new GenericItem("Риттер Спорт", 99.90f, catalog.findItemByID(1)));

        catalog.addItem(new FoodItem("Чебупели", 119.90f, (short) 90));
        catalog.addItem(new FoodItem("Чебупицца", 99.90f, (short) 90));

        TechnicalItem technicalItem = new TechnicalItem();
        technicalItem.name = "Мультиварка";
        technicalItem.price = 5999.99f;
        technicalItem.warrantyTime = 365;
        technicalItem.category = Category.GENERAL;

        catalog.addItem(technicalItem);

        try {
            FoodItem foodItem = (FoodItem) catalog.findItemByID(3).clone();
            foodItem.name = "Круггетсы";
            catalog.addItem(foodItem);
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Ошибка при клонировании объекта");
        }

        String line = "Конфеты ’Маска’;45;120";
        String[] itemFields = line.split(";");

        catalog.addItem(new FoodItem(
            itemFields[0],
            Float.parseFloat(itemFields[1]),
            Short.parseShort(itemFields[2])
        ));

        catalog.printItems();
    }
}
