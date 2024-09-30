import java.lang.reflect.Array;

public class Leavel7_Permutations {
    public static void main(String[] args) {
    permutations("","abc");
    }
    static void permutations(String initial,String given){
        if (given.isEmpty()){
            System.out.println(initial);
            return;
        }
        char firstChar = given.charAt(0);
        for(int i=0;i<=initial.length();i++){
            String firstString = initial.substring(0,i);
            String secondString = initial.substring(i,initial.length());
            permutations(firstString + firstChar+secondString,given.substring(1));
        }
    }

}
