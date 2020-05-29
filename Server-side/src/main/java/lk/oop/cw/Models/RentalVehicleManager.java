package lk.oop.cw.Models;

public interface RentalVehicleManager {
    final static int MAX_PARKING_SLOT = 50;
    public abstract void addNewVehicle(Vehicle vehicle);
    public abstract void deleteVehicle(String plateNum);
    public abstract void printListOfVehicle();
    public abstract void writeOrSave();
}
