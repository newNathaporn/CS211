
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherExample {
	
	public static void main(String ...strings ){
		String pattern = "[a-z]+";
		String text = "i love CS211 a lot ";
		String text2 = "kitty";
		Pattern patt = Pattern.compile(pattern);
		Matcher matcher = patt.matcher(text);
		//if (matcher.matches()){
		if (matcher.lookingAt()){
			System.out.println( "text matches");
		}else{
			System.out.println( "text does not matches");
		}
		matcher.reset();
		while (matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			System.out.println("Find at " + start + ":"+end + " val "+text.substring(start,end)  );
		}
		
		
	}
}
