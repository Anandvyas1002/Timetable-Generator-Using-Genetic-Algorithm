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
public class Timeslot {
    	private final int timeslotId;
	private final String timeslot;

	
	public Timeslot(int timeslotId, String timeslot) {
		this.timeslotId = timeslotId;
		this.timeslot = timeslot;
	}

	public int getTimeslotId() {
		return this.timeslotId;
	}

	public String getTimeslot() {
		return this.timeslot;
	}
    
}
