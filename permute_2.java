import java.util.HashSet;
import java.util.Set;
 
public class permute {
 
    public static void main(String[] args) {
        String input = "aba";
        String input2 = "aab";
        String input3 = "abc";
 
        Set<String> set = new HashSet<String>();
 
        permutation(input, "", set);
        System.out.println(set);
        set.clear();
 
        permutation(input2, "", set);
        System.out.println(set);
        set.clear();
 
        permutation(input3, "", set);
        System.out.println(set);
    }
 
    private static void permutation(String input, String sofar, Set<String> set) {
        if (input.equals("")) {
            set.add(sofar);
        }
        for (int i = 0; i < input.length(); i++) {
            String newstring=input.substring(0,i)+input.substring(i+1);
            permutation(newstring, sofar + input.charAt(i), set);
        }
    }
 
}
