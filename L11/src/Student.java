

public class Student {
    int studentId;
    String name;
    int score;
    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public Student(int studentId, String name, int score) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }  
}
