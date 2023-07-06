import java.io.*;

public class TwoThreads extends Thread {
    
    private int theVar = 0;

    public void run() {
        for(int i=1; i<11; i++) {
            setVar(i);
        }
        System.out.println(temp);
    }
    
    synchronized void setVar(int value)  {
            while (theVar != 0)
            {
                // data already holds a string
                // wait for some other Thread 
                // to remove it!
                // awaken one other waiting Thread
                notify(); 
                try {
                // release the monitor
                wait(); 
                }
            
        catch (InterruptedException e) {}
            }
        // data is now null
            theVar = value;
            notify();
            
    } 

    synchronized int readVal() {
   
            while (theVar == 0)
            {
                // no data to extract
                // wait for some to arrive
                // awaken one other waiting Thread
                
                notify(); 
                try {
                // release the monitor and go to sleep
                wait(); 
                }
            
        catch (InterruptedException e) {}
            }
            // data is now not full
            int temp = theVar;
            theVar = 0;
            notify();
            return temp;
    }
    
    public static void main(String[] argv) 
    {
        TwoThreads numbers = new TwoThreads();

        Thread sett1 = new setVar(numbers); 
        // {
        //     public void run() {
        //         for(int i=1; i<11; i++) {
        //             numbers.setVar(i);
        //         }
        //     }
            
        // };
        
        Thread readt2 = new Thread(numbers);
        // {
        //     public void run() {
        //         numbers.readVal();
        //     }            
        // };
        
        readt2.start();
        sett1.start();
    }
}
