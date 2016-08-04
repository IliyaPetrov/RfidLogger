package org.rfid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.List;


/**
 * Created by zlatan on 03.08.16.
 */
@Component
class ReportLogic extends Report{

    @Autowired
    ReportFactory reportFactory;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TeacherRepository teacherRepository;


     Report generateReport(String rfid, long date){

        Report report = reportFactory.createReport();
        Teacher teacher = teacherRepository.findByRfid(rfid);
        List<Event> minMax = eventRepository.findByRfidAndDateBetweenOrderByDate(rfid,date,date+(24*60*60));


        report.setEntrance(0L);
        report.setExit(0L);

        if (minMax.size()==1){
            Event first = minMax.get(0);

            report.setEntrance(first.getDate());
            report.setExit(0L);
        } else if(minMax.size() > 1) {
            Event first = minMax.get(0);
            Event last  = minMax.get(minMax.size() - 1);

            report.setEntrance(first.getDate());
            report.setExit(last.getDate());
        }

        report.setName(teacher.getName());
        report.add(linkTo(methodOn(ReportController.class).reportControllerGet(rfid,date)).withSelfRel());

        return report;
    }
}
