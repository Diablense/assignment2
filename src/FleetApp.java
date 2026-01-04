import java.util.ArrayList;
import java.util.Scanner;
public class FleetApp {
    ArrayList<Vehicle> vehicles;
    Scanner scanner;
    boolean isRunning;
    public void run(){
        isRunning=true;
        vehicles= new ArrayList<>();
        scanner = new Scanner(System.in);

        while(isRunning){
            printMenu();
            chooseOption();
            waitForResponse();
            clearConsole();
        }
    }

    private void printMenu(){
        System.out.println("Fleet Management System\n" +
                "1.Print all vehicles\n" +
                "2.Add new car\n" +
                "3.Add new bus\n" +
                "4.Show total yearly insurance fees\n" +
                "5.Show vehicles older than N years\n" +
                "6.Perform service for all vehicles\n" +
                "7.Quit\n");
    }
    private void clearConsole() {
        System.out.print("\n".repeat(100));
    }
    private void waitForResponse(){
        System.out.println("Type any number to proceed\n");
        scanner.nextInt();
    }
    private void chooseOption(){
        int option = scanner.nextInt();
        switch (option){
            case 1:
                printAllVehicles();
                break;
            case 2:
                addNewCar();
                break;
            case 3:
                addNewBus();
                break;
            case 4:
                totalInsuranceFees();
                break;
            case 5:
                allVehiclesOlder();
                break;
            case 6:
                performService();
                break;
            case 7:
                quit();
                break;
        }
    }
    private void printAllVehicles(){
        if(vehicles.size()==0){
            System.out.println("No vehicles in the fleet\n");
            return;
        }
        for(Vehicle vehicle:vehicles){
            System.out.println(vehicle.toString());
        }
    }
    private void addNewCar(){
        System.out.println("Please, input the model, year, base price and the number of doors");
        vehicles.add(new Car(scanner.next(),scanner.nextInt(),scanner.nextDouble(),scanner.nextInt()));
    }
    private void addNewBus(){
        System.out.println("Please, input the model, year, base price and the passenger capacity");
        vehicles.add(new Bus(scanner.next(),scanner.nextInt(),scanner.nextDouble(),scanner.nextInt()));
    }
    private void totalInsuranceFees(){
        double sum=0;
        for(Vehicle vehicle:vehicles){
            sum+= vehicle.calculateInsuranceFee();
        }
        System.out.println(sum);
    }
    private void allVehiclesOlder(){
        int minAge=scanner.nextInt();
        for(Vehicle vehicle:vehicles){
            if(vehicle.getAge(2026)>minAge){
                System.out.println(vehicle.toString());
            }
        }
    }
    private void performService(){
        for(Vehicle vehicle:vehicles){
            vehicle.performService();
        }
    }
    private void quit(){
        isRunning=false;
    }
}
