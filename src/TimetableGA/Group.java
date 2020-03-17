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
public class Group {
    	private final int groupId;
	private final int groupSize;
	private final int moduleIds[];

	public Group(int groupId, int groupSize, int moduleIds[]) {
		this.groupId = groupId;
		this.groupSize = groupSize;
		this.moduleIds = moduleIds;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public int getGroupSize() {
		return this.groupSize;
	}

	public int[] getModuleIds() {
		return this.moduleIds;
	}
    
}
