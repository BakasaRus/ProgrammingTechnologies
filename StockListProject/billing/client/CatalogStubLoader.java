package StockListProject.billing.client;

import StockListProject.billing.exceptions.CatalogLoadException;
import StockListProject.billing.exceptions.ItemAlreadyExistsException;
import StockListProject.billing.stocklist.Category;
import StockListProject.billing.stocklist.FoodItem;
import StockListProject.billing.stocklist.GenericItem;
import StockListProject.billing.stocklist.ItemCatalog;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {
    public void load(ItemCatalog cat) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short)10);
        try {
            cat.addItem(item1);
            cat.addItem(item2);
        }
        catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e.getMessage());
        }
    }
}
