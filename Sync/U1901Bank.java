package Sync;

public class U1901Bank {
    private int to = 0;
    private int from = 220;

    public synchronized void calc(int transaction, long timeout) {
        System.out.println(
            "Before: Thread = " + Thread.currentThread().getName() +
            ", To = " + to +
            ", From = " + from
        );
        from -= transaction;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        to += transaction;
        System.out.println(
            "After: Thread = " + Thread.currentThread().getName() +
            ", To = " + to +
            ", From = " + from
        );
    }
}
