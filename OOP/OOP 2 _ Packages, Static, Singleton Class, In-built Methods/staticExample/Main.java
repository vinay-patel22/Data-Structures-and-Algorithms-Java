// Inside the static method you can not use any method without static .

package staticExample;

import java.util.GregorianCalendar;

import javax.crypto.spec.GCMParameterSpec;

public class Main {
    public static void main(String[] args) {
        // Human vinay = new Human(22, "Vinay Patel", 50000, false);
        // Human sonu = new Human(22, "Sonu Patel", 60000, true);
        // Human Airpt = new Human(22, "Sonu Patel", 60000, true);

        // System.out.println(vinay.population);
        // System.out.println(sonu.population);
        // System.out.println(Airpt.population);
        
        // System.out.println(Human.population);
        // System.out.println(Human.population);
        // System.out.println(Human.population);

        // greeting(); //This is non-static 

        // fun();

        // this is not dependent on objects.
        static void fun(){
            // greeting(); //You cant use this because it requires on instance(object).
            // but the function you are using it in does not instance.

            // we can use it like below
            Main obj = new Main();
            obj.greeting();
        }
    }
    // we know that something which is not static, belongs to an object.
    void greeting(){
        // fun(); // we can use it.
        System.out.println("HEYY");
    }
    
}
