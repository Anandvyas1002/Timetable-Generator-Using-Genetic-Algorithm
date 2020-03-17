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
public class SaveTT {
    private int classid;
    private String subName;
    private int group;
    private String rName;
    private String fName;
    private int tsId;

    public SaveTT(int classid, String subName, int group, String rName, String fName, int tsId) {
        this.classid = classid;
        this.subName = subName;
        this.group = group;
        this.rName = rName;
        this.fName = fName;
        this.tsId = tsId;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getTime() {
        return tsId;
    }

    public void setTime(String time) {
        this.tsId = tsId;
    }
    
    
}
