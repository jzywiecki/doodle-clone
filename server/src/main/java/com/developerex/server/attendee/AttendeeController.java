package com.developerex.server.attendee;


import com.developerex.server.term.TermDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<List<AttendeeDto>> getAllAttendees() {
        List<AttendeeDto> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(attendees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttendeeDto> addAttendee(@RequestBody AttendeeDto attendeeDto) {
        if (attendeeService.addAttendee(attendeeDto)){
            return ResponseEntity.ok(attendeeDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
