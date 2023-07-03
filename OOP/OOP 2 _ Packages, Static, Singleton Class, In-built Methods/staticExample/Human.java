// Which propeties are not directly linked with object is known as static.

// common to all object of the class is known as static.

// It is accessed by class name as well as this keyword.

// common to all the object is known as static

// whenever you deal with static varibale whether you decaring or changeing or accesing--> then do not do it with reference varable (Object) it work but... convence is not ... RIGHT APPROACH IS use CLASS NAME ..

// static variable is not depednet on  the  object. It will work even if you do not creat object. --> Best example of this line is main method in java. where entire code is runing...


// static variable or methods or block.. anthing are run on the compile time.

package staticExample;

public class Human {

    int age;
    String name;
    int salary;
    boolean married;

    // long population; // static
    static long population; // static


    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;


        // this.population += 1;
        Human.population += 1;
    }

}
