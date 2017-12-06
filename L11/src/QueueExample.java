
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue <String> data = new LinkedList<String>();
		LinkedList <String> data2 = new LinkedList<String>();
		
		data.offer("cat");
		data.offer("pig");
		data.offer("penguin");
		while (data.isEmpty() == false){
			System.out.println(data.poll());
		}
		
	}

}
