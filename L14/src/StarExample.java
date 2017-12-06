

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarExample {
	  public static void main(String args[]) {
	        String pattern = ".*foo";
	        String text = "xfooxxxxxxfoo";
	        Pattern p = Pattern.compile(pattern);
	        Matcher m = p.matcher(text);
	        String newText = "";
	        while (m.find()) {
	            System.out.println("Found :" + text.substring(m.start(), m.end()) );
	        }
	    }

}
