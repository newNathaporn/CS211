

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Anagram2 {
	private ArrayList<String> words= new ArrayList<String>() ;
	public void readData(){
		//read file and fill words arraylist
		try(Scanner scan = new Scanner(new File("word.txt"))){
			while (scan.hasNext()){
				words.add(scan.next());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			return;
		}
		
	}
	public void processData(){
		HashMap <String, HashSet<String>> anaMap = new HashMap <String, HashSet<String>>(); 
		for (String word:words){
			char keychars[] = word.toCharArray();
			Arrays.sort(keychars);
			String key = new String(keychars);
			HashSet<String> val =  anaMap.get(key);
			if (val == null){
				//anagram not exist yet
				//create arraylist and add it
				val = new HashSet<String>();
				anaMap.put(key,val);
				val.add(word);
			}else{
				//add word to list
				val.add(word);
			}
		}
		for (Entry e: anaMap.entrySet()){
			System.out.print(e.getKey() + " : ");
			for (String v: (HashSet<String>)e.getValue()){
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		Anagram2 a = new Anagram2();
		a.readData();
		a.processData();
	}

}
