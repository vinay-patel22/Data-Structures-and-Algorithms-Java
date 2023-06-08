// Never Asked by product based company like ( MAANG ) .
// Sometimes Asked by service based company.

// Patterns ----> (Nested Loops)

// Trick to solve any pattern question

// 1) for the outer loop , count the number of lines.

// 2) for the inner loop , focus on the colums & connent them somehow to the rows. 

// 3) print "*" inside the inner for loop.

// 4) Observe symmetry [ Optimal ]



class Patterns {
    public static void main(String[] args) {
        // pattern1(5);;
        // pattern2(5);;
        // pattern3(5);
        // pattern4(5);
        // pattern5(5);
        // pattern6(5);
        // pattern7(5);
        // pattern8(5);
        // pattern9(5);
        // pattern10(5);
        // pattern11(5);
        // pattern12(5);
        // pattern13(5);
        // pattern14(5);
        // pattern15(5);
        // pattern16(5);
        // pattern17(5);
        // pattern18(5);
        // pattern19(5);
        // pattern20(5);
        // pattern21(5);
        // pattern22(4);

    }

    public static void pattern1(int n) {
        // *****
        // *****
        // *****
        // *****
        // *****
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        // *
        // **
        // ***
        // ****
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        // 1
        // 12
        // 123
        // 1234
        // 12345
        // 123456
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        // 1
        // 22
        // 333
        // 4444
        // 55555
        // 666666
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        // ******
        // *****
        // ****
        // ***
        // **
        // *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {

        // 12345
        // 1234
        // 123
        // 12
        // 1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        // *
        // ***
        // *****
        // *******
        // *********

        // space , star , space ( This is how we break our code)
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");

            }
            // space
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {

        // *********
        // *******
        // *****
        // ***
        // *

        // space , star , space ( This is how we break our code)
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");

            }
            // space
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Pattern 9

    // *
    // ***
    // *****
    // *******
    // *********
    // *********
    // *******
    // *****
    // ***
    // *

    // Just run pattern(7) and pattern(8) combine in the main code.

    public static void pattern10(int n) {

        // *
        // **
        // ***
        // ****
        // *****
        // ****
        // ***
        // **
        // *

        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i; // This is logic for print reverse triangle after 5 star printing.
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {

        // 1
        // 01
        // 101
        // 0101
        // 10101

        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start; // This is for fliping number( 1->0 & 0->1 )
            }
            System.out.println();
        }
    }

    public static void pattern12(int n) {

        // 1        1
        // 12      21
        // 123    321
        // 1234  4321
        // 1234554321

        int space = 2 * (n - 1);
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
            space -= 2;
        }
    }

    public static void pattern13(int n){

        // 1
        // 23
        // 456
        // 78910
        // 1112131415

        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num);
                num = num + 1;
            }
            System.out.println();
        }
    }

    public static void pattern14(int n){

    // A
    // AB        
    // ABC       
    // ABCD      
    // ABCDE  

        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A'+i; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }
    public static void pattern15(int n){

        // ABCDE
        // ABCD 
        // ABC  
        // AB   
        // A  

        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A'+(n-i-1); ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }
  
    public static void pattern16(int n){

        // A
        // BB
        // CCC
        // DDDD
        // EEEEE

        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }
    
    public static void pattern17(int n){

    //      A    
    //     ABA
    //    ABCBA
    //   ABCDCBA
    //  ABCDEDCBA

        for (int i = 0; i < n; i++) {
            // space
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            // star
            char ch = 'A';
            int breakpoint = (2*i+1)/2;
            for(int j=1;j<=2*i + 1;j++){
                System.out.print(ch);
                // ch++;
                if(j<=breakpoint)ch++;
                else ch--;
            }
            // space
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }

    }
   
    public static void pattern18(int n){

        // E
        // DE
        // CDE
        // BCDE
        // ABCDE

        for (int i = 0; i < n; i++) {
            for(char ch=(char) ('E'-i);ch<='E';ch++){
                System.out.print(ch);
            }
            System.out.println();
        }

    }
 
    public static void pattern19(int n){

        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********

        int iniSpace=0;
       for (int i = 0; i < n; i++) {
        // star
        for(int j=1;j<=n-i;j++){
            System.out.print("*");
        }
        // space
        for(int j=0;j<iniSpace;j++){
            System.out.print(" ");
        }
        // star
        for(int j=1;j<=n-i;j++){
            System.out.print("*");
        }
        iniSpace += 2;
        System.out.println();
       }


        iniSpace=2*n -2;
       for(int i=1;i<=n;i++){
        // star
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        // space
        for(int j=0;j<iniSpace;j++){
            System.out.print(" ");
        }
        // star
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        iniSpace -= 2;
        System.out.println();
        
    }
    }

    public static void pattern22(int n) {

        // 4444444
        // 4333334
        // 4322234
        // 4321234
        // 4322234
        // 4333334
        // 4444444

        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                int top=i;
                int left = j;
                int right = (2*n- 2) -j;
                int down = (2*n -2) - i;
                System.out.print(n-Math.min(Math.min(top, down),Math.min(left, right)));
            }
            System.out.println();
        }
    }

public static void pattern21(int n) {

            // *****
            // *   *
            // *   *
            // *   *
            // *****

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j == 0|| i== n-1 || j==n-1){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();
        }

    }

public static void pattern20(int n) {

    // *        *
    // **      **
    // ***    ***
    // ****  ****
    // **********
    // ****  ****
    // ***    ***
    // **      **
    // *        *


    int spaces = 2*n - 2;
    for (int i = 1; i <=2*n-1; i++) {
        int star = i;
        if(i>n) star = 2*n -i;
        for (int j = 1; j <= star; j++) {
            System.out.print("*");
        }
        for(int j=1;j<=spaces;j++){
            System.out.print(" ");
        }
        for (int j = 1; j <= star; j++) {
            System.out.print("*");
        }
        System.out.println();
        if(i<n) spaces -= 2;
        else spaces +=2;
    }
    }

}