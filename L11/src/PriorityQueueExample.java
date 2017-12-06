
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		String ani[] = {"bee","donky","penguin","cat","coala","pig","hourse","lion"};
		PriorityQueue<String> animals = new PriorityQueue<>();
		for (String animal:ani){
			animals.offer(animal);
		}
		
		while(!animals.isEmpty()){
			System.out.println(animals.poll());
		}
		
		int data[] = {2,4,15,8,100,20,3,4,2};
		PriorityQueue<Integer> pData = new PriorityQueue<>();
		for (int i:data){
			pData.offer(i);
		}
		while (!pData.isEmpty()){
			System.out.println(pData.poll());
		}
		System.out.println("--------------");
		PriorityQueue<Student> students = new PriorityQueue<>();
		students.offer(new Student(3,"Mary Jane",30));
		students.offer(new Student(4,"Jacky Jane",30));
		students.offer(new Student(5,"Janie Smith",60));
		students.offer(new Student(6,"Harry Kane",20));
		students.offer(new Student(7,"Bobby Andrey",80));
		while (!students.isEmpty()){
			System.out.println(students.poll());
		}
		
	}

}
