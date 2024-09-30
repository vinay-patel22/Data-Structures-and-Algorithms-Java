// Maze question are important for Google / Amazon ..etc
public class Level1_Backtracking_Intro {
    public static void main(String[] args) {
//        System.out.println(mazePathCount_Q1(3,3));
        mazePathReturn("",3,3);

    }
//    what we are doing ?  How are we doing?


//    Q1 :- Online go right and down
    static int mazePathCount_Q1(int r,int c){
        if (r == 1 || c == 1){
            return 1;
        }
        int left = mazePathCount_Q1(r-1,c);
        int right = mazePathCount_Q1(r,c-1);

        return left+right;
    }

//    Q1   Modify We just return the answer list..
//    InitiallyEmpt == p(Processed String )
    static void mazePathReturn(String InitiallyEmpt,int r,int c){
        if (r == 1 && c== 1){
            System.out.println(InitiallyEmpt);
            return;
        }
        if (r>1){
            mazePathReturn(InitiallyEmpt+'d',r-1,c);
        }
        if (c>1){
            mazePathReturn(InitiallyEmpt+'r',r,c-1);
        }
    }
}
