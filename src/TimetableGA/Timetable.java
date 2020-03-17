/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;

import java.util.HashMap;
/**
 *
 * @author Anand
 */
public class Timetable {
    	private final HashMap<Integer, ClassRoom> rooms;
	private final HashMap<Integer, Lecturer> lecturers;
	private final HashMap<Integer, Course> modules;
	private final HashMap<Integer, Group> groups;
	private final HashMap<Integer, Timeslot> timeslots;
	private Class classes[];

	private int numClasses = 0;

	/**
	 * ³õÊ¼»¯¿Î³Ì±í
	 */
	public Timetable() {
		this.rooms = new HashMap<Integer, ClassRoom>();
		this.lecturers = new HashMap<Integer, Lecturer>();
		this.modules = new HashMap<Integer, Course>();
		this.groups = new HashMap<Integer, Group>();
		this.timeslots = new HashMap<Integer, Timeslot>();
	}

	/**
	 * ¿ËÂ¡¿Î³Ì±í
	 * 
	 * @param cloneable
	 */
	public Timetable(Timetable cloneable) {
		this.rooms = cloneable.getRooms();
		this.lecturers = cloneable.getlecturers();
		this.modules = cloneable.getModules();
		this.groups = cloneable.getGroups();
		this.timeslots = cloneable.getTimeslots();
	}

	private HashMap<Integer, Group> getGroups() {
		return this.groups;
	}

	private HashMap<Integer, Timeslot> getTimeslots() {
		return this.timeslots;
	}

	private HashMap<Integer, Course> getModules() {
		return this.modules;
	}

	private HashMap<Integer, Lecturer> getlecturers() {
		return this.lecturers;
	}

	/**
	 * Ìí¼Ó½ÌÊÒ
	 * 
	 * @param roomId
	 * @param roomName
	 * @param capacity
	 */
	public void addRoom(int roomId, String roomName, int capacity) {
		this.rooms.put(roomId, new ClassRoom(roomId, roomName, capacity));
	}

	/**
	 * Ìí¼ÓÐÂµÄ½²Ê¦
	 * 
	 * @param lecturerId
	 * @param lecturerName
	 */
	public void addlecturer(int lecturerId, String lecturerName) {
		this.lecturers.put(lecturerId, new Lecturer(lecturerId, lecturerName));
	}

	/**
	 * Ìí¼ÓÐÂµÄ¿Î³Ì
	 * 
	 * @param moduleId
	 * @param moduleCode
	 * @param module
	 * @param lecturerIds
	 */
	public void addModule(int moduleId, String moduleCode, String module, int lecturerIds[]) {
		this.modules.put(moduleId, new Course(moduleId, moduleCode, module, lecturerIds));
	}

	/**
	 * Ìí¼ÓÐÂµÄ×é
	 * 
	 * @param groupId
	 * @param groupSize
	 * @param moduleIds
	 */
	public void addGroup(int groupId, int groupSize, int moduleIds[]) {
		this.groups.put(groupId, new Group(groupId, groupSize, moduleIds));
		this.numClasses = 0;
	}

	/**
	 * Ìí¼ÓÐÂµÄÊ±¼ä¶Î
	 * 
	 * @param timeslotId
	 * @param timeslot
	 */
	public void addTimeslot(int timeslotId, String timeslot) {
		this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
	}

	/**
	 * Ê¹ÓÃ¸öÌåµÄÈ¾É«Ìå´´½¨classes
	 * 
	 * @param individual
	 */
	public void createClasses(Individual individual) {
		Class classes[] = new Class[this.getNumClasses()];

		int chromosome[] = individual.getChromosome();
		int chromosomePos = 0;
		int classIndex = 0;

		for (Group group : this.getGroupsAsArray()) {
			int moduleIds[] = group.getModuleIds();
			for (int moduleId : moduleIds) {
				classes[classIndex] = new Class(classIndex, group.getGroupId(), moduleId);

				classes[classIndex].addTimeslot(chromosome[chromosomePos]);
				chromosomePos++;

				classes[classIndex].setRoomId(chromosome[chromosomePos]);
				chromosomePos++;

				classes[classIndex].addlecturer(chromosome[chromosomePos]);
				chromosomePos++;

				classIndex++;
			}
		}
		this.classes = classes;
	}

