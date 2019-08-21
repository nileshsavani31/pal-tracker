package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    public List<TimeEntry> list = new ArrayList<>();
    private int counter = 1;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter);
        list.add(timeEntry);
        counter++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {

     for (int i=0; i< list.size();i++){
         if(list.get(i).getId() == timeEntryId){
             return  list.get(i);
         }
     }
        return null;
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
       if(list == null || list.size() == 0)
            return null;

        TimeEntry obj = find(timeEntryId);
        list.remove(obj.getId());
        timeEntry.setId(timeEntryId);
        list.add(timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long timeEntryId) {
        list.remove(find(timeEntryId));
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> obj = new ArrayList<>(list);
        return obj;
    }

}
