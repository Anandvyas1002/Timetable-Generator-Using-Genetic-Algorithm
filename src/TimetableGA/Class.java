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
public class Class {
    	private final int classId;
	private final int groupId;
	private final int moduleId;
	private int lecturerId;
	private int timeslotId;
	private int roomId;

	public Class(int classId, int groupId, int moduleId) {
		this.classId = classId;
		this.moduleId = moduleId;
		this.groupId = groupId;
	}

	public void addlecturer(int lecturerId) {
		this.lecturerId = lecturerId;
	}
	public void addTimeslot(int timeslotId) {
		this.timeslotId = timeslotId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getClassId() {
		return this.classId;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public int getModuleId() {
		return this.moduleId;
	}

	public int getlecturerId() {
		return this.lecturerId;
	}

	public int getTimeslotId() {
		return this.timeslotId;
	}

	public int getRoomId() {
		return this.roomId;
	}
    
}
