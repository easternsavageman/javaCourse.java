public class Module7SetVar extends Thread {

    Module7DataHolder numbers;

    public Module7SetVar(Module7DataHolder numbers) {
        this.numbers = numbers;
        start();
    }

    public void run() {
         for(int i=1; i<11; i++) {
            try {
                sleep((int) (Math.random()*1000));
            } catch(InterruptedException e) {}
            
            numbers.setVar(i);
        }
    }
}
