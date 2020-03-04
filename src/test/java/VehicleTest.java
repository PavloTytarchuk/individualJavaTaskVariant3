import org.testng.Assert;
import org.testng.annotations.Test;
import variant3.Vehicle;
import variant3.VehicleService;

import java.util.List;

public class VehicleTest {

    @Test(priority = 1, dataProvider = "DataForTestingVehicleAge", dataProviderClass = VehicleDataProvider.class)
    public void methodShouldShowFullYearsOfVehicle(Vehicle testVehicle, int expectedYears) {
        //arrange
        int expectedFullYears = expectedYears;
        //act
        int actualFullYears = testVehicle.getAge();
        //assert
        Assert.assertEquals(actualFullYears, expectedFullYears, "Expected and actual full years do not correspond");
    }

    @Test(priority = 2, dataProvider = "DataForSortingTest", dataProviderClass = VehicleDataProvider.class)
    public void methodShouldSortByBrandAndModel(List<Vehicle> testList, List<Vehicle> sortedList) {
        //arrange
        List<Vehicle> expectedResult = sortedList;
        //act
        List<Vehicle> actualResult = VehicleService.sortVehicles(testList);
        //assert
        Assert.assertEquals(actualResult, expectedResult, "Sorting doesn't work correct");
    }
}