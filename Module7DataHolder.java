public class Module7DataHolder {
    
    private int theVar = 0;
    
    public synchronized void setVar(int value)  {
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
                } catch(InterruptedException e) {}
            }
        // data is now null
            theVar = value;
            notify();
            
    }

    public synchronized int readVal() {
   
            while (theVar == 0)
            {
                // no data to extract
                // wait for some to arrive
                // awaken one other waiting Thread
                
                notify(); 
                try {
                // release the monitor and go to sleep
                    wait(); 
                } catch(InterruptedException e) { }
            }
            // data is now not full
            int temp = theVar;
            theVar = 0;
            notify();
            return temp;
    }
}
