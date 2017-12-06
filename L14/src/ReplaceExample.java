
public class ReplaceExample {
    public static void main(String[] args) {
        String names = "Obama aAladin Shisuka"; 
        String patterns = "^a|i";
        String newNames = names.replaceFirst(patterns, "E");
        System.out.println("After replace first with E:" + newNames);
        newNames = names.replaceAll(patterns, "E");
        System.out.println("After replace All with E:" + newNames);
        
    }

}
