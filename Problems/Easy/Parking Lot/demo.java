import java.util.*;

public class demo {
    public static void main(String[] args) {
        // Create parking spots
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot(1, VehicleType.CAR));
        floor1Spots.add(new ParkingSpot(2, VehicleType.BIKE));

        List<ParkingSpot> floor2Spots = new ArrayList<>();
        floor2Spots.add(new ParkingSpot(1, VehicleType.CAR));
        floor2Spots.add(new ParkingSpot(2, VehicleType.CAR));

        // Create floors
        ParkingFloor floor1 = new ParkingFloor(1, floor1Spots);
        ParkingFloor floor2 = new ParkingFloor(2, floor2Spots);

        // Create parking lot
        ParkingLot lot = new ParkingLot("Downtown Lot", Arrays.asList(floor1, floor2));

        // Create vehicles
        Vehicle car1 = new Car("ABC123");
        Vehicle bike1 = new Bike("BIKE99");
        Vehicle car2 = new Car("CAR88");

        // Park vehicles
        System.out.println("Parking car1: " + lot.parkVehicle(car1));
        System.out.println("Parking bike1: " + lot.parkVehicle(bike1));
        System.out.println("Parking car2: " + lot.parkVehicle(car2));

        // Show available spots
        System.out.println("\nAvailable CAR spots:");
        for (String spot : lot.getAllAvailableSpots(VehicleType.CAR)) {
            System.out.println(spot);
        }

        // Unpark vehicle
        System.out.println("\nUnparking car from Floor 1, Spot 1");
        lot.unparkVehicle(1, 1);

        // Show available again
        System.out.println("\nAvailable CAR spots after unparking:");
        for (String spot : lot.getAllAvailableSpots(VehicleType.CAR)) {
            System.out.println(spot);
        }
    }
}
