package org.rfid;

/**
 * Created by iliyapetrov on 31.07.16.
 */
public class Report {

    Long entrance;
    Long exit;

    String name;

    public Report(Long entrance, Long exit, String name) {
        this.entrance = entrance;
        this.exit = exit;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
