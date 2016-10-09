package org.rfid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by iliyapetrov on 31.07.16.
 */

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ReportLogic reportLogic;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpEntity<List<ReportDTO>> reportControllerGetAll() {

        List<Report> reportAll = new ArrayList<>();
        List<ReportDTO> reportDTO = new ArrayList<>();


        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime timeToday = timeNow.withDayOfYear(timeNow.getDayOfYear()).
                withDayOfMonth(timeNow.getDayOfMonth()).
                withMonth(timeNow.getMonthValue()).
                withHour(0).
                withMinute(0).
                withSecond(0);
        ZoneId zoneId = ZoneId.systemDefault();
        Long today = timeToday.atZone(zoneId).toEpochSecond();


        for (Teacher teacher : teacherRepository.findAll()) {
            reportAll.add(reportLogic.generateReport(teacher.getRfid(),today));
			}

        reportAll.stream().map(report ->
                reportDTO.add(
                        new ReportDTO(String.valueOf(report.getEntrance()),
                                String.valueOf(report.getExit()),
                                report.getName()))).
                collect(Collectors.toList());

        return new ResponseEntity<>(reportDTO,  HttpStatus.OK);
    }

    @RequestMapping(value = "/{rfid}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpEntity<Report> reportControllerGet(@PathVariable String rfid, @PathVariable long date) {
        return new ResponseEntity<>(reportLogic.generateReport(rfid,date), HttpStatus.OK);
    }

}
