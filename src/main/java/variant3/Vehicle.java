package variant3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Car", value = Car.class)
})
public class Vehicle {
    private String brand;
    private String model;
    private Date productionDate;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, Date productionDate) {
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "; Model: " + model + "; ProductionDate: " + productionDate + ";";
    }

    public void input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter brand, model, and date in format dd.MM.yyyy");
        try {
            brand = reader.readLine();
            model = reader.readLine();
            String date = reader.readLine();
            productionDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (IOException | ParseException e) {
            System.out.println("You've entered incorrect value, try again");
            input();
        }
    }

    public void output() {
        System.out.println(toString());
    }

    @JsonIgnore
    public int getAge() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String[] productionDateArray = format.format(productionDate).split("\\.");
        String[] currentDateArray = format.format(new Date()).split("\\.");

        int fullYears = Integer.parseInt(currentDateArray[2]) - Integer.parseInt(productionDateArray[2]);
        if (Integer.parseInt(currentDateArray[1]) - Integer.parseInt(productionDateArray[1]) < 0) {
            fullYears = fullYears - 1;
        } else if (Integer.parseInt(currentDateArray[1]) - Integer.parseInt(productionDateArray[1]) == 0 && Integer.parseInt(currentDateArray[0]) - Integer.parseInt(productionDateArray[0]) < 0) {
            fullYears = fullYears - 1;
        }
        return fullYears;
    }

    public void vehicleMoreThan10YearsOld(List<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getAge() > 10) {
                vehicle.output();
            }
        }
    }

    public static List<Vehicle> sortVehicles(List<Vehicle> vehicles) {
        return vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getModel))
                .peek(Vehicle::output)
                .collect(Collectors.toList());
    }
}
