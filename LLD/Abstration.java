interface car{
    void startEngine();
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
}

class SportCar implements car{
    String brand;
    String model;
    boolean isEngineOn=false;
    int currentSpeed=0;
    int currentGear=0;

    public SportCar(String brand, String model){
        this.brand=brand;
        this.model=model;
    }
    @Override
    public void startEngine(){
        isEngineOn=true;
        System.out.println(brand+" "+model+": Engine Start With a Roar!");
    }
    @Override
    public void shiftGear(int gear){
        if(!isEngineOn){
            System.out.println(brand+" "+model+": Engine is off! cannot Shift Gear.");
            return;
        }
        this.currentGear=gear;
        System.out.println(brand+" "+model+" : shifted to gear"+ currentGear);
    }
    @Override
    public void accelerate(){
        if(!isEngineOn){
            System.out.println(brand+" "+model+": Engine is Off! Cannot Accelerate.");
            return;
        }
        currentSpeed+=20;
        System.out.println(brand+" "+model+" :Accelerating to "+currentSpeed+"km/h");
    }
    @Override
    public void brake(){
        currentSpeed =currentSpeed-20;
        if(currentSpeed<0) currentSpeed=0;   //Kadane Algorithm.
        System.out.println(brand+" "+model+"  Branking! Spped Is Now "+ currentSpeed+"km/h");
    }
    // @Override
    // public void stopEngine(){
    //     isEngineOn=false;
    //     currentGear=0;
    //     currentSpeed=0;
    //     System.out.println(brand+" "+model+": Engine turned off.");
    // }
    @Override
    public void stopEngine(){
        isEngineOn=false;
        currentGear=0;
        currentSpeed=0;
        System.out.println(brand+" "+model+" : Engine turned Off.");
        // return null;
    }
}

//Main Method

public class Abstration{
    public static void main(String []args){
        car myCar=new SportCar("Audi", "Mustang");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.brake();
        myCar.stopEngine();
    }
}