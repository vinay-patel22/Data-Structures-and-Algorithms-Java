import java.util.Arrays;

public class LS_Q2_Search_In_String {
    public static void main(String[] args) {
        String str = "Vinay";
        char target = 'y';
        System.out.println(search(str, target));
        System.out.println(Arrays.toString(str.toCharArray()));
    }

    public static boolean search(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }
        return false;

    }

    // This below code I copied and write beacuse i dont undersand at now .
    public static boolean search_Using_Array_In_String(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (char ch : str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }
        return false;

    }
}
