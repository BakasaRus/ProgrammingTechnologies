package StockListProject.billing.exceptions;

public class CatalogLoadException extends Exception {
    public CatalogLoadException() {
        super("Error occurs during catalog loading");
    }

    public CatalogLoadException(String message) {
        super(message);
    }
}
