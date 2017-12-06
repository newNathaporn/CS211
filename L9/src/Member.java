
import java.io.Serializable;

public class Member implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String memberId;
    private String name;
    private String lastName;
    private int age;
    
    public Member(String memberId, String name, String lastName, int age) {
        super();
        this.memberId = memberId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    public Member(String data) throws MemberErrorException {
        String info[] = data.split(" ");
        if (info.length < 4 ){
            throw new MemberErrorException("Error input: " + data);
        }
        this.memberId = info[0];
        this.name = info[1];
        this.lastName = info[2];
        this.age = Integer.valueOf(info[3]);
    }
    public String toString(){
        return "id: " + this.memberId + " <br/>" +
                " name = " + this.name + " " + this.lastName + "<br/>" +
                " age = " + age + "<br/>";
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
