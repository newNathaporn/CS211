

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MemberReader {
    ArrayList<Member> members;

    public MemberReader() {
        members = new ArrayList<Member>();
    }

    public void loadMember(File memberFile) throws FileNotFoundException {
        members.clear();
        BufferedReader reader = new BufferedReader(new FileReader(memberFile));
        try {
            String data = reader.readLine();
            while (data != null) {
                try {
                    members.add(new Member(data));
                } catch (MemberErrorException e) {
                    System.out.println ("Read Error:" + e.getMessage());
                }
                data = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error Reading File: skipping rest of file");
        }finally {
            
        }
        
    }
    public String toString(){
        float aveAge = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        for (Member m: members){
            sb.append(m.toString());
            aveAge += m.getAge();
        }
        sb.append(" average age = " + aveAge/members.size() + "<br/>");
        sb.append("</html>");
        return sb.toString();
    }
}
