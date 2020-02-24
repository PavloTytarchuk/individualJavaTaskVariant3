package variant3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Car", value = Car.class)
})
public class Vehicle {
    private String brand;
    private String model;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate productionDate;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, LocalDate productionDate) {
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

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            productionDate = LocalDate.parse(date, formatter);
        } catch (IOException e) {
            System.out.println("You've entered incorrect value, try again");
            input();
        }
    }

    public void output() {
        System.out.println(toString());
    }

    @JsonIgnore
    public int getAge() {
        return Period.between(productionDate, LocalDate.now()).getYears();
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
