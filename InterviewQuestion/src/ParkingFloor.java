import java.util.*;

public class ParkingFloor {
	private int floorNumber;
	private ArrayList<ParkingSpot> spots;
	public ParkingFloor (int floorNumber, ArrayList<ParkingSpot> spots) {
		this.floorNumber = floorNumber;
		this.spots = spots;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}
	
	public ArrayList<ParkingSpot> getSpots() {
		return spots;
	}
}
