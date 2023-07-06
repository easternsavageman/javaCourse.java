public class Module7TwoThreads {
    public static void main(String[] argv) 
    {
        Module7DataHolder numbers = new Module7DataHolder();

        Thread sett1 = new Module7SetVar(numbers); 
        Thread readt2 = new Module7ReadVal(numbers);
    }
}
