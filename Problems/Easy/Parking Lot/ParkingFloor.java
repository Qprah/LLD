import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    // Find first available spot of the given vehicle type
    public synchronized ParkingSpot getAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == type) {
                return spot;
            }
        }
        return null; // No available spot found
    }

    // Return the floor number
    public int getFloorNumber() {
        return floorNumber;
    }

    // Return all parking spots
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    // Return a list of available spot numbers for the given vehicle type
    public List<Integer> getAvailableSpots(VehicleType type) {
        List<Integer> available = new ArrayList<>();
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == type) {
                available.add(spot.getSpotNumber());
            }
        }
        return available;
    }
}