	/**
	 * @param roomId
	 * @return room
	 */
	public ClassRoom getRoom(int roomId) {
		if (!this.rooms.containsKey(roomId)) {
			System.out.println("Rooms doesn't contain key " + roomId);
		}
		return (ClassRoom) this.rooms.get(roomId);
	}

	public HashMap<Integer, ClassRoom> getRooms() {
		return this.rooms;
	}

	/**
	 * @return room
	 */
	public ClassRoom getRandomRoom() {
		Object[] roomsArray = this.rooms.values().toArray();
		ClassRoom room = (ClassRoom) roomsArray[(int) (roomsArray.length * Math.random())];
		return room;
	}

	/**
	 * @param lecturerId
	 * @return lecturer
	 */
	public Lecturer getlecturer(int lecturerId) {
		return (Lecturer) this.lecturers.get(lecturerId);
	}

	/**
	 * @param moduleId
	 * @return module
	 */
	public Course getModule(int moduleId) {
		return (Course) this.modules.get(moduleId);
	}

	/**
	 * @param groupId
	 * @return moduleId array
	 */
	public int[] getGroupModules(int groupId) {
		Group group = (Group) this.groups.get(groupId);
		return group.getModuleIds();
	}

	/**
	 * @param groupId
	 * @return group
	 */
	public Group getGroup(int groupId) {
		return (Group) this.groups.get(groupId);
	}

	/**
	 * @return array of groups
	 */
	public Group[] getGroupsAsArray() {
		return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
	}

	/**
	 * @param timeslotId
	 * @return timeslot
	 */
	public Timeslot getTimeslot(int timeslotId) {
		return (Timeslot) this.timeslots.get(timeslotId);
	}

	/**
	 * @return timeslot
	 */
	public Timeslot getRandomTimeslot() {
		Object[] timeslotArray = this.timeslots.values().toArray();
		Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
		return timeslot;
	}

	/**
	 * @return classes
	 */
	public Class[] getClasses() {
		return this.classes;
	}

	/**
	 * @return numClasses
	 */
	public int getNumClasses() {
		if (this.numClasses > 0) {
			return this.numClasses;
		}

		int numClasses = 0;
		Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
		for (Group group : groups) {
			numClasses += group.getModuleIds().length;
		}
		this.numClasses = numClasses;

		return this.numClasses;
	}

	/**
	 * Õâ¸öÀàÓÃÀ´¼ì²â³åÍ»
	 * 
	 * @return numClashes
	 */
	public int calcClashes() {
		int clashes = 0;

		for (Class classA : this.classes) {

			int roomCapacity = this.getRoom(classA.getRoomId()).getRoomCapacity();
			int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();

			// ¼ì²â½ÌÊÒµÄÈÝÁ¿²»ÄÜ´óÓÚ×éµÄÊýÁ¿
			if (roomCapacity <= groupSize) {
				clashes++;
			}

			// ¼ì²âÍ¬Ò»¸ö½ÌÊÒÍ¬Ò»¸öÊ±¼ä²»ÄÜÍ¬Ê±ÔÝÓÃ
			for (Class classB : this.classes) {
				if (classA.getRoomId() == classB.getRoomId() && classA.getTimeslotId() == classB.getTimeslotId()
						&& classA.getClassId() != classB.getClassId()) {
					clashes++;
					break;
				}
			}

			// ¼ì²âÍ¬Ò»¸ö½²Ê¦²»ÄÜÍ¬Ê±ÉÏÁ½½Ú²»Ò»ÑùµÄ¿Î
			for (Class classB : this.classes) {
				if (classA.getlecturerId() == classB.getlecturerId() && classA.getTimeslotId() == classB.getTimeslotId()
						&& classA.getClassId() != classB.getClassId()) {
					clashes++;
					break;
				}
			}
			// ¼ì²âÍ¬Ò»¸ö×éµÄÍ¬Ñ§²»ÄÜÔÚÍ¬Ò»Ê±¼äÉÏ¿Î
			for (Class classB : this.classes) {
				if (classA.getGroupId() == classB.getGroupId() && classA.getTimeslotId() == classB.getTimeslotId()
						&& classA.getClassId() != classB.getClassId()) {
					clashes++;
					break;
				}
			}
		}
		return clashes;
	}
}
