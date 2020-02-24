import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import variant3.Car;
import variant3.Vehicle;
import variant3.VehicleCollection;
import variant3.VehicleService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VehicleServiceTest {
    @Test
    public void serializedAndDeserializedDataShouldBeTheSame() throws IOException {
        //arrange
        VehicleCollection expectedCollection = testData();
        //act
        VehicleService.serializeToXML(testData(), "serializationTest.xml");
        VehicleCollection actualCollection = VehicleService.deserializeListFromXML("serializationTest.xml");
        //assert
        ReflectionAssert.assertReflectionEquals("Deserialization isn't working properly", expectedCollection, actualCollection);
    }

    private static VehicleCollection testData() {
        VehicleCollection vehicleCollection = new VehicleCollection();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("LAZ", "ElectroLAZ", VehicleService.convertStringToDate("29.06.2017")));
        vehicles.add(new Vehicle("LAZ", "CityLAZ", VehicleService.convertStringToDate("19.02.2009")));
        vehicles.add(new Car("Toyota", "Corolla", VehicleService.convertStringToDate("21.12.2013"), "Petrol"));
        vehicles.add(new Car("Subaru", "Forester", VehicleService.convertStringToDate("31.12.2008"), "Petrol"));
        vehicles.add(new Car("Toyota", "Yaris", VehicleService.convertStringToDate("14.07.2005"), "Petrol"));

        vehicleCollection.setVehicleList(vehicles);
        return vehicleCollection;
    }


}
