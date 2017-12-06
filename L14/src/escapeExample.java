
public class escapeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "[a-zA-Z_$][\\w$]*\\[\\d+\\]";
		
		String word = "Says E, I’ll eat it fast, I will, Says F, I vow I’ll have my fill,"+
				"Says G, give it me good and great, Says H, a little bit I hate,"+
				"Says I, it’s ice I must request, Says J, the juice I love the best";
		String newWord = word.replaceAll("[\\,’]", " ");
		System.out.println(newWord);
		
		
	}

}
