package StockListProject;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem("Рафаэлло", 249.90f, Category.FOOD);
        GenericItem item2 = new GenericItem("Милка", 119.90f, item1);
        GenericItem item3 = new GenericItem("Риттер Спорт", 99.90f, item2);

        FoodItem foodItem = new FoodItem("Чебупели", 119.90f, (short) 90);
        FoodItem foodItem1 = new FoodItem("Чебупицца", 99.90f, (short) 90);

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
            System.out.println(e.getMessage());
        }
    }
}
