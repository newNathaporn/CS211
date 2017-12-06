

import java.util.HashSet;
import java.util.Set;

public class TestHashSet3 {

    /**
     *
     * @param args
     */
    private static void printSet(HashSet <Student2> set){
        for (Student2 s: set){
            System.out.println ("\t" + s.getStudentId() + " " + s.getName());
        }
    }
    public static void main(String[] args) {
        Student2 s = new Student2 (2152,"Taylor Swift", 90);
        HashSet<Student2> studentSet = new HashSet<Student2>();
        
        studentSet.add(new Student2 (2151,"James Dean", 89));
        studentSet.add(new Student2 (2151,"James Dean", 89));
        studentSet.add( s);
        studentSet.add( s);
        studentSet.add( new Student2 (2153,"Harry Potter", 70));
        studentSet.add( new Student2 (2151,"Jack Daniel", 50));
        printSet(studentSet);       
    }

}
