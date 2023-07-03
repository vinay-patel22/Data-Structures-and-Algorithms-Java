package staticExample;

// outside classes can not be static.

// static public class InnerClasses {
//     class Test{

//     }
// }

public class InnerClasses {

    // Without static it will give error.

    // class Test {
    //     String name;

    //     public Test(String name) {
    //         this.name = name;
    //     }
    // }
    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Vinay");
        Test b = new Test("Patel");

        System.out.println(a);
    }
}
