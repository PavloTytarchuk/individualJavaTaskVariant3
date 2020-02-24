import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import variant3.Car;
import variant3.Vehicle;
import variant3.VehicleService;

import java.util.ArrayList;
import java.util.List;

public class VehicleTest {
    private final Vehicle testVehicle = new Vehicle("VAZ", "2109", VehicleService.convertStringToDate("20.08.2002"));

    public VehicleTest() {
    }

    @Test
    public void methodShouldShowFullYearsOfVehicle() {
        int fullYears = 17;

        Assert.assertEquals(testVehicle.getAge(), fullYears);
    }

    @Test
    public void methodShouldSortByBrandAndModel() {
        List<Vehicle> sorted = Vehicle.sortVehicles(testVehicleList());

        ReflectionAssert.assertReflectionEquals(sorted, correctlySortedVehiclesList());
    }

    private static List<Vehicle> testVehicleList() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        vehicles.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        vehicles.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        vehicles.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        vehicles.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));
        return vehicles;
    }

    private static List<Vehicle> correctlySortedVehiclesList() {
        List<Vehicle> correctlySortedList = new ArrayList<>();
        correctlySortedList.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        correctlySortedList.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        correctlySortedList.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        correctlySortedList.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        correctlySortedList.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));
        return correctlySortedList;
    }
}