abstract class Vehicle implements Servicable{
    private int id;
    private static int idGen;
    private String model;
    private int year;
    private double basePrice;
    private int serviceIntervalKm;
    public Vehicle(String model, int year, double basePrice){
        setId();
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public void setServiceIntervalKm(int serviceIntervalKm){
        this.serviceIntervalKm = serviceIntervalKm;
    }

    @Override
    public int getServiceIntervalKm() {
        return serviceIntervalKm;
    }


    public void setId(){
        id=idGen++;
    }
    public int getId(){
        return id;
    }
    public void setModel(String model){
        if(model.length()>0){
            this.model=model;
        }
        else{
            throw new IllegalArgumentException("Model name can not be blank\n");
        }
    }
    public String getModel(){
        return model;
    }
    public void setYear(int year){
        if(year>=1900 && year<=2026){
            this.year=year;
        }
        else{
            throw new IllegalArgumentException("Year must be within a reasonable range\n");
        }
    }
    public int getYear(){
        return year;
    }
    public void setBasePrice(double basePrice){
        if(basePrice>0){
            this.basePrice=basePrice;
        }
        else{
            throw new IllegalArgumentException("Base price must be larger than zero\n");
        }
    }
    public double getBasePrice(){
        return basePrice;
    }

    public int getAge(int currentYear){
        return currentYear-getYear();
    }
    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "ID: "+getId()+" Model: "+getModel()+" Year: "+getYear()+" basePrice: "+getBasePrice();
    }
}
