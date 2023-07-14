import java.io.*;
import java.util.*;
import java.net.URL;

public class TextDisplay {

    public void readUrlLines(String urlString, int lines) throws IOException {
        
        URL u;
        try {
            u = new URL(urlString);
        } catch (IOException ioe1) {
            System.out.println("URL written incorrectly");
            return;
        }

        BufferedReader br;
        List<String> allLines = new ArrayList<String>();
        try {
            br = new BufferedReader(new InputStreamReader(u.openStream()));
            allLines = br.lines().toList();
        } catch (IOException ioe2) {
            System.out.println("Cannot connect to site");
            return;
        }

        if (lines == 0) {
            for (String line : allLines) {
                System.out.println(line);
            }
        } else if (lines > 0) {
            for (int i = 0; i < lines; i++) {
                System.out.println(allLines.get(i));
            }
        } else {
            int startLine = allLines.size() + lines;
            for (int i = startLine; i < allLines.size(); i++) {
                System.out.println(allLines.get(i));
            }
        }

    }
    
    public static void main(String[] argv) throws IOException {
        TextDisplay starWars = new TextDisplay();
        starWars.readUrlLines("https://en.wikipedia.org/wiki/Star_Wars", 5);
        starWars.readUrlLines("https://en.wikipedia.org/wiki/Star_Wars", 0);
        starWars.readUrlLines("https://en.wikipedia.org/wiki/Star_Wars", -5);
    }
}
