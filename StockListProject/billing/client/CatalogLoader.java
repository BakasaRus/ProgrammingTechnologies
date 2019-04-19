package StockListProject.billing.client;

import StockListProject.billing.exceptions.CatalogLoadException;
import StockListProject.billing.stocklist.ItemCatalog;

public interface CatalogLoader {
    void load(ItemCatalog cat) throws CatalogLoadException;
}
