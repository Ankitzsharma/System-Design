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

class ManualCar extends car{
    private int currentGear;
    public ManualCar(String brand, String model){
        super(brand, model);
        this.currentGear=0;
    }
    public void shiftGear(int gear){
        this.currentGear=gear;
        System.out.println(brand+" "+model+": Shifted to gear"+ currentGear);
    }
}

class ElectricCar extends car{
    private int batteryLevel;
    public ElectricCar(String brand, String model){
        super(brand,model);
        this.batteryLevel=100;
    }
    public void chargeBattery(){
        batteryLevel=100;
        System.out.println(brand+" "+model+": Battery Fully Charged!");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        
        ManualCar myManualCar=new ManualCar("Suzuki", "G-Wagon");
        myManualCar.startEngine();
        myManualCar.shiftGear(1); 
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("-----------------------------------");

        ElectricCar myElectricCar=new ElectricCar("Tesla", "Model S");
        myElectricCar.chargeBattery();
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}

