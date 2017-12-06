

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberWriter {

    public static void main(String[] args) {
        Member m1 = new Member("I123","Robin","Cook",50);
        Member m2 = new Member ("I345", "Rachel", "Cain", 40);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream ("memberBi.dat"));
            os.writeObject(m1);
            os.writeObject(m2);
            os.writeObject("Hello");
            os.writeObject(m1);
            os.close();
        } catch (IOException e) {
            System.out.println ("Error Writing file:" + e.getMessage());
        }
        
        ArrayList<Member> members = new ArrayList<Member>();
        try {           
            ObjectInputStream is = new ObjectInputStream (new FileInputStream ("memberBi.dat"));
            try{
                while (true){
                    try {
                        members.add((Member) is.readObject());
                    } catch (ClassNotFoundException|ClassCastException e) {
                        System.out.println ("Error: object is not member. Skipping");
                    }
                }
            }catch (EOFException eof){
                System.out.println ("Finish Reading");
            }           
        } catch (IOException e) {
            System.out.println ("Error Reading file:" + e.getMessage());
        }        
        for (Member m: members){
            System.out.println(m.toString());
        }
        System.out.println("------------------------------");
        members.get(0).setAge(80);
        System.out.println(members.get(2).toString());
    }

}
