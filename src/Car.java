public class Car extends Vehicle{
    private int numberOfDoors;


    public Car(String model, int year, double basePrice, int numberOfDoors){
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
        setServiceIntervalKm(20000);
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice()/20+((getAge(2026)>10)?getBasePrice()/50:0);
    }

    public void performService(){
        System.out.println("Performed service on the car with ID"+getId()+"\n");
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if(numberOfDoors>0){
            this.numberOfDoors=numberOfDoors;
        }
        else{
            throw new IllegalArgumentException("Number of doors cannot be less than 1\n");
        }
    }
    public int getNumberOfDoors(){
        return numberOfDoors;
    }
}
