
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class WordCount {
	String sentence;
	public WordCount (String s){
		sentence = s;
	}
	public void showResult(){
		String words[] = sentence.split("\\s+|,\\s*");
		HashMap <String,Integer> freqMap = new HashMap<String,Integer>();
		for (String word:words){
			//System.out.println(word);
			Integer count = freqMap.get(word);
			if (count == null){
				//not exist yet
				freqMap.put(word,1);
			}else{
				//already exist
				freqMap.put(word, count+1);
			}
		}
//		for (Entry e:freqMap.entrySet()){
//			System.out.println(e.getKey() + " : " + e.getValue());
//		}
		String keys[] = freqMap.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		for (String key:keys){
			System.out.println(key + " : " + freqMap.get(key));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCount c = new WordCount("Says E, I’ll eat it fast, I will, Says F, I vow I’ll have my fill,"+
									"Says G, give it me good and great, Says H, a little bit I hate,"+
									"Says I, it’s ice I must request, Says J, the juice I love the best");
		c.showResult();
	}

}
