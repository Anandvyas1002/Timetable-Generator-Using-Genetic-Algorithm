/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;

/**
 *
 * @author Anand
 */
public class ClassRoom {
    	private final int roomId;
	private final String roomNumber;
	private final int capacity;
	public ClassRoom(int roomId, String roomNumber, int capacity) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}


	public int getRoomCapacity() {
		return this.capacity;
	}
    
}
