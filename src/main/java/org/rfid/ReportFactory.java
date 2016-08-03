package org.rfid;

import org.springframework.stereotype.Component;

/**
 * Created by zlatan on 02.08.16.
 */
@Component
public class ReportFactory {

    public Report createReport(){
    return new Report();
    }
}
