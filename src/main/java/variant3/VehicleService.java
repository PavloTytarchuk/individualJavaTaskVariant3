package variant3;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
    public static void main(String[] args) throws IOException {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.input();
        vehicle1.output();
        System.out.println("Vehicles full years: " + vehicle1.getAge());
        System.out.println();
        Car car = new Car();
        car.input();
        car.output();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("LAZ", "ElectroLAZ", convertStringToDate("29.06.2017")));
        vehicles.add(new Vehicle("LAZ", "CityLAZ", convertStringToDate("19.02.2009")));
        vehicles.add(new Car("Toyota", "Corolla", convertStringToDate("21.12.2013"), "Petrol"));
        vehicles.add(new Car("Subaru", "Forester", convertStringToDate("31.12.2008"), "Petrol"));
        vehicles.add(new Car("Ford", "Kuga", convertStringToDate("23.11.2017"), "Diesel"));
        vehicles.add(new Car("Audi", "A1", convertStringToDate("27.12.2015"), "Diesel"));
        vehicles.add(new Car("Volkswagen", "Golf", convertStringToDate("06.12.2019"), "Petrol"));
        vehicles.add(new Car("Volga", "Pobeda", convertStringToDate("02.03.1975"), "Petrol"));

        isVehicleMoreThan10YearsOld(vehicles);
        System.out.println();
        System.out.println("Sorted vehicles list:");
        vehicles = sortVehicles(vehicles);
        for (Vehicle v : vehicles) {
            v.output();
        }

        System.out.println();
        writeToFile(vehicles, "VehiclesList");
        VehicleCollection vehicleCollection = new VehicleCollection(vehicles);
        serializeToXML(vehicleCollection, "serialized.xml");

        vehicleCollection = deserializeListFromXML("serialized.xml");
        for (int i = 0; i < vehicleCollection.getVehicleList().size(); i++) {
            System.out.print("Deserialized vehicle: ");
            System.out.println(vehicleCollection.getVehicleList().get(i));
        }
    }

    public static LocalDate convertStringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static void isVehicleMoreThan10YearsOld(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAge() > 10) {
                System.out.print("Vehicle older than 10 years: ");
                vehicle.output();
            }
        }
    }

    public static List<Vehicle> sortVehicles(List<Vehicle> vehicles) {
        return vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getModel))
                .collect(Collectors.toList());
    }

    public static void writeToFile(List<Vehicle> list, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(fileName));
            for (Object e : list) {
                writer.println(e.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("You've entered incorrect FileName, try again");
            writeToFile(list, fileName);
        }
    }

    public static void serializeToXML(VehicleCollection vehicles, String fileName) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static VehicleCollection deserializeListFromXML(String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(fileName), VehicleCollection.class);
    }
}