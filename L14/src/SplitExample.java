
public class SplitExample {
	public static void main(String[] args) {
        String tester = "53;42 ;78 :33 ;40;  9: 4";
        String pattern = "\\s*[;:]\\s*";
        //String pattern = ";";
        //String [] split1 = tester.split(pattern);
        //String [] split2 = tester.split(pattern, 5);
        String [] split3 = tester.split(pattern, 0);
        System.out.println("Split with no limit");
        printArray(split3);
//        System.out.println("Split with limit = 3");
//        printArray(split2);
//        System.out.println("Split with limit = 0");
//        printArray(split3);

    }
    private static void printArray(String[] strings){
        for (String s:strings){
            System.out.println("-" + s + "-");
        }
        System.out.println("-------------------");
    }

}
