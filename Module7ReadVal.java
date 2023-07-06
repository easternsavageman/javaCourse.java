public class Module7ReadVal extends Thread{
    Module7DataHolder numbers;

    public Module7ReadVal(Module7DataHolder numbers) {
        this.numbers = numbers;
        start();
    }

    public void run() {

        int number;

         for(int i=1; i<11; i++) {
            try {
                sleep((int) (Math.random()*1000));
            } catch(InterruptedException e) {}

            number = numbers.readVal();
            System.out.println("the value being read is: " + number);
        }
    }
}
