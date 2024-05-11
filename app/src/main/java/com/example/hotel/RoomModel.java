package com.example.hotel;

public class RoomModel {

    private int rmid;
    private String rmcid, rmtype, rmrate, rmindate, rmoutdate;

    public RoomModel(int rmid, String rmcid, String rmtype, String rmrate, String rmindate, String rmoutdate) {
        this.rmid = rmid;
        this.rmcid = rmcid;
        this.rmtype = rmtype;
        this.rmrate = rmrate;
        this.rmindate = rmindate;
        this.rmoutdate = rmoutdate;
    }

    public RoomModel() {
    }

    public int getRmid() {
        return rmid;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
    }

    public String getRmcid() {
        return rmcid;
    }

    public void setRmcid(String rmcid) {
        this.rmcid = rmcid;
    }

    public String getRmtype() {
        return rmtype;
    }

    public void setRmtype(String rmtype) {
        this.rmtype = rmtype;
    }

    public String getRmrate() {
        return rmrate;
    }

    public void setRmrate(String rmrate) {
        this.rmrate = rmrate;
    }

    public String getRmindate() {
        return rmindate;
    }

    public void setRmindate(String rmindate) {
        this.rmindate = rmindate;
    }

    public String getRmoutdate() {
        return rmoutdate;
    }

    public void setRmoutdate(String rmoutdate) {
        this.rmoutdate = rmoutdate;
    }
}
