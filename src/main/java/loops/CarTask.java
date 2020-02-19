package loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarTask car1 = new CarTask("Sedan", Integer.parseInt(reader.readLine()), 1.4);
        CarTask car2 = new CarTask("Hatch", Integer.parseInt(reader.readLine()), 1.6);
        CarTask car3 = new CarTask("Coupe", Integer.parseInt(reader.readLine()), 1.8);
        CarTask car4 = new CarTask("Shootingbreak", Integer.parseInt(reader.readLine()), 2.0);

        List<CarTask> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car type is: " + cars.get(i).getType() + "; Year of production is: " + cars.get(i).getYearOfProduction()
                    + "; Engine capacity is: " + cars.get(i).getEngineCapacity());
        }
    }

    private String type;
    private int yearOfProduction;
    private double engineCapacity;

    public CarTask(String type, int yearOfProduction, double engineCapacity) {
        this.type = type;
        this.yearOfProduction = yearOfProduction;
        this.engineCapacity = engineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
