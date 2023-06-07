// Buniowski Module 2 Programming Assignment

// put this at the very top of your file: 
import java.io.*;

public class StringSort {
    // change the first line of main to look like this 
    public static void main(String [] argv) throws IOException
    {
        // then, in your main() function:
        BufferedReader stdin =
        new BufferedReader(new InputStreamReader(System.in), 1);
        // then, to get a line of user input
        System.out.println("How many strings do you want to read?");
        // ... or to read an integer 
        int numString = Integer.parseInt(stdin.readLine());
        // getting the string
        String [] myArray = new String[numString];
        for (int i=0; i<numString; i++) {
            System.out.println("Please enter string: ");
            //as a string: 
            String theString = stdin.readLine();
            myArray[i] = theString;
        }
        for (int k=0; k<numString; k++) {
            for (int j=0; j<(numString-1); j++) {
                String right = myArray[j+1];
                String left = myArray[j];
                if (right.compareTo(left)<0) {
                    myArray[j] = right;
                    myArray[j+1] = left;
                }
            }
        }
        // print the strings alphabetically
        for (int k=0; k<numString; k++) {
            System.out.println(myArray[k]);
        }
    }
}
