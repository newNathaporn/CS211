

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group2 {
    public static void main(String args[]) {
        String pattern = " *([A-Z][a-z]+) *([A-Z][a-z]+) *;";
        String text = "John Smith; Eearl Gray  ; Harry Potter James Harriet; tim Cook; ";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        String newText = "";
        while (m.find()) {
            System.out.println("Found :" + text.substring(m.start(), m.end()) );
            newText = newText + m.group(2) + "," + m.group(1)+":";
        }
        System.out.println("New Text:" + newText);
    }
}
