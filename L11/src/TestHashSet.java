

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    private static void printSet(HashSet <String> set){
        System.out.println ("set has " + set.size());
        for (String s: set){
            System.out.println ("\t" + s);
        }
    }
    public static void main(String[] args) {
        HashSet <String> wordSet1 = new HashSet<String>();
        HashSet <String> wordSet2 = new HashSet<String>();

        wordSet1.add("street");
        wordSet1.add( "princess");
        System.out.println ("set1 has street  " + wordSet1.contains("street"));

        wordSet2.add("bed");
        wordSet2.add("bed");
        wordSet2.add("street");
        wordSet2.add("hair");
        
        System.out.println ("------ set1 -------------");
        printSet(wordSet1);
        System.out.println ("------ set2 -------------");
        printSet(wordSet2);
        System.out.println ("------ new set1 -------------");
        wordSet1.retainAll(wordSet2);
        printSet(wordSet1);
        

        

    }

}
