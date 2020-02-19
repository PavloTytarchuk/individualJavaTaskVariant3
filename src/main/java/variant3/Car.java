package variant3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car extends Vehicle {
    private String fuelType;

    public Car() {
    }

    public Car(String brand, String model, Date productionDate, String fuelType) {
        super(brand, model, productionDate);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return super.toString() + " FuelType: " + fuelType + ";";
    }

    @Override
    public void input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter brand, model, date in format dd.MM.yyyy, and fuel type");
        try {
            setBrand(reader.readLine());
            setModel(reader.readLine());
            String date = reader.readLine();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            setProductionDate(format.parse(date));
            setFuelType(reader.readLine());
        } catch (IOException | ParseException e) {
            System.out.println("You've entered incorrect value, try again");
            input();
        }

    }

    @Override
    public void output() {
        super.output();
    }
}
