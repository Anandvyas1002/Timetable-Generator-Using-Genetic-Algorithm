/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Anand
 */
public class viewTimetable {
    private String subName;
    private int sem;
    private String batch;
    private String rname;
    private String fname;
    private int dayNo;
    private int slotNo;
  

    public viewTimetable(String subName, int sem, String batch, String rname, String fname, int dayNo, int slotNo) {
        this.subName = subName;
        this.sem = sem;
        this.batch = batch;
        this.rname = rname;
        this.fname = fname;
        this.dayNo = dayNo;
        this.slotNo = slotNo;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getDayNo() {
        return dayNo;
    }

    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }
    
}
