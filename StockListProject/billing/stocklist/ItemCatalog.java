package StockListProject.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item) {
        catalog.put(item.ID, item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        //Если нет такого ID, возвращаем пустое значение
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.ID == id) return i;
        }
        return null;
    }
}
