package StockListProject.billing.exceptions;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException() {
        super("Item already exists in catalog");
    }

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
