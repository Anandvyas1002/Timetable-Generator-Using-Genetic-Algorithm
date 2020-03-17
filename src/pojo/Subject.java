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
public class Subject {
int sid;
String subCode;
String subName;
int sem;
int lpw;

    public Subject(int sid, String subCode, String subName, int sem, int lpw) {
        this.sid = sid;
        this.subCode = subCode;
        this.subName = subName;
        this.sem = sem;
        this.lpw = lpw;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
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

    public int getLpw() {
        return lpw;
    }

    public void setLpw(int lpw) {
        this.lpw = lpw;
    }

}
