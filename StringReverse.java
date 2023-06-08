// Buniowski Module 3 Programming Assignment

public class StringReverse {
    static String reverse(String s) {
        final int sLength = s.length();
        if (sLength <= 1) {
            return s;
        } else {
            return s.charAt(sLength-1)+reverse(s.substring(0,sLength-1));
        }
    }

public static void main(String[] argv)   
{ 
    String stringReversed = reverse("perpendicular"); 
    System.out.println(stringReversed);
}  
}