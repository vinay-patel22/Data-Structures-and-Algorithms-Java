// You only want one instance of that class. 
// Only one object you want to allow.

public class Singleton {
    // In this class we creat only one object.

    // You should not allow anyone to creat constructor.
    
    private Singleton(){

    }
    private static Singleton instance;

    public static Singleton getInstance(){
        //  check whether 1 obj only is created or not
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
