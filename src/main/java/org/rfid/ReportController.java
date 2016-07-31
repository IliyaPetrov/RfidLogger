package org.rfid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by iliyapetrov on 31.07.16.
 */
@RestController
public class ReportController {

    @Autowired
    EventRepository repository;

    @RequestMapping(value = "/report/{rfid}/{date}", method = RequestMethod.GET)
    @ResponseBody
    public Report reportControllerGet(@PathVariable String rfid,@PathVariable long date) {
        List<Event> minMax = repository.findByRfidAndDateBetweenOrderByDate(rfid,date,date+(24*60*60));
        if (minMax.isEmpty()){
            return new Report(0L, 0L, rfid);
        } else if (minMax.size()==1){
            Event first = minMax.get(0);
            return new Report(first.getDate(), 0L, first.getRfid());
        }
        else {
            Event first = minMax.get(0);
            Event last = minMax.get(minMax.size() - 1);
            return new Report(first.getDate(), last.getDate(), first.getRfid());
        }
    }



}
