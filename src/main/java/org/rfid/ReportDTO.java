package org.rfid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kili on 23.09.16.
 */
public class ReportDTO {

    String entrance;
    String exit;
    String name;


    public ReportDTO(String entrance, String exit, String name) {
        this.entrance = entrance;
        this.exit = exit;
        this.name = name;
    }

    private String converter(String date,String msg){
        if(!date.equals("0") ) {
            Long epochTime = Long.valueOf(date);
            Date dateTime = new Date(epochTime * 1000);
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM  kk:mm",Locale.forLanguageTag("BG"));
            return formatter.format(dateTime);
        } else{
            return msg;
        }
    }

    public String getEntrance() {
        return converter(entrance,"Няма регистрирано влизане.");
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getExit() {
        return converter(exit,"Няма регистрирано излизане.");
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
