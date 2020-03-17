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
public class Lecturer {
    	private final int lecturerId;
	private final String lecturerName;


	public Lecturer(int lecturerId, String lecturerName) {
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
	}

	public int getLecturerId() {
		return this.lecturerId;
	}


	public String getLecturerName() {
		return this.lecturerName;
	}
}
