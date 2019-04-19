package StockListProject.billing.client;

import java.util.Date;

import StockListProject.billing.exceptions.CatalogLoadException;
import StockListProject.billing.exceptions.ItemAlreadyExistsException;
import StockListProject.billing.stocklist.*;

public class Main {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();

        try {
            catalog.addItem(new GenericItem("Рафаэлло", 249.90f, Category.FOOD));
            catalog.addItem(new GenericItem("Милка", 119.90f, catalog.findItemByID(0)));
            catalog.addItem(new GenericItem("Риттер Спорт", 99.90f, catalog.findItemByID(1)));

            catalog.addItem(new FoodItem("Чебупели", 119.90f, (short) 90));
            catalog.addItem(new FoodItem("Чебупицца", 99.90f, (short) 90));
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        TechnicalItem technicalItem = new TechnicalItem();
        technicalItem.setName("Мультиварка");
        technicalItem.setPrice(5999.99f);
        technicalItem.setWarrantyTime((short) 365);
        technicalItem.setCategory(Category.GENERAL);

        try {
            catalog.addItem(technicalItem);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            FoodItem foodItem = (FoodItem) catalog.findItemByID(3).clone();
            foodItem.setName("Круггетсы");
            catalog.addItem(foodItem);
        } catch (CloneNotSupportedException e) {
            System.out.println("Ошибка при клонировании объекта");
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        String line = "Конфеты ’Маска’;45;120";
        String[] itemFields = line.split(";");

        try {
            catalog.addItem(new FoodItem(
                    itemFields[0],
                    Float.parseFloat(itemFields[1]),
                    Short.parseShort(itemFields[2])
            ));
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        long begin = new Date().getTime();
        for (int i = 0; i < 100000; i++)
            catalog.findItemByID(7);
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++)
            catalog.findItemByIDAL(7);
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        // Default methods
        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(catalog);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        catalog.printItems();
    }
}
