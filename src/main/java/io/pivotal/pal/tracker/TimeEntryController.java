package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    //InMemoryTimeEntryRepository inMemoryTimeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody TimeEntry timeEntry) {
        TimeEntry obj =  timeEntryRepository.create(timeEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);

    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id){
        TimeEntry timeEntry = this.timeEntryRepository.find(id);
        if(timeEntry!=null)
            return ResponseEntity.status(HttpStatus.OK).body(timeEntry);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping()
    public  ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> list =  this.timeEntryRepository.list();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @PutMapping(value = "{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry timeEntry){
            TimeEntry updatedTimeEntry = this.timeEntryRepository.update(id, timeEntry);
            if(updatedTimeEntry != null)
                return ResponseEntity.status(HttpStatus.OK).body(updatedTimeEntry);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        this.timeEntryRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
