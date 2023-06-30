// Part 2

import java.io.IOException;

public class Balloon {
    
    final private static int maxinflation = 10;
    private int inflationPressure = 0;

    public void inflate() throws IOException {
        if (inflationPressure > (maxinflation-1)) {
            System.out.println("the balloon has popped!");
        } else {
            ++ inflationPressure;
            System.out.println(inflationPressure);
        }
    }

    public static void main(String[] argv) throws IOException 
    {
        Balloon red = new Balloon();
        for (int i = 0; i < 6; i++) {
        red.inflate();
        }
    }
}
