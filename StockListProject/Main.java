package StockListProject;

import java.util.Date;

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

        FoodItem foodItem = new FoodItem();
        foodItem.ID = 4;
        foodItem.name = "Чебупели";
        foodItem.price = 119.90f;
        foodItem.category = Category.FOOD;
        foodItem.dateOfIncome = new Date();
        foodItem.expires = 90;

        FoodItem foodItem1 = new FoodItem();
        foodItem1.ID = 6;
        foodItem1.name = "Чебупицца";
        foodItem1.price = 99.90f;
        foodItem1.category = Category.FOOD;
        foodItem1.dateOfIncome = new Date();
        foodItem1.expires = 90;
        foodItem1.analog = foodItem;

        TechnicalItem technicalItem = new TechnicalItem();
        technicalItem.ID = 5;
        technicalItem.name = "Мультиварка";
        technicalItem.price = 5999.99f;
        technicalItem.warrantyTime = 365;
        technicalItem.category = Category.GENERAL;

        GenericItem[] items = {item1, item2, item3, foodItem, technicalItem, foodItem1};
        for (GenericItem item : items) {
            item.printAll();
            System.out.println(item);
            System.out.println();
        }

        System.out.println(foodItem.equals(foodItem1));

        try {
            FoodItem foodItem2 = (FoodItem) foodItem1.clone();
            System.out.println(foodItem1.equals(foodItem2));

            foodItem2.analog.ID = 7;
            foodItem2.analog.name = "Круггетсы";
            foodItem2.analog.printAll();
            System.out.println(foodItem1.equals(foodItem2));
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
