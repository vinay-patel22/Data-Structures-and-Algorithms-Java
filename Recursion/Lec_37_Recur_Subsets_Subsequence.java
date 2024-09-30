import java.util.*;
public class Lec_37_Recur_Subsets_Subsequence {
    public static final String []mapping = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits){
        List<String>ans = new ArrayList<>();
        if (digits.equals("") == true){
            return ans;
        }
        solve(digits,"",0,ans);
        return ans;

    }
//    Q1. Subset ( Power Set )
    static void solve(String digit,String output,int index,List<String>ans){
        // base case
        if (index >= digit.length()){
            ans.add(output);
            return;
        }
        String letters = mapping[digit.charAt(index) -'0'];
        for (int i=0;i<letters.length();i++){
            StringBuilder sb = new StringBuilder(output);
            sb.append(letters.charAt(i));
            solve(digit,sb.toString(),index+1,ans);
        }
    }
}
