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

    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping(value = "/report/{rfid}/{date}", method = RequestMethod.GET)
    public Report reportControllerGet(@PathVariable String rfid,@PathVariable long date) {
        Teacher teacher = teacherRepository.findByRfid(rfid);
        List<Event> minMax = repository.findByRfidAndDateBetweenOrderByDate(rfid,date,date+(24*60*60));

        if (minMax.isEmpty()){
            return new Report(0L, 0L, teacher.getName());
        } else if (minMax.size()==1){
            Event first = minMax.get(0);
            return new Report(first.getDate(), 0L, teacher.getName());
        }
        else {
            Event first = minMax.get(0);
            Event last = minMax.get(minMax.size() - 1);
            return new Report(first.getDate(), last.getDate(), teacher.getName());
        }
    }



}
