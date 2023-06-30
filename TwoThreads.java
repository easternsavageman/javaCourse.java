public class TwoThreads {
    // public void run() {
    //     while (true) {
    //         move();
    //         animate();
    //     }
    // }
    int data = null;
    synchronized void setVar(int s) {
        try {
            while (data != null) {
                notify();
                wait();
            }
        } catch (InterruptedException e) {}
            data = s;
            notify();
        }
    synchronized int readVal() {
        try {
            while (data == null) {
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            
        }
        int temp = data;
        data = null;
        notify();
        return temp;
        }
}

// Thread t1 = new Thread(new TwoThreads()); t1.start();
// Thread t2 = new Thread(new TwoThreads()); t2.start();
