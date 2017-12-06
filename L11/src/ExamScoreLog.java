

import java.util.PriorityQueue;

public class ExamScoreLog {
    PriorityQueue <Student3> studentQueue;
    public ExamScoreLog (){
        studentQueue = new PriorityQueue <Student3>();
    }
    
    public void addStudent(Student3 s){
        studentQueue.offer(s);
    }
    public Student3 getNextHighScore(){
        return studentQueue.poll();
    }
    public Student3 peek(){
        return studentQueue.peek();
    }

    public static void main(String[] args) {
        ExamScoreLog examLog = new ExamScoreLog();
        examLog.addStudent(new Student3 (2151,"James Dean", 89));
        examLog.addStudent(new Student3 (2152,"James Morris", 70));
        examLog.addStudent( new Student3 (2153,"Harry Potter", 70));
        examLog.addStudent( new Student3 (2154,"Jack Daniel", 50));
        
        while (examLog.peek() != null){
            System.out.println (examLog.getNextHighScore().toString());
        }
    }
}
