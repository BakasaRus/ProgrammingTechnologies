package Sync;

public class U1901Thread extends Thread {
    private U1901Bank bankWork;
    private int trans;
    private long sleep;

    public U1901Thread(U1901Bank bankWork, int trans, long sleep) {
        this.bankWork = bankWork;
        this.trans = trans;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        bankWork.calc(trans, sleep);
    }
}
