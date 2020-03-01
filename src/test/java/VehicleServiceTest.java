import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import variant3.VehicleCollection;
import variant3.VehicleService;

import java.io.IOException;


public class VehicleServiceTest {

    @Test(priority = 3, dataProvider = "DataForDeserializationTest", dataProviderClass = VehicleDataProvider.class)
    public void serializedAndDeserializedDataShouldBeTheSame(VehicleCollection vehicleCollectionToCheckWith) throws IOException {
        //arrange
        VehicleCollection expectedCollection = vehicleCollectionToCheckWith;
        //act
        VehicleCollection actualCollection = VehicleService.deserializeListFromXML("serializationTest.xml");
        //assert
        ReflectionAssert.assertReflectionEquals("Deserialization isn't working properly", expectedCollection, actualCollection);
    }
}