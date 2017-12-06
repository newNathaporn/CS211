

public class Student3 implements Comparable<Student3>{
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
    public Student3(int studentId, String name, int score) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }
    public String toString (){
        return this.studentId + " " + this.name + " : " + this.score;
    }
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Student3)){
            return false;
        }
        return this.studentId == ((Student3)o).studentId;
    }
    @Override
    public int hashCode() {
        return studentId ;
    }

    @Override
    //Need to make it so that the higher the score the higher the priority
    public int compareTo(Student3 o) {
        //Negative if this is smaller than o, 0 if o is equal, positive if this is bigger than o.
        int result = 0;
        if (this.getScore() > o.getScore()){
            result = -1;
        }else if (this.getScore() < o.getScore()){
            result = 1;
        }
        return result ;
    }  
}
