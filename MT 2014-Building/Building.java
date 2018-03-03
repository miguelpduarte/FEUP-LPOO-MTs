import java.util.HashSet;
import java.util.Iterator;


public class Building extends Facility {
	
	private int minFloor;
	private int maxFloor;
	private HashSet<Room> roomSet = new HashSet<>();

	public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
		super(name);
		if(minFloor > maxFloor) {
			throw new IllegalArgumentException();
		}
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}
	
	public int getCapacity() {
		int capacity = 0;
		
		for(Room room : roomSet) {
			capacity += room.getCapacity();
		}
		
		return capacity;
	}

	@Override
	public String toString() {
		return "Building(" + getName() + ")";
	}

	public void addRoom(Room r) throws DuplicateRoomException {
		if(roomSet.contains(r)) {
			throw new DuplicateRoomException();
		}
		
		roomSet.add(r);
	}

	@Override
	public boolean canEnter(User u) {
		for(Room r : roomSet) {
			if(r.canEnter(u))  {
				return true;
			}
		}
		
		return false;
	}
}
