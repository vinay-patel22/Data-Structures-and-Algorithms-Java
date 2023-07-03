package OOP_KUNAL;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[5];
        String[] names = new String[5];

        Student[] students = new Student[5];

        // just declaring
        // Student vinay;
        // System.out.println(Arrays.toString(students)); // Output is null

        // vinay = new Student();
        // here new keyword use it --> Dynamically allocate the memory and return a ref
        // to it.

        Student vinay = new Student(197, "VP", 90);

        // System.out.println(vinay); // give random value

        // vinay.rno =197;
        // vinay.name="Vinay Patel";
        // vinay.marks = 88.54f;

        // vinay.changeName("Patel");
        // vinay.greeting();

        System.out.println(vinay.rno); // by default 0
        System.out.println(vinay.name); // by default null
        System.out.println(vinay.marks); // by default 0.0

        // constructure is defined that what is happen when you creating object.
        System.out.println();
        Student random = new Student(vinay);
        System.out.println(random.name);
        System.out.println(random.marks);
        System.out.println(random.rno);

    }

}
// create a class

// Inside the object variable is known as instance variable.
class Student {
    int rno;
    String name;
    float marks = 90;

    // we need a way to add the value of the above properties object by objects.

    // we need one word to access every object.

    void greeting() {
        System.out.println("Hello ! my name is " + name);
    }

    void changeName(String newName) {
        // name = newName;
        this.name = newName;
    }

    Student(Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
    }

    Student() {
        // vinay.rno =197;
        // vinay.name="Vinay Patel";
        // vinay.marks = 88.54f;
        this.rno = 197;
        this.name = "Vinay Patel";
        this.marks = 88.54f;
        // replacing name with referance vaibale.(Simple meaning of this keyword)
    }

    // this keyword is simple means that is referance to the object.

    // here below aprit is object of student class and this is automatically take
    // name (Arput.rno,Arpit.name)

    // Student arpit = new Student(17,"Arpit")
    Student(int roll, String name, float marks) {
        this.rno = roll;
        this.name = name;
        this.marks = marks;
    }
    // Student(){

    // }
}

// premetive data type like int ,float are stored in stack memory only for more
// effeciency