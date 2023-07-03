// premetive data types should be also created using new keyword is known as wrapper class.

// In java only pass by value .

package OOP_KUNAL;

import javax.print.DocFlavor.STRING;

public class WrapperExample {
    public static void main(String[] args) {
        // int a = 10;
        // int b=20;
        // Integer num = new Integer(45);

        // Integer num = 45; //here num is like object
        // num.compare(a, a) // different method is available.

        Integer a = 10;
        Integer b=20;



        swap(a, b); // not swap
        System.out.println(a+" "+b);

        final A vinay = new A("Vinay");
        vinay.name = "other name";

        // when a non primitive is final,you cannot reassign it.
        // vinay = new A("new object");
        A obj;
        for (int i = 0; i < 100000000; i++) {
            obj = new A("Random name");
        }
    }
    static void swap(int a,int b){
            int temp = a;
            a = b;
            b = temp;
           
        }
        // below still not swap
        // because intenal implementation of Integr is the using final .
    static void swap(Integer a,Integer b){
            Integer temp = a;
            a = b;
            b = temp;
           
        }

}


class A{
    // final int num;
    // final variable always initialize while declaring.


    // If not premitive data type then it will be change..

    // final Student vinay = new Student(){
    //     vinay.name = "new name";
        // vinay = other object ( we can not do it)
    // }

    // In above example we can change the name;


    final int num = 10;
    String name;

    public A(String name){
        // System.out.println("Object is created");
        this.name = name;
    }
    
    @Override
    protected void finalize() throws Throwable {
       System.out.println("Object is destroyed");
    }
}
