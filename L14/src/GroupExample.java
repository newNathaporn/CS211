

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupExample {

	public static void main(String[] args) {
		String pattern = "([a-zA-Z]*)([0-9]+)|([A-Z]{3})";
		
		Pattern pat = Pattern.compile(pattern);
		Matcher matcher = pat.matcher("AAA");
		if (matcher.matches()){
			System.out.println("Group 0 " + matcher.group(0));
			System.out.println("Group 1 " + matcher.group(1));
			System.out.println("Group 2 " + matcher.group(2));
			System.out.println("Group 3 " + matcher.group(3));
		}

	}

}
