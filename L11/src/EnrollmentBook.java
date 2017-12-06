

import java.util.HashSet;

public class EnrollmentBook {

    HashSet<Student> studentSet = new HashSet<Student>();
    public boolean enroll(Student s){
        return this.studentSet.add(s);
    }
    public void printSet(){
        for (Student s: studentSet){
            System.out.println ("\t" + s.getStudentId() + " " + s.getName());
        }
    }
    public static void main(String[] args) {
        Student s = new Student (2152,"Taylor Swift", 90);
        EnrollmentBook book = new EnrollmentBook();
        
        book.enroll(new Student (2151,"James Dean", 89));
        book.enroll(new Student (2151,"James Dean", 89));
        book.enroll( s);
        book.enroll( s);
        book.enroll( new Student (2153,"Harry Potter", 70));
        book.enroll( new Student (2151,"Jack Daniel", 50));
        book.printSet();
    }
}
