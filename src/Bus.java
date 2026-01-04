public class Bus extends Vehicle{
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice,int passengerCapacity){
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
        setServiceIntervalKm(5000);
    }
    @Override
    public double calculateInsuranceFee() {
        return getBasePrice()/15+((getAge(2026)>10)?getBasePrice()/20:0);
    }

    @Override
    public void performService() {
        System.out.println("Service performed on the bus with ID"+getId()+"\n");
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if(passengerCapacity >0){
            this.passengerCapacity = passengerCapacity;
        }
        else{
            throw new IllegalArgumentException("Passenger capacity cannot be less than 1\n");
        }
    }
    public int getPassengerCapacity(){
        return passengerCapacity;
    }
}
