class EvenPrinter implements Runnable {
    private final Object lock;

    public EvenPrinter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            synchronized (lock) {
                System.out.println(i);
                lock.notify();
                try {
                    if (i < 20) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class OddPrinter implements Runnable {
    private final Object lock;

    public OddPrinter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 19; i += 2) {
            synchronized (lock) {
                System.out.println(i);
                lock.notify();
                try {
                    if (i < 19) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class EvenOddPrinter {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread evenThread = new Thread(new EvenPrinter(lock));
        Thread oddThread = new Thread(new OddPrinter(lock));
        evenThread.start();
        oddThread.start();
    }
}
