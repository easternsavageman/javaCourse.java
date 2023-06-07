// Module 2 Programming Assignment

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
        System.out.println(myArray);
        // read strings one at a time from input
        for (int i=0; i<numString; i++) {
            if (i==0){
                System.out.println("Please enter string: ");
                //as a string: 
                String theString = stdin.readLine();
                myArray[i] = theString;
            } else {
                // sort the strings alphabetically
                System.out.println("Please enter string: ");
                //as a string: 
                String theString = stdin.readLine();
                for (int j=numString-1; j==0; j--) {
                    if (theString.compareTo(myArray[j-1])<0) {
                        myArray[j] = myArray[j-1];
                        myArray[j-1] = theString;
                    } else {
                        myArray[j] = theString;
                    }
                }
            }
        }
        for (int k=numString; k<numString; k++) {
            System.out.println(myArray[k]); 
        }  
    }
}
