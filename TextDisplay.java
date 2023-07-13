import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



public class TextDisplay {


    public static void main(String[] argv) throws IOException {
        new TextDisplay().readUrlLines("https://en.wikipedia.org/wiki/Warsaw", -5);
    }

    private void readUrlLines(String urlString, int lines) throws IOException {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException mue) {
            System.err.println("xxx");
            return;
        }
        BufferedReader br;
        List<String> allLines;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            allLines = br.lines().toList();
        } catch (IOException ioe) {
            System.err.println("yyy");
            return;
        }
        if (lines == 0) {
            for (String line : allLines) {
                System.out.println(line);
            }
        } else if (lines > 0) {
            for (int i = 0; i < lines && i < allLines.size(); i++) {
                System.out.println(allLines.get(i));
            }
        } else {
            int startIndex = allLines.size() > Math.abs(lines) ? allLines.size() + lines : 0;
            for (int i = startIndex; i < allLines.size(); i++) {
                System.out.println(allLines.get(i));
            }
        }
        br.close();
    }
}
