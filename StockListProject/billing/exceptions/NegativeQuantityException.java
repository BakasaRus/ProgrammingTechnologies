package StockListProject.billing.exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException() {
        super("Warehouse has less items than requested");
    }

    public NegativeQuantityException(String message) {
        super(message);
    }
}
