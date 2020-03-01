import org.testng.annotations.DataProvider;
import variant3.Car;
import variant3.Vehicle;
import variant3.VehicleCollection;
import variant3.VehicleService;

import java.util.ArrayList;
import java.util.List;

public class VehicleDataProvider {

    @DataProvider(name = "DataForTestingVehicleAge")
    public Object[][] dataForTestingVehicleAge() {
        return new Object[][]{{new Vehicle("VAZ", "2109", VehicleService.convertStringToDate("20.08.2002")), 17}};
    }

    @DataProvider(name = "DataForSortingTest")
    public Object[][] ListsOfVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        vehicles.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        vehicles.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        vehicles.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        vehicles.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));

        List<Vehicle> correctlySortedList = new ArrayList<>();
        correctlySortedList.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        correctlySortedList.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        correctlySortedList.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        correctlySortedList.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        correctlySortedList.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));
        return new Object[][]{{vehicles, correctlySortedList}};
    }

    @DataProvider(name = "DataForDeserializationTest")
    public Object[][] dataForDeserializationTest() {
        VehicleCollection vehicleCollection = new VehicleCollection();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        vehicles.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        vehicles.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        vehicles.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        vehicles.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));

        vehicleCollection.setVehicleList(vehicles);
        return new Object[][]{{vehicleCollection}};
    }
}
