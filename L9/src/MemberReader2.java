
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberReader2 {
    ArrayList<Member> members;

    public MemberReader2() {
        members = new ArrayList<Member>();
    }

    public void loadMember(File memberFile) throws FileNotFoundException {
        members.clear();
//        Scanner scan = new Scanner(memberFile);
//        try {
//            while (scan.hasNext()) {
//                members.add(new Member(scan.next(), scan.next(), scan.next(),
//                        scan.nextInt()));
//            }
//        } catch (Excecption e) {
//
//        } finally {
//            scan.close();
//        }
      
      try (Scanner scan = new Scanner(memberFile)){
          while (scan.hasNext()) {
              members.add(new Member(scan.next(), scan.next(), scan.next(),
                      scan.nextInt()));
          }
      }
    }

    public String toString() {
        float aveAge = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        for (Member m : members) {
            sb.append(m.toString());
            aveAge += m.getAge();
        }
        sb.append(" average age = " + aveAge / members.size() + "<br/>");
        sb.append("</html>");
        return sb.toString();
    }
}
