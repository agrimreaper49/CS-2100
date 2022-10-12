
public class ParkingSpot {
	private int spotNumber;
	private boolean isOccupied;
	private boolean underMaintenance;
	private boolean isHandicap;
	private boolean isCompact;
	
	public ParkingSpot (int num, boolean isOccupied, boolean maintenance,
			boolean handicap, boolean compact) {
		this.spotNumber = num;
		this.isOccupied = isOccupied;
		this.underMaintenance = maintenance;
		this.isHandicap = handicap;
		this.isCompact = compact;
	}
	
}
