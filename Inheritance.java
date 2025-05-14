class car{
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;


    public car(String brand, String model){
        this.brand=brand;
        this.model=model;
        this.isEngineOn=false;
        this.currentSpeed=0;
    }
      // Common methods for all cars
    public void startEngine(){
        isEngineOn=true;
        System.out.println(brand+" "+model+": Engine Ignited.");
    }

    public void stopEngine(){
        isEngineOn=false;
        currentSpeed=0;
        System.out.println(brand+" "+model+": Engine turned Off.");
    }
    public void accelerate(){
        if(!isEngineOn){
            System.out.println(brand+" "+model+": Cannot Accelerate! Engine Is Off.");
        }else{
            currentSpeed +=20;
            System.out.println(brand+" "+model+": Accelerating to "+ currentSpeed +"km/h");
        }
    }
    public void brake(){
        currentSpeed -=20;
        if(currentSpeed <0) currentSpeed=0;
        System.out.println(brand+" "+model+": breaking! Speed is Now "+currentSpeed+"km/h");
    }
}

class ManualCar extends car{    // Inherits from Car
    private int currentGear;  //spcific to Manual Car.
    public ManualCar(String brand, String model){
        super(brand, model);
        this.currentGear=0;
    }
    // Specialized method for Manual Car
    public void shiftGear(int gear){
        this.currentGear=gear;
        System.out.println(brand+" "+model+": Shifted to gear"+ currentGear);
    }
}

class ElectricCar extends car{    // Inherits from Car
    private int batteryLevel;  //spcific to ElectricCar Car.
    public ElectricCar(String brand, String model){
        super(brand,model);
        this.batteryLevel=100;
    }
    // Specialized method for Electric Car
    public void chargeBattery(){
        batteryLevel=100;
        System.out.println(brand+" "+model+": Battery Fully Charged!");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        
        ManualCar myManualCar=new ManualCar("Suzuki", "G-Wagon");
        myManualCar.startEngine();
        myManualCar.shiftGear(1); // Specific to Manual Car
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("-----------------------------------");

        ElectricCar myElectricCar=new ElectricCar("Tesla", "Model S");
        myElectricCar.chargeBattery(); // Specific to Electric Car
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}



/*
We know that real world Objects show inheritance relationship where we
have parent object and child object. child object have all the characters
or behaviours that parent have plus some additional characters/behaviours.
Like all cars in real world have a brand, model etc and can start, stop, 
accelerate etc. But some specific cars like manual car have gear System
while other specific cars like Electric cars have battery system.

We represent this scenario of real world in programming by creating a parent class and
defining all the characters(variables) or behaviours(methods) that all cars 
have in parent class. Then we create different child classes that inherits 
from this parent class and define only those characters and behaviours
that are specific to them. Although objects of these child classes can 
access or call parent class characters(variables) and behaviours(methods).
Hence providing code reusability.
*/

