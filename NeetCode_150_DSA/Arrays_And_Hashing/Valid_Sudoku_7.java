package Arrays_And_Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Valid_Sudoku_7 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                char num = board[r][c];
                if (rows.containsKey(r) && rows.get(r).contains(num) ||
                        cols.containsKey(c) && cols.get(c).contains(num) ||
                        squares.containsKey((r / 3) * 3 + c / 3) && squares.get((r / 3) * 3 + c / 3).contains(num)) {
                    return false;
                }

                rows.computeIfAbsent(r, k -> new HashSet<>()).add(num);
                cols.computeIfAbsent(c, k -> new HashSet<>()).add(num);
                squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(num);
            }
        }

        return true;
    }
}
