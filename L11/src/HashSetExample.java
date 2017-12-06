
import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet <Integer> data = new HashSet<Integer>();
		data.add(2);
		data.add(3);
		data.add(2);
		data.add(4);
		
		System.out.println("size" + data.size());
		for (int i: data){
			System.out.println(i);
		}
		
		HashSet <String> sData = new HashSet<String>();
		sData.add(new String ("cat"));
		sData.add(new String ("Cat"));
		sData.add(new String ("dog"));
		sData.add(new String ("cat"));
		printSet(sData);
		
		HashSet <String> sData2 = new HashSet<String>();
		sData2.add(new String ("cat"));
		sData2.add(new String ("panda"));
		sData2.add(new String ("penguin"));
		
		sData.addAll(sData2);
		printSet (sData);
		
		if (sData.containsAll(sData2)){
			System.out.println("subset");
		}
		
		sData.retainAll(sData2);
		printSet (sData);
		
		HashSet<Students> stuSet = new HashSet<Students>();
		stuSet.add(new Students (2,"Mary Jane", 40));
		stuSet.add(new Students (2,"Maryxxxx Jane", 30));
		stuSet.add(new Students (3,"Jacky chan", 40));
		stuSet.add(new Students (4,"Jane Osborne", 50));
		System.out.println("student size" + stuSet.size());
		for (Students i: stuSet){
			System.out.println(i);
		}	


	}
	private static void printSet(HashSet<String> sData){
		System.out.println("s data size" + sData.size());
		for (String i: sData){
			System.out.println(i);
		}
	}

}
