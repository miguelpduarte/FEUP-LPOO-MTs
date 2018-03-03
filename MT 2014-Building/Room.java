import java.util.ArrayList;
import java.util.HashSet;


public class Room extends Facility {
	private Building b;
	private int floor;
	private int capacity;
	private HashSet<User> authorizedUsers = new HashSet<>();
	
	public Room(Building b, String name, int floor) throws IllegalArgumentException, DuplicateRoomException {
		this(b, name, floor, 0);
	}

	public Room(Building b, String name, int floor, int capacity) throws DuplicateRoomException, IllegalArgumentException {
		super(name);
		if(floor > b.getMaxFloor() || floor < b.getMinFloor()) {
			throw new IllegalArgumentException();
		}
		this.b = b;
		this.floor = floor;
		this.capacity = capacity;
		this.capacity = capacity;
		b.addRoom(this);
	}
	
	

	public Building getBuilding() {
		return b;
	}

	public String getNumber() {
		return super.getName();
	}
	
	@Override
	public String getName() {
		return b.getName() + super.getName();
	}

	public int getFloor() {
		return floor;
	}

	@Override
	public String toString() {
		return "Room(" + b.getName() + "," + getNumber() + ")";
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public boolean canEnter(User u) {
		return authorizedUsers.contains(u);
	}

	public void authorize(User u) {
		authorizedUsers.add(u);
	}
	
}
