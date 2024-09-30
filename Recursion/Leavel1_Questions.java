public class Leavel1_Questions {
    public static void main(String[] args) {
//        fun(5);
//        funRev(7);
//        funBoth(5);
//        System.out.println(facto(5));
//        System.out.println(sum(50));
//        System.out.println(sumOfDigits(1342));
//        System.out.println(productOfDigits(1342));

//            reverseNumber_Method1(1234);
//        System.out.println(sum);
//        System.out.println(reverseNumber_Method2(1234));

//        System.out.println(palinNumber_method1(123));

//        System.out.println(countNumber_Zeros(30204,0));
//        System.out.println(count(123002530));

//        System.out.println(numberOfSteps(14));

    }
    static void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }
    static void funRev(int n){
        if(n==0){
            return;
        }
        funRev(n-1);
        System.out.println(n);
    }
    static void funBoth(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

    static int facto(int n){
//        if (n<2){
//            return 1;
//        }
        if (n<=1){
            return 1;
        }
        return n*facto(n-1);
    }
    static int sum(int n){
//        if (n<2){
//            return 1;
//        }
        if (n<=1){
            return 1;
        }
        return n+sum(n-1);
    }

    static int sumOfDigits(int n){
        if (n==0){
            return 0;
        }
//        Just Do below thing in the recursion code
//        int remainder;
//        remainder = n % 10;
//        n = n / 10;
        return (n%10)+sumOfDigits(n/10);
    }
    static int productOfDigits(int n){
        if (n%10 == n){
            return n;
        }
//
        return (n%10)*productOfDigits(n/10);
    }




    static int sum=0;
    static void reverseNumber_Method1(int n){
    if (n==0){
        return;
    }
    int renainder = n%10;
    sum = sum * 10 + renainder;
    reverseNumber_Method1(n/10);
    }

// Make Helper Function If You want to pass any extra arguments in original function...

    static int reverseNumber_Method2(int n){
        // sometimes you might need some additional variable in thr arguments
        //in this make another helper function
        int digits = (int)(Math.log10(n))+1;
        return helper(n,digits);
    }
     static int helper(int n, int digits) {
        if (n%10 == n){
            return n;

        }
        int rem = n %10;
        return rem * (int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
    }

    static boolean palinNumber_method1(int n){
        return n==reverseNumber_Method2(n);
    }



    // make int --> long or vice versa...
    static long count(long n){
        return countNumber_Zeros(n,0);
    }
    static long countNumber_Zeros(long n,long count){

        if (n==0){
            return count;
        }
        long rem = n % 10;
        if (rem == 0){
            return countNumber_Zeros(n/10,count+1);
        }
        return countNumber_Zeros(n/10,count);

    }



    // leetcode question
    public static int numberOfSteps(int num){
        return helper_here(num,0);
    }
    public static int helper_here(int num, int steps) {
        if (num == 0){
            return steps;
        }
        if (num % 2 == 0 ){
            return helper_here(num/2,steps+1);
        }
        return helper_here(num-1,steps+1);
    }
}
