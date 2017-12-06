

import java.util.HashSet;
import java.util.Set;

public class TestHashSet2 {

    /**
     *
     * @param args
     */
    private static void printSet(HashSet <Student> set){
        for (Student s: set){
            System.out.println ("\t" + s.getStudentId() + " " + s.getName());
        }
    }
    public static void main(String[] args) {
        Student s = new Student (2152,"Taylor Swift", 90);
        HashSet<Student> studentSet = new HashSet<Student>();
        
        studentSet.add(new Student (2151,"James Dean", 89));
        studentSet.add(new Student (2151,"James Dean", 89));
        studentSet.add( s);
        studentSet.add( s);
        studentSet.add( new Student (2153,"Harry Potter", 70));
        studentSet.add( new Student (2151,"Jack Daniel", 50));
        printSet(studentSet);       
    }

}
