package variant3;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class VehicleCollection {
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Vehicle> vehicleList = new ArrayList<>();

    public VehicleCollection() {
    }

    public VehicleCollection(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<? extends Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
