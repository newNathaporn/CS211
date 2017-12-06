
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberWriter2 {
    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList<Member>();
        members.add(new Member("I123","Robin","Cook",50));
        members.add(new Member("I345", "Rachel", "Cain", 40));     
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream ("memberBi.dat"));
            os.writeObject(members);
            os.close();
        } catch (IOException e) {
            System.out.println ("Error Writing file:" + e.getMessage());
        }
        
        ArrayList<Member> readMembers = null;
        try {           
            ObjectInputStream is = new ObjectInputStream (new FileInputStream ("memberBi.dat"));
            try{
                while (true){
                    try {
                        readMembers = (ArrayList<Member>) is.readObject();
                        for (Member m: readMembers){
                            System.out.println(m.toString());
                        }
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


    }

}
