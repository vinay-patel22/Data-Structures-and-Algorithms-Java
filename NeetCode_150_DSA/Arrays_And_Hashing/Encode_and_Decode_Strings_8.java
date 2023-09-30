package Arrays_And_Hashing;

import java.util.ArrayList;
import java.util.List;

public class Encode_and_Decode_Strings_8 {
    public static void main(String[] args) {
        Encode_and_Decode_Strings_8 solution = new Encode_and_Decode_Strings_8();

        // Example usage:
        List<String> inputList = new ArrayList<>();
        inputList.add("Hello");
        inputList.add("World");
        inputList.add("Java");

        // Encoding
        String encodedString = solution.encode(inputList);
        System.out.println("Encoded String: " + encodedString);

        // Decoding
        List<String> decodedList = solution.decode(encodedString);
        System.out.println("Decoded List: " + decodedList);
    }

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
