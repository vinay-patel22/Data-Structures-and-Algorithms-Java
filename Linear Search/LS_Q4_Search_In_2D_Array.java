import java.util.Arrays;

public class LS_Q4_Search_In_2D_Array {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 8, 9, 0 }
        };
        int target = 8;
        System.out.println(Arrays.toString(search2D(arr, target)));
    }
    
    static int[] search2D(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {

                    return new int[] { row, col };
                }
            }
        }

        return new int[] { -1, -1 };
    }
}
