package Interface;

public class Car implements Engine,Break {
    @Override
    public void brake(){
        System.out.println("I brake like a normal car");
    }

    @Override
    public void stop(){
        System.out.println("I stop like normal car");
    }

    @Override
    public void accelarate(){
        System.out.println("I accelarate like a normal car");
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
