

public class Student2 {
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
    public Student2(int studentId, String name, int score) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Student2)){
            return false;
        }
        return this.studentId == ((Student2)o).studentId;
    }
    @Override
    public int hashCode() {
        return studentId ;
    }  
}
