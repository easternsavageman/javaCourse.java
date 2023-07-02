public class TwoThreads implements Runnable {

    private int theVar = 0;

    public void run() {}
    
    synchronized void setVar(int value) {
        try {
            while (theVar != 0) {
                notify();
                wait();
            }
        } catch (InterruptedException e) {}
            theVar = value;
            notify();
    }

    synchronized int readVal() {
        try {
            while (theVar == 0) {
                notify();
                wait();
            }
            } catch (InterruptedException e) { }

            int temp = theVar;
            theVar = 0;
            notify();
            System.out.println(temp);
            return temp;
}

    public static void main(String[] argv) 
    {
        Thread t1 = new Thread(new TwoThreads() { 
            public void run() {
                for(int i=1; i<11; i++) {
                    setVar(1);
            }
            }
        });
        
        Thread t2 = new Thread(new TwoThreads() {  
            public void run() {
                readVal();
            }
        });
 
        t2.start();
        t1.start();        
    }
}
