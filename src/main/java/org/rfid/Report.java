package org.rfid;

/**
 * Created by iliyapetrov on 31.07.16.
 */
public class Report {

    Long entrance;
    Long exit;

    String rfid;

    public Report(Long entrance, Long exit, String rfid) {
        this.entrance = entrance;
        this.exit = exit;
        this.rfid = rfid;
    }

    public Long getEntrance() {
        return entrance;
    }

    public void setEntrance(Long entrance) {
        this.entrance = entrance;
    }

    public Long getExit() {
        return exit;
    }

    public void setExit(Long exit) {
        this.exit = exit;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}
