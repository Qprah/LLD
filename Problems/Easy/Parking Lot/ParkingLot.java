import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final String name;
    private final List<ParkingFloor> floors;

    public ParkingLot(String name, List<ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }

    // Try to park a vehicle in any available spot
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getAvailableSpot(vehicle.getType());
            if (spot != null) {
                return spot.park(vehicle);
            }
        }
        return false; // No spot available
    }

    // Unpark vehicle from a specific spot number on a specific floor
    public boolean unparkVehicle(int floorNumber, int spotNumber) {
        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                for (ParkingSpot spot : floor.getParkingSpots()) {
                    if (spot.getSpotNumber() == spotNumber && !spot.isAvailable()) {
                        spot.unpark();
                        return true;
                    }
                }
            }
        }
        return false; // Spot not found or already empty
    }

    // Get all available spots for a vehicle type across the entire parking lot
    public List<String> getAllAvailableSpots(VehicleType type) {
        List<String> available = new ArrayList<>();
        for (ParkingFloor floor : floors) {
            List<Integer> spots = floor.getAvailableSpots(type);
            for (int spotNum : spots) {
                available.add("Floor " + floor.getFloorNumber() + ", Spot " + spotNum);
            }
        }
        return available;
    }

    public String getName() {
        return name;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}
