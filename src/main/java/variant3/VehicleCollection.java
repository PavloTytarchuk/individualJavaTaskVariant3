package variant3;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleCollection)) return false;
        VehicleCollection that = (VehicleCollection) o;
        return Objects.equals(vehicleList, that.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleList);
    }
}
